package net.romhenri.platinum.item;

import net.romhenri.platinum.PlatinumMod;
import net.romhenri.platinum.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier PLATINUM = TierSortingRegistry.registerTier(

            new ForgeTier(3, 741, 7f, 0f, 64,
                    ModTags.Blocks.NEEDS_PLATINUM_TOOL, () -> Ingredient.of(ModItems.PLATINUM_INGOT.get())),
            new ResourceLocation(PlatinumMod.MOD_ID, "platinum"),
            List.of(Tiers.NETHERITE),
            List.of()
        );
    }
