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

public class SlimeRightClickProcedure {
    public static void execute(Level world, BlockPos pos, ServerPlayer player, ItemStack itemStack, int cooldownTicks, int durabilityCost) {
        if (world.isClientSide) {
            return;
        }

        if (
                world.dimension().location().equals(Level.NETHER.location())
        ) {
            return;
        }

        ServerLevel serverWorld = (ServerLevel) world;

        SoundEvent slimeSound = ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.slime_block.place"));
        if (slimeSound != null) {
            serverWorld.playSound(null, pos, slimeSound, SoundSource.BLOCKS, 1.0F, 1.0F);
        }

        int radius = 1;
        int centerX = pos.getX();
        int centerY = pos.getY() - 1;
        int centerZ = pos.getZ();

        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                if (Math.sqrt(x * x + z * z) <= radius) {
                    BlockPos posBelow1 = new BlockPos(centerX + x, centerY-1, centerZ + z);
                    BlockPos posBelow2 = new BlockPos(centerX + x, centerY-2, centerZ + z);
                    BlockPos posBelow3 = new BlockPos(centerX + x, centerY-3, centerZ + z);

                    BlockPos newPos = new BlockPos(centerX + x, centerY, centerZ + z);

                    if (serverWorld.getBlockState(posBelow3).getBlock().defaultBlockState().isAir()) {
                        newPos = posBelow3;
                    } else
                    if (serverWorld.getBlockState(posBelow2).getBlock().defaultBlockState().isAir()) {
                        newPos = posBelow2;
                    } else
                    if (serverWorld.getBlockState(posBelow1).getBlock().defaultBlockState().isAir()) {
                        newPos = posBelow1;
                    } else {
                        newPos = new BlockPos(centerX + x, centerY, centerZ + z);
                    }

                    BlockState leavesState = Blocks.SLIME_BLOCK.defaultBlockState();

                    BlockState currentState = serverWorld.getBlockState(newPos);
                    if (
                            currentState.isAir() ||
                            currentState.getBlock() == Blocks.GRASS ||
                            currentState.getBlock() == Blocks.TALL_GRASS
                    ){
                        serverWorld.setBlock(newPos, leavesState, 3);

                        serverWorld.sendParticles(ParticleTypes.ITEM_SLIME, newPos.getX() + 0.5, newPos.getY() + 0.5, newPos.getZ() + 0.5, 5, 0.5, 0.5, 0.5, 0.1);
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
