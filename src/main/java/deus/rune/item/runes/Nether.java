package deus.rune.item.runes;

import deus.rune.interfaces.IEntityAccessor;
import deus.rune.interfaces.IEntityPlayerAccessor;
import deus.rune.item.runes.core.Rune;
import net.minecraft.core.entity.player.EntityPlayer;

public class Nether extends Rune {
	@Override
	public void effect(EntityPlayer player) {
		IEntityPlayerAccessor playerAccesor = (IEntityPlayerAccessor) player;
		IEntityAccessor entityAccesor = (IEntityAccessor) player;
		playerAccesor.Rune$setFireHealAlways(true);
		entityAccesor.Rune$setIsInvulnerableFire(true);

	}
}
