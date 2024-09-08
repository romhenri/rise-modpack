package net.romhenri.burnerite.item.custom;

import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;

public class BurneriteShovel extends ShovelItem {
    public BurneriteShovel(Tier tier, float attackDamage, float attackSpeed, Item.Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }
}
