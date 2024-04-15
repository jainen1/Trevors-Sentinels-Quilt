package net.trevorskullcrafter.trevorssentinels.entity.animation;

import net.minecraft.client.render.animation.Animation;
import net.minecraft.client.render.animation.AnimationKeyframe;
import net.minecraft.client.render.animation.Animator;
import net.minecraft.client.render.animation.PartAnimation;

public class ModAnimations {
	public static final Animation SPAWN = Animation.Builder.withLength(1f)
		.addPartAnimation("mainbody",
			new PartAnimation(PartAnimation.AnimationTargets.SCALE,
				new AnimationKeyframe(0f, Animator.scale(0f, 0f, 0f), PartAnimation.Interpolations.SPLINE),
				new AnimationKeyframe(0.15f, Animator.scale(1f, 1f, 0f), PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(0.35f, Animator.scale(1f, 1f, 0.7f), PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(0.5f, Animator.scale(1f, 0.8f, 0.8f), PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(0.75f, Animator.scale(1f, 1f, 1f), PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(1f, Animator.scale(1f, 1f, 1f), PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("visor",
			new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
				new AnimationKeyframe(0.5f, Animator.translate(0f, 4f, 0f), PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(0.85f, Animator.translate(0f, 0f, 0f), PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("visor",
			new PartAnimation(PartAnimation.AnimationTargets.SCALE,
				new AnimationKeyframe(0f, Animator.scale(0f, 0f, 0f), PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(0.15f, Animator.scale(0f, 0.5f, 1f), PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(0.35f, Animator.scale(1f, 0.5f, 1f), PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(0.5f, Animator.scale(1f, 1f, 1f), PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(0.85f, Animator.scale(1f, 1f, 1f), PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("lens",
			new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
				new AnimationKeyframe(0.25f, Animator.translate(0f, 0f, 5f), PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(0.5f, Animator.translate(0f, 0f, 6f), PartAnimation.Interpolations.SPLINE),
				new AnimationKeyframe(0.85f, Animator.translate(0f, 0f, -1f), PartAnimation.Interpolations.SPLINE),
				new AnimationKeyframe(1f, Animator.translate(0f, 0f, 0f), PartAnimation.Interpolations.SPLINE)))
		.addPartAnimation("lens",
			new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
				new AnimationKeyframe(0.4f, Animator.rotate(0f, 0f, 720f), PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(0.8f, Animator.rotate(0f, 0f, 0f), PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("lens",
			new PartAnimation(PartAnimation.AnimationTargets.SCALE,
				new AnimationKeyframe(0f, Animator.scale(0f, 0f, 0f), PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(0.25f, Animator.scale(1f, 1f, 0f), PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(1f, Animator.scale(1f, 1f, 1f), PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("left",
			new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
				new AnimationKeyframe(0.5f, Animator.rotate(0f, 0f, -45f), PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(0.75f, Animator.rotate(0f, 0f, 22.5f), PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(0.95f, Animator.rotate(0f, 0f, 0f), PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("right",
			new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
				new AnimationKeyframe(0.5f, Animator.rotate(0f, 0f, 45f), PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(0.75f, Animator.rotate(0f, 0f, -20f), PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(0.95f, Animator.rotate(0f, 0f, 0f), PartAnimation.Interpolations.LINEAR))).build();
	public static final Animation IDLE = Animation.Builder.withLength(2f).looping()
		.addPartAnimation("head",
			new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
				new AnimationKeyframe(0f, Animator.translate(0f, 0f, 0f), PartAnimation.Interpolations.SPLINE),
				new AnimationKeyframe(1f, Animator.translate(0f, 1f, 0f), PartAnimation.Interpolations.SPLINE),
				new AnimationKeyframe(2f, Animator.translate(0f, 0f, 0f), PartAnimation.Interpolations.SPLINE)))
		.addPartAnimation("head",
			new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
				new AnimationKeyframe(0f, Animator.rotate(0f, 0f, 0f), PartAnimation.Interpolations.SPLINE),
				new AnimationKeyframe(0.65f, Animator.rotate(2.5f, 0f, 0f), PartAnimation.Interpolations.SPLINE),
				new AnimationKeyframe(1.35f, Animator.rotate(-1.25f, 0f, 0f), PartAnimation.Interpolations.SPLINE),
				new AnimationKeyframe(2f, Animator.rotate(0f, 0f, 0f), PartAnimation.Interpolations.SPLINE)))
		.addPartAnimation("left",
			new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
				new AnimationKeyframe(0f, Animator.rotate(0f, 0f, 0f), PartAnimation.Interpolations.SPLINE),
				new AnimationKeyframe(0.25f, Animator.rotate(0f, 0f, 5f), PartAnimation.Interpolations.SPLINE),
				new AnimationKeyframe(0.75f, Animator.rotate(0f, 0f, -5f), PartAnimation.Interpolations.SPLINE),
				new AnimationKeyframe(1.25f, Animator.rotate(0f, 0f, 0f), PartAnimation.Interpolations.SPLINE),
				new AnimationKeyframe(2f, Animator.rotate(0f, 0f, 0f), PartAnimation.Interpolations.SPLINE)))
		.addPartAnimation("right",
			new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
				new AnimationKeyframe(0f, Animator.rotate(0f, 0f, 0f), PartAnimation.Interpolations.SPLINE),
				new AnimationKeyframe(0.25f, Animator.rotate(0f, 0f, 5f), PartAnimation.Interpolations.SPLINE),
				new AnimationKeyframe(0.75f, Animator.rotate(0f, 0f, -5f), PartAnimation.Interpolations.SPLINE),
				new AnimationKeyframe(1.25f, Animator.rotate(0f, 0f, 3f), PartAnimation.Interpolations.SPLINE),
				new AnimationKeyframe(2f, Animator.rotate(0f, 0f, 0f), PartAnimation.Interpolations.SPLINE))).build();
	public static final Animation FLY = Animation.Builder.withLength(1f).looping()
		.addPartAnimation("head",
			new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
				new AnimationKeyframe(0f, Animator.translate(0f, 0f, 0f), PartAnimation.Interpolations.SPLINE),
				new AnimationKeyframe(0.5f, Animator.translate(0f, 1f, 0f), PartAnimation.Interpolations.SPLINE),
				new AnimationKeyframe(1f, Animator.translate(0f, 0f, 0f), PartAnimation.Interpolations.SPLINE)))
		.addPartAnimation("head",
			new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
				new AnimationKeyframe(0f, Animator.rotate(0f, 0f, 0f), PartAnimation.Interpolations.SPLINE),
				new AnimationKeyframe(0.35f, Animator.rotate(2.5f, 0f, 0f), PartAnimation.Interpolations.SPLINE),
				new AnimationKeyframe(0.65f, Animator.rotate(-1.25f, 0f, 0f), PartAnimation.Interpolations.SPLINE),
				new AnimationKeyframe(1f, Animator.rotate(0f, 0f, 0f), PartAnimation.Interpolations.SPLINE))).build();
	public static final Animation ATTACK = Animation.Builder.withLength(1f)
		.addPartAnimation("left",
			new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
				new AnimationKeyframe(0f, Animator.rotate(0f, 0f, 0f), PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(0.2f, Animator.rotate(0f, 0f, -45f), PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(0.75f, Animator.rotate(0f, 0f, 0f), PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("right",
			new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
				new AnimationKeyframe(0f, Animator.rotate(0f, 0f, 0f), PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(0.2f, Animator.rotate(0f, 0f, 45f), PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(0.75f, Animator.rotate(0f, 0f, 0f), PartAnimation.Interpolations.LINEAR)))
		.addPartAnimation("lens",
			new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
				new AnimationKeyframe(0f, Animator.translate(0f, 0f, 0f), PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(0.15f, Animator.translate(0f, 0f, 1f), PartAnimation.Interpolations.LINEAR),
				new AnimationKeyframe(1f, Animator.translate(0f, 0f, 0f), PartAnimation.Interpolations.LINEAR))).build();
}
