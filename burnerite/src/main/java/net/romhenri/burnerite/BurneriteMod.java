package net.romhenri.burnerite;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.romhenri.burnerite.block.ModBlocks;
import net.romhenri.burnerite.item.ModCreativeModeTabs;
import net.romhenri.burnerite.loot.ModLootModifiers;
import net.romhenri.burnerite.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(BurneriteMod.MOD_ID)
public class BurneriteMod {
    public static final String MOD_ID = "burnerite";
    public static final Logger LOGGER = LogManager.getLogger();

    public BurneriteMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModLootModifiers.register(modEventBus);

        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.BURNERITE);
            event.accept(ModItems.BURNERITE_SCRAP);
        }

        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.BURNERITE_ORE);
        }

        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.BURNERITE_SWORD);
            event.accept(ModItems.BURNERITE_PICKAXE);
            event.accept(ModItems.BURNERITE_SHOVEL);
            event.accept(ModItems.BURNERITE_AXE);
            event.accept(ModItems.BURNERITE_HOE);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
