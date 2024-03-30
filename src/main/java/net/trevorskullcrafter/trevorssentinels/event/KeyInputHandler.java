package net.trevorskullcrafter.trevorssentinels.event;

import com.mojang.blaze3d.platform.InputUtil;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBind;
import net.trevorskullcrafter.trevorssentinels.networking.ModMessages;
import org.lwjgl.glfw.GLFW;
import org.quiltmc.qsl.lifecycle.api.client.event.ClientTickEvents;
import org.quiltmc.qsl.networking.api.PacketByteBufs;
import org.quiltmc.qsl.networking.api.client.ClientPlayNetworking;

public class KeyInputHandler {
    public static final String KEY_CATEGORY_TREVORSSENTINELS = "key.category.trevorssentinels.trevorssentinels";
    public static final String KEY_STYLE_SWITCH = "key.trevorssentinels.style_switch";
    public static final String KEY_RELOAD = "key.trevorssentinels.reload";

    public static KeyBind styleSwitch;
	public static KeyBind reload;

    public static void registerKeyInputs(){
        ClientTickEvents.END.register(client -> {
            if(styleSwitch.wasPressed()) ClientPlayNetworking.send(ModMessages.STYLE_SWITCH_ID, PacketByteBufs.create());
            if(reload.wasPressed()) ClientPlayNetworking.send(ModMessages.RELOAD_ID, PacketByteBufs.create());
        });
    }

    public static void register(){
        styleSwitch = KeyBindingHelper.registerKeyBinding(new KeyBind(KEY_STYLE_SWITCH, InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_Z, KEY_CATEGORY_TREVORSSENTINELS));
        reload = KeyBindingHelper.registerKeyBinding(new KeyBind(KEY_RELOAD, InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_R, KEY_CATEGORY_TREVORSSENTINELS));

        registerKeyInputs();
    }
}
