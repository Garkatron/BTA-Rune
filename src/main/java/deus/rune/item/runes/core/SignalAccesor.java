package deus.rune.item.runes.core;

import deus.godotsignalsystem.core.Signal;
import deus.rune.util.Tuple;
import net.minecraft.core.entity.player.EntityPlayer;

public class SignalAccesor {
	public static final Signal<Tuple<EntityPlayer, Integer>> hurt = new Signal<>();

}
