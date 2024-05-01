package net.trevorskullcrafter.trevorssentinels.entity.client;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.trevorskullcrafter.trevorssentinels.entity.custom.SentinelEntity;
import net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain;
import org.joml.Vector3f;

public class SentinelEyeFeatureRenderer<T extends SentinelEntity> extends EyesFeatureRenderer<T, SentinelEntityModel<T>> {
	private static final RenderLayer SKIN = RenderLayer.getEyes(new Identifier(trevorssentinelsMain.MOD_ID, "textures/entity/sentinel_eye.png"));

	public SentinelEyeFeatureRenderer(FeatureRendererContext<T, SentinelEntityModel<T>> featureRendererContext) { super(featureRendererContext); }

	public RenderLayer getEyesLayer() { return SKIN; }

	@Override public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, T entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
		Vector3f color = Vec3d.unpackRgb(entity.getColor()).toVector3f();
		VertexConsumer vertexConsumer = vertexConsumers.getBuffer(this.getEyesLayer());
		this.getContextModel().render(matrices, vertexConsumer, 15728640, OverlayTexture.DEFAULT_UV, color.x(), color.y(), color.z(), 1.0F);
	}
}
