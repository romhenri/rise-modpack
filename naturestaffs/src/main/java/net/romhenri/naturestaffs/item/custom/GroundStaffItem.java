package net.romhenri.naturestaffs.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;
import net.romhenri.naturestaffs.procedures.GroundRightClickProcedure;

public class GroundStaffItem extends Item {

    private static final int COOLDOWN_TICKS = 10;
    private static final int DURABILITY_COST = 1;

    public GroundStaffItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if (world.isClientSide) {
            return InteractionResultHolder.pass(player.getItemInHand(hand));
        }

        if (!(player instanceof ServerPlayer)) {
            return InteractionResultHolder.pass(player.getItemInHand(hand));
        }

        ServerPlayer serverPlayer = (ServerPlayer) player;
        ItemStack itemStack = serverPlayer.getItemInHand(hand);
        BlockPos blockPos = serverPlayer.blockPosition();

        GroundRightClickProcedure.execute(world, blockPos, serverPlayer, itemStack, COOLDOWN_TICKS, DURABILITY_COST);

        return InteractionResultHolder.success(itemStack);
    }
}
