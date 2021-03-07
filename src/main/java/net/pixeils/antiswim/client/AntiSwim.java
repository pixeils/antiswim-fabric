package net.pixeils.antiswim.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class AntiSwim implements ClientModInitializer {
    public static boolean antiswim = true;
    public void onInitializeClient() {
        KeyBinding toggleAntiSwim = KeyBindingHelper.registerKeyBinding(new KeyBinding("AntiSwim", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_RIGHT_BRACKET,"Pixeils Mod"));
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while(toggleAntiSwim.wasPressed())
                antiswim = !antiswim;


        });
    }
}
