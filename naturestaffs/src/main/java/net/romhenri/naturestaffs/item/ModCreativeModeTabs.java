package net.romhenri.naturestaffs.item;

import net.romhenri.naturestaffs.NatureStaffsMod;
import net.romhenri.naturestaffs.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NatureStaffsMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> NATURESTAFFS_TAB = CREATIVE_MODE_TABS.register("naturestaffs_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ICE_STAFF.get()))
                    .title(Component.translatable("creativetab.naturestaffs_tab"))
                    .displayItems((displayParameters, output) -> {
                        output.accept(ModItems.RAW_GEM.get());
                        output.accept(ModItems.GEM.get());
                        output.accept(ModItems.CALCITE_FRAG.get());

                        output.accept(ModItems.IGNIS_GEM.get());
                        output.accept(ModItems.BLUE_GEM.get());
                        output.accept(ModItems.GREEN_GEM.get());
                        output.accept(ModItems.GRAY_GEM.get());
                        output.accept(ModItems.BROWN_GEM.get());

                        output.accept(ModItems.STAFF.get());
                        output.accept(ModItems.LEAVES_STAFF.get());
                        output.accept(ModItems.GROUND_STAFF.get());
                        output.accept(ModItems.ICE_STAFF.get());
                        output.accept(ModItems.MAGMA_STAFF.get());
                        output.accept(ModItems.BASALT_STAFF.get());
                        output.accept(ModItems.SLIME_STAFF.get());

                        output.accept(ModBlocks.MINERAL_ORE.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
