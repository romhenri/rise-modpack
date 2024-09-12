package net.romhenri.burnerite.item;

import net.romhenri.burnerite.BurneriteMod;
import net.romhenri.burnerite.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BurneriteMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> BURNERITE_TAB = CREATIVE_MODE_TABS.register("burnerite_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BURNERITE.get()))
                    .title(Component.translatable("creativetab.burnerite_tab"))
                    .displayItems((displayParameters, output) -> {
                        output.accept(ModItems.BURNERITE.get());
                        output.accept(ModItems.BURNERITE_SCRAP.get());

                        output.accept(ModItems.BURNERITE_SWORD.get());
                        output.accept(ModItems.BURNERITE_PICKAXE.get());
                        output.accept(ModItems.BURNERITE_SHOVEL.get());
                        output.accept(ModItems.BURNERITE_AXE.get());
                        output.accept(ModItems.BURNERITE_HOE.get());

                        output.accept(ModBlocks.BURNERITE_ORE.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
