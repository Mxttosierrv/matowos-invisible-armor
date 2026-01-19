package net.matowo.invisiblearmor.recipe;

import net.matowo.invisiblearmor.MatowosInvisibleArmor;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static final RecipeSerializer<InvisibleArmorRecipe> INVISIBLE_ARMOR_RECIPE_SERIALIZER =
            Registry.register(
                    Registries.RECIPE_SERIALIZER,
                    new Identifier(MatowosInvisibleArmor.MOD_ID, "invisible_armor"),
                    new InvisibleArmorRecipe.Serializer()
            );

    public static final RecipeSerializer<VisibleArmorRecipe> VISIBLE_ARMOR_RECIPE_SERIALIZER =
            Registry.register(
                    Registries.RECIPE_SERIALIZER,
                    new Identifier(MatowosInvisibleArmor.MOD_ID, "visible_armor"),
                    new VisibleArmorRecipe.Serializer()
            );

    public static void registerRecipes() {
        MatowosInvisibleArmor.LOGGER.info("Registering Recipe Serializers for " + MatowosInvisibleArmor.MOD_ID);
    }
}