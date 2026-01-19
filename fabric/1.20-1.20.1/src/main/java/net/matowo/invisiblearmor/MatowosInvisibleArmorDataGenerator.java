package net.matowo.invisiblearmor;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.matowo.invisiblearmor.datagen.ModItemTagProvider;
import net.matowo.invisiblearmor.datagen.ModModelProvider;

public class MatowosInvisibleArmorDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModModelProvider::new);

	}
}
