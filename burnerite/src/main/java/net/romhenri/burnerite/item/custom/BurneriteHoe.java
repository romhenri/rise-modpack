package net.romhenri.burnerite.item.custom;

import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;

public class BurneriteHoe extends HoeItem {
    public BurneriteHoe(Tier tier, int attackDamage, int attackSpeed, Item.Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }
}
