package net.trevorskullcrafter.trevorssentinels.entity.client;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.util.math.MatrixStack;

@Environment(EnvType.CLIENT)
public class PhaserProjectileModel extends Model {
    private final ModelPart exterior;
    private final ModelPart interior;
    public PhaserProjectileModel(ModelPart root) {
        super(ModRenderLayers::getEntityTranslucentCullEmissive);
        this.exterior = root.getChild("exterior");
        this.interior = root.getChild("interior");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData interior = modelPartData.addChild("interior", ModelPartBuilder.create()
                        .uv(8, 8).cuboid(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)),
                ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        ModelPartData exterior = modelPartData.addChild("exterior", ModelPartBuilder.create()
				.uv(-4, 0).cuboid(-2.0F, -4.0F, -2.0F, 4.0F, 0.0F, 4.0F, new Dilation(0.0F))
				.uv(4, 0).cuboid(-2.0F, 4.0F, -2.0F, 4.0F, 0.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 8).cuboid(-2.0F, -4.0F, -2.0F, 0.0F, 8.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(2.0F, -4.0F, -2.0F, 0.0F, 8.0F, 4.0F, new Dilation(0.0F))
				.uv(24, 0).cuboid(-2.0F, -4.0F, 2.0F, 4.0F, 8.0F, 0.0F, new Dilation(0.0F))
				.uv(16, 0).cuboid(-2.0F, -4.0F, -2.0F, 4.0F, 8.0F, 0.0F, new Dilation(0.0F)),
                ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
    }

	@Override public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		exterior.render(matrices, vertices, 15, overlay, red, green, blue, alpha);
		interior.render(matrices, vertices, 15, overlay, 1.0f, 1.0f, 1.0f, alpha);
	}
}
