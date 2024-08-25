package net.romhenri.naturestaffs.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraftforge.registries.ForgeRegistries;

public class BasaltRightClickProcedure {
    public static void execute(Level world, BlockPos pos, ServerPlayer player, ItemStack itemStack, int cooldownTicks, int durabilityCost) {
        if (world.isClientSide) {
            return;
        }

        ServerLevel serverWorld = (ServerLevel) world;

        SoundEvent basaltSound = ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.basalt.place"));
        if (basaltSound != null) {
            serverWorld.playSound(null, pos, basaltSound, SoundSource.BLOCKS, 1.0F, 1.0F);
        }

        int radius = 3;
        int centerX = pos.getX();
        int centerY = pos.getY() - 1;
        int centerZ = pos.getZ();

        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                if (Math.sqrt(x * x + z * z) <= radius) {
                    BlockPos newPos = new BlockPos(centerX + x, centerY, centerZ + z);
                    BlockState basaltState = Blocks.BASALT.defaultBlockState();

                    BlockState currentState = serverWorld.getBlockState(newPos);
                    BlockPos abovePos = newPos.above();
                    BlockPos above2Pos = newPos.above();

                    BlockState aboveState = serverWorld.getBlockState(abovePos);
                    BlockState above2State = serverWorld.getBlockState(above2Pos);
                    if (aboveState.getBlock() == Blocks.LAVA) {
                        serverWorld.setBlock(abovePos, Blocks.AIR.defaultBlockState(), 3);
                    }
                    if (above2State.getBlock() == Blocks.LAVA) {
                        serverWorld.setBlock(above2Pos, Blocks.AIR.defaultBlockState(), 3);
                    }

                    if (
                            currentState.isAir() ||
                                    currentState.getBlock() == Blocks.GRASS ||
                                    currentState.getBlock() == Blocks.TALL_GRASS ||
                                    currentState.getBlock() == Blocks.FLOWER_POT ||
                                    currentState.getBlock() == Blocks.POPPY ||
                                    currentState.getBlock() == Blocks.DANDELION ||
                                    currentState.getBlock() == Blocks.ROSE_BUSH ||
                                    currentState.getBlock() == Blocks.SUNFLOWER ||
                                    currentState.getBlock() == Blocks.PEONY ||
                                    currentState.getBlock() == Blocks.LILAC ||
                                    currentState.getBlock() == Blocks.ROSE_BUSH ||
                                    currentState.getBlock() == Blocks.CORNFLOWER ||
                                    currentState.getBlock() == Blocks.WITHER_ROSE ||
                                    currentState.getBlock() == Blocks.BLUE_ORCHID ||
                                    currentState.getBlock() == Blocks.ALLIUM ||
                                    currentState.getBlock() == Blocks.LAVA ||
                                    currentState.getBlock() == Blocks.FIRE ||
                                    currentState.getBlock() == Blocks.MAGMA_BLOCK
                    ) {
                        serverWorld.setBlock(newPos, basaltState, 3);

                        // Adiciona partículas de basalto
                        serverWorld.sendParticles(ParticleTypes.ASH, newPos.getX() + 0.5, newPos.getY() + 0.5, newPos.getZ() + 0.5, 15, 0.5, 0.5, 0.5, 0.1);
                    }
                }
            }
        }

        // Adiciona cooldown ao item
        player.getCooldowns().addCooldown(itemStack.getItem(), cooldownTicks);

        // Desgasta o item
        if (!itemStack.isEmpty() && itemStack.getItem().isDamageable(itemStack)) {
            itemStack.hurt(durabilityCost, serverWorld.random, player);
            if (itemStack.getDamageValue() >= itemStack.getMaxDamage()) {
                itemStack.shrink(1); // Remove o item se estiver completamente desgastado
            }
        }
    }
}
