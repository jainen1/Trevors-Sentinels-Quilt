package net.trevorskullcrafter.trevorssentinels.datagen.lang;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.Block;
import net.minecraft.data.DataPackOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.stat.StatType;
import net.minecraft.text.component.TextComponent;
import net.minecraft.text.component.TranslatableComponent;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.util.LangGenUtils;

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
import static net.trevorskullcrafter.trevorssentinels.util.LangGenUtils.*;

public class JsonLanguageProvider extends FabricLanguageProvider {
	protected final FabricDataOutput dataOutput;
	private final String languageCode;

	protected JsonLanguageProvider(FabricDataOutput dataOutput) { this(dataOutput, "en_us"); }
	protected JsonLanguageProvider(FabricDataOutput dataOutput, String languageCode) {
		super(dataOutput, languageCode);
		this.dataOutput = dataOutput;
		this.languageCode = languageCode;
	}

	@Override public void generateTranslations(TranslationBuilder translationBuilder) {}

	public void generateRichTranslations(JsonTranslationBuilder translationBuilder){}

	@Override public CompletableFuture<?> run(DataWriter writer) {
		TreeMap<String, JsonArray> translationEntries = new TreeMap<>();

		generateRichTranslations((String key, JsonArray jsonObject) -> {
			Objects.requireNonNull(key);
			Objects.requireNonNull(jsonObject);

			if (translationEntries.containsKey(key)) {
				throw new RuntimeException("Existing translation key found - " + key + " - Duplicate will be ignored.");
			}

			translationEntries.put(key, jsonObject);
		});

		JsonObject translationEntriesJson = new JsonObject();

		for (Map.Entry<String, JsonArray> entry : translationEntries.entrySet()) {
			translationEntriesJson.add(entry.getKey(), entry.getValue());
		}

		return DataProvider.method_10320(writer, translationEntriesJson, dataOutput
			.createPathResolver(DataPackOutput.Type.RESOURCE_PACK, "lang")
			.resolveJsonFile(new Identifier(dataOutput.getModId(), this.languageCode)));
	}

	@FunctionalInterface
	public interface JsonTranslationBuilder {
		void add(String translationKey, JsonArray value);
		default void add(String translationKey, String value, Color color){ add(translationKey, LangGenUtils.toJsonArray(LangGenUtils.jsonTextComponent(value, color))); }
		default void add(String translationKey, String value) { add(translationKey, value, Color.WHITE); }

		default void add(LangGenUtils.ItemTranslation... itemTranslations){
			for(LangGenUtils.ItemTranslation itemTranslation : itemTranslations){ if(itemTranslation.item != null){
				String itemKey = itemTranslation.item instanceof Block block? block.getTranslationKey() : itemTranslation.item.asItem().getTranslationKey();
				if(itemTranslation.name == null){ add(itemKey, stringifyTranslationKey(itemKey), itemTranslation.color); }
				else { add(itemKey, itemTranslation.name); }
				if (itemTranslation.tooltip != null) { add("tooltip." + itemKey, itemTranslation.tooltip); }
			}}
		}

		default void addItemsWithParent(LangGenUtils.ItemTranslation parent, LangGenUtils.ItemTranslation... itemTranslations){
			for (LangGenUtils.ItemTranslation itemTranslation:itemTranslations) { if(itemTranslation != null && itemTranslation.item != null) {
				JsonArray name = itemTranslation.name == null? parent.name : itemTranslation.name;
				JsonArray tooltip = itemTranslation.tooltip == null? parent.tooltip : itemTranslation.tooltip;
				Color color = itemTranslation.color == null? parent.color : itemTranslation.color;
				add(new LangGenUtils.ItemTranslation(itemTranslation.item).name(name).tooltip(tooltip).color(color));
			}}
		}

		default void add(String advancement, JsonArray title, JsonArray desc) {
			add("advancements." + MOD_ID + "." + advancement + ".title", title);
			add("advancements." + MOD_ID + "." + advancement + ".desc", desc);
		}

		//default void generateAdvancement(Advancement advancement, String title, String desc) {
		//    add("advancements." + advancement.id() + ".title", title);
		//    add("advancements." + advancement.id() + ".desc", desc);
		//}

		default void addNumbered(String translationKey, JsonArray... nums){
			for (int i = 0; i < nums.length; i++) { add(translationKey+(i+1), nums[i]); }
		}

		default void addPottedPlant(ItemConvertible r, ItemConvertible p, String name, String tooltip, Color color){
			if(r!=null) add(new LangGenUtils.ItemTranslation(r).name(name).tooltip(tooltip).color(color));
			if(p!=null) add(new LangGenUtils.ItemTranslation(p).name("Potted "+name).tooltip(tooltip).color(color));
		}

		default void addMusicDisc(LangGenUtils.ItemTranslation trans, JsonArray desc, SoundEvent sound){
			add(trans);
			add(trans.item.asItem().getTranslationKey()+".desc", desc);
			add(sound, stringToJsonArray(trans.item.asItem().getName().getString()+" plays"));
		}

		default void add(EntityType<?> entityType, JsonArray value) { add(entityType.getTranslationKey(), value); }
		default void add(Enchantment enchantment, JsonArray value) { add(enchantment.getTranslationKey(), value); }
		default void add(EntityAttribute entityAttribute, JsonArray value) { add(entityAttribute.getTranslationKey(), value); }
		default void add(StatusEffect statusEffect, JsonArray value) { add(statusEffect.getTranslationKey(), value); }
		default void addStatusEffect(StatusEffect statusEffect, JsonArray name, boolean hasPotion){
			add(statusEffect, name);
			if(hasPotion){
				String key = statusEffect.getTranslationKey().substring(("effect."+ MOD_ID).length()+1);
				add("item.minecraft.potion.effect."+key+"_potion", name + " Potion");
				add("item.minecraft.splash_potion.effect."+key+"_potion", "Splash Potion of " + name);
				add("item.minecraft.lingering_potion.effect."+key+"_potion", "Lingering Potion of " + name);
				add("item.minecraft.tipped_arrow.effect."+key+"_potion", "Arrow of " + name);
			}
		}
		default void add(SoundEvent sound, JsonArray value) { add(MOD_ID+":"+sound.getId().getPath(), value); }
		default void add(Identifier identifier, JsonArray value) { add(identifier.toTranslationKey(), value); }
		default void add(StatType<?> statType, JsonArray value) {
			add("stat_type." + Registries.STAT_TYPE.getId(statType).toString().replace(':', '.'), value);
		}
		default void add(RegistryKey<ItemGroup> registryKey, JsonArray value) {
			final ItemGroup group = Registries.ITEM_GROUP.getOrThrow(registryKey);
			final TextComponent content = group.getName().asComponent();
			if (content instanceof TranslatableComponent translatableTextContent) { add(translatableTextContent.getKey(), value); return; }
			throw new UnsupportedOperationException("Cannot add language entry for ItemGroup (%s) as the display name is not translatable.".formatted(group.getName().getString()));
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
