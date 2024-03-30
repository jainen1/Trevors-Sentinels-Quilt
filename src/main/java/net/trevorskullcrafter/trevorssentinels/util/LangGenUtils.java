package net.trevorskullcrafter.trevorssentinels.util;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.Block;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.ItemConvertible;
import net.minecraft.sound.SoundEvent;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain.MOD_ID;

public class LangGenUtils {
    public static void generateAdvancement(@NotNull FabricLanguageProvider.TranslationBuilder translationBuilder, String advancement, String title, String desc) {
        translationBuilder.add("advancements." + MOD_ID + "." + advancement + ".title", title);
        translationBuilder.add("advancements." + MOD_ID + "." + advancement + ".desc", desc);
    }

    //public static void generateAdvancement(@NotNull FabricLanguageProvider.TranslationBuilder translationBuilder, Advancement advancement, String title, String desc) {
    //    translationBuilder.add("advancements." + advancement.id() + ".title", title);
    //    translationBuilder.add("advancements." + advancement.id() + ".desc", desc);
    //}

	public static void generateNumbered(FabricLanguageProvider.TranslationBuilder translationBuilder, String translationKey, String... nums){
		for (int i = 0; i < nums.length; i++) { translationBuilder.add(translationKey+(i+1), nums[i]); }
	}

    public static void generateStatusEffect(FabricLanguageProvider.TranslationBuilder translationBuilder, StatusEffect statusEffect, String name, boolean hasPotion){
        translationBuilder.add(statusEffect, name);
        if(hasPotion){
            String key = statusEffect.getTranslationKey().substring(("effect."+ MOD_ID).length()+1);
            translationBuilder.add("item.minecraft.potion.effect."+key+"_potion", name + " Potion");
            translationBuilder.add("item.minecraft.splash_potion.effect."+key+"_potion", "Splash Potion of " + name);
            translationBuilder.add("item.minecraft.lingering_potion.effect."+key+"_potion", "Lingering Potion of " + name);
            translationBuilder.add("item.minecraft.tipped_arrow.effect."+key+"_potion", "Arrow of " + name);
        }
    }

    public static void generatePot(@NotNull FabricLanguageProvider.TranslationBuilder translationBuilder, ItemConvertible r, ItemConvertible p, String name, String tooltip, Color color){
        if(r!=null) generateItems(translationBuilder, ItemTranslation.of(r, name, tooltip, color));
        if(p!=null) generateItems(translationBuilder, ItemTranslation.of(p, "Potted "+name, tooltip, color));
    }

    public static void generateSound(FabricLanguageProvider.TranslationBuilder translationBuilder, SoundEvent sound, String subtitle){
        translationBuilder.add(MOD_ID+":"+sound.getId().getPath(), subtitle);
    }

    public static void generateMusicDisc(FabricLanguageProvider.TranslationBuilder translationBuilder, ItemTranslation trans, String desc, SoundEvent sound){
        generateItems(translationBuilder, trans);
        translationBuilder.add(trans.item.asItem().getTranslationKey()+".desc", desc);
        generateSound(translationBuilder, sound, trans.item.asItem().getName().getString()+" plays");
    }

	public static String getItemKey(ItemConvertible item){
		if (item instanceof Block block) { return block.getTranslationKey(); }
		else { return item.asItem().getTranslationKey(); }
	}

	public static void generateTooltip(FabricLanguageProvider.TranslationBuilder translationBuilder, ItemTranslation item){
		translationBuilder.add("tooltip." + getItemKey(item.item), item.tooltip);
	}

	public static void generateItems(@NotNull FabricLanguageProvider.TranslationBuilder translationBuilder, ItemTranslation... items){
		for (ItemTranslation item:items) { if(item.item != null) {
			translationBuilder.add(getItemKey(item.item), item.name);
			if (item.tooltip != null) { generateTooltip(translationBuilder, item); }
		}}
	}

	public static void generateItemsWithParent(@NotNull FabricLanguageProvider.TranslationBuilder translationBuilder, ItemTranslation parent, ItemTranslation... items){
		for (ItemTranslation item:items) { if(item.item != null) {
			String name = item.name == null? parent.name : item.name;
			String tooltip = item.tooltip == null? parent.tooltip : item.tooltip;
			Color color = item.color == null? parent.color : item.color;
			generateItems(translationBuilder, ItemTranslation.of(item.item, name, tooltip, color));
		}}
	}

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

	public static class ItemTranslation{
		ItemConvertible item; String name; String tooltip; Color color;
		private ItemTranslation(ItemConvertible item, String name, String tooltip, Color color){ this.item = item; this.name = name; this.tooltip = tooltip; this.color = color; }

		public static ItemTranslation of(ItemConvertible item, String name, String tooltip, Color color) { return new ItemTranslation(item, name, tooltip, color); }
		public static ItemTranslation of(ItemConvertible item, String name, Color color) { return of(item, name, null, color); }
		public static ItemTranslation of(ItemConvertible item, String name) { return of(item, name, null, null); }
		public static ItemTranslation of(ItemConvertible item) {
			return of(item, capitalize(getItemKey(item).substring(getItemKey(item).lastIndexOf(".") + 1).replace("_", " ")), null, null); }
	}
}
