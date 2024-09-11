package net.romhenri.burnerite.item.custom;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.item.Items;

public class BurneriteHoe extends HoeItem {
    public BurneriteHoe(Tier tier, int attackDamage, float attackSpeed, Item.Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entity) {
        if (!level.isClientSide) {
            ItemStack smeltedStack = getSmeltedResult(state);

            if (smeltedStack != null) {
                level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);

                ItemEntity itemEntity = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), smeltedStack);
                level.addFreshEntity(itemEntity);

                if (level instanceof ServerLevel serverLevel) {
                    serverLevel.sendParticles(ParticleTypes.FLAME, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                            5, 0.5, 0.5, 0.5, 0.1);
                }

                SoundEvent fireSound = ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("minecraft", "block.lava.extinguish"));
                if (fireSound != null) {
                    level.playSound(null, pos, fireSound, SoundSource.BLOCKS, 0.3F, 1.8F);
                }
            }
        }

        return super.mineBlock(stack, level, state, pos, entity);
    }

    private ItemStack getSmeltedResult(BlockState state) {
        if (state.getBlock() == Blocks.SAND) {
            return new ItemStack(Blocks.GLASS);
        } else if (state.getBlock() == Blocks.GRAVEL) {
            return new ItemStack(Items.FLINT);
        }

        return null;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos();

        if (!world.isClientSide) {
            if (world instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(ParticleTypes.FLAME, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                        5, 0.5, 0.5, 0.5, 0.1);
            }

            SoundEvent fireSound = ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("minecraft", "block.lava.extinguish"));
            if (fireSound != null) {
                world.playSound(null, pos, fireSound, SoundSource.BLOCKS, 0.3F, 1.8F);
            }
        }

        return super.useOn(context);
    }
}
