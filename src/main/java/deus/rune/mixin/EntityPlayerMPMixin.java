package deus.rune.mixin;

import deus.rune.interfaces.IEntityPlayerAccessor;
import deus.rune.util.RuneUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.net.handler.NetClientHandler;
import net.minecraft.core.player.Session;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static deus.rune.RuneMod.MOD_CONFIG;


@Mixin(net.minecraft.client.entity.player.EntityClientPlayerMP.class)
public class EntityPlayerMPMixin {
	@Inject(method = "<init>(Lnet/minecraft/client/Minecraft;Lnet/minecraft/core/world/World;Lnet/minecraft/core/player/Session;Lnet/minecraft/client/net/handler/NetClientHandler;)V", at = @At("TAIL"), remap = false)
	private void onCreate(Minecraft minecraft, World world, Session session, NetClientHandler netclienthandler, CallbackInfo ci) {

		IEntityPlayerAccessor e = (IEntityPlayerAccessor) (Object) this;
		MOD_CONFIG.getPlayerPermanentRunes(session.username).forEach(
			a->e.Rune$addPermanentRune(RuneUtils.getRuneFromName(a)
		));

	}
}
