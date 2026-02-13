package net.matowo.invisiblearmor.util;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;

public final class InvisibleNameHelper {

    private InvisibleNameHelper() {}

    public static Component buildInvisibleName(ItemStack stack, ArmorItem armor) {
        Component baseName = Component.translatable(stack.getItem().getDescriptionId());
        String slotKey = getSlotKey(armor);

        return Component.translatable(
                "item.matowos_invisible_armor.invisible." + slotKey,
                baseName
        ).withStyle(style -> style.withItalic(false));
    }

    public static String getSlotKey(ArmorItem armor) {
        EquipmentSlot slot = armor.getEquipmentSlot();
        return switch (slot) {
            case HEAD -> "helmet";
            case CHEST -> "chestplate";
            case LEGS -> "leggings";
            case FEET -> "boots";
            default -> throw new IllegalStateException("Invalid armor slot: " + slot);
        };
    }
}