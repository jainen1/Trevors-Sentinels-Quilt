package net.trevorskullcrafter.trevorssentinels.mixin;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.item.ModArmorMaterials;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(ArmorItem.class)
public abstract class ArmorItemMixin extends ItemMixin {
	@Unique public int correctArmorSet(ArmorMaterial material, PlayerEntity player) {
		int num = 0;
		for(int i = 0; i <= 3; i++) { if (player.getInventory().getArmorStack(i).getItem() instanceof ArmorItem armorItem && armorItem.getMaterial() == material) { num++; }}
		return num;
	}

	@Override public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected, CallbackInfo ci) {
		super.inventoryTick(stack, world, entity, slot, selected, ci);
		if (entity instanceof PlayerEntity player){
			ArmorMaterial material = ((ArmorItem) stack.getItem()).getMaterial();
			if(correctArmorSet(material, player) == 4){
				StatusEffect effect = null;
				if(material instanceof ModArmorMaterials modMaterial){ effect = modMaterial.getStatusEffect(); }
				else if (material == ArmorMaterials.LEATHER) { effect = StatusEffects.SPEED; }
				else if (material == ArmorMaterials.CHAIN) { effect = StatusEffects.NIGHT_VISION; }
				else if (material == ArmorMaterials.IRON) { effect = StatusEffects.RESISTANCE; }
				else if (material == ArmorMaterials.GOLD) { effect = StatusEffects.LUCK; }
				else if (material == ArmorMaterials.DIAMOND) { effect = StatusEffects.HASTE; }
				else if (material == ArmorMaterials.TURTLE) { effect = StatusEffects.WATER_BREATHING; }
				else if (material == ArmorMaterials.NETHERITE) { effect = StatusEffects.FIRE_RESISTANCE; }
				if(effect != null && !player.hasStatusEffect(effect)) { player.addStatusEffect(new StatusEffectInstance(effect, 5, 0, true, false)); }
			}
		}
	}

	@Override public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context, CallbackInfo ci) {
		if(stack.getHolder() instanceof PlayerEntity playerEntity) {
			ArmorMaterial material = ((ArmorItem) stack.getItem()).getMaterial();
			if (correctArmorSet(material, playerEntity) == 4) { tooltip.add(Text.translatable("tooltip.trevorssentinels.set_bonus_active").formatted(Formatting.YELLOW)); }
			else { tooltip.add(Text.translatable("tooltip.trevorssentinels.set_bonus_inactive")
				.append(Text.literal(" (" + correctArmorSet(material, playerEntity) + "/4)")).formatted(Formatting.DARK_GRAY)); }}
		super.appendTooltip(stack, world, tooltip, context, ci);
    }
}
