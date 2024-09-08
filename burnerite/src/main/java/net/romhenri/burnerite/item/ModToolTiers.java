package net.romhenri.burnerite.item;

import net.romhenri.burnerite.BurneriteMod;
import net.romhenri.burnerite.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier BURNERITE = TierSortingRegistry.registerTier(

            new ForgeTier(5, 2501, 11f, 5f, 25,
                    ModTags.Blocks.NEEDS_BURNERITE_TOOL, () -> Ingredient.of(ModItems.BURNERITE.get())),
            new ResourceLocation(BurneriteMod.MOD_ID, "burnerite"),
            List.of(Tiers.NETHERITE),
            List.of()
        );
    }
