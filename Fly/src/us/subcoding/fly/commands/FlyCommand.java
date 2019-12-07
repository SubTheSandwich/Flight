package us.subcoding.fly.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import us.subcoding.fly.Main;
import us.subcoding.fly.utils.Utils;

public class FlyCommand implements CommandExecutor {
	
	private Main plugin;
	
	public FlyCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("fly").setExecutor(this);
        System.out.println("§c===================================");
        System.out.println("§aFlight Plugin");
        System.out.println("§aBy: TGG2006/subFN");
        System.out.println("§c===================================");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("console_message")));
			return true;
		}
		Player p = (Player) sender;
		if (p.hasPermission("fly.use")) {
			if (p.isFlying() == true) {
				p.setFlying(false);
				p.setAllowFlight(false);
				p.sendMessage(Utils.chat(plugin.getConfig().getString("flying_disabled_message")));
				return true;
			} else {
				if (p.isFlying() == false) {
				p.setAllowFlight(true);
				p.setFlying(true);
				p.sendMessage(Utils.chat(plugin.getConfig().getString("flying_enabled_message")));
				return true;
				}
			}
		} else {
			p.sendMessage(Utils.chat(plugin.getConfig().getString("nopermission_message")));
		}
		return false;
		
	}

}
