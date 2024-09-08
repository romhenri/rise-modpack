package net.romhenri.burnerite.item.custom;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.item.ItemEntity;
import java.util.List;

public class BurneriteSword extends SwordItem {

    public BurneriteSword(Tier tier, int attackDamage, float attackSpeed, Item.Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof Player player) {
            target.setSecondsOnFire(5);

            if (target.getHealth() <= 0.0F && target.isOnFire()) {
                Level world = target.getCommandSenderWorld();

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

}
