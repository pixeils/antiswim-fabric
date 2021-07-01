package net.pixeils.antiswim.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.network.MessageType;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class AntiSwim implements ClientModInitializer {
    public static boolean antiswim = true;
    public void onInitializeClient() {
        KeyBinding toggleAntiSwim = KeyBindingHelper.registerKeyBinding(new KeyBinding("AntiSwim", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_RIGHT_BRACKET,"Pixeils' Mod"));
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (toggleAntiSwim.wasPressed()){
                antiswim = !antiswim;
                client.inGameHud.addChatMessage(MessageType.SYSTEM, Text.of("Toggled AntiSwim"), client.player.getUuid());
                }
        });
    }
}
