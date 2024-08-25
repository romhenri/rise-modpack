package net.romhenri.naturestaffs.datagen;

import net.romhenri.naturestaffs.NatureStaffsMod;
import net.romhenri.naturestaffs.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, NatureStaffsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.RAW_GEM);
        simpleItem(ModItems.GEM);
        simpleItem(ModItems.CALCITE_FRAG);

        simpleItem(ModItems.RED_GEM);
        simpleItem(ModItems.BLUE_GEM);
        simpleItem(ModItems.GREEN_GEM);
        simpleItem(ModItems.GRAY_GEM);
        simpleItem(ModItems.BROWN_GEM);

        handheldItem(ModItems.STAFF);
        handheldItem(ModItems.LEAVES_STAFF);
        handheldItem(ModItems.GROUND_STAFF);
        handheldItem(ModItems.ICE_STAFF);
        handheldItem(ModItems.MAGMA_STAFF);
        handheldItem(ModItems.BASALT_STAFF);
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(NatureStaffsMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(NatureStaffsMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(NatureStaffsMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}
