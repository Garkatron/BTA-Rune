package deus.rune.item.runes.normal;

import deus.rune.interfaces.IEntityAccessor;
import deus.rune.interfaces.IEntityPlayerAccessor;
import deus.rune.item.runes.core.Rune;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.util.helper.DamageType;

// Fire rune
// T1: Reduce fire damage
// T2: No fire damage
// T3: Fire heal life

public class Ar extends Rune {

	public Ar(int tier) {

		setIsOvertime(true);
		addTiers(0);
		addTiers(1);
		addTiers(2);
		setCurrentTier(tier);

		switch (getCurrentTier()) {
			case 0:

			case 2:
				setActivationTimeSeconds(10);
				setCooldownTimeSeconds(10);
				break;

			case 1:
				setActivationTimeSeconds(120);
				setCooldownTimeSeconds(60);
				break;

		}

	}

	@Override
	public void activate(EntityPlayer player) {
		super.activate(player);

		IEntityPlayerAccessor playerAccesor = (IEntityPlayerAccessor) player;
		IEntityAccessor entityAccesor = (IEntityAccessor) player;

		switch (getCurrentTier()) {
			case 0:
				setActivationTimeSeconds(10);
				setCooldownTimeSeconds(10);
				// Grant immunity to fire damage at Tier 0
				entityAccesor.Rune$setIsInvulnerableFire(true);
				break;

			case 1:
				// Additional logic for Tier 1 if needed
				setActivationTimeSeconds(190);
				setCooldownTimeSeconds(190);
				entityAccesor.Rune$setIsInvulnerableFire(true);
				break;

			case 2:
				// Additional logic for Tier 1 if needed
				setActivationTimeSeconds(10);
				setCooldownTimeSeconds(10);
				entityAccesor.Rune$setIsInvulnerableFire(true);
				break;

		}
	}

	@Override
	public void effect(EntityPlayer player) {
		IEntityAccessor entityAccessor = (IEntityAccessor) player;

		if (getCurrentTier() == 2) {
			if (entityAccessor.Rune$isCoveredInFlames()) {
				player.heal(2);
			}
		}

		if (player.isInWater()) {
			player.hurt(null, 2, DamageType.FIRE);
		}


	}

	@Override
	public void deactivate() {
		super.deactivate();

		IEntityPlayerAccessor playerAccesor = (IEntityPlayerAccessor) getCurrentUser();
		IEntityAccessor entityAccesor = (IEntityAccessor) getCurrentUser();

		entityAccesor.Rune$setIsInvulnerableFire(false);
		playerAccesor.Rune$setFireHeal(false);
	}

	@Override
	public void reactivate() {
		super.reactivate();
		// Implement any additional logic needed for reactivation
	}
}
