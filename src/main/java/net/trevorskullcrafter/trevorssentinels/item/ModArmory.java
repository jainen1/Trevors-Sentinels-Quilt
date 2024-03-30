package net.trevorskullcrafter.trevorssentinels.item;

import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain.*;

public class ModArmory {

    public static final Item SCARA_SHEARS = registerItem("scara_shears", new SwordItem(ModToolMaterials.ZENITHIUM,3,-2.4f, new QuiltItemSettings().fireproof()));
    public static final Item MASTER_SWORD = registerItem("master_sword", new SwordItem(ModToolMaterials.ZENITHIUM, 3, -2.4f, new QuiltItemSettings().fireproof()));

    private static Item registerItem(String name, Item item){ return Registry.register(Registries.ITEM, new Identifier(MOD_ID, name), item); }
    public static void registerArmory(){ LOGGER.info("Registering armory... (" + MOD_ID + ")"); }
}
