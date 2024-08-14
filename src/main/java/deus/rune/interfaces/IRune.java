package deus.rune.interfaces;

import deus.rune.enums.RuneEffect;
import deus.rune.enums.RuneType;
import net.minecraft.core.entity.player.EntityPlayer;

public interface IRune {
	void activate(EntityPlayer player);
	void deactivate();
	void cooldown();
	void charge();
	boolean isActivated();
	boolean isDeactivated();

	void update();

	RuneType getRuneType();
	void setRuneType(RuneType runeType);

	RuneEffect getRuneEffect();
	void setRuneEffect(RuneEffect runeEffect);

	int getChargeSpentValue();
	void setChargeSpentValue(int value);

	void setCharge(int value);
	int getCharge();

	int getChargeAmount();
	void setChargeAmount(int amount);

	int getChargeSpeed();
	void setChargeSpeed(int speed);
	void setMaxCharge(int maxCharge);
	int getMaxCharge();

	void reactivate();

	void effect(EntityPlayer player);
}
