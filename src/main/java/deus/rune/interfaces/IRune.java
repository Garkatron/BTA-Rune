package deus.rune.interfaces;

import deus.rune.enums.RuneEffect;
import deus.rune.enums.RuneType;

public interface IRune {
	void activate();
	void deactivate();
	void cooldown();
	void charge();
	void isActivated();
	void isDeactivated();

	RuneType getRuneType();
	void setRuneType(RuneType runeType);

	RuneEffect getRuneEffect();
	void setRuneEffect(RuneEffect runeEffect);

}
