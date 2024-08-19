package deus.rune.item.runes;

import deus.rune.interfaces.IEntityAccessor;
import deus.rune.interfaces.IEntityPlayerAccessor;
import deus.rune.item.runes.core.Rune;
import net.minecraft.client.Minecraft;
import net.minecraft.core.entity.player.EntityPlayer;

public class Nether extends Rune {
	@Override
	public void effect(EntityPlayer player) {
		IEntityPlayerAccessor playerAccessor = (IEntityPlayerAccessor) player;
		IEntityAccessor entityAccessor = (IEntityAccessor) player;
		playerAccessor.Rune$setFireHealAlways(true);
		entityAccessor.Rune$setIsInvulnerableFire(true);
		player.sendMessage("You are nether adapted, like pigmens.");
	}
}
