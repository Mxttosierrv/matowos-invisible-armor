package net.matowo.invisiblearmor.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class ForgeEventHandler {

    private static final String NBT_KEY_UNDERWATER = "InvisibleTurtleHelmetUnderwater";
    private static final int EXTRA_AIR = 200;         // 10 s * 20 ticks
    private static final int EFFECT_DURATION = 210;   // 10.5 s para prevenir solapamientos

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent event) {
        Player player = event.player;
        if (player.level().isClientSide) {
            return;
        }

        ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);
        boolean isVanilla = helmet.is(Items.TURTLE_HELMET);
        boolean isInvisible = helmet.is(ModItems.INVISIBLE_TURTLE_HELMET.get());

        CompoundTag data = player.getPersistentData();
        boolean wasUnder = data.getBoolean(NBT_KEY_UNDERWATER);

        if (isInvisible || isVanilla) {
            boolean inWater = player.isEyeInFluid(FluidTags.WATER);
            if (inWater && !wasUnder) {
                // Primera inmersión: añade aire y efecto
                int newAir = Math.min(player.getAirSupply() + EXTRA_AIR, player.getMaxAirSupply());
                player.setAirSupply(newAir);
                player.addEffect(new MobEffectInstance(
                        MobEffects.WATER_BREATHING,
                        EFFECT_DURATION, 0, false, false
                ));
            } else if (!inWater && wasUnder) {
                // Al salir: quita el efecto
                player.removeEffect(MobEffects.WATER_BREATHING);
            }
            data.putBoolean(NBT_KEY_UNDERWATER, inWater);
        }
        // 3) Ningún casco de tortuga
        else {
            data.remove(NBT_KEY_UNDERWATER);
            player.removeEffect(MobEffects.WATER_BREATHING);
        }
    }
}
