package net.trevorskullcrafter.trevorssentinels.util;

import com.google.gson.JsonArray;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectUtil;
import net.minecraft.item.ItemConvertible;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.awt.*;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain.MOD_ID;

public class TextUtil {
    public static final Color DARK_RED = new Color(170, 0, 0); //#AA0000
    public static final Color RED = new Color(255, 85, 85);
    public static final Color GOLD = new Color(255, 170, 0); //#FFAA00
    public static final Color YELLOW = new Color(255, 255, 85); //#FFFF55
    public static final Color DARK_GREEN = new Color(0, 170, 0); //#00AA00
    public static final Color GREEN = new Color(85, 255, 85); //#55FF55
    public static final Color AQUA = new Color(85, 255, 255); //#55FFFF
    public static final Color DARK_AQUA = new Color(0, 170, 170); //#00AAAA
    public static final Color DARK_BLUE = new Color(0, 0, 170); //#0000AA
    public static final Color BLUE = new Color(85, 85, 255); //#5555FF
    public static final Color LIGHT_PURPLE = new Color(255, 85, 255); //#FF55FF
    public static final Color DARK_PURPLE = new Color(170, 0, 170); //#AA00AA
    public static final Color WHITE = new Color(255, 255, 255); //#FFFFFF
    public static final Color GRAY = new Color(170, 170, 170); //#AAAAAA
    public static final Color DARK_GRAY = new Color(85, 85, 85); //#555555
    public static final Color BLACK = new Color(0, 0, 0); //#000000

    public static final Color SENTINEL_AQUA1 = new Color(51, 204, 204); //#33CCCC
    public static final Color SENTINEL_AQUA2 = new Color(0, 153, 204); //#0099CC
    public static final Color SENTINEL_AQUA3 = new Color(0, 102, 153); //#006699
    public static final Color SENTINEL_GOLD1 = new Color(255, 204, 51); //#FFCC33
    public static final Color SENTINEL_GOLD2 = new Color(255, 153, 0); //#FF9900
    public static final Color SENTINEL_GOLD3 = new Color(220, 110, 0); //#DC6E00
    public static final Color SENTINEL_CRIMSON1 = new Color(255, 51, 51); //#FF3333
    public static final Color SENTINEL_CRIMSON2 = new Color(204, 0, 0); //#CC0000
    public static final Color SENTINEL_CRIMSON3 = new Color(153, 0, 0); //#990000

	public static final Color[] SENTINEL_AQUA = {SENTINEL_AQUA1, SENTINEL_AQUA2, SENTINEL_AQUA3};
	public static final Color[] SENTINEL_GOLD = {SENTINEL_GOLD1, SENTINEL_GOLD2, SENTINEL_GOLD3};
	public static final Color[] SENTINEL_CRIMSON = {SENTINEL_CRIMSON1, SENTINEL_CRIMSON2, SENTINEL_CRIMSON3};

    public static final Color SCRAP_METAL_BASE = new Color(121, 121, 121); //#797979
    public static final Color RUSTED_SCRAP_METAL = new Color(115, 105, 98); //#736962
    public static final Color COPPER = new Color(231, 124, 86); //#E77C56
    public static final Color ROSE_GOLD = new Color(247, 210, 197); //#F7D2C5
    public static final Color STARSTEEL_BASE = new Color(200, 200, 211); //#6F7D9D
    public static final Color IMPERIAL_ALLOY = new Color(234, 230, 155); //#EAE96B
    public static final Color IMPERIAL_ALLOY2 = new Color(181, 153, 75); //#EAE96B
    public static final Color BLOOD_RED = new Color(217, 0, 18); //#D90012
    public static final Color NUCLEAR1 = new Color(189, 247, 150); //#47FA0C
    public static final Color NUCLEAR2 = new Color(118, 224, 83); //#47FA0C
    public static final Color NUCLEAR3 = new Color(68, 204, 50); //#47FA0C
	public static final Color ZENITHIUM1 = new Color(38, 177, 72);
	public static final Color ZENITHIUM2 = new Color(43, 187, 200);
	public static final Color ZENITHIUM3 = new Color(141, 38, 177);

	public static final Color[] SCRAP_METAL = { SCRAP_METAL_BASE, RUSTED_SCRAP_METAL };
	public static final Color[] STARSTEEL = { STARSTEEL_BASE, SCRAP_METAL_BASE };
	public static final Color[] NUCLEAR = { NUCLEAR1, NUCLEAR2, NUCLEAR3 };
	public static final Color[] NANOTECH = { NUCLEAR1, BLOOD_RED, NUCLEAR3 };
	public static final Color[] ZENITHIUM = { ZENITHIUM1, ZENITHIUM2, ZENITHIUM3 };
	public static final Color[] RAINBOW = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.MAGENTA };

    public static final Color YGGDRASIL = new Color(234, 225, 229); //#EAE1E5
    public static final Color CHARRED = new Color(170, 170, 170); //#AAAAAA
    public static final Color MIDAS = new Color(190, 171, 39); //#BEAB27
    public static final Color VIRIDIAN = new Color(117, 137, 46); //#75892E
    public static final Color CERULII = new Color(17, 123, 205); //#117BCD

    public static final Color TRANQUIL = new Color(153, 73, 242); //#9949F2
    public static final Color SKULLWEED = new Color(128, 123, 173); //#807BAD
    public static final Color CHORUS = new Color(186, 155, 186); //#BA9BBA
    public static final Color PEARFRUIT = new Color(212, 255, 28); //#D4FF1C
    public static final Color SHINY_GOLD = new Color(249, 189, 35); //#F9BD23
    public static final Color FLESH_PINK = new Color(191, 87, 85); //#BF5755
    public static final Color VENDOR_TOKEN = new Color(162, 175, 177); //#A2AFB1
    public static final Color DOLPHIN = new Color(205, 220, 237); //#CDDCED
    public static final Color SMOKED_FISH = new Color(190, 171, 39); //#BEAB27
    public static final Color SALT = new Color(251, 235, 229); //#FBEBE5
    public static final Color MOSS = new Color(107, 137, 46); //#6B892E
    public static final Color DUNE_TAN = new Color(212, 185, 99); //#D4B963
    public static final Color SNOWSTONE = new Color(240, 253, 253); //#F0FDFD
    public static final Color HELLFIRE = new Color(244, 133, 34); //#F48522

	public static final Color PLASMA = new Color(25, 221, 223); //#19DDDF
	public static final Color PURE = new Color(249, 231, 159); //#FEF9E7
    public static final Color FLESH_PUS = new Color(200, 225, 100, 255); //#C8E164

    public static MutableText coloredText(String textContent, Color color) { return coloredText(Text.translatable(textContent), color); }
    public static MutableText coloredText(Text textContent, Color color) { return textContent.copy().fillStyle(color == null? Style.EMPTY : Style.EMPTY.withColor(color.getRGB())); }

    public static Formatting[] defaultFormattings = { Formatting.RED, Formatting.YELLOW, Formatting.GREEN, Formatting.AQUA, Formatting.LIGHT_PURPLE };
    public static Formatting[] reverseFormattings = { Formatting.LIGHT_PURPLE, Formatting.AQUA, Formatting.GREEN, Formatting.YELLOW, Formatting.RED };

    //Returns a Formatting based on the dividend / divisor.
    public static Formatting quotientToolTipFormatting(double dividend, double divisor) { return quotientToolTipFormatting(dividend, divisor, defaultFormattings); }
    public static Formatting quotientToolTipFormatting(double dividend, double divisor, Formatting... formattings) {
        double a = Math.abs(dividend * formattings.length - 1);
        int test = (int) Math.floor(a / divisor);
        return test >= 0 ? formattings[Math.min(test, formattings.length - 1)] : Formatting.GRAY;
    }

    public static Text potionText(StatusEffectInstance effect, boolean categorize){
        MutableText mutableText = Text.translatable(effect.getTranslationKey());
        if (effect.getAmplifier() > 0) { mutableText =
			Text.translatable("potion.withAmplifier", mutableText, Text.translatable("potion.potency." + effect.getAmplifier())); }
        if (effect.getDuration() > 20) { mutableText =
			Text.translatable("potion.withDuration", mutableText, StatusEffectUtil.durationToString(effect, 0.05f, 1.0f)); }
        return TextUtil.coloredText(mutableText, categorize? null : Color.decode(String.valueOf(effect.getEffectType().getColor())));
    }

    public static int tintByIndex(int tintIndex, int... tints){ return tints[tintIndex]; }
    public static int tintByIndex(int tintIndex, Color... tints){ return tints[tintIndex].getRGB(); }
    public static Color decodedColorKey(String string){ return Color.decode(Text.translatable(string).getString()); }
    @Nullable public static String translationDiffersFromKey(String translationKey){
        String translation = Text.translatable(translationKey).getString(); return translation.equals(translationKey)? null : translation;
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

	public static String stringifyTranslationKey(String key){
		return capitalize(key.substring(key.lastIndexOf(".") + 1).replace("_", " "));
	}

	public static JsonArray jsonArrayOf(JsonTextObject... objects){
		JsonArray entry = new JsonArray();
		for(JsonTextObject object : objects){ entry.add(object.build()); }
		return entry;
	}

	public static class TranslationInfo {
		public String key; public String rawText; public JsonTextObject[] text; public JsonTextObject[] tooltip; public Color[] textColor;
		public boolean underlined; public boolean italic; public boolean bold; public boolean strikethrough; public boolean obfuscated;
		public boolean potion;

		public TranslationInfo() { this.key = null; }
		public TranslationInfo(String key) { this.key = key; }
		public TranslationInfo(ItemConvertible item) { this.key = item instanceof Block block? block.getTranslationKey() : item.asItem().getTranslationKey(); }
		public TranslationInfo(StatusEffect effect, boolean potion) { this.key = effect.getTranslationKey(); this.potion = potion; }
		public TranslationInfo(EntityType<?> entityType) { this.key = entityType.getTranslationKey(); }
		public TranslationInfo(Enchantment enchantment) { this.key = enchantment.getTranslationKey(); }
		public TranslationInfo(EntityAttribute entityAttribute) { this.key = entityAttribute.getTranslationKey(); }
		public TranslationInfo(SoundEvent sound) { this.key = MOD_ID+":"+sound.getId().getPath(); }
		public TranslationInfo(Identifier identifier) { this.key = identifier.toTranslationKey(); }

		public TranslationInfo text(String text){ this.rawText = text; return this; }
		public TranslationInfo text(JsonTextObject... text){ this.text = text; return this; }
		public TranslationInfo textColor(Color... color){ this.textColor = color; return this; }
		public TranslationInfo tooltip(String tooltip){ return tooltip(new JsonTextObject().text(tooltip)); }
		public TranslationInfo tooltip(JsonTextObject... tooltip){ this.tooltip = tooltip; return this; }
		public TranslationInfo underlined(boolean underlined){ this.underlined = underlined; return this; }
		public TranslationInfo italic(boolean italic){ this.italic = italic; return this; }
		public TranslationInfo bold(boolean bold){ this.bold = bold; return this; }
		public TranslationInfo strikethrough(boolean strikethrough){ this.strikethrough = strikethrough; return this; }
		public TranslationInfo obfuscated(boolean obfuscated){ this.obfuscated = obfuscated; return this; }

		public TranslationInfo underlined(){ return underlined(true); }
		public TranslationInfo italic(){ return italic(true); }
		public TranslationInfo bold(){ return bold(true); }
		public TranslationInfo strikethrough(){ return strikethrough(true); }
		public TranslationInfo obfuscated(){ return obfuscated(true); }
	}
}
