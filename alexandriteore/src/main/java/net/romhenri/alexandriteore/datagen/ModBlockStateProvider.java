package net.romhenri.alexandriteore.datagen;

import net.romhenri.alexandriteore.AlexandriteOreMod;
import net.romhenri.alexandriteore.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, AlexandriteOreMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ALEXANDRITE_BLOCK);
        blockWithItem(ModBlocks.CHISELED_STONE_BRICKS);
        blockWithItem(ModBlocks.CHISELED_DEEPSLATE_BRICKS);

        registerTorch(ModBlocks.ALEXANDRITE_TORCH, ModBlocks.ALEXANDRITE_WALL_TORCH);

        blockWithItem(ModBlocks.ALEXANDRITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE);
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("alexandriteore:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("alexandriteore:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void registerTorch(RegistryObject<Block> torch, RegistryObject<Block> wallTorch) {
        simpleBlock(torch.get(), models().torch(torch.getId().getPath(), modLoc("block/" + torch.getId().getPath())));

        simpleBlock(wallTorch.get(), models().torchWall(wallTorch.getId().getPath(), modLoc("block/" + torch.getId().getPath())));

        simpleBlockItem(torch.get(), models().getExistingFile(modLoc("item/alexandrite_torch_item")));
    }
}
