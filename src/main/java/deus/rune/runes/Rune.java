package deus.rune.runes;

import deus.rune.Debug.Debug;
import deus.rune.Util;
import deus.rune.enums.RuneEffect;
import deus.rune.enums.RuneType;
import deus.rune.interfaces.IRune;
import net.minecraft.core.entity.player.EntityPlayer;

import static deus.rune.Util.secondsToTicks;

public abstract class Rune implements IRune {

	RuneType runeType = RuneType.USELESS;
	RuneEffect runeEffect = RuneEffect.NONE;

	int charge = 100;
	int maxCharge = 100;
	int chargeSpeed = 1;
	int chargeAmount = 1;
	int chargeSpentValue = 10;

	boolean activated = false;
	boolean canActivate = true;
	boolean isInCooldown = false;
	boolean isCharging = false;

	int cooldownTimeTicks = secondsToTicks(1);
	int ticksRemaining = 0;

	@Override
	public void update() {
		if (isInCooldown) {
			ticksRemaining++;
			if (ticksRemaining >= cooldownTimeTicks) {
				ticksRemaining = 0;
				isInCooldown = false;
				// Reactivate once cooldown is complete
				reactivate();
			}
		}
		if (isCharging) {
			charge();
		}
	}

	@Override
	public void activate(EntityPlayer player) {
		if (!canActivate || isCharging) {
			Debug.println("Can't activate because: [isCharging]: "+isCharging + " or " + "[canActivate]: "+!canActivate);
			player.sendMessage(getClass().getSimpleName() + " can't be used because it is charging.");

			return;
		} // Prevent activation if currently charging

		activated = true;
		canActivate = false;
		charge = 0;
		cooldown();
		charge();
		effect(player);

		player.sendMessage(getClass().getSimpleName() + " activated");
		Debug.println("Rune activated: " + getClass().getSimpleName());
	}

	@Override
	public void deactivate() {
		activated = false;
		canActivate = true;
		isInCooldown = false;
	}

	@Override
	public void cooldown() {
		isInCooldown = true;
		ticksRemaining = 0; // Reset ticksRemaining for the cooldown cycle
		Debug.println("Cooldown started for rune: " + getClass().getSimpleName());
	}

	@Override
	public void charge() {
		if (charge < maxCharge) {
			isCharging = true;
			charge += chargeAmount * chargeSpeed;
			Debug.println("Charging: "+charge);
			if (charge >= maxCharge) {
				charge = maxCharge;
				isCharging = false;
				// Optionally reactivate or perform an action when fully charged
				reactivate();
			}
		}
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
	public int getCharge() {
		return charge;
	}

	@Override
	public int getChargeAmount() {
		return chargeAmount;
	}

	@Override
	public int getChargeSpeed() {
		return chargeSpeed;
	}

	@Override
	public int getChargeSpentValue() {
		return chargeSpentValue;
	}

	@Override
	public void setCharge(int charge) {
		this.charge = charge;
	}

	@Override
	public void setChargeAmount(int chargeAmount) {
		this.chargeAmount = chargeAmount;
	}

	@Override
	public void setChargeSpentValue(int chargeSpentValue) {
		this.chargeSpentValue = chargeSpentValue;
	}

	@Override
	public void setMaxCharge(int maxCharge) {
		this.maxCharge = maxCharge;
	}

	@Override
	public int getMaxCharge() {
		return maxCharge;
	}

	@Override
	public void setChargeSpeed(int chargeSpeed) {
		this.chargeSpeed = chargeSpeed;
	}
}
