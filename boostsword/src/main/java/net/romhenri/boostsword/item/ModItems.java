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

    // Boost Sword
    public static final RegistryObject<Item> BOOST_SWORD = ITEMS.register("boost_sword",
            () -> new BoostSwordItem(Tiers.DIAMOND, 3, -1.6F, new Item.Properties().durability(1561)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
