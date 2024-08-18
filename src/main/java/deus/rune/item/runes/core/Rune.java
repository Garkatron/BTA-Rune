package deus.rune.item.runes.core;

import deus.rune.Debug.Debug;
import deus.rune.enums.RuneEffect;
import deus.rune.enums.RuneType;
import deus.rune.interfaces.IRune;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.player.EntityPlayer;

import java.util.ArrayList;
import java.util.List;

import static deus.rune.Debug.Util.secondsToTicks;

public abstract class Rune implements IRune {

	List<Integer> tiers = new ArrayList<>();
	int currentTier = 0;

	EntityPlayer currentUser;

	RuneType runeType = RuneType.USELESS;
	RuneEffect runeEffect = RuneEffect.NONE;

	boolean activated = false;
	boolean canActivate = true;
	boolean isInCooldown = false;

	int activationTimeSeconds = 5; // Tiempo de activación en segundos
	int activationTimeTicks = secondsToTicks(activationTimeSeconds); // Usando secondsToTicks para convertir segundos a ticks
	int cooldownTimeTicks = secondsToTicks(1); // Convertir 1 segundo a ticks para el cooldown
	int ticksRemaining = 0;
	int ticksActive = 0;

	boolean overTime = false;

	@Override
	public void update(EntityPlayer player) {


		if (overTime && activated) {
			ticksActive++;

			// Apply effect every second
			if (ticksActive % secondsToTicks(1) == 0) {
				if (currentUser!=null)
					effect(currentUser);
			}

			if (ticksActive >= activationTimeTicks) {
				deactivate();
				Debug.println("Rune deactivated after activation time: " + getClass().getSimpleName());
			}
		}

		if (isInCooldown) {
			ticksRemaining++;
			if (ticksRemaining >= cooldownTimeTicks) {
				ticksRemaining = 0;
				isInCooldown = false;
				reactivate();
			}
		}
	}


	@Override
	public void activate(EntityPlayer player) {
		if (!canActivate || isInCooldown) {
			Debug.println("Can't activate because: [isInCooldown]: " + isInCooldown + " or " + "[canActivate]: " + !canActivate);
			player.sendMessage(getClass().getSimpleName() + " can't be used because it is in cooldown.");
			return;
		}

		currentUser = player;
		activated = true;
		canActivate = false;
		ticksActive = 0;
		cooldown();
		effect(player);

		player.sendMessage(getClass().getSimpleName() + " activated for " + activationTimeSeconds + " seconds");
		Debug.println("Rune activated: " + getClass().getSimpleName());
	}

	@Override
	public void deactivate() {
		activated = false;
		canActivate = true;
		Debug.println("Rune deactivated: " + getClass().getSimpleName());
	}

	@Override
	public void cooldown() {
		isInCooldown = true;
		ticksRemaining = 0; // Reiniciar ticksRemaining para el ciclo de cooldown
		Debug.println("Cooldown started for rune: " + getClass().getSimpleName());
	}

	@Override
	public void reactivate() {
		isInCooldown = false;
		canActivate = true;
		activated = false;
		Debug.println("Rune reactivated: " + getClass().getSimpleName());
	}

	@Override
	public boolean isActivated() {
		return activated;
	}

	@Override
	public boolean isDeactivated() {
		return !activated;
	}

	@Override
	public RuneType getRuneType() {
		return runeType;
	}

	@Override
	public void setRuneType(RuneType runeType) {
		this.runeType = runeType;
	}

	@Override
	public RuneEffect getRuneEffect() {
		return runeEffect;
	}

	@Override
	public void setRuneEffect(RuneEffect runeEffect) {
		this.runeEffect = runeEffect;
	}

	@Override
	public int getActivationTimeSeconds() {
		return activationTimeSeconds;
	}

	@Override
	public void setActivationTimeSeconds(int activationTimeSeconds) {
		this.activationTimeSeconds = activationTimeSeconds;
		this.activationTimeTicks = secondsToTicks(activationTimeSeconds);
	}

	@Override
	public int getActivationTimeTicks() {
		return activationTimeTicks;
	}

	@Override
	public void setActivationTimeTicks(int activationTimeTicks) {
		this.activationTimeTicks = activationTimeTicks;
	}

	@Override
	public void setCooldownTimeSeconds(int seconds) {
		cooldownTimeTicks = secondsToTicks(seconds);
	}

	@Override
	public void setIsOvertime(boolean isOvertime) {
		overTime = isOvertime;
	}

	@Override
	public boolean getIsOvertime() {
		return overTime;
	}

	@Override
	public void addTiers(int tier) {
		tiers.add(tier);
	}

	@Override
	public List<Integer> getTiers() {
		return tiers;
	}

	@Override
	public int getCurrentTier() {
		return currentTier;
	}

	@Override
	public void setCurrentTier(int index) {
		this.currentTier = tiers.get(index);
	}

	@Override
	public EntityPlayer getCurrentUser() {
		return currentUser;
	}
}
