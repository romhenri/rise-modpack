package net.romhenri.alexandriteore.block;

import net.romhenri.alexandriteore.AlexandriteOreMod;
import net.romhenri.alexandriteore.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.minecraft.core.particles.ParticleTypes;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, AlexandriteOreMod.MOD_ID);

    public static final RegistryObject<Block> ALEXANDRITE_BLOCK = registerBlock("alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .requiresCorrectToolForDrops()
                    .strength(5.0F, 6.0F)
                    .sound(SoundType.METAL)
                    .lightLevel((state) -> 9)
            ));

    public static final RegistryObject<Block> ALEXANDRITE_ORE = registerBlock("alexandrite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> DEEPSLATE_ALEXANDRITE_ORE = registerBlock("deepslate_alexandrite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));

    public static final RegistryObject<Block> CHISELED_STONE_BRICKS = registerBlock("chiseled_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)
                    .strength(1.5f, 6.0f)
                    .lightLevel((state) -> 8)
            ));
    public static final RegistryObject<Block> CHISELED_DEEPSLATE_BRICKS = registerBlock("chiseled_deepslate_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS)
                    .strength(1.5f, 6.0f)
                    .lightLevel((state) -> 8)
            ));

    public static final RegistryObject<Block> ALEXANDRITE_TORCH = BLOCKS.register("alexandrite_torch",
            () -> new TorchBlock(BlockBehaviour.Properties.of().noCollission().instabreak().lightLevel((state) -> 15), ParticleTypes.FLAME));

    public static final RegistryObject<Block> ALEXANDRITE_WALL_TORCH = BLOCKS.register("alexandrite_wall_torch",
            () -> new WallTorchBlock(BlockBehaviour.Properties.of().noCollission().instabreak().lightLevel((state) -> 15), ParticleTypes.FLAME));

    private static final Logger log = LoggerFactory.getLogger(ModBlocks.class);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
