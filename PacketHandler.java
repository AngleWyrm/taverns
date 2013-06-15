package mods.taverns;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;


/**
 * Client-Server communications packet handler
 * for messages passed on the "Taverns" channel.
 * Currently no custom messages
 */
public class PacketHandler implements IPacketHandler {
	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) 
	{
		// This space intentionally left blank
	}
}