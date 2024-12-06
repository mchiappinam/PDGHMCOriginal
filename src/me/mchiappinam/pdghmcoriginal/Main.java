package me.mchiappinam.pdghmcoriginal;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	List<Player> original = new ArrayList<Player>();
	
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new Listeners(this), this);
		getServer().getConsoleSender().sendMessage("§3[PDGHMCOriginal] §2ativado - Plugin by: mchiappinam");
		getServer().getConsoleSender().sendMessage("§3[PDGHMCOriginal] §2Acesse: http://pdgh.com.br/");
	}

	public void onDisable() {
		getServer().getConsoleSender().sendMessage("§3[PDGHMCOriginal] §2desativado - Plugin by: mchiappinam");
		getServer().getConsoleSender().sendMessage("§3[PDGHMCOriginal] §2Acesse: http://pdgh.com.br/");
	}
}