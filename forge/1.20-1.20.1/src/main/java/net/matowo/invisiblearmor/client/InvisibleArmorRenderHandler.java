package net.matowo.invisiblearmor.client;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;

public class InvisibleArmorRenderHandler {

    private static final EquipmentSlot[] ARMOR_SLOTS = {
            EquipmentSlot.HEAD,
            EquipmentSlot.CHEST,
            EquipmentSlot.LEGS,
            EquipmentSlot.FEET
    };

    private static final ThreadLocal<Map<EquipmentSlot, ItemStack>> SAVED_STACKS =
            ThreadLocal.withInitial(HashMap::new);

    @SubscribeEvent
    public static void onRenderLivingPre(RenderLivingEvent.Pre<?, ?> event) {
        LivingEntity entity = event.getEntity();
        Map<EquipmentSlot, ItemStack> saved = SAVED_STACKS.get();
        saved.clear();

        for (EquipmentSlot slot : ARMOR_SLOTS) {
            ItemStack stack = entity.getItemBySlot(slot);

            if (!stack.isEmpty() && hasInvisibleTag(stack)) {
                saved.put(slot, stack.copy());

                entity.setItemSlot(slot, ItemStack.EMPTY);
            }
        }
    }

    @SubscribeEvent
    public static void onRenderLivingPost(RenderLivingEvent.Post<?, ?> event) {
        LivingEntity entity = event.getEntity();
        Map<EquipmentSlot, ItemStack> saved = SAVED_STACKS.get();

        for (Map.Entry<EquipmentSlot, ItemStack> entry : saved.entrySet()) {
            entity.setItemSlot(entry.getKey(), entry.getValue());
        }
        saved.clear();
    }

    private static boolean hasInvisibleTag(ItemStack stack) {
        if (!stack.hasTag()) return false;
        CompoundTag tag = stack.getTag();
        return tag != null && tag.getBoolean("InvisibleArmor");
    }
}