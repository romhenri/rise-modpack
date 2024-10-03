package net.romhenri.naturestaffs;

import com.mojang.logging.LogUtils;
import net.romhenri.naturestaffs.block.ModBlocks;
import net.romhenri.naturestaffs.item.ModCreativeModeTabs;
import net.romhenri.naturestaffs.loot.ModLootModifiers;
import net.romhenri.naturestaffs.item.ModItems;
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

@Mod(NatureStaffsMod.MOD_ID)
public class NatureStaffsMod {
    public static final String MOD_ID = "naturestaffs";
    public static final Logger LOGGER = LogUtils.getLogger();

    public NatureStaffsMod() {
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
            event.accept(ModItems.STAFF);
            event.accept(ModItems.CALCITE_FRAG);
            event.accept(ModItems.RAW_GEM);
            event.accept(ModItems.GEM);

            event.accept(ModItems.GREEN_GEM);
            event.accept(ModItems.IGNIS_GEM);
            event.accept(ModItems.BLUE_GEM);
            event.accept(ModItems.BROWN_GEM);
            event.accept(ModItems.GRAY_GEM);
        }

        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.MINERAL_ORE);
        }

        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.LEAVES_STAFF);
            event.accept(ModItems.GROUND_STAFF);
            event.accept(ModItems.ICE_STAFF);
            event.accept(ModItems.MAGMA_STAFF);
            event.accept(ModItems.BASALT_STAFF);
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
