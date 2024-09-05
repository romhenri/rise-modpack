package net.romhenri.alexandriteore.item;

import net.romhenri.alexandriteore.AlexandriteOreMod;
import net.romhenri.alexandriteore.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier ALEXANDRITE = TierSortingRegistry.registerTier(

            new ForgeTier(5, 1717, 10f, 5f, 32,
                    ModTags.Blocks.NEEDS_ALEXANDRITE_TOOL, () -> Ingredient.of(ModItems.ALEXANDRITE.get())),
            new ResourceLocation(AlexandriteOreMod.MOD_ID, "alexandrite"),
            List.of(Tiers.NETHERITE),
            List.of()
        );
    }
