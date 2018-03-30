package projecthrzn.talesfromtheforge;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;
import projecthrzn.talesfromtheforge.common.CommonProxy;
import projecthrzn.talesfromtheforge.util.TFTFConfigs;
import projecthrzn.talesfromtheforge.util.TFTFConstants;

@Mod(modid = TFTFConstants.MODID, name = TFTFConstants.NAME, version = TFTFConstants.VERSION, dependencies = TFTFConstants.DEPS, acceptedMinecraftVersions = TFTFConstants.MCVERS)
public class TalesFromTheForge {

    @SidedProxy(clientSide = TFTFConstants.CLIENTPROXY, serverSide = TFTFConstants.COMMONPROXY, modId = TFTFConstants.MODID)
    public static CommonProxy proxy;
    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.Init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        TFTFConfigs.postInit(event);
        proxy.postInit(event);
    }

    @EventHandler
    public void serverStart(FMLServerStartingEvent event) {
        proxy.serverStart(event);
    }
}
