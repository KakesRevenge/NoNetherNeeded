package kakesrevenge.nonetherneeded;

import java.io.File;

import kakesrevenge.nonetherneeded.blocks.OverworldQuartz;
import kakesrevenge.nonetherneeded.config.ConfigHandler;
import kakesrevenge.nonetherneeded.handlers.RecipesHandler;
import kakesrevenge.nonetherneeded.help.Reference;
import kakesrevenge.nonetherneeded.items.EmptyGate;
import kakesrevenge.nonetherneeded.items.NetherGate;
import kakesrevenge.nonetherneeded.proxies.ProxyCommon;
import kakesrevenge.nonetherneeded.worldgen.Generation;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "nnn", name = "No Nether Needed" , version = "1.3")
public class Main {

    @SidedProxy(clientSide = "kakesrevenge.nonetherneeded.proxies.ProxyClient", serverSide = "kakesrevenge.nonetherneeded.proxies.ProxyCommon")
    public static ProxyCommon proxy;
    @Instance(Reference.MODID)
    
    public static Main instance;
	public static Configuration config;
    public static Generation WorldGen = new Generation();
    public static Item EmptyGate;
	public static Item NetherGate;
	public static Block OverworldQuartz;

    @EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		FMLCommonHandler.instance().bus().register(Main.instance);

    	config = new Configuration(new File("config/NoNetherNeeded.cfg"));
    	GameRegistry.registerWorldGenerator(WorldGen, 1);
    	
		ConfigHandler.loadConfigs();

		EmptyGate = new EmptyGate();
    	NetherGate = new NetherGate();
		OverworldQuartz = new OverworldQuartz(Material.rock);

    }
    
    @EventHandler
	public void init(FMLInitializationEvent event) {
    	GameRegistry.registerItem(NetherGate, "NetherGate");
        GameRegistry.registerItem(EmptyGate, "EmptyGate");
    	GameRegistry.registerBlock(OverworldQuartz, "OverworldQuartz");
    	RecipesHandler.registerRecipes();
    }
    
    @EventHandler
	public void postInit(FMLPostInitializationEvent event) {
    	
    }
    
    @SubscribeEvent
 	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
 		if(event.modID.equals(Reference.MODID)) {
 			ConfigHandler.loadConfigs();
 		}
 	}
    
}