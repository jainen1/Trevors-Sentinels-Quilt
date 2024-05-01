package net.trevorskullcrafter.trevorssentinels.datagen.lang;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.data.DataPackOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.stat.StatType;
import net.minecraft.text.component.TextComponent;
import net.minecraft.text.component.TranslatableComponent;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain;
import net.trevorskullcrafter.trevorssentinels.util.JsonTextObject;

import java.awt.*;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain.MOD_ID;
import static net.trevorskullcrafter.trevorssentinels.util.TextUtil.*;

public class OwoLanguageProvider extends FabricLanguageProvider {
	protected final FabricDataOutput dataOutput;
	private final String languageCode;

	protected OwoLanguageProvider(FabricDataOutput dataOutput, String languageCode) {
		super(dataOutput, languageCode);
		this.dataOutput = dataOutput;
		this.languageCode = languageCode;
	}

	@Override public void generateTranslations(TranslationBuilder translationBuilder) {}

	public void generateRichTranslations(OwoTranslationBuilder translationBuilder){}

	@Override public CompletableFuture<?> run(DataWriter writer) {
		TreeMap<String, JsonArray> translationEntries = new TreeMap<>();

		generateRichTranslations((String key, JsonArray jsonObject) -> {
			Objects.requireNonNull(key, "Attempt to index null translation key");
			if (jsonObject == null) { trevorssentinelsMain.LOGGER.warn("Attempt to index null contents for '" + key + "' will be ignored."); }
			else if (translationEntries.containsKey(key)) { trevorssentinelsMain.LOGGER.warn("Existing translation found for '" + key + "' - Duplicate will be ignored."); }
			else { translationEntries.put(key, jsonObject); }
		});

		JsonObject translationEntriesJson = new JsonObject();

		for (Map.Entry<String, JsonArray> entry : translationEntries.entrySet()) {
			translationEntriesJson.add(entry.getKey(), entry.getValue());
		}

		return DataProvider.writeToPath(writer, translationEntriesJson, dataOutput
			.createPathResolver(DataPackOutput.Type.RESOURCE_PACK, "lang")
			.resolveJsonFile(new Identifier(dataOutput.getModId(), this.languageCode)));
	}

	@FunctionalInterface public interface OwoTranslationBuilder {
		void add(String translationKey, JsonArray value);
		default void add(String translationKey, JsonTextObject... values){ add(translationKey, jsonArrayOf(values)); }
		default void add(TranslationInfo... entries){
			for(TranslationInfo entry : entries){ if(entry.key != null){
				if(entry.rawText == null){
					if(entry.text == null){ entry.rawText = stringifyTranslationKey(entry.key); }
					else {
						StringBuilder builder = new StringBuilder();
						for(JsonTextObject object : entry.text){ builder.append(object.object.get("text")); }
						entry.rawText = builder.toString();
					}
				}

				JsonArray name = new JsonArray();
				if(entry.text == null){
					if(entry.textColor == null || entry.textColor.length == 1){ name = jsonArrayOf(new JsonTextObject(entry)); }
					else {
						int sectionSize = entry.rawText.length() / (entry.textColor.length - 1);
						for (int colorIndex = 0; colorIndex < entry.textColor.length - 1; colorIndex++) {
							String substring = entry.rawText.substring(sectionSize * colorIndex, sectionSize * (colorIndex + 1));
							for (int i = 0; i < substring.length(); i++) {
								float ratio = (float) i / (float) substring.length();
								int red = (int) (entry.textColor[colorIndex + 1].getRed() * ratio + entry.textColor[colorIndex].getRed() * (1 - ratio));
								int green = (int) (entry.textColor[colorIndex + 1].getGreen() * ratio + entry.textColor[colorIndex].getGreen() * (1 - ratio));
								int blue = (int) (entry.textColor[colorIndex + 1].getBlue() * ratio + entry.textColor[colorIndex].getBlue() * (1 - ratio));
								Color stepColor = new Color(red, green, blue);
								name.add(new JsonTextObject(entry).text(String.valueOf(substring.charAt(i))).color(stepColor).build());
							}
						}
					}
				} else { name = jsonArrayOf(entry.text); }
				add(entry.key, name);

				if (entry.tooltip != null) { add(new TranslationInfo("tooltip." + entry.key).text(entry.tooltip)); }
				if (entry.potion) { String key = entry.key.substring(("effect."+ MOD_ID).length()+1);
					add(new TranslationInfo("item.minecraft.potion.effect."+key+"_potion").text(entry.rawText + " Potion"),
						new TranslationInfo("item.minecraft.splash_potion.effect."+key+"_potion").text("Splash Potion of " + entry.rawText),
						new TranslationInfo("item.minecraft.lingering_potion.effect."+key+"_potion").text("Lingering Potion of " + entry.rawText),
						new TranslationInfo("item.minecraft.tipped_arrow.effect."+key+"_potion").text("Arrow of " + entry.rawText));
				}
			}}
		}

		default void addWithParent(TranslationInfo parent, TranslationInfo... entries){
			for (TranslationInfo entry : entries) { if(entry != null && entry.key != null) {
				if(entry.tooltip == null) { entry.tooltip(parent.tooltip); }
				if(entry.textColor == null) { entry.textColor(parent.textColor); }
				if(entry.text == null && parent.text != null) { entry.text(parent.text); }
				else if(entry.rawText == null) { entry.text(parent.rawText); }
				add(entry);
			}}
		}

		default void addNumbered(TranslationInfo parent, TranslationInfo... nums){
			for (int i = 0; i < nums.length; i++) { add(new TranslationInfo(parent.key+(i+1)).text(nums[i].text)); }
		}

		default void addAdvancement(String advancement, TranslationInfo title, TranslationInfo description) {
			title.key = "advancements." + MOD_ID + "." + advancement + ".title";
			description.key = "advancements." + MOD_ID + "." + advancement + ".desc";
			add(title, description);
		}

		default void addPottedPlant(ItemConvertible r, ItemConvertible p, String name, String tooltip, Color color){
			if(r!=null) add(new TranslationInfo(r).text(name).tooltip(tooltip).textColor(color));
			if(p!=null) add(new TranslationInfo(p).text("Potted "+name).tooltip(tooltip).textColor(color));
		}

		default void addMusicDisc(TranslationInfo entry, JsonArray desc, SoundEvent sound){
			add(entry);
			add(entry.key+".desc", desc);
			add(new TranslationInfo(sound).text(entry.rawText + " plays"));
		}

		default void add(StatType<?> statType, JsonArray value) {
			add("stat_type." + Registries.STAT_TYPE.getId(statType).toString().replace(':', '.'), value);
		}
		default void add(RegistryKey<ItemGroup> registryKey, JsonArray value) {
			final ItemGroup group = Registries.ITEM_GROUP.getOrThrow(registryKey);
			final TextComponent content = group.getName().asComponent();
			if (content instanceof TranslatableComponent translatableTextContent) { add(translatableTextContent.getKey(), value); return; }
			throw new UnsupportedOperationException("Cannot add language entry for ItemGroup (%s) as the display text is not translatable.".formatted(group.getName().getString()));
		}
		default void add(Path existingLanguageFile) throws IOException {
			try (Reader reader = Files.newBufferedReader(existingLanguageFile)) {
				JsonObject translations = JsonParser.parseReader(reader).getAsJsonObject();

				for (String key : translations.keySet()) {
					add(key, translations.get(key).getAsJsonArray());
				}
			}
		}
	}
}
