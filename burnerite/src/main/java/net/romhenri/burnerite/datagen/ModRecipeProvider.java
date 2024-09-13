package net.romhenri.burnerite.datagen;

import net.minecraft.world.item.Items;
import net.romhenri.burnerite.BurneriteMod;
import net.romhenri.burnerite.block.ModBlocks;
import net.romhenri.burnerite.item.ModItems;
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
    private static final List<ItemLike> BURNERITE_SMELTABLES = List.of(
            ModBlocks.BURNERITE_ORE.get()
    );

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        // Burnerite Recipe
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BURNERITE.get(), 1)
                .requires(ModItems.BURNERITE_SCRAP.get(), 3)
                .requires(Items.NETHERITE_SCRAP, 3)
                .requires(Items.GOLD_INGOT, 3)
                .unlockedBy("has_burnerite_scrap", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.BURNERITE_SCRAP.get()).build()))
                .save(pWriter);

        // Burnerite Sword Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BURNERITE_SWORD.get())
                .pattern("  B")
                .pattern(" N ")
                .define('B', ModItems.BURNERITE.get())
                .define('N', Items.NETHERITE_SWORD)
                .unlockedBy("has_burnerite", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.BURNERITE.get()).build()))
                .save(pWriter);

        // Burnerite Pickaxe Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BURNERITE_PICKAXE.get())
                .pattern("  B")
                .pattern(" N ")
                .define('B', ModItems.BURNERITE.get())
                .define('N', Items.NETHERITE_PICKAXE)
                .unlockedBy("has_burnerite", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.BURNERITE.get()).build()))
                .save(pWriter);

        // Burnerite Axe Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BURNERITE_AXE.get())
                .pattern("  B")
                .pattern(" N ")
                .define('B', ModItems.BURNERITE.get())
                .define('N', Items.NETHERITE_AXE)
                .unlockedBy("has_burnerite", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.BURNERITE.get()).build()))
                .save(pWriter);

        // Burnerite Shovel Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BURNERITE_SHOVEL.get())
                .pattern("  B")
                .pattern(" N ")
                .define('B', ModItems.BURNERITE.get())
                .define('N', Items.NETHERITE_SHOVEL)
                .unlockedBy("has_burnerite", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.BURNERITE.get()).build()))
                .save(pWriter);

        // Burnerite Hoe Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BURNERITE_HOE.get())
                .pattern("  B")
                .pattern(" N ")
                .define('B', ModItems.BURNERITE.get())
                .define('N', Items.NETHERITE_HOE)
                .unlockedBy("has_burnerite", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.BURNERITE.get()).build()))
                .save(pWriter);

        oreBlasting(pWriter, BURNERITE_SMELTABLES, RecipeCategory.MISC,
                ModItems.BURNERITE_SCRAP.get(), 1.0F, 300, "burnerite");
        oreSmelting(pWriter, BURNERITE_SMELTABLES, RecipeCategory.MISC,
                ModItems.BURNERITE_SCRAP.get(), 1.0F, 300, "burnerite");
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
                    .save(pFinishedRecipeConsumer, BurneriteMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }

}
