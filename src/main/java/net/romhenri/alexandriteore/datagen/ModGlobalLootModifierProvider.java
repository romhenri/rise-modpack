package net.romhenri.alexandriteore.datagen;

import net.romhenri.alexandriteore.AlexandriteOreMod;
import net.romhenri.alexandriteore.item.ModItems;
import net.romhenri.alexandriteore.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.level.block.Blocks;
//import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output) {
        super(output, AlexandriteOreMod.MOD_ID);
    }

    @Override
    protected void start() {
        add("alexandrite_from_jungle_temple", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/jungle_temple")).build() },
                ModItems.ALEXANDRITE.get())
        );

        add("alexandrite_from_dungeon", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/simple_dungeon")).build() },
                ModItems.ALEXANDRITE.get())
        );

        add("alexandrite_from_weaponsmith_10", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(
                        new ResourceLocation("chests/village/village_weaponsmith")).build(),
                LootItemRandomChanceCondition.randomChance(0.1f).build() },
                ModItems.ALEXANDRITE.get())
        );

        add("alexandrite_from_ruined_portal_20", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(
                        new ResourceLocation("chests/ruined_portal")).build(),
                LootItemRandomChanceCondition.randomChance(0.2f).build() },
                ModItems.ALEXANDRITE.get())
        );

    }
}