package net.romhenri.burnerite.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class BurneriteSword extends SwordItem {

    public BurneriteSword(Tier tier, int attackDamage, float attackSpeed, Item.Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide) {
            BlockPos pos = player.blockPosition();

            if (level instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(ParticleTypes.FLAME, player.getX(), player.getY() + 1.5, player.getZ(),
                        10, 0.5, 0.5, 0.5, 0.1);
            }

            SoundEvent fireSound = ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("minecraft", "block.lava.extinguish"));
            if (fireSound != null) {
                level.playSound(null, pos, fireSound, SoundSource.PLAYERS, 0.3F, 1.8F);
            }
        }

        player.startUsingItem(hand);
        return InteractionResultHolder.consume(stack);
    }

    @Override
    public InteractionResult useOn(net.minecraft.world.item.context.UseOnContext context) {
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos().relative(context.getClickedFace());
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();
        BlockState blockState = world.getBlockState(pos);

        if (!world.isClientSide && blockState.isAir()) {
            world.setBlock(pos, Blocks.FIRE.defaultBlockState(), 11);

            SoundEvent fireSound = ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("minecraft", "block.lava.extinguish"));
            if (fireSound != null) {
                world.playSound(null, pos, fireSound, SoundSource.BLOCKS, 0.3F, 1.8F);
            }

            stack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(context.getHand()));

            if (world instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(ParticleTypes.FLAME, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                        10, 0.5, 0.5, 0.5, 0.1);
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof Player) {
            target.setSecondsOnFire(5);

            Level world = target.getCommandSenderWorld();
            if (!world.isClientSide && world instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(ParticleTypes.FLAME, target.getX(), target.getY() + target.getBbHeight() / 2.0, target.getZ(), 10, 0.5, 0.5, 0.5, 0.1);
            }

            if (target.getHealth() <= 0.0F && target.isOnFire()) {
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

        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entity, int timeLeft) {
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 72000;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BLOCK;
    }
}
