package net.romhenri.platinum.datagen;

import net.minecraft.world.item.Items;
import net.romhenri.platinum.PlatinumMod;
import net.romhenri.platinum.block.ModBlocks;
import net.romhenri.platinum.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraft.resources.ResourceLocation;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> PLATINUM_SMELTABLES = List.of(
            ModBlocks.PLATINUM_ORE.get()
    );

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        // Platinum from Nuggets
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLATINUM_INGOT.get())
                .pattern("NNN")
                .pattern("NNN")
                .pattern("NNN")
                .define('N', ModItems.PLATINUM_NUGGET.get())
                .unlockedBy("has_platinum_nugget", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.PLATINUM_NUGGET.get()).build()))
                .save(pWriter);

        // Platinum from Block
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PLATINUM_INGOT.get(), 9)
                .requires(ModBlocks.PLATINUM_BLOCK.get())
                .unlockedBy("has_platinum_block_unique", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.PLATINUM_BLOCK.get()).build()))
                .save(pWriter, new ResourceLocation(PlatinumMod.MOD_ID, "platinum_from_block"));

        // Platinum Block
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PLATINUM_BLOCK.get())
                .pattern("PPP")
                .pattern("PPP")
                .pattern("PPP")
                .define('P', ModItems.PLATINUM_INGOT.get())
                .unlockedBy("has_platinum_ingot", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.PLATINUM_INGOT.get()).build()))
                .save(pWriter);

        // Nugget from Ingot
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PLATINUM_NUGGET.get(), 9)
                .requires(ModItems.PLATINUM_INGOT.get())
                .unlockedBy("has_platinum_ingot", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.PLATINUM_INGOT.get()).build()))
                .save(pWriter, new ResourceLocation(PlatinumMod.MOD_ID, "platinum_nugget_from_ingot"));

        // Platinum Sword Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.PLATINUM_SWORD.get())
                .pattern(" P ")
                .pattern(" P ")
                .pattern(" S ")
                .define('P', ModItems.PLATINUM_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_platinum", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.PLATINUM_INGOT.get()).build()))
                .save(pWriter);

        // Platinum Pickaxe Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.PLATINUM_PICKAXE.get())
                .pattern("PPP")
                .pattern(" S ")
                .pattern(" S ")
                .define('P', ModItems.PLATINUM_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_platinum", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.PLATINUM_INGOT.get()).build()))
                .save(pWriter);

        // Platinum Axe Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.PLATINUM_AXE.get())
                .pattern("PP ")
                .pattern("PS ")
                .pattern(" S ")
                .define('P', ModItems.PLATINUM_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_platinum", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.PLATINUM_INGOT.get()).build()))
                .save(pWriter);

        // Platinum Shovel Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.PLATINUM_SHOVEL.get())
                .pattern(" P ")
                .pattern(" S ")
                .pattern(" S ")
                .define('P', ModItems.PLATINUM_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_platinum", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.PLATINUM_INGOT.get()).build()))
                .save(pWriter);

        // Platinum Hoe Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.PLATINUM_HOE.get())
                .pattern("PP ")
                .pattern(" S ")
                .pattern(" S ")
                .define('P', ModItems.PLATINUM_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_platinum", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.PLATINUM_INGOT.get()).build()))
                .save(pWriter);

        // Smelt or Blast Platinum Ore
        oreSmelting(pWriter, PLATINUM_SMELTABLES, RecipeCategory.MISC, ModItems.PLATINUM_INGOT.get(), 1.0f, 200, "platinum");
        oreBlasting(pWriter, PLATINUM_SMELTABLES, RecipeCategory.MISC, ModItems.PLATINUM_INGOT.get(), 1.0f, 100, "platinum");
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
                    .save(pFinishedRecipeConsumer, PlatinumMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }

}