package net.romhenri.naturestaves.datagen;

import net.romhenri.naturestaves.NatureStavesMod;
import net.romhenri.naturestaves.item.ModItems;
import net.romhenri.naturestaves.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output) {
        super(output, NatureStavesMod.MOD_ID);
    }

    @Override
    protected void start() {
        add("alexandrite_from_dungeon", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/simple_dungeon")).build() },
                ModItems.GEM.get())
        );

        add("alexandrite_from_weaponsmith_10", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(
                        new ResourceLocation("chests/village/village_weaponsmith")).build(),
                LootItemRandomChanceCondition.randomChance(0.1f).build() },
                ModItems.RAW_GEM.get())
        );
    }
}