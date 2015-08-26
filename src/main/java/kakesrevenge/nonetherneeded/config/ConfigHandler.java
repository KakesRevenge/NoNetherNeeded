package kakesrevenge.nonetherneeded.config;

import cpw.mods.fml.common.FMLCommonHandler;
import kakesrevenge.nonetherneeded.Main;

public class ConfigHandler  {	
	
	public static int GateDurabilityInt;
	public static boolean GateInfiniteDurabilityBoolean;
	public static boolean RitualEnabledBoolean;
	
	public static void loadConfigs() {
		
		final String RitualEnabled = Main.config.CATEGORY_GENERAL + Main.config.CATEGORY_SPLITTER + "RitualEnabled";
		RitualEnabledBoolean = Main.config.get(Main.config.CATEGORY_GENERAL, "Ritual enabled [Default : true] ", true).getBoolean();
		
		final String GateDurability = Main.config.CATEGORY_GENERAL + Main.config.CATEGORY_SPLITTER + "GateDurability";
		GateDurabilityInt = Main.config.get(Main.config.CATEGORY_GENERAL, "Set nether gate durability [Default : 100] ", 100).getInt();
		
		final String GateInfiniteDurability = Main.config.CATEGORY_GENERAL + Main.config.CATEGORY_SPLITTER + "GateInfiniteDurability";
		GateInfiniteDurabilityBoolean = Main.config.get(Main.config.CATEGORY_GENERAL, "Set nether gate infinite durability [Default : false] ", false).getBoolean();
		
		if(Main.config.hasChanged()) Main.config.save();
	}
}
