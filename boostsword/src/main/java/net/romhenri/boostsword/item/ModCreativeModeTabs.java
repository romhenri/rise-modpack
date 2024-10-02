package net.romhenri.boostsword.item;

import net.romhenri.boostsword.BoostSword;
import net.romhenri.boostsword.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BoostSword.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ALPHA_BOOST_SWORD_TAB = CREATIVE_MODE_TABS.register("alexandrite_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ALPHA_BOOST_SWORD.get()))
                    .title(Component.translatable("creativetab.boost_sword_tab"))
                    .displayItems((displayParameters, output) -> {
                        output.accept(ModItems.ALPHA_BOOST_SWORD.get());
                        output.accept(ModItems.BETA_BOOST_SWORD.get());
                        output.accept(ModItems.DELTA_BOOST_SWORD.get());
                        output.accept(ModItems.EPSILON_BOOST_SWORD.get());
                        output.accept(ModItems.ZETA_BOOST_SWORD.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
