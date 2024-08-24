package net.romhenri.boostsword.procedures;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class BoostSwordRightClickProcedure {
    public static void execute(LevelAccessor world, int x, int y, int z, int cooldown, Entity entity) {
        if (entity == null) return;

        if (entity instanceof Player player) {
            ItemStack heldItem = player.getMainHandItem();
            ItemCooldowns cooldowns = player.getCooldowns();
            if (cooldowns.isOnCooldown(heldItem.getItem())) {
                return;
            }
        }

        entity.getPersistentData().putBoolean("User3", true);

        Vec3 newPosition = entity.getLookAngle().scale(3.0).add(entity.getDeltaMovement().scale(1.0));
        entity.setDeltaMovement(newPosition);

        if (world instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(ParticleTypes.FIREWORK, x, y + 1, z, 30, 1.0D, 1.0D, 1.0D, 0.1D);
        }

        if (world instanceof Level level) {
            SoundEvent soundEvent = ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use"));
            if (soundEvent != null) {
                level.playSound(null, new BlockPos(x, y, z), soundEvent, SoundSource.PLAYERS, 0.7F, 1.0F);
            }
        }

        if (entity instanceof Player player) {
            ItemStack heldItem = player.getMainHandItem();
            player.getCooldowns().addCooldown(heldItem.getItem(), cooldown);
            player.swing(player.getUsedItemHand(), true);

            heldItem.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(player.getUsedItemHand()));
        }

        entity.setYHeadRot(0.0F);

        Vec3 center = new Vec3(x, y, z);
        List<Entity> entitiesFound = world.getEntitiesOfClass(Entity.class, new AABB(center, center).inflate(3.0D))
                .stream()
                .sorted(Comparator.comparingDouble(entity::distanceToSqr))
                .collect(Collectors.toList());

        for (Entity entityIterator : entitiesFound) {
            if (!entityIterator.getPersistentData().getBoolean("User3")) {
                entityIterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)),
                        (float) Mth.nextInt(RandomSource.create(), 6, 10));
            }
        }

        entity.getPersistentData().putBoolean("User3", false);
    }
}
