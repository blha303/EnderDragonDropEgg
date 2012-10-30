package me.blha303;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class ItemOnMobDeath extends JavaPlugin implements Listener {
	
	private static final Logger log = Logger.getLogger("Minecraft");
	String version = getDescription().getVersion();
	
	public void goodMessage(String msg) {
		log.info("[IOMD] " + ChatColor.GREEN + msg);
	}
	
	public void badMessage(String msg) {
		log.info("[IOMD] " + ChatColor.RED + msg);
	}

	public void onDisable() {
		goodMessage("Disabled " + version);
	}
	
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		goodMessage("Enabled " + version);
	}
	
	@EventHandler
	public void onEnderDragonDie(EntityDeathEvent e) {
		Player killer = e.getEntity().getKiller();
		Entity entity = e.getEntity();
		ItemStack item = new ItemStack(122, 1);
		
		if (entity instanceof EnderDragon) {
			killer.getInventory().addItem(item);
			return;
		}
	}
}
