package mods.taverns;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

/**
 * Taverns
 *
 * @author AngleWyrm
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 *
 */
@Mod(modid = Taverns.modID, name = Taverns.modID, version = Taverns.releaseDate)
@NetworkMod(clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)

public class Taverns 
{
	@Instance public static Taverns instance;
    @SidedProxy(clientSide = "mods.taverns.ClientProxy", serverSide = "mods.taverns.ServerProxy")
    public static ServerProxy proxy;
	public static final String modID = "Taverns";
	public static final String releaseDate = "19-Jul-2013";
	Configuration config;

    // Blocks, Items, Creative tab, etc
	
    public Taverns() {
        instance = this;
    }

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        int baseID;
        baseID = config.getBlock("BaseID", 1200).getInt();
        config.save();
    }

    @Init
    public void load(FMLInitializationEvent event) {

        // register structures & entities
        //GraveStoneStructures.getInstance();
        //GraveStoneEntity.getInstance();

        proxy.registerRenderHandlers();
    }

    @Mod.PostInit
    public void postInit(FMLPostInitializationEvent event) {
        //if (Loader.isModLoaded("TwilightForest|MoCreatures")) {}
    }
}