package deus.rune.runes;

import deus.rune.enums.RuneEffect;
import deus.rune.enums.RuneType;
import deus.rune.interfaces.IRune;

public abstract class Rune implements IRune {

	RuneType runeType = RuneType.USELESS;
	RuneEffect runeEffect = RuneEffect.NONE;

	int charge = 100;

	boolean activated = false;

	int cooldownTimeTicks = 20;
	int cooldownTimeTickCount = 0;

	@Override
	public void activate() {

	}

	@Override
	public void deactivate() {

	}

	@Override
	public void cooldown() {

	}

	@Override
	public void charge() {

	}

	@Override
	public void isActivated() {

	}

	@Override
	public void isDeactivated() {

	}

	@Override
	public RuneType getRuneType() {
		return null;
	}

	@Override
	public void setRuneType(RuneType runeType) {

	}

	@Override
	public RuneEffect getRuneEffect() {
		return null;
	}

	@Override
	public void setRuneEffect(RuneEffect runeEffect) {

	}
}
