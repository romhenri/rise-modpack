package net.romhenri.naturestaffs.datagen;

import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.romhenri.naturestaffs.NatureStaffsMod;
import net.romhenri.naturestaffs.block.ModBlocks;
import net.romhenri.naturestaffs.item.ModItems;
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
    private static final List<ItemLike> GEM_SMELTABLES = List.of(
            ModItems.RAW_GEM.get(),
            ModBlocks.MINERAL_ORE.get()
    );

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BONE_MEAL, 2)
                .requires(ModItems.CALCITE_FRAG.get())
                .unlockedBy("has_calcite_frag", has(ModItems.CALCITE_FRAG.get()))
                .save(pWriter, NatureStaffsMod.MOD_ID + ":calcite_frag_to_bone_meal");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.CALCITE)
                .pattern("CC")
                .pattern("CC")
                .define('C', ModItems.CALCITE_FRAG.get())
                .unlockedBy("has_calcite_frag", has(ModItems.CALCITE_FRAG.get()))
                .save(pWriter, NatureStaffsMod.MOD_ID + ":calcite_frag_to_calcite_frag_block");

        oreSmelting(pWriter, GEM_SMELTABLES, RecipeCategory.MISC, ModItems.GEM.get(), 0.25f, 200, "gem");
        oreBlasting(pWriter, GEM_SMELTABLES, RecipeCategory.MISC, ModItems.GEM.get(), 0.25f, 100, "gem");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GREEN_GEM.get())
                .pattern("SLS")
                .pattern("LGL")
                .pattern("SLS")
                .define('G', ModItems.GEM.get())
                .define('L', Blocks.OAK_LEAVES)
                .define('S', Items.OAK_SAPLING)
                .unlockedBy("has_gem", has(ModItems.GEM.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BLUE_GEM.get())
                .pattern("SIS")
                .pattern("IGI")
                .pattern("SIS")
                .define('G', ModItems.GEM.get())
                .define('I', Items.ICE)
                .define('S', Items.WATER_BUCKET)
                .unlockedBy("has_gem", has(ModItems.GEM.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.IGNIS_GEM.get())
                .pattern("BMB")
                .pattern("MGM")
                .pattern("BMB")
                .define('G', ModItems.GEM.get())
                .define('M', Blocks.MAGMA_BLOCK)
                .define('B', Items.MAGMA_CREAM)
                .unlockedBy("has_gem", has(ModItems.GEM.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BROWN_GEM.get())
                .pattern("DFD")
                .pattern("FGF")
                .pattern("DFD")
                .define('G', ModItems.GEM.get())
                .define('F', Blocks.DIRT)
                .define('D', Items.FLINT)
                .unlockedBy("has_gem", has(ModItems.GEM.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GRAY_GEM.get())
                .pattern("BMB")
                .pattern("MGM")
                .pattern("BMB")
                .define('G', ModItems.GEM.get())
                .define('M', Blocks.BASALT)
                .define('B', Items.BLAZE_POWDER)
                .unlockedBy("has_gem", has(ModItems.GEM.get()))
                .save(pWriter);

        // Staff Recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STAFF.get())
                .pattern(" LS")
                .pattern("LSL")
                .pattern("SL ")
                .define('S', Items.STICK)
                .define('L', Items.LAPIS_LAZULI)
                .unlockedBy("has_stick", has(Items.STICK))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LEAVES_STAFF.get())
                .pattern(" LG")
                .pattern(" SL")
                .define('S', ModItems.STAFF.get())
                .define('G', ModItems.GREEN_GEM.get())
                .define('L', Blocks.OAK_LEAVES)
                .unlockedBy("has_staff", has(ModItems.STAFF.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GROUND_STAFF.get())
                .pattern(" DG")
                .pattern(" SD")
                .define('S', ModItems.STAFF.get())
                .define('G', ModItems.BROWN_GEM.get())
                .define('D', Blocks.COARSE_DIRT)
                .unlockedBy("has_staff", has(ModItems.STAFF.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ICE_STAFF.get())
                .pattern(" IG")
                .pattern(" SI")
                .define('S', ModItems.STAFF.get())
                .define('G', ModItems.BLUE_GEM.get())
                .define('I', Items.ICE)
                .unlockedBy("has_staff", has(ModItems.STAFF.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MAGMA_STAFF.get())
                .pattern(" MG")
                .pattern(" SM")
                .define('S', ModItems.STAFF.get())
                .define('G', ModItems.IGNIS_GEM.get())
                .define('M', Blocks.MAGMA_BLOCK)
                .unlockedBy("has_staff", has(ModItems.STAFF.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BASALT_STAFF.get())
                .pattern(" BG")
                .pattern(" SB")
                .define('S', ModItems.STAFF.get())
                .define('G', ModItems.GRAY_GEM.get())
                .define('B', Blocks.BASALT)
                .unlockedBy("has_staff", has(ModItems.STAFF.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SLIME_STAFF.get())
                .pattern("LLG")
                .pattern("LSL")
                .pattern("LLL")
                .define('S', ModItems.STAFF.get())
                .define('G', ModItems.GEM.get())
                .define('L', Items.SLIME_BLOCK)
                .unlockedBy("has_staff", has(ModItems.STAFF.get()))
                .save(pWriter);
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
                    .save(pFinishedRecipeConsumer, NatureStaffsMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}