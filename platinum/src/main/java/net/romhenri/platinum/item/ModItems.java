package net.romhenri.platinum.item;

import net.romhenri.platinum.PlatinumMod;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PlatinumMod.MOD_ID);

    public static final RegistryObject<Item> PLATINUM_INGOT = ITEMS.register("platinum",
            () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> PLATINUM_NUGGET = ITEMS.register("platinum_nugget",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> PLATINUM_SWORD = ITEMS.register("platinum_sword",
            () -> new SwordItem(ModToolTiers.PLATINUM, 5, -1.6F, new Item.Properties()
                    .durability(741)
            ));
    public static final RegistryObject<Item> PLATINUM_PICKAXE = ITEMS.register("platinum_pickaxe",
            () -> new PickaxeItem(ModToolTiers.PLATINUM, 4, -2.8F, new Item.Properties()
                    .durability(741)
            ));
    public static final RegistryObject<Item> PLATINUM_SHOVEL = ITEMS.register("platinum_shovel",
            () -> new ShovelItem(ModToolTiers.PLATINUM, 4.5F, -3.0F, new Item.Properties()
                    .durability(741)
            ));
    public static final RegistryObject<Item> PLATINUM_AXE = ITEMS.register("platinum_axe",
            () -> new AxeItem(ModToolTiers.PLATINUM, 8  , -3.0F, new Item.Properties()
                    .durability(741)
            ));
    public static final RegistryObject<Item> PLATINUM_HOE = ITEMS.register("platinum_hoe",
            () -> new HoeItem(ModToolTiers.PLATINUM, 0, 0, new Item.Properties()
                    .durability(741)
            ));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
