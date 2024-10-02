package net.romhenri.boostsword.datagen;

import net.romhenri.boostsword.BoostSword;
import net.romhenri.boostsword.item.ModItems;
import net.romhenri.boostsword.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output) {
        super(output, BoostSword.MOD_ID);
    }

    @Override
    protected void start() {
        // ALPHA_BOOST_SWORD
        LootItemCondition[] alphaConditions = new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("minecraft", "chests/end_city_treasure")).build(),
                LootItemRandomChanceCondition.randomChance(0.3f).build()
        };

        // BETA_BOOST_SWORD
        LootItemCondition[] betaConditions = new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("minecraft", "chests/end_city_treasure")).build(),
                LootItemRandomChanceCondition.randomChance(0.4f).build()
        };

        // DELTA_BOOST_SWORD
        LootItemCondition[] deltaConditions = new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("minecraft", "chests/end_city_treasure")).build(),
                LootItemRandomChanceCondition.randomChance(0.3f).build()
        };

        // EPSILON_BOOST_SWORD
        LootItemCondition[] epsilonConditions = new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("minecraft", "chests/end_city_treasure")).build(),
                LootItemRandomChanceCondition.randomChance(0.2f).build()
        };

        // ZETA_BOOST_SWORD
        LootItemCondition[] zetaConditions = new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("minecraft", "chests/end_city_treasure")).build(),
                LootItemRandomChanceCondition.randomChance(0.1f).build()
        };

        add("alpha_boost_sword_in_end_city", new AddItemModifier(alphaConditions, ModItems.ALPHA_BOOST_SWORD.get()));
        add("beta_boost_sword_in_end_city", new AddItemModifier(betaConditions, ModItems.BETA_BOOST_SWORD.get()));
        add("delta_boost_sword_in_end_city", new AddItemModifier(deltaConditions, ModItems.DELTA_BOOST_SWORD.get()));
        add("epsilon_boost_sword_in_end_city", new AddItemModifier(epsilonConditions, ModItems.EPSILON_BOOST_SWORD.get()));
        add("zeta_boost_sword_in_end_city", new AddItemModifier(zetaConditions, ModItems.ZETA_BOOST_SWORD.get()));
    }
}
