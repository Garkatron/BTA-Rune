package deus.rune.item.runes.todo;

import deus.rune.interfaces.IEntityPlayerAccessor;
import deus.rune.item.runes.core.Rune;
import deus.rune.item.runes.core.SignalAccesor;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.player.inventory.InventoryPlayer;
import net.minecraft.core.util.helper.DamageType;

import java.util.Objects;

public class FriendshipLigament extends Rune {

	EntityPlayer player1;
	EntityPlayer player2;

	@Override
	public void activate(EntityPlayer player) {

		if (player1==null) {
			player = player1;
		} else if (!Objects.equals(player.username, player1.username)) {
			player2 = player;
		}

	}

	@Override
	public void effect(EntityPlayer player) {
		IEntityPlayerAccessor customPlayer1 = (IEntityPlayerAccessor) player1;
		IEntityPlayerAccessor customPlayer2 = (IEntityPlayerAccessor) player2;

		InventoryPlayer inv1 = customPlayer1.Rune$getPlayerInventory();
		InventoryPlayer inv2 = customPlayer2.Rune$getPlayerInventory();

		customPlayer1.Rune$setInventoryBackup(inv1);
		customPlayer2.Rune$setInventoryBackup(inv2);

		InventoryPlayer a = new InventoryPlayer(player1);

		customPlayer1.Rune$setPlayerInventory(a);
		customPlayer2.Rune$setPlayerInventory(a);

		SignalAccesor.hurt.connect(
			t -> {
				if (!Objects.equals(t.first.username, player1.username))
					player2.hurt(t.first, t.second, DamageType.COMBAT);
			}

		);

	}
}
