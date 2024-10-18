package net.romhenri.alexandriteore.datagen;

import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.romhenri.alexandriteore.AlexandriteOreMod;
import net.romhenri.alexandriteore.block.ModBlocks;
import net.romhenri.alexandriteore.item.ModItems;
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
    private static final List<ItemLike> ALEXANDRITE_SMELTABLES = List.of(
            ModItems.RAW_ALEXANDRITE.get(),
            ModBlocks.ALEXANDRITE_ORE.get(),
            ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get()
    );

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.ALEXANDRITE.get()),
                        RecipeCategory.MISC, ModItems.ALEXANDRITE_DUST.get(), 0.5f, 300)
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ALEXANDRITE.get()).build()))
                .save(pWriter, AlexandriteOreMod.MOD_ID + ":alexandrite_dust_from_smelting");

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModItems.ALEXANDRITE.get()),
                        RecipeCategory.MISC, ModItems.ALEXANDRITE_DUST.get(), 0.5f, 300)
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ALEXANDRITE.get()).build()))
                .save(pWriter, AlexandriteOreMod.MOD_ID + ":alexandrite_dust_from_blasting");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModBlocks.ALEXANDRITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ALEXANDRITE.get())
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.ALEXANDRITE.get()).build()))
                .save(pWriter);

        // Alexandrite Sword Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ALEXANDRITE_SWORD.get())
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" S ")
                .define('A', ModItems.ALEXANDRITE.get())
                .define('S', Items.STICK)
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.ALEXANDRITE.get()).build()))
                .save(pWriter);

        // Alexandrite Pickaxe Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ALEXANDRITE_PICKAXE.get())
                .pattern("AAA")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.ALEXANDRITE.get())
                .define('S', Items.STICK)
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.ALEXANDRITE.get()).build()))
                .save(pWriter);

        // Alexandrite Axe Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ALEXANDRITE_AXE.get())
                .pattern("AA ")
                .pattern("AS ")
                .pattern(" S ")
                .define('A', ModItems.ALEXANDRITE.get())
                .define('S', Items.STICK)
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.ALEXANDRITE.get()).build()))
                .save(pWriter);

        // Alexandrite Shovel Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ALEXANDRITE_SHOVEL.get())
                .pattern(" A ")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.ALEXANDRITE.get())
                .define('S', Items.STICK)
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.ALEXANDRITE.get()).build()))
                .save(pWriter);

        // Alexandrite Hoe Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ALEXANDRITE_HOE.get())
                .pattern("AA ")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.ALEXANDRITE.get())
                .define('S', Items.STICK)
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.ALEXANDRITE.get()).build()))
                .save(pWriter);

        // Alexandrite Hammer Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ALEXANDRITE_HAMMER.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern(" S ")
                .define('A', ModItems.ALEXANDRITE.get())
                .define('S', Items.STICK)
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.ALEXANDRITE.get()).build()))
                .save(pWriter);

        // Alexandrite Combat Axe Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ALEXANDRITE_COMBAT_AXE.get())
                .pattern("AAA")
                .pattern("ASA")
                .pattern(" S ")
                .define('A', ModItems.ALEXANDRITE.get())
                .define('S', Items.STICK)
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.ALEXANDRITE.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_STONE_BRICKS.get())
                .pattern("SSS")
                .pattern("SAS")
                .pattern("SSS")
                .define('S', Blocks.STONE_BRICKS)
                .define('A', ModItems.ALEXANDRITE.get())
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.ALEXANDRITE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_DEEPSLATE_BRICKS.get())
                .pattern("SSS")
                .pattern("SAS")
                .pattern("SSS")
                .define('S', Blocks.DEEPSLATE_BRICKS)
                .define('A', ModItems.ALEXANDRITE.get())
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.ALEXANDRITE.get()).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 9)
                .requires(ModBlocks.ALEXANDRITE_BLOCK.get())
                .unlockedBy("has_alexandrite_block", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.ALEXANDRITE_BLOCK.get()).build()))
                .save(pWriter);

        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC,
                ModItems.ALEXANDRITE.get(),
                RecipeCategory.MISC,
                ModBlocks.ALEXANDRITE_BLOCK.get(),
                "alexandriteore:raw_alexandrite", "alexandrite","alexandriteore:raw_alexandrite_block", "alexandrite");
        oreSmelting(pWriter, ALEXANDRITE_SMELTABLES, RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 0.25f, 200, "alexandrite");
        oreBlasting(pWriter, ALEXANDRITE_SMELTABLES, RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 0.25f, 100, "alexandrite");
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
                    .save(pFinishedRecipeConsumer, AlexandriteOreMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }

}
