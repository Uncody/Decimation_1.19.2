package com.decimation.event;

import com.decimation.ProjectDecimation;
import com.decimation.util.KeyBinding;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = ProjectDecimation.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if (KeyBinding.TEST_KEY.consumeClick()) {
                //Проверка на всякий случай, может вызвать NullPointer
                if(Minecraft.getInstance().player == null) return;
                Minecraft.getInstance().player.sendSystemMessage(Component.literal("Test Text"));
            }
        }

    }
    @Mod.EventBusSubscriber(modid = ProjectDecimation.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.TEST_KEY);
        }
    }


}
