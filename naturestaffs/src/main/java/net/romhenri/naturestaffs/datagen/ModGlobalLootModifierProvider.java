package net.romhenri.naturestaffs.datagen;

import net.romhenri.naturestaffs.NatureStaffsMod;
import net.romhenri.naturestaffs.item.ModItems;
import net.romhenri.naturestaffs.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output) {
        super(output, NatureStaffsMod.MOD_ID);
    }

    @Override
    protected void start() {
    }
}