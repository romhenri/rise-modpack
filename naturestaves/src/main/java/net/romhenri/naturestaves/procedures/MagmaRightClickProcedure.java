package net.romhenri.naturestaves.procedures;

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
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.core.particles.ParticleTypes;

public class MagmaRightClickProcedure {
    public static void execute(Level world, BlockPos pos, ServerPlayer player, ItemStack itemStack, int cooldownTicks, int durabilityCost) {
        if (world.isClientSide) {
            return;
        }

        if (
                world.dimension().location().equals(Level.END.location())
        ) {
            return;
        }

        ServerLevel serverWorld = (ServerLevel) world;

        SoundEvent magmaSound = ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.pop"));
        if (magmaSound != null) {
            serverWorld.playSound(null, pos, magmaSound, SoundSource.BLOCKS, 1.0F, 1.0F);
        }

        int radius = 3;
        int centerX = pos.getX();
        int centerY = pos.getY() - 1;
        int centerZ = pos.getZ();

        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                if (Math.sqrt(x * x + z * z) <= radius) {
                    BlockPos newPos = new BlockPos(centerX + x, centerY, centerZ + z);
                    BlockState magmaState = Blocks.MAGMA_BLOCK.defaultBlockState();

                    BlockState currentState = serverWorld.getBlockState(newPos);
                    if (
                        currentState.isAir() ||
                        currentState.getBlock() == Blocks.LAVA ||
                        currentState.getBlock() == Blocks.FIRE ||
                        currentState.getBlock() == Blocks.GRASS ||
                        currentState.getBlock() == Blocks.TALL_GRASS ||
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
                        currentState.getBlock() == Blocks.ALLIUM
                    ){
                        serverWorld.setBlock(newPos, magmaState, 3);

                        serverWorld.sendParticles(ParticleTypes.LAVA, newPos.getX() + 0.5, newPos.getY() + 0.5, newPos.getZ() + 0.5, 5, 0.5, 0.5, 0.5, 0.1);
                    }
                }
            }
        }

        player.getCooldowns().addCooldown(itemStack.getItem(), cooldownTicks);

        if (!itemStack.isEmpty() && itemStack.getItem().isDamageable(itemStack)) {
            itemStack.hurt(durabilityCost, serverWorld.random, player);
            if (itemStack.getDamageValue() >= itemStack.getMaxDamage()) {
                itemStack.shrink(1);
            }
        }
    }
}
