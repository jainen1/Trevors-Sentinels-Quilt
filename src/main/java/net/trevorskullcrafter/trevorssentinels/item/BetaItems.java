package net.trevorskullcrafter.trevorssentinels.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain.MOD_ID;

public class BetaItems {
    public static final Item JUMP_DRIVE = registerItem("jump_drive", new JumpItemv2(ModArmorMaterials.IMPERIAL, ArmorItem.ArmorSlot.CHESTPLATE,
            new QuiltItemSettings().maxDamage(100)));
    public static final Item JETPACK = registerItem("jetpack", new JetpackItem(ModArmorMaterials.NUCLEAR, ArmorItem.ArmorSlot.CHESTPLATE,
            new QuiltItemSettings().maxDamage(100)));
    public static final Item DISTANCE_TRACKER = registerItem("distance_tracker", new DistanceTrackerItem(new QuiltItemSettings().maxCount(1)));

    public static final Item PAPPYM_BLADE = registerItem("pappym_blade",
            new PappyMSwordItem(ModToolMaterials.ZENITHIUM,0,-2.5f,
                    new QuiltItemSettings().fireproof().maxDamage(1200)));

    public static final Item PAPPYD_BLADE = registerItem("pappyd_blade",
            new PappyDSwordItem(ModToolMaterials.ZENITHIUM,0,-2.5f, new QuiltItemSettings().fireproof()));

    public static final Item THANATU_BLADE = registerItem("thanatu_blade",
            new ThanatuBladeItem(ModToolMaterials.ZENITHIUM, 3,-2.8f, new QuiltItemSettings().fireproof()));

    public static final Item MORPHEUS_BLADE = registerItem("morpheus_blade",
            new MorpheusBladeItem(ModToolMaterials.ZENITHIUM,3,-2.4f, new QuiltItemSettings().fireproof()));

    public static final Item SKYLAR_BLADE = registerItem("skylar_blade",
            new SkylarBladeItem(ModToolMaterials.ZENITHIUM,0,-2.4f, new QuiltItemSettings().fireproof()));

    public static final Item LILITH_BLADE = registerItem("lilith_blade",
            new LilithBladeItem(ModToolMaterials.ZENITHIUM,-5,-2.4f, new QuiltItemSettings().fireproof()));

    public static final Item TREVOR_BLADE = registerItem("trevor_blade",
            new TrevorBladeItem(ModToolMaterials.ZENITHIUM,3,-2.4f, new QuiltItemSettings().fireproof()));

    public static final Item KINGS_BLADE = registerItem("kings_blade",
            new KingsBladeItem(ModToolMaterials.ZENITHIUM,3,-2.4f, new QuiltItemSettings().fireproof()));

    public static final Item COPPER_ARM = registerItem("copper_arm",
            new CopperArmItem(new QuiltItemSettings().maxDamage(465)));

    public static final Item BLACKSMITHS_WELDING_MASK = registerItem("blacksmiths_welding_mask",
            new ArmorItem(ModArmorMaterials.ZENITHIUM, ArmorItem.ArmorSlot.HELMET, new QuiltItemSettings()));

    public static final Item MAD_SCIENTISTS_LAB_COAT = registerItem("mad_scientists_lab_coat",
            new ArmorItem(ModArmorMaterials.ZENITHIUM, ArmorItem.ArmorSlot.CHESTPLATE, new QuiltItemSettings()));

    private static Item registerItem(String name, Item item){ return Registry.register(Registries.ITEM, new Identifier(MOD_ID, name), item); }
    public static void registerModItems(){ trevorssentinelsMain.LOGGER.info("Registering beta items... ("+ MOD_ID + ")"); }
}
