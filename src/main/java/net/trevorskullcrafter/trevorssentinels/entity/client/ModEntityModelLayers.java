package net.trevorskullcrafter.trevorssentinels.entity.client;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain;

public class ModEntityModelLayers {
    public static final EntityModelLayer PLASMA_PROJECTILE = new EntityModelLayer(new Identifier(trevorssentinelsMain.MOD_ID, "plasma_projectile"), "main");
    public static final EntityModelLayer SENTINEL = new EntityModelLayer(new Identifier(trevorssentinelsMain.MOD_ID, "sentinel"), "main");
	public static final EntityModelLayer ROOMBA = new EntityModelLayer(new Identifier(trevorssentinelsMain.MOD_ID, "roomba"), "main");
	public static final EntityModelLayer FLORBUS = new EntityModelLayer(new Identifier(trevorssentinelsMain.MOD_ID, "florbus"), "main");
}
