package net.romhenri.boostsword.item.custom;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.romhenri.boostsword.procedures.BoostSwordRightClickProcedure;

public class BoostSwordItem extends SwordItem {

    private final int cooldown;
    private final double force;

    public BoostSwordItem(Tier tier, int attackDamageIn, float attackSpeedIn, Item.Properties properties, int cooldown, double force) {
        super(tier, attackDamageIn, attackSpeedIn, properties);
        this.cooldown = cooldown;
        this.force = force;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        BoostSwordRightClickProcedure.execute(
                (LevelAccessor) world,
                (int) player.getX(),
                (int) player.getY(),
                (int) player.getZ(),
                this.cooldown,
                player,
                this.force
        );

        return InteractionResultHolder.pass(itemStack);
    }
}
