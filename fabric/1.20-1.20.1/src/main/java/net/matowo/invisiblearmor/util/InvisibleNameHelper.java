package net.matowo.invisiblearmor.util;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

public final class InvisibleNameHelper {

    private InvisibleNameHelper() {}

    public static Text buildInvisibleName(ItemStack stack, ArmorItem armor) {
        Text baseName = Text.translatable(stack.getItem().getTranslationKey());

        String slotKey = getSlotKey(armor);

        return Text.translatable(
                "item.matowos_invisible_armor.invisible." + slotKey,
                baseName
        ).styled(style -> style.withItalic(false));
    }

    public static String getSlotKey(ArmorItem armor) {
        return switch (armor.getSlotType()) {
            case HEAD -> "helmet";
            case CHEST -> "chestplate";
            case LEGS -> "leggings";
            case FEET -> "boots";
            default -> throw new IllegalStateException("Invalid armor slot");
        };
    }
}
