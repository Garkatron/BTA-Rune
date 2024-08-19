package deus.rune.item.runes;

import deus.rune.interfaces.IEntityPlayerAccessor;
import deus.rune.item.runes.core.Rune;
import net.minecraft.core.entity.player.EntityPlayer;

// Resistance, Reduce damage, add strength

public class Sowilo extends Rune {

	private IEntityPlayerAccessor currentUser;

	private int strength = 0;

	public Sowilo() {
		setActivationTimeSeconds(10);
		setCooldownTimeSeconds(300);
		setIsOvertime(true);
		this.strength = 26;
	}

	@Override
	public void effect(EntityPlayer player) {
		IEntityPlayerAccessor customPlayer = (IEntityPlayerAccessor) player;
		customPlayer.Rune$setExtraStrengthFromRune(strength);
		player.sendMessage("Strength aumented in:" + strength);
		currentUser = customPlayer;
	}

	@Override
	public void reactivate() {
		super.reactivate();
		currentUser.Rune$setExtraStrengthFromRune(0);
	}
}
