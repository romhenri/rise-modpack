package net.romhenri.naturestaves.datagen.loot;

import net.romhenri.naturestaves.block.ModBlocks;
import net.romhenri.naturestaves.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.add(ModBlocks.MINERAL_ORE.get(), block -> createCustomOreDrops());
    }

    private LootTable.Builder createCustomOreDrops() {
        LootPoolEntryContainer.Builder<?> calcite_fragDrop = LootItem.lootTableItem(ModItems.CALCITE_FRAG.get())
                .setWeight(4);

        LootPoolEntryContainer.Builder<?> quartzDrop = LootItem.lootTableItem(Items.QUARTZ)
                .setWeight(4);

        LootPoolEntryContainer.Builder<?> gemDrop = LootItem.lootTableItem(ModItems.RAW_GEM.get())
                .setWeight(2);

        return LootTable.lootTable()
                .withPool(applyExplosionDecay(ModBlocks.MINERAL_ORE.get(), LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(calcite_fragDrop)
                        .add(quartzDrop)
                        .add(gemDrop)));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
