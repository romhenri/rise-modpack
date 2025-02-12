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

    // Delta Boost Sword
    public static final RegistryObject<Item> DELTA_BOOST_SWORD = ITEMS.register("delta_boost_sword",
            () -> new BoostSwordItem(
                    Tiers.DIAMOND,
                    3,
                    -2.4F,
                    new Item.Properties().durability(1561),
                    10,
                    1.5
            ));


    // Epsilon Boost Sword
    public static final RegistryObject<Item> EPSILON_BOOST_SWORD = ITEMS.register("epsilon_boost_sword",
            () -> new BoostSwordItem(
                    Tiers.DIAMOND,
                    3,
                    -2.4F,
                    new Item.Properties().durability(1561),
                    15,
                    3
            ));

    // Zeta Boost Sword
    public static final RegistryObject<Item> ZETA_BOOST_SWORD = ITEMS.register("zeta_boost_sword",
            () -> new BoostSwordItem(
                    Tiers.DIAMOND,
                    3,
                    -2.4F,
                    new Item.Properties().durability(1561),
                    30,
                    6
            ));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
