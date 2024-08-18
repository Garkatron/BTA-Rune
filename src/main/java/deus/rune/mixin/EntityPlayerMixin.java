package deus.rune.mixin;

import deus.rune.interfaces.IEntityAccessor;
import deus.rune.interfaces.IEntityPlayerAccessor;
import deus.rune.util.Util;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.player.inventory.InventoryPlayer;
import net.minecraft.core.util.helper.DamageType;
import org.checkerframework.checker.units.qual.A;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityPlayer.class)
public abstract class EntityPlayerMixin implements IEntityPlayerAccessor {

	@Shadow
	public abstract int getMaxHealth();

	@Unique
	private boolean fireHeal = false;

	@Unique
	private boolean fireHealAlways = false;

	@Unique
	private boolean netherOverpowered = false;

	@Unique
	private int maxHealth = 20;

	@Unique
	private int extraStrengthFromRune = 0;

	@Unique
	private int resistance = 0;

	@Unique
	private int ticksPerSeconds = Util.secondsToTicks(1);

	@Unique
	private int ticksRemaining = 0;

	@Override
	public boolean Rune$getFireHeal() {
		return fireHeal;
	}

	@Override
	public void Rune$setFireHeal(boolean value) {
		fireHeal = value;
	}

	@Override
	public void Rune$setNetherOverpowered(boolean value) {
		netherOverpowered = value;
	}

	@Override
	public boolean Rune$getNetherOverpowered() {
		return netherOverpowered;
	}

	@Inject(method = "getMaxHealth()I", at = @At("RETURN"), cancellable = true, remap = false)
	private void modifyMaxHealth(CallbackInfoReturnable<Integer> cir) {
		cir.setReturnValue(maxHealth);
	}

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

	@Inject(method = "tick()V", at = @At("RETURN"), remap = false)
	private void alwaysFireHeal(CallbackInfo ci) {
		if (fireHealAlways && ticksRemaining >= ticksPerSeconds) {

			IEntityAccessor a = (IEntityAccessor) (Object) this;
			EntityPlayer e = (EntityPlayer) (Object) this;;
			if (a.Rune$isCoveredInFlames()) {
				e.heal(2);
			}
			if (e.isInWater()) {
				e.hurt(null, 2, DamageType.FIRE);
			}
			ticksRemaining = 0;
		}
		ticksRemaining++;
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

	public void Rune$setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;

	}

	@Override
	public void Rune$setFireHealAlways(boolean value) {
		fireHealAlways = value;
	}

	@Override
	public boolean Rune$getFireHealAlways() {
		return fireHealAlways;
	}
}
