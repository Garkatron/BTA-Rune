package deus.rune.item.runes;

import deus.rune.interfaces.IEntityLivingAccesor;
import deus.rune.item.runes.core.Rune;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.entity.player.EntityPlayer;

public class Alcarin extends Rune {

	private double jumpBoost = 0.2;
	private IEntityLivingAccesor customEntity;

	public Alcarin() {
		//setActivationTimeSeconds(5);
		setCooldownTimeSeconds(5);
		setIsOvertime(false);
	}


	@Override
	public void effect(EntityPlayer player) {
		customEntity = (IEntityLivingAccesor) player;
		customEntity.addJumpBoost(jumpBoost);
	}


	@Override
	public void reactivate() {
		super.reactivate();
		customEntity.setJumpBoost(0);

	}
}
