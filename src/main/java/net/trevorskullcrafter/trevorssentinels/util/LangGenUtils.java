package net.trevorskullcrafter.trevorssentinels.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.Block;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.ItemConvertible;
import net.minecraft.sound.SoundEvent;
import net.trevorskullcrafter.trevorssentinels.datagen.lang.JsonLanguageProvider;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain.MOD_ID;

public class LangGenUtils {
	public static String capitalize(String str) {
		if (str.isEmpty()) { return str; }
		else { char[] buffer = str.toCharArray(); boolean capitalizeNext = true;
			for(int i = 0; i < buffer.length; ++i) {
				char ch = buffer[i];
				if (Character.isWhitespace(ch)) { capitalizeNext = true; }
				else if (capitalizeNext) { buffer[i] = Character.toTitleCase(ch); capitalizeNext = false; }
			} return new String(buffer);
		}
	}

	public static String stringifyTranslationKey(String key){
		return capitalize(key.substring(key.lastIndexOf(".") + 1).replace("_", " "));
	}

	public static JsonObject jsonTextComponent(String name, Color color){
		JsonObject object = new JsonObject();
		object.addProperty("text", name);
		if(color != null) { object.addProperty("color", "#" + Integer.toHexString(color.getRGB()).substring(2)); }
		return object;
	}

	public static JsonArray toJsonArray(JsonObject... objects){
		JsonArray entry = new JsonArray();
		for(JsonObject object : objects){ entry.add(object); }
		return entry;
	}

	public static JsonArray stringToJsonArray(String string){ return toJsonArray(jsonTextComponent(string, Color.WHITE)); }

	public static class ItemTranslation{
		public ItemConvertible item; public JsonArray name; public JsonArray tooltip; public Color color;
		public ItemTranslation(ItemConvertible item){ this.item = item; }
		public ItemTranslation name(String name){ this.name = toJsonArray(jsonTextComponent(name, color)); return this; }
		public ItemTranslation name(JsonArray name){ this.name = name; return this; }
		public ItemTranslation tooltip(String tooltip){ this.tooltip = toJsonArray(jsonTextComponent(tooltip, Color.WHITE)); return this; }
		public ItemTranslation tooltip(JsonArray tooltip){ this.tooltip = tooltip; return this; }
		public ItemTranslation color(Color color){ this.color = color; return this; }
	}
}
