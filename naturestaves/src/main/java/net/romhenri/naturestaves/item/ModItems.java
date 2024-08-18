package net.romhenri.naturestaves.item;

import net.romhenri.naturestaves.NatureStavesMod;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.romhenri.naturestaves.item.custom.IceStaffItem;
import net.romhenri.naturestaves.item.custom.MagmaStaffItem;
import net.romhenri.naturestaves.item.custom.GroundStaffItem;
import net.romhenri.naturestaves.item.custom.LeavesStaffItem;
import net.romhenri.naturestaves.item.custom.BasaltStaffItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, NatureStavesMod.MOD_ID);

    public static final RegistryObject<Item> RAW_GEM = ITEMS.register("raw_gem",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM = ITEMS.register("gem",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CALCITE_FRAG = ITEMS.register("calcite_frag",
            () -> new Item(new Item.Properties()));

    // Gems
    public static final RegistryObject<Item> RED_GEM = ITEMS.register("red_gem",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BLUE_GEM = ITEMS.register("blue_gem",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GREEN_GEM = ITEMS.register("green_gem",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GRAY_GEM = ITEMS.register("gray_gem",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BROWN_GEM = ITEMS.register("brown_gem",
            () -> new Item(new Item.Properties()));

    // Staff
    public static final RegistryObject<Item> STAFF = ITEMS.register("staff",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LEAVES_STAFF = ITEMS.register("leaves_staff",
            () -> new LeavesStaffItem(new Item.Properties().durability(192)));
    public static final RegistryObject<Item> GROUND_STAFF = ITEMS.register("ground_staff",
            () -> new GroundStaffItem(new Item.Properties().durability(96)));
    public static final RegistryObject<Item> ICE_STAFF = ITEMS.register("ice_staff",
            () -> new IceStaffItem(new Item.Properties().durability(96)));
    public static final RegistryObject<Item> MAGMA_STAFF = ITEMS.register("magma_staff",
            () -> new MagmaStaffItem(new Item.Properties().durability(96)));
    public static final RegistryObject<Item> BASALT_STAFF = ITEMS.register("basalt_staff",
            () -> new BasaltStaffItem(new Item.Properties().durability(96)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
