package net.trevorskullcrafter.trevorssentinels.recipe;

import net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain;

public class ModRecipes {
    public static void registerRecipes(){
        trevorssentinelsMain.LOGGER.info("Cooking up some fun... ("+ trevorssentinelsMain.MOD_ID + ")");
        //Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(trevorssentinels.MOD_ID, ForgeRecipe.Serializer.ID),
        //        ForgeRecipe.Serializer.INSTANCE);
        //Registry.register(Registries.RECIPE_TYPE, new Identifier(trevorssentinels.MOD_ID, ForgeRecipe.Type.ID),
        //        ForgeRecipe.Type.INSTANCE);
    }
}
