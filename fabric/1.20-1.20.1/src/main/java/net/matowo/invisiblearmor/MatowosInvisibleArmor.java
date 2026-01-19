package net.matowo.invisiblearmor;

import net.fabricmc.api.ModInitializer;
import net.matowo.invisiblearmor.item.ModItemGroups;
import net.matowo.invisiblearmor.item.ModItems;
import net.matowo.invisiblearmor.recipe.ModRecipes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MatowosInvisibleArmor implements ModInitializer {
	public static final String MOD_ID = "matowos_invisible_armor";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
        ModRecipes.registerRecipes();
	}
}