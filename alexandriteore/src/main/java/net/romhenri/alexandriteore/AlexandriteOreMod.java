package net.romhenri.alexandriteore;

import com.mojang.logging.LogUtils;
import net.romhenri.alexandriteore.block.ModBlocks;
import net.romhenri.alexandriteore.item.ModCreativeModeTabs;
import net.romhenri.alexandriteore.loot.ModLootModifiers;
import net.romhenri.alexandriteore.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(AlexandriteOreMod.MOD_ID)
public class AlexandriteOreMod {
    public static final String MOD_ID = "alexandriteore";
    public static final Logger LOGGER = LogUtils.getLogger();

    public AlexandriteOreMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModLootModifiers.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.ALEXANDRITE);
            event.accept(ModItems.RAW_ALEXANDRITE);
            event.accept(ModItems.ALEXANDRITE_DUST);
        }

        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.ALEXANDRITE_BLOCK);
            event.accept(ModBlocks.CHISELED_STONE_BRICKS);
            event.accept(ModBlocks.CHISELED_DEEPSLATE_BRICKS);
//            event.accept(ModBlocks.ALEXANDRITE_TORCH);
        }

        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.ALEXANDRITE_ORE);
            event.accept(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE);
        }

        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.ALEXANDRITE_PICKAXE);
            event.accept(ModItems.ALEXANDRITE_SHOVEL);
            event.accept(ModItems.ALEXANDRITE_AXE);
            event.accept(ModItems.ALEXANDRITE_HOE);
            event.accept(ModItems.ALEXANDRITE_HAMMER);
        }

        if(event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.ALEXANDRITE_SWORD);
            event.accept(ModItems.ALEXANDRITE_AXE);
            event.accept(ModItems.ALEXANDRITE_COMBAT_AXE);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
