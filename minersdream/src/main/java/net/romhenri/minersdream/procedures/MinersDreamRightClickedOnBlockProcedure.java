package net.romhenri.minersdream.procedures;

import net.romhenri.minersdream.item.MinersDreamItems;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class MinersDreamRightClickedOnBlockProcedure {
    public static void execute(LevelAccessor world, int x, int y, int z, Entity entity) {
        if (entity == null || !(world instanceof ServerLevel serverLevel)) return;

        CommandSourceStack commandSourceStack = new CommandSourceStack(
                CommandSource.NULL,
                new Vec3(x, y, z),
                Vec2.ZERO,
                serverLevel,
                4,
                "",
                Component.literal(""),
                serverLevel.getServer(),
                entity
        );

        String[] blocksToReplace = {
                "minecraft:stone", "minecraft:gravel", "minecraft:lava", "minecraft:water", "minecraft:granite",
                "minecraft:andesite", "minecraft:diorite", "minecraft:dirt", "minecraft:netherrack", "minecraft:end_stone",
                "minecraft:basalt", "minecraft:blackstone", "minecraft:deepslate", "minecraft:tuff", "minecraft:calcite",
                "minecraft:dripstone_block", "minecraft:moss_block", "minecraft:clay", "minecraft:smooth_basalt",
                "minecraft:cobblestone" // Adicionado cobblestone à lista de substituição
        };

        // Replacing
        for (String block : blocksToReplace) {
            serverLevel.getServer().getCommands().performPrefixedCommand(
                    commandSourceStack, String.format("fill ~5 ~-1 ~ ~-5 ~5 ~50 minecraft:air replace %s", block)
            );
        }

        // Cobblestone
        serverLevel.getServer().getCommands().performPrefixedCommand(
                commandSourceStack, "fill ~5 ~-2 ~ ~-5 ~-2 ~50 minecraft:cobblestone replace minecraft:air"
        );

        // Torches
        for (int i = 5; i <= 45; i += 5) {
            serverLevel.getServer().getCommands().performPrefixedCommand(
                    commandSourceStack, String.format("setblock ~ ~-1 ~%d minecraft:torch", i)
            );
        }

        playExplosionSound(world, x, y, z);
        removeItemFromPlayer(entity);
    }

    private static void playExplosionSound(LevelAccessor world, int x, int y, int z) {
        if (world instanceof Level level) {
            SoundEvent explosionSound = ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode"));
            if (explosionSound != null) {
                if (!level.isClientSide()) {
                    level.playSound(null, new BlockPos(x, y, z), explosionSound, SoundSource.NEUTRAL, 1.0F, 1.0F);
                } else {
                    level.playLocalSound(x, y, z, explosionSound, SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                }
            }
        }
    }

    private static void removeItemFromPlayer(Entity entity) {
        if (entity instanceof Player player) {
            ItemStack minersDreamItem = new ItemStack(MinersDreamItems.MINERS_DREAM.get());
            player.getInventory().removeItem(minersDreamItem);
        }
    }
}
