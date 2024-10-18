package net.romhenri.rubyore.datagen;

import net.minecraft.world.item.Items;
import net.romhenri.rubyore.RubyOreMod;
import net.romhenri.rubyore.block.ModBlocks;
import net.romhenri.rubyore.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> RUBY_SMELTABLES = List.of(
            ModBlocks.RUBY_ORE.get(),
            ModBlocks.DEEPSLATE_RUBY_ORE.get()
    );

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.RUBY.get()),
                        RecipeCategory.MISC, ModItems.RUBY_DUST.get(), 0.5f, 300)
                .unlockedBy("has_ruby", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.RUBY.get()).build()))
                .save(pWriter, RubyOreMod.MOD_ID + ":ruby_dust_from_smelting");

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModItems.RUBY.get()),
                        RecipeCategory.MISC, ModItems.RUBY_DUST.get(), 0.5f, 300)
                .unlockedBy("has_ruby", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.RUBY.get()).build()))
                .save(pWriter, RubyOreMod.MOD_ID + ":ruby_dust_from_blasting");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModBlocks.RUBY_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.RUBY.get())
                .unlockedBy("has_ruby", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.RUBY.get()).build()))
                .save(pWriter);

        // Ruby Sword Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RUBY_SWORD.get())
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" S ")
                .define('A', ModItems.RUBY.get())
                .define('S', Items.STICK)
                .unlockedBy("has_ruby", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.RUBY.get()).build()))
                .save(pWriter);

        // Ruby Pickaxe Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RUBY_PICKAXE.get())
                .pattern("AAA")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.RUBY.get())
                .define('S', Items.STICK)
                .unlockedBy("has_ruby", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.RUBY.get()).build()))
                .save(pWriter);

        // Ruby Axe Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RUBY_AXE.get())
                .pattern("AA ")
                .pattern("AS ")
                .pattern(" S ")
                .define('A', ModItems.RUBY.get())
                .define('S', Items.STICK)
                .unlockedBy("has_ruby", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.RUBY.get()).build()))
                .save(pWriter);

        // Ruby Shovel Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RUBY_SHOVEL.get())
                .pattern(" A ")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.RUBY.get())
                .define('S', Items.STICK)
                .unlockedBy("has_ruby", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.RUBY.get()).build()))
                .save(pWriter);

        // Ruby Hoe Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RUBY_HOE.get())
                .pattern("AA ")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.RUBY.get())
                .define('S', Items.STICK)
                .unlockedBy("has_ruby", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.RUBY.get()).build()))
                .save(pWriter);

        // Ruby Hammer Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RUBY_HAMMER.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern(" S ")
                .define('A', ModItems.RUBY.get())
                .define('S', Items.STICK)
                .unlockedBy("has_ruby", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.RUBY.get()).build()))
                .save(pWriter);

        // Ruby Combat Axe Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RUBY_COMBAT_AXE.get())
                .pattern("AAA")
                .pattern("ASA")
                .pattern(" S ")
                .define('A', ModItems.RUBY.get())
                .define('S', Items.STICK)
                .unlockedBy("has_ruby", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.RUBY.get()).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RUBY.get(), 9)
                .requires(ModBlocks.RUBY_BLOCK.get())
                .unlockedBy("has_ruby_block", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.RUBY_BLOCK.get()).build()))
                .save(pWriter);

        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC,
                ModItems.RUBY.get(),
                RecipeCategory.MISC,
                ModBlocks.RUBY_BLOCK.get(),
                "rubyore:raw_ruby", "ruby","rubyore:raw_ruby_block", "ruby");
        oreSmelting(pWriter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY.get(), 0.25f, 200, "ruby");
        oreBlasting(pWriter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY.get(), 0.25f, 100, "ruby");
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer,
                                     List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime,
                    pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, RubyOreMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }

}
