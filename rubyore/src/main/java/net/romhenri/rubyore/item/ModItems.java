package net.romhenri.rubyore.item;

import net.romhenri.rubyore.RubyOreMod;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.romhenri.rubyore.item.custom.HammerItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RubyOreMod.MOD_ID);

    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUBY_DUST = ITEMS.register("ruby_dust",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword",
            () -> new SwordItem(ModToolTiers.RUBY, 5, -1.6F, new Item.Properties().durability(2031)));
    public static final RegistryObject<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe",
            () -> new PickaxeItem(ModToolTiers.RUBY, 2, -2.8F, new Item.Properties().durability(2031)));
    public static final RegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel",
            () -> new ShovelItem(ModToolTiers.RUBY, (float)2.5, -3.0F, new Item.Properties().durability(2031)));
    public static final RegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe",
            () -> new AxeItem(ModToolTiers.RUBY, 7, -3.0F, new Item.Properties().durability(2031)));
    public static final RegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe",
            () -> new HoeItem(ModToolTiers.RUBY, -6, 0, new Item.Properties().durability(2031)));

    public static final RegistryObject<Item> RUBY_HAMMER = ITEMS.register("ruby_hammer",
            () -> new HammerItem(ModToolTiers.RUBY, 2, -3.4F, new Item.Properties().durability(2031)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
