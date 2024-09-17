package net.romhenri.platinum.datagen;

import net.romhenri.platinum.PlatinumMod;
import net.romhenri.platinum.item.ModItems;
import net.romhenri.platinum.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output) {
        super(output, PlatinumMod.MOD_ID);
    }

    @Override
    protected void start() {
        add("platinum_from_ruined_portal_80", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(
                        new ResourceLocation("chests/ruined_portal")).build(),
                LootItemRandomChanceCondition.randomChance(0.8f).build()},
                ModItems.PLATINUM_INGOT.get())
        );
    }
}