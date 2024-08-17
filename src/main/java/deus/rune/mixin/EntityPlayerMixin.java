package deus.rune.mixin;

import deus.rune.interfaces.IEntityPlayerAccesor;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.player.inventory.InventoryPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EntityPlayer.class)
public class EntityPlayerMixin implements IEntityPlayerAccesor {

	@Unique
	private int extraStrengthFromRune = 0;

	@Unique
	private int resistance = 0;

	@Redirect(
		method = "attackTargetEntityWithCurrentItem(Lnet/minecraft/core/entity/Entity;)V",
		at = @At(value = "INVOKE", target = "Lnet/minecraft/core/player/inventory/InventoryPlayer;getDamageVsEntity(Lnet/minecraft/core/entity/Entity;)I")
		,remap = false
	)
	private int redirectGetDamageVsEntity(InventoryPlayer inventory, Entity entity) {
		int originalDamage = inventory.getDamageVsEntity(entity);
		int modifiedDamage = originalDamage + extraStrengthFromRune;
		System.out.println("Modified damage: " + modifiedDamage);
		return modifiedDamage;
	}

	@Override
	public void Rune$setExtraStrengthFromRune(int value) {
		extraStrengthFromRune = value;
	}

	@Override
	public void Rune$addExtraStrengthFromRune(int amount) {
		extraStrengthFromRune += amount;
	}

	@Override
	public int Rune$getExtraStrengthFromRune() {
		return extraStrengthFromRune;
	}
}
