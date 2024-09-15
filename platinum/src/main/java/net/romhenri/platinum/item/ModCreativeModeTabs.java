package net.romhenri.platinum.item;

import net.romhenri.platinum.PlatinumMod;
import net.romhenri.platinum.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PlatinumMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> PLATINUM_TAB = CREATIVE_MODE_TABS.register("platinum_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PLATINUM_INGOT.get()))
                    .title(Component.translatable("creativetab.platinum_tab"))
                    .displayItems((displayParameters, output) -> {
                        output.accept(ModItems.PLATINUM_INGOT.get());
                        output.accept(ModItems.PLATINUM_NUGGET.get());

                        output.accept(ModItems.PLATINUM_SWORD.get());
                        output.accept(ModItems.PLATINUM_PICKAXE.get());
                        output.accept(ModItems.PLATINUM_SHOVEL.get());
                        output.accept(ModItems.PLATINUM_AXE.get());
                        output.accept(ModItems.PLATINUM_HOE.get());

                        output.accept(ModBlocks.PLATINUM_ORE.get());
                        output.accept(ModBlocks.PLATINUM_BLOCK.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
