package net.romhenri.boostsword.item;

import net.romhenri.boostsword.BoostSword;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.Tiers;
import net.romhenri.boostsword.item.custom.BoostSwordItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BoostSword.MOD_ID);

    // Alpha Boost Sword
    public static final RegistryObject<Item> ALPHA_BOOST_SWORD = ITEMS.register("alpha_boost_sword",
            () -> new BoostSwordItem(
                    Tiers.DIAMOND,
                    3,
                    -2.4F,
                    new Item.Properties().durability(1561),
                    30,
                    3.0
            ));

    // Beta Boost Sword
    public static final RegistryObject<Item> BETA_BOOST_SWORD = ITEMS.register("beta_boost_sword",
            () -> new BoostSwordItem(
                    Tiers.DIAMOND,
                    3,
                    -2.4F,
                    new Item.Properties().durability(1561),
                    30,
                    1.5
            ));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
