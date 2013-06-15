package mods.taverns;

import java.io.File;
import net.minecraftforge.common.Configuration;

public class Settings extends Configuration 
{
	// Settings
	public boolean generateTaverns;
	
	public Settings(File configurationFile) {
		super(configurationFile);
	}

	// loads/creates configuration file
	public void loadSettings()
	{
		load();
		
        generateTaverns = get(Configuration.CATEGORY_GENERAL, "generateTaverns", true).getBoolean(true);

        save();
	}	
}
