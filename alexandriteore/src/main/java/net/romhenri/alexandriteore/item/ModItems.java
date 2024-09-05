package net.romhenri.alexandriteore.item;

import net.romhenri.alexandriteore.AlexandriteOreMod;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.romhenri.alexandriteore.item.custom.HammerItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AlexandriteOreMod.MOD_ID);

    public static final RegistryObject<Item> ALEXANDRITE = ITEMS.register("alexandrite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_ALEXANDRITE = ITEMS.register("raw_alexandrite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ALEXANDRITE_DUST = ITEMS.register("alexandrite_dust",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ALEXANDRITE_SWORD = ITEMS.register("alexandrite_sword",
            () -> new SwordItem(ModToolTiers.ALEXANDRITE, 2, 0.8F, new Item.Properties().durability(1717)));
    public static final RegistryObject<Item> ALEXANDRITE_PICKAXE = ITEMS.register("alexandrite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ALEXANDRITE, 1, -2.8F, new Item.Properties().durability(1717)));
    public static final RegistryObject<Item> ALEXANDRITE_SHOVEL = ITEMS.register("alexandrite_shovel",
            () -> new ShovelItem(ModToolTiers.ALEXANDRITE, (float)1.5, -3.0F, new Item.Properties().durability(1717)));
    public static final RegistryObject<Item> ALEXANDRITE_AXE = ITEMS.register("alexandrite_axe",
            () -> new AxeItem(ModToolTiers.ALEXANDRITE, 7, -3.0F, new Item.Properties().durability(1717)));
    public static final RegistryObject<Item> ALEXANDRITE_HOE = ITEMS.register("alexandrite_hoe",
            () -> new HoeItem(ModToolTiers.ALEXANDRITE, -5, 0, new Item.Properties().durability(1717)));

    public static final RegistryObject<Item> ALEXANDRITE_HAMMER = ITEMS.register("alexandrite_hammer",
            () -> new HammerItem(ModToolTiers.ALEXANDRITE, 1, -2.8F, new Item.Properties().durability(1717)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
