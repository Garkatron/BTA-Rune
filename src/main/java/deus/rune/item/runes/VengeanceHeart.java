package deus.rune.item.runes;

import deus.rune.interfaces.IEntityPlayerAccessor;
import deus.rune.item.runes.core.Rune;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.util.helper.DamageType;

public class VengeanceHeart extends Rune {

	private int strength = 0;
	private int maxHealth = 0;

	public VengeanceHeart() {

		setIsOvertime(false);
		this.maxHealth = 10;
		this.strength = 8;
	}

	@Override
	public void effect(EntityPlayer player) {
		IEntityPlayerAccessor customPlayer = (IEntityPlayerAccessor) player;

		int difference = player.getHealth() - maxHealth;

		customPlayer.Rune$setExtraStrengthFromRune(strength);
		player.hurt((Entity) null, difference, DamageType.COMBAT);
		customPlayer.Rune$setMaxHealth(maxHealth);

		//player.sendMessage("Strength aumented in:" + strength);

	}

	@Override
	public void reactivate() {
		super.reactivate();
		//currentUser.Rune$setExtraStrengthFromRune(0);
	}
}
