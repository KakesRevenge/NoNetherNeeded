package kakesrevenge.nonetherneeded.config;

import kakesrevenge.nonetherneeded.Main;
import kakesrevenge.nonetherneeded.help.Reference;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.config.GuiConfig;

public class ConfigGui extends GuiConfig {
	
	public ConfigGui(GuiScreen screen) {
		super(screen, new ConfigElement(Main.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(), 
				Reference.NAME, 
				false, 
				false, 
				GuiConfig.getAbridgedConfigPath(Main.config.toString()));
	}

}
