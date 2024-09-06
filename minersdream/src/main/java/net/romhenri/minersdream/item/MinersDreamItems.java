package net.romhenri.minersdream.item;

import net.romhenri.minersdream.MinersDreamMod;
import net.romhenri.minersdream.procedures.MinersDreamRightClickedOnBlockProcedure;
import net.romhenri.minersdream.procedures.NetherMinersDreamRightClickedOnBlockProcedure;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MinersDreamItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MinersDreamMod.MOD_ID);

    public static final RegistryObject<Item> MINERS_DREAM = ITEMS.register("miners_dream",
            () -> new MinersDreamItem());

    public static final RegistryObject<Item> NETHER_MINERS_DREAM = ITEMS.register("nether_miners_dream",
            () -> new NetherMinersDreamItem());

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static class MinersDreamItem extends Item {
        public MinersDreamItem() {
            super((new Item.Properties()).stacksTo(16).rarity(Rarity.COMMON));
        }

        @Override
        public UseAnim getUseAnimation(ItemStack itemstack) {
            return UseAnim.EAT;
        }

        @Override
        public InteractionResult useOn(UseOnContext context) {
            super.useOn(context);
            MinersDreamRightClickedOnBlockProcedure.execute(
                    context.getLevel(),
                    (int)context.getClickLocation().x(),
                    (int)context.getClickLocation().y(),
                    (int)context.getClickLocation().z(),
                    context.getPlayer()
            );
            return InteractionResult.SUCCESS;
        }
    }

    public static class NetherMinersDreamItem extends Item {
        public NetherMinersDreamItem() {
            super((new Item.Properties()).stacksTo(16).rarity(Rarity.COMMON));
        }

        @Override
        public UseAnim getUseAnimation(ItemStack itemstack) {
            return UseAnim.EAT;
        }

        @Override
        public InteractionResult useOn(UseOnContext context) {
            super.useOn(context);
            NetherMinersDreamRightClickedOnBlockProcedure.execute(
                    context.getLevel(),
                    (int)context.getClickLocation().x(),
                    (int)context.getClickLocation().y(),
                    (int)context.getClickLocation().z(),
                    context.getPlayer()
            );
            return InteractionResult.SUCCESS;
        }
    }
}