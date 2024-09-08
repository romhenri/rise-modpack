package net.romhenri.burnerite.item;

import net.romhenri.burnerite.BurneriteMod;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.romhenri.burnerite.item.custom.BurneriteSword;
import net.romhenri.burnerite.item.custom.BurneritePickaxe;
import net.romhenri.burnerite.item.custom.BurneriteShovel;
import net.romhenri.burnerite.item.custom.BurneriteAxe;
import net.romhenri.burnerite.item.custom.BurneriteHoe;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BurneriteMod.MOD_ID);

    public static final RegistryObject<Item> BURNERITE = ITEMS.register("burnerite",
            () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> BURNERITE_DUST = ITEMS.register("burnerite_dust",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> BURNERITE_SWORD = ITEMS.register("burnerite_sword",
            () -> new BurneriteSword(ModToolTiers.BURNERITE, 5, -2.4F, new Item.Properties()
                    .durability(2501)
                    .fireResistant()
            ));
    public static final RegistryObject<Item> BURNERITE_PICKAXE = ITEMS.register("burnerite_pickaxe",
            () -> new BurneritePickaxe(ModToolTiers.BURNERITE, 2, -2.8F, new Item.Properties()
                    .durability(2501)
                    .fireResistant()
            ));
    public static final RegistryObject<Item> BURNERITE_SHOVEL = ITEMS.register("burnerite_shovel",
            () -> new BurneriteShovel(ModToolTiers.BURNERITE, 2.5F, -3.0F, new Item.Properties()
                    .durability(2501)
                    .fireResistant()
            ));
    public static final RegistryObject<Item> BURNERITE_AXE = ITEMS.register("burnerite_axe",
            () -> new BurneriteAxe(ModToolTiers.BURNERITE, 7, -3.0F, new Item.Properties()
                    .durability(2501)
                    .fireResistant()
            ));
    public static final RegistryObject<Item> BURNERITE_HOE = ITEMS.register("burnerite_hoe",
            () -> new BurneriteHoe(ModToolTiers.BURNERITE, -5, 0, new Item.Properties()
                    .durability(2501)
                    .fireResistant()
            ));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
