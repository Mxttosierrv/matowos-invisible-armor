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
    private static final int MAX_DURATION = 205; // 10 segundos = 200 ticks
    private static final int EXTRA_AIR = 200;

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

            // Bonus de aire extra al entrar al agua (vanilla behavior)
            if (inWater && !wasUnder) {
                int newAir = Math.min(player.getAirSupply() + EXTRA_AIR, player.getMaxAirSupply());
                player.setAirSupply(newAir);
            }

            if (!inWater) {
                // En superficie: siempre mantener el efecto a 10 segundos (full)
                player.addEffect(new MobEffectInstance(
                        MobEffects.WATER_BREATHING,
                        MAX_DURATION, 0, false, false, true
                ));
            }
            // Bajo el agua: Minecraft descuenta la duracion automaticamente cada tick.
            // Cuando se agote, el jugador pierde el efecto naturalmente.

            data.putBoolean(NBT_KEY_UNDERWATER, inWater);
        } else {
            // Sin casco de tortuga: limpiar
            if (data.contains(NBT_KEY_UNDERWATER)) {
                data.remove(NBT_KEY_UNDERWATER);
                player.removeEffect(MobEffects.WATER_BREATHING);
            }
        }
    }
}