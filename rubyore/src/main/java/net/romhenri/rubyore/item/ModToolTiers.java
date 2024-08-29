package net.romhenri.rubyore.item;

import net.romhenri.rubyore.RubyOreMod;
import net.romhenri.rubyore.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier RUBY = TierSortingRegistry.registerTier(

            new ForgeTier(6, 2031, 12f, 6f, 42,
                    ModTags.Blocks.NEEDS_RUBY_TOOL, () -> Ingredient.of(ModItems.RUBY.get())),
            new ResourceLocation(RubyOreMod.MOD_ID, "ruby"),
            List.of(Tiers.NETHERITE),
            List.of()
        );
    }
