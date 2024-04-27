package net.trevorskullcrafter.trevorssentinels;

import com.terraformersmc.terraform.sign.SpriteIdentifierRegistry;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.resource.Material;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.entity.ModEntities;
import net.trevorskullcrafter.trevorssentinels.entity.client.*;
import net.trevorskullcrafter.trevorssentinels.event.KeyInputHandler;
import net.trevorskullcrafter.trevorssentinels.item.ModItems;
import net.trevorskullcrafter.trevorssentinels.item.TSItems;
import net.trevorskullcrafter.trevorssentinels.item.custom.PhotonicLensItem;
import net.trevorskullcrafter.trevorssentinels.networking.ModMessages;
import net.trevorskullcrafter.trevorssentinels.particle.ModSuspendParticle;
import net.trevorskullcrafter.trevorssentinels.util.ModRegistries;
import net.trevorskullcrafter.trevorssentinels.util.TextUtil;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.block.extensions.api.client.BlockRenderLayerMap;

public class trevorssentinelsClient implements ClientModInitializer {

	@Override public void onInitializeClient(ModContainer mod) {
		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xCFF8FF, ModItems.VENDOR_TOKEN);
		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> TextUtil.DARK_PURPLE.getRGB(), ModItems.LEGENDARY_TOKEN);

		ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> TextUtil.tintByIndex(tintIndex, TextUtil.SENTINEL_AQUA1, TextUtil.SENTINEL_AQUA3),
			ModBlocks.HARD_LIGHT, ModBlocks.HARD_LIGHT_BARRIER);
		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> TextUtil.tintByIndex(tintIndex, TextUtil.SENTINEL_AQUA1, TextUtil.SENTINEL_AQUA3),
			ModBlocks.HARD_LIGHT_BARRIER);
		ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> TextUtil.tintByIndex(tintIndex, TextUtil.SENTINEL_GOLD1, TextUtil.SENTINEL_GOLD3),
			ModBlocks.CAUTION_HARD_LIGHT, ModBlocks.CAUTION_HARD_LIGHT_BARRIER);
		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> TextUtil.tintByIndex(tintIndex, TextUtil.SENTINEL_GOLD1, TextUtil.SENTINEL_GOLD3),
			ModBlocks.CAUTION_HARD_LIGHT_BARRIER);
		ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> TextUtil.tintByIndex(tintIndex, TextUtil.SENTINEL_CRIMSON1, TextUtil.SENTINEL_CRIMSON3),
			ModBlocks.SENTINEL_HARD_LIGHT, ModBlocks.SENTINEL_HARD_LIGHT_BARRIER);
		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> TextUtil.tintByIndex(tintIndex, TextUtil.SENTINEL_CRIMSON1, TextUtil.SENTINEL_CRIMSON3),
			ModBlocks.SENTINEL_HARD_LIGHT_BARRIER);

		ColorProviderRegistry.ITEM.register((stack, tintIndex) ->
			TextUtil.tintByIndex(tintIndex, TextUtil.WHITE.getRGB(), ((PhotonicLensItem) stack.getItem()).getColor(stack)), TSItems.Tech.PHOTONIC_LENS);


		BlockRenderLayerMap.put(RenderLayer.getCutout(), ModBlocks.PALE_LEAVES, ModBlocks.PALE_SAPLING, ModBlocks.POTTED_PALE_SAPLING, ModBlocks.PALE_DOOR, ModBlocks.PALE_TRAPDOOR);
		BlockRenderLayerMap.put(RenderLayer.getCutout(), ModBlocks.CHARRED_DOOR, ModBlocks.CHARRED_TRAPDOOR);
		BlockRenderLayerMap.put(RenderLayer.getCutout(), ModBlocks.MIDAS_LEAVES, ModBlocks.MIDAS_SAPLING, ModBlocks.POTTED_MIDAS_SAPLING, ModBlocks.MIDAS_DOOR, ModBlocks.MIDAS_TRAPDOOR);
		BlockRenderLayerMap.put(RenderLayer.getCutout(), ModBlocks.VIRIDIAN_LEAVES, ModBlocks.VIRIDIAN_SAPLING, ModBlocks.POTTED_VIRIDIAN_SAPLING, ModBlocks.VIRIDIAN_DOOR,
			ModBlocks.VIRIDIAN_TRAPDOOR);
		BlockRenderLayerMap.put(RenderLayer.getCutout(), ModBlocks.CERULII_LEAVES, ModBlocks.CERULII_SAPLING, ModBlocks.POTTED_CERULII_SAPLING, ModBlocks.CERULII_DOOR,
			ModBlocks.CERULII_TRAPDOOR);
		BlockRenderLayerMap.put(RenderLayer.getCutout(), ModBlocks.FANCY_COMPUTER, ModBlocks.UNHOLY_BLOCK, ModBlocks.RECONSTRUCTION_TABLE, ModBlocks.MODIFICATION_TABLE,
			ModBlocks.TRANQUIL_ROSE, ModBlocks.POTTED_TRANQUIL_ROSE, ModBlocks.FEATHERCORN, ModBlocks.SKULLWEED, ModBlocks.POTTED_SKULLWEED, ModBlocks.RICE_PLANT, ModBlocks.FLESH_VEINS);
		BlockRenderLayerMap.put(RenderLayer.getTranslucent(), ModBlocks.HARD_LIGHT, ModBlocks.CAUTION_HARD_LIGHT, ModBlocks.SENTINEL_HARD_LIGHT, ModBlocks.HARD_LIGHT_BARRIER,
			ModBlocks.CAUTION_HARD_LIGHT_BARRIER, ModBlocks.SENTINEL_HARD_LIGHT_BARRIER);

		KeyInputHandler.register();
		ModMessages.registerS2CPackets();

		EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.PLASMA_PROJECTILE, PhaserProjectileModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.SENTINEL, SentinelEntityModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.ROOMBA, RoombaEntityModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.FLORBUS, FlorbusEntityModel::getTexturedModelData);

		ModRegistries.registerModelPredicates();
		EntityRendererRegistry.register(ModEntities.SENTINEL, SentinelEntityRenderer::new);
		EntityRendererRegistry.register(ModEntities.JANITOR_DROID, RoombaRenderer::new);
		EntityRendererRegistry.register(ModEntities.FLORBUS, FlorbusEntityRenderer::new);
		EntityRendererRegistry.register(ModEntities.SHARD_PROJECTILE, FlyingItemEntityRenderer::new);
		EntityRendererRegistry.register(ModEntities.DAGGER_PROJECTILE, DaggerEntityRenderer::new);
		EntityRendererRegistry.register(ModEntities.DELAYED_EXPLOSIVE, FlyingItemEntityRenderer::new);
		EntityRendererRegistry.register(ModEntities.PHASER_PROJECTILE, PhaserProjectileRenderer::new);

		ParticleFactoryRegistry.getInstance().register(ModRegistries.FLESH_PUS, ModSuspendParticle.FleshPusFactory::new);
		ParticleFactoryRegistry.getInstance().register(ModRegistries.MUZZLE_FLASH, ModSuspendParticle.MuzzleFlashFactory::new);

		SpriteIdentifierRegistry.INSTANCE.addIdentifier(new Material(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.PALE_SIGN_TEXTURE));
		SpriteIdentifierRegistry.INSTANCE.addIdentifier(new Material(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.PALE_HANGING_SIGN_TEXTURE));
		SpriteIdentifierRegistry.INSTANCE.addIdentifier(new Material(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.CHARRED_SIGN_TEXTURE));
		SpriteIdentifierRegistry.INSTANCE.addIdentifier(new Material(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.CHARRED_HANGING_SIGN_TEXTURE));
		SpriteIdentifierRegistry.INSTANCE.addIdentifier(new Material(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.MIDAS_SIGN_TEXTURE));
		SpriteIdentifierRegistry.INSTANCE.addIdentifier(new Material(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.MIDAS_HANGING_SIGN_TEXTURE));
		SpriteIdentifierRegistry.INSTANCE.addIdentifier(new Material(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.VIRIDIAN_SIGN_TEXTURE));
		SpriteIdentifierRegistry.INSTANCE.addIdentifier(new Material(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.VIRIDIAN_HANGING_SIGN_TEXTURE));
		SpriteIdentifierRegistry.INSTANCE.addIdentifier(new Material(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.CERULII_SIGN_TEXTURE));
		SpriteIdentifierRegistry.INSTANCE.addIdentifier(new Material(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.CERULII_HANGING_SIGN_TEXTURE));
	}
}
