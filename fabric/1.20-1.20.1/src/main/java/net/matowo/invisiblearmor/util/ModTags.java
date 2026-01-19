package net.matowo.invisiblearmor.util;

import net.matowo.invisiblearmor.MatowosInvisibleArmor;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Items {
        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(MatowosInvisibleArmor.MOD_ID, name));
        }
    }
}
