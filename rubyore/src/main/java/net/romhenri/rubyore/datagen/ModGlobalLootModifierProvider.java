package net.romhenri.rubyore.datagen;

import net.romhenri.rubyore.RubyOreMod;
import net.romhenri.rubyore.item.ModItems;
import net.romhenri.rubyore.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output) {
        super(output, RubyOreMod.MOD_ID);
    }

    @Override
    protected void start() {
        add("ruby_from_desert_pyramid", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/desert_pyramid")).build() },
                ModItems.RUBY.get())
        );

        add("ruby_from_ruined_portal_20", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(
                        new ResourceLocation("chests/ruined_portal")).build(),
                LootItemRandomChanceCondition.randomChance(0.2f).build() },
                ModItems.RUBY.get())
        );
    }
}