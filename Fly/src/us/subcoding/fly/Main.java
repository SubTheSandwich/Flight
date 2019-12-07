package us.subcoding.fly;

import org.bukkit.plugin.java.JavaPlugin;
import us.subcoding.fly.commands.FlyCommand;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		new FlyCommand(this);
	}

}
