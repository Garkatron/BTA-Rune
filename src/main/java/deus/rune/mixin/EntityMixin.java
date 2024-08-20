package deus.rune.mixin;

import deus.rune.interfaces.IEntityAccessor;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.world.World;
import net.minecraft.core.world.data.SynchedEntityData;
import org.checkerframework.checker.units.qual.A;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityMixin implements IEntityAccessor {



	@Shadow
	protected boolean fireImmune;

	@Shadow
	public int remainingFireTicks;


	@Override
	public boolean Rune$getIsInvulnerableFire() {
		return fireImmune;
	}

	@Override
	public void Rune$setIsInvulnerableFire(boolean value) {
		fireImmune = value;
	}

	@Override
	public int Rune$getRemainingFireTicks() {
		return remainingFireTicks;
	}

	@Override
	public boolean Rune$isCoveredInFlames() {

		return !(remainingFireTicks <= 0);
	}
}
