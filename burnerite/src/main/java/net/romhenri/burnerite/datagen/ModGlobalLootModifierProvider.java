package net.romhenri.burnerite.datagen;

import net.romhenri.burnerite.BurneriteMod;
import net.romhenri.burnerite.item.ModItems;
import net.romhenri.burnerite.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output) {
        super(output, BurneriteMod.MOD_ID);
    }

    @Override
    protected void start() {
        add("burnerite_from_desert_pyramid", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/desert_pyramid")).build() },
                ModItems.BURNERITE.get())
        );

        add("burnerite_from_ruined_portal_20", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(
                        new ResourceLocation("chests/ruined_portal")).build(),
                LootItemRandomChanceCondition.randomChance(0.2f).build() },
                ModItems.BURNERITE.get())
        );
    }
}