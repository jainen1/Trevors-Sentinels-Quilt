package net.trevorskullcrafter.trevorssentinels.villager;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.item.MagicItems;
import net.trevorskullcrafter.trevorssentinels.item.ModItems;
import net.trevorskullcrafter.trevorssentinels.item.TechItems;
import net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain;
import org.quiltmc.qsl.entity.extensions.api.PointOfInterestHelper;
import org.quiltmc.qsl.entity.extensions.api.TradeOfferHelper;

public class ModVillagers {

    public static final PointOfInterestType DEMOLITIONIST_POI = registerPOI("demolitionist_poi", Blocks.TNT);
    public static final VillagerProfession DEMOLITIONIST = registerProfession("demolitionist",
            RegistryKey.of(Registries.POINT_OF_INTEREST_TYPE.getKey(), new Identifier(trevorssentinelsMain.MOD_ID,"demolitionist_poi")));

    public static final PointOfInterestType WITHERSEER_POI = registerPOI("witherseer_poi", Blocks.RESPAWN_ANCHOR);
    public static final VillagerProfession WITHERSEER = registerProfession("witherseer",
            RegistryKey.of(Registries.POINT_OF_INTEREST_TYPE.getKey(), new Identifier(trevorssentinelsMain.MOD_ID,"witherseer_poi")));

    public static final PointOfInterestType ACOLYTE_POI = registerPOI("acolyte_poi", Blocks.DRAGON_EGG);
    public static final VillagerProfession ACOLYTE = registerProfession("acolyte",
            RegistryKey.of(Registries.POINT_OF_INTEREST_TYPE.getKey(), new Identifier(trevorssentinelsMain.MOD_ID,"acolyte_poi")));


    public static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(trevorssentinelsMain.MOD_ID, name),
			VillagerProfessionBuilder.create().id(new Identifier(trevorssentinelsMain.MOD_ID, name)).workstation(type).workSound(SoundEvents.ENTITY_VILLAGER_WORK_ARMORER).build());
    }

    public static PointOfInterestType registerPOI(String name, Block block){
        return Registries.POINT_OF_INTEREST_TYPE.get(PointOfInterestHelper.register(new Identifier(trevorssentinelsMain.MOD_ID, name),
			1, 1, ImmutableSet.copyOf(block.getStateManager().getStates())));
    }

    public static void registerVillagers(){ trevorssentinelsMain.LOGGER.debug("Fixing the unemployment rate... ("+trevorssentinelsMain.MOD_ID+")"); }

    public static void registerTrades(){
        TradeOfferHelper.registerVillagerOffers(DEMOLITIONIST,1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
				new ItemStack(Items.EMERALD, 16),
				new ItemStack(Items.GUNPOWDER,64),
				4,2,0.02f));
            factories.add((entity, random) -> new TradeOffer(
				new ItemStack(Items.EMERALD, 6),
				new ItemStack(Items.FIREWORK_STAR,2),
				6,2,0.02f));
            factories.add((entity, random) -> new TradeOffer(
				new ItemStack(Items.EMERALD, 16),
				new ItemStack(Items.FIREWORK_ROCKET,16),
				4,2,0.02f));
            factories.add((entity, random) -> new TradeOffer(
				new ItemStack(Items.EMERALD, 3),
				new ItemStack(Items.TNT,1),
				8,2,0.02f));
        });

        TradeOfferHelper.registerVillagerOffers(WITHERSEER,1, factories -> {
			factories.add((entity, random) -> new TradeOffer(
				new ItemStack(MagicItems.SOUL, 2),
				new ItemStack(MagicItems.TRANQUIL_ESSENCE,8),
				new ItemStack(MagicItems.DEMON_SOUL, 1),
				16,5,0.02f));
        });
        TradeOfferHelper.registerVillagerOffers(WITHERSEER,2, factories -> {
            factories.add((entity, random) -> new TradeOffer(
				new ItemStack(Items.EMERALD, 3),
				new ItemStack(Items.TNT,1),
				8,2,0.02f));
        });
    }
}
