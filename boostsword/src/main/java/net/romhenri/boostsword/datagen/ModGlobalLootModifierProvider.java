package net.romhenri.boostsword.datagen;

import net.romhenri.boostsword.BoostSword;
import net.romhenri.boostsword.item.ModItems;
import net.romhenri.boostsword.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output) {
        super(output, BoostSword.MOD_ID);
    }

    @Override
    protected void start() {
        LootItemCondition[] conditions = new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("minecraft", "chests/end_city_treasure")).build(),
                LootItemRandomChanceCondition.randomChance(0.3f).build()
        };

        add("boost_sword_in_end_city", new AddItemModifier(conditions, ModItems.BOOST_SWORD.get()));
    }
}
