package net.trevorskullcrafter.trevorssentinels.entity.client;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Axis;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.trevorskullcrafter.trevorssentinels.entity.custom.PhaserProjectileEntity;
import net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain;
import org.joml.Vector3f;

public class PhaserProjectileRenderer extends EntityRenderer<PhaserProjectileEntity> {
    private final PhaserProjectileModel model;

    public PhaserProjectileRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new PhaserProjectileModel(context.getPart(ModEntityModelLayers.PLASMA_PROJECTILE));
    }

    public void render(PhaserProjectileEntity projectile, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if(projectile.getAge() > 1) {
            matrixStack.push();
            matrixStack.multiply(Axis.Y_POSITIVE.rotationDegrees(MathHelper.lerp(g, projectile.prevYaw, projectile.getYaw()) - 90.0F));
            matrixStack.multiply(Axis.Z_POSITIVE.rotationDegrees(MathHelper.lerp(g, projectile.prevPitch, projectile.getPitch()) + 90.0F));
            VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(this.model.getLayer(this.getTexture(projectile)));
            Vector3f color = Vec3d.unpackRgb(projectile.getColor()).toVector3f();
			int ticksLeft = projectile.getLifetime() - projectile.getAge();
			int speed = (int) (projectile.getVelocity().length() * 10);
			this.model.render(matrixStack, vertexConsumer, 15, OverlayTexture.DEFAULT_UV, color.x(), color.y(), color.z(),
				((ticksLeft <= 10)? Math.max(0, ticksLeft * 0.1f) : 1.0f) * ((speed <= 20)? Math.max(0, speed * 0.05f) : 1.0f));
            matrixStack.pop();
            super.render(projectile, f, g, matrixStack, vertexConsumerProvider, 15);
        }
    }

    @Override public Identifier getTexture(PhaserProjectileEntity entity) { return new Identifier(trevorssentinelsMain.MOD_ID, "textures/entity/phaser_projectile.png"); }
}
