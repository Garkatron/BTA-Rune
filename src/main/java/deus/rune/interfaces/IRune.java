package deus.rune.interfaces;

import deus.rune.enums.RuneEffect;
import deus.rune.enums.RuneType;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.player.EntityPlayer;

public interface IRune {
	void activate(EntityPlayer player);
	void deactivate();
	void cooldown();
	boolean isActivated();
	boolean isDeactivated();

	void update(Entity entity);

	RuneType getRuneType();
	void setRuneType(RuneType runeType);

	RuneEffect getRuneEffect();
	void setRuneEffect(RuneEffect runeEffect);

	void reactivate();

	void effect(EntityPlayer player);
	void effect(Entity entity);


	public int getActivationTimeSeconds();
	public void setActivationTimeSeconds(int activationTimeSeconds);

	public int getActivationTimeTicks();

	public void setActivationTimeTicks(int activationTimeTicks);
	public void setCooldownTimeSeconds(int seconds);
}
