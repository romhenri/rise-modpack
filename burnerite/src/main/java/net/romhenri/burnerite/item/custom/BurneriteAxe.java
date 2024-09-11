package net.romhenri.burnerite.item.custom;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class BurneriteAxe extends AxeItem {
    public BurneriteAxe(Tier tier, float attackDamage, float attackSpeed, Item.Properties properties) {
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

                // Usar o sistema de som especificado
                SoundEvent fireSound = ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("minecraft", "block.lava.extinguish"));
                if (fireSound != null) {
                    level.playSound(null, pos, fireSound, SoundSource.BLOCKS, 0.3F, 1.8F);
                }
            }
        }

        return super.mineBlock(stack, level, state, pos, entity);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof Player player) {
            target.setSecondsOnFire(5);

            Level world = target.getCommandSenderWorld();
            if (!world.isClientSide && world instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(ParticleTypes.FLAME, target.getX(), target.getY() + target.getBbHeight() / 2.0, target.getZ(), 10, 0.5, 0.5, 0.5, 0.1);
            }

            if (target.getHealth() <= 0.0F && target.isOnFire()) {
                if (!world.isClientSide) {
                    List<ItemEntity> drops = world.getEntitiesOfClass(ItemEntity.class, target.getBoundingBox());

                    for (ItemEntity drop : drops) {
                        ItemStack dropStack = drop.getItem();

                        if (dropStack.getItem() == Items.PORKCHOP) {
                            drop.setItem(new ItemStack(Items.COOKED_PORKCHOP, dropStack.getCount()));
                        } else if (dropStack.getItem() == Items.BEEF) {
                            drop.setItem(new ItemStack(Items.COOKED_BEEF, dropStack.getCount()));
                        } else if (dropStack.getItem() == Items.CHICKEN) {
                            drop.setItem(new ItemStack(Items.COOKED_CHICKEN, dropStack.getCount()));
                        } else if (dropStack.getItem() == Items.MUTTON) {
                            drop.setItem(new ItemStack(Items.COOKED_MUTTON, dropStack.getCount()));
                        } else if (dropStack.getItem() == Items.RABBIT) {
                            drop.setItem(new ItemStack(Items.COOKED_RABBIT, dropStack.getCount()));
                        }
                    }
                }
            }
        }
        return super.hurtEnemy(stack, target, attacker);
    }

    private ItemStack getSmeltedResult(BlockState state) {
        if (state.getBlock() == Blocks.OAK_LOG || state.getBlock() == Blocks.SPRUCE_LOG ||
                state.getBlock() == Blocks.BIRCH_LOG || state.getBlock() == Blocks.JUNGLE_LOG ||
                state.getBlock() == Blocks.ACACIA_LOG || state.getBlock() == Blocks.DARK_OAK_LOG) {
            return new ItemStack(Items.CHARCOAL);
        } else if (state.getBlock() == Blocks.COBBLESTONE) {
            return new ItemStack(Items.STONE);
        } else if (state.getBlock() == Blocks.SAND) {
            return new ItemStack(Items.GLASS);
        }

        return null;
    }
}
