package net.trevorskullcrafter.trevorssentinels.util;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.effect.StatusEffectUtil;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.jetbrains.annotations.Nullable;

import java.awt.*;

public class TextUtil {
    public static final Color DARK_RED = new Color(Formatting.DARK_RED.getColorValue()); //#AA0000
    public static final Color RED = new Color(Formatting.RED.getColorValue()); //#FF5555
    public static final Color GOLD = new Color(Formatting.GOLD.getColorValue()); //#FFAA00
    public static final Color YELLOW = new Color(Formatting.YELLOW.getColorValue()); //#FFFF55
    public static final Color DARK_GREEN = new Color(Formatting.DARK_GREEN.getColorValue()); //#00AA00
    public static final Color GREEN = new Color(Formatting.GREEN.getColorValue()); //#55FF55
    public static final Color AQUA = new Color(Formatting.AQUA.getColorValue()); //#55FFFF
    public static final Color DARK_AQUA = new Color(Formatting.DARK_AQUA.getColorValue()); //#00AAAA
    public static final Color DARK_BLUE = new Color(Formatting.DARK_BLUE.getColorValue()); //#0000AA
    public static final Color BLUE = new Color(Formatting.BLUE.getColorValue()); //#5555FF
    public static final Color LIGHT_PURPLE = new Color(Formatting.LIGHT_PURPLE.getColorValue()); //#FF55FF
    public static final Color DARK_PURPLE = new Color(Formatting.DARK_PURPLE.getColorValue()); //#AA00AA
    public static final Color WHITE = new Color(Formatting.WHITE.getColorValue()); //#FFFFFF
    public static final Color GRAY = new Color(Formatting.GRAY.getColorValue()); //#AAAAAA
    public static final Color DARK_GRAY = new Color(Formatting.DARK_GRAY.getColorValue()); //#555555
    public static final Color BLACK = new Color(Formatting.BLACK.getColorValue()); //#000000

    public static final Color SENTINEL_AQUA_T1 = new Color(51, 204, 204); //#189DBB
    public static final Color SENTINEL_AQUA_T2 = new Color(0, 153, 204); //#006771
    public static final Color SENTINEL_AQUA_T3 = new Color(0, 102, 153); //#006771
    public static final Color SENTINEL_GOLD_T1 = new Color(255, 204, 51); //#006771
    public static final Color SENTINEL_GOLD_T2 = new Color(255, 153, 0); //#006771
    public static final Color SENTINEL_GOLD_T3 = new Color(220, 110, 0); //#825700
    public static final Color SENTINEL_CRIMSON_T1 = new Color(255, 51, 51); //#D31400
    public static final Color SENTINEL_CRIMSON_T2 = new Color(204, 0, 0); //#D31400
    public static final Color SENTINEL_CRIMSON_T3 = new Color(153, 0, 0); //#710000

    public static final Color SCRAP_METAL = new Color(121, 121, 121); //#797979
    public static final Color RUSTED_SCRAP_METAL = new Color(115, 105, 98); //#736962
    public static final Color COPPER = new Color(231, 124, 86); //#E77C56
    public static final Color ROSE_GOLD = new Color(247, 210, 197); //#F7D2C5
    public static final Color STARSTEEL = new Color(200, 200, 211); //#6F7D9D
    public static final Color IMPERIAL_ALLOY = new Color(234, 230, 155); //#EAE96B
    public static final Color BLOOD_RED = new Color(217, 0, 18); //#D90012
    public static final Color NUCLEAR = new Color(71, 250, 12); //#47FA0C

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
    public static final Color PATRIOT_1 = new Color(180, 0, 0); //#B40000
    public static final Color PATRIOT_2 = new Color(39, 59, 147); //#273B93
    public static final Color HELLFIRE = new Color(244, 133, 34); //#F48522

    public static final Color GAS_TEST = new Color(113, 255, 124); //#71ff7c
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
        StatusEffectType category = effect.getEffectType().getType();
        if (effect.getAmplifier() > 0) { mutableText = Text.translatable("potion.withAmplifier", mutableText, Text.translatable("potion.potency." + effect.getAmplifier())); }
        if (effect.getDuration() > 20) { mutableText = Text.translatable("potion.withDuration", mutableText, StatusEffectUtil.durationToString(effect, 1.0f)); }
        Color color;
        if(categorize){ color = (category == StatusEffectType.BENEFICIAL? TextUtil.GREEN : category == StatusEffectType.NEUTRAL? TextUtil.YELLOW : TextUtil.RED); }
        else { color = Color.decode(String.valueOf(effect.getEffectType().getColor())); }
        return TextUtil.coloredText(mutableText, color);
    }

    public static int tintByIndex(int tintIndex, int... tints){ return tints[tintIndex]; }
    public static int tintByIndex(int tintIndex, Color... tints){ return tints[tintIndex].getRGB(); }
    public static Color decodedColorKey(String string){ return Color.decode(Text.translatable(string).getString()); }
    @Nullable public static String translationDiffersFromKey(String translationKey){
        String translation = Text.translatable(translationKey).getString(); return translation.equals(translationKey)? null : translation;
    }
}
