package deus.rune.interfaces;

import deus.rune.enums.RuneEffect;
import deus.rune.enums.RuneType;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.player.EntityPlayer;

import java.util.ArrayList;
import java.util.List;

public interface IRune {
	void activate(EntityPlayer player);
	void deactivate();
	void cooldown();
	boolean isActivated();
	boolean isDeactivated();

	void update(EntityPlayer player);

	RuneType getRuneType();
	void setRuneType(RuneType runeType);

	RuneEffect getRuneEffect();
	void setRuneEffect(RuneEffect runeEffect);

	void reactivate();

	void effect(EntityPlayer player);

	void setIsOvertime(boolean isOvertime);
	boolean getIsOvertime();

	int getActivationTimeSeconds();
	void setActivationTimeSeconds(int activationTimeSeconds);

	int getActivationTimeTicks();

	void setActivationTimeTicks(int activationTimeTicks);
	void setCooldownTimeSeconds(int seconds);

	void addTiers(int tier);
	List<Integer> getTiers();
	void setCurrentTier(int index);
	int getCurrentTier();

	EntityPlayer getCurrentUser();
}
