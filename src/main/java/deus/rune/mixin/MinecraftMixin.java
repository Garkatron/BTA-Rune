package deus.rune.mixin;

import deus.rune.interfaces.IEntityPlayerAccessor;
import deus.rune.interfaces.IMinecraftAccesor;
import deus.rune.item.runes.core.Rune;
import net.minecraft.client.Minecraft;
import net.minecraft.client.render.window.GameWindow;
import net.minecraft.core.entity.player.EntityPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(Minecraft.class)
public class MinecraftMixin implements IMinecraftAccesor {

	@Unique
	private EntityPlayer previousPlayer;

	@Unique
	private EntityPlayer newPlayer;

	@Inject(method = "Lnet/minecraft/client/Minecraft;respawn(ZI)V", at = @At("HEAD"), cancellable = true, remap = false)
	private void capturePreviousPlayer(boolean flag, int i, CallbackInfo ci) {
		Minecraft minecraft = (Minecraft) (Object) this;
		previousPlayer = minecraft.thePlayer;
	}

	@Inject(method = "Lnet/minecraft/client/Minecraft;respawn(ZI)V", at = @At("RETURN"), remap = false)
	private void afterRespawn(boolean flag, int i, CallbackInfo ci) {
		Minecraft minecraft = (Minecraft) (Object) this;

		newPlayer = minecraft.thePlayer;

		IEntityPlayerAccessor customPlayer = (IEntityPlayerAccessor) newPlayer;
		IEntityPlayerAccessor customPlayer2 = (IEntityPlayerAccessor) previousPlayer;
		List<Rune> runes = customPlayer2.Rune$getPermanentRunes();
		runes.forEach(customPlayer::Rune$addPermanentRune);

	}


	@Override
	public EntityPlayer Rune$getPreviousPlayer() {
		return previousPlayer;
	}

	@Override
	public EntityPlayer Rune$getNewPlayer() {
		return newPlayer;
	}
}
