package mods.taverns;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import cpw.mods.fml.client.registry.RenderingRegistry;

/**
 * Client-side proxy customizes some functions
 * that should be handled differently for client and server
 * @author AngleWyrm
 */
public class ClientProxy extends ServerProxy 
{
	/**
	 * register renderers, done on client side
	 */
	@Override
	public void registerRenderHandlers() {
		// TODO: RenderingRegistry.registerEntityRenderingHandler(EntityPeep.class, new RenderPeep(new ModelBiped(), 0.65f, 1.0f));
	}
}