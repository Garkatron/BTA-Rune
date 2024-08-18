package deus.rune.mixin;

import deus.rune.interfaces.IEntityPlayerAccessor;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.player.inventory.InventoryPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(EntityPlayer.class)
public class EntityPlayerMixin implements IEntityPlayerAccessor {

	@Unique
	private boolean fireHeal = false;

	@Unique
	private boolean netherOverpowered = false;


	@Unique
	private int extraStrengthFromRune = 0;

	@Unique
	private int resistance = 0;


//	@Inject(method = "tick", at = @At("RETURN"), remap = false)
//	private void modifyFireHurt(CallbackInfo ci) {
//		IEntityAccesor a = (IEntityAccesor) (Object) this;
//		EntityPlayer b = (EntityPlayer) (Object) this;
//		System.out.println((a.Rune$getRemainingFireTicks()));
//		if (a.Rune$getRemainingFireTicks() % 20 == 0) {
//			System.out.println("A");
//
//		} else {
//			if (fireHeal && a.Rune$getRemainingFireTicks() % 20 == 0) {
//				b.heal(2);
//				//ci.cancel();
//			}
//		}
//	}
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
