package me.mchiappinam.pdghmcoriginal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Listeners implements Listener {
	private Main plugin;
	
	public Listeners(Main main) {
		plugin=main;
	}
	
	@EventHandler(priority=EventPriority.MONITOR)
	private void onJoin(PlayerJoinEvent e) {
		boolean result = false;
	    try {
	    	URL url = new URL("https://minecraft.net/haspaid.jsp?user=" + e.getPlayer().getName() + "&serverid=" + plugin.getServer().getServerId());
	    	InputStreamReader reader = new InputStreamReader(url.openStream());
	    	BufferedReader buffer = new BufferedReader(reader);
	    	String response = buffer.readLine().toUpperCase();
	    	result = response.equals("TRUE");
	    } catch (MalformedURLException ex) {
	    	ex.printStackTrace();
	    	result = false;
	    } catch (IOException ex) {
	    	ex.printStackTrace();
	    	result = false;
	    }
	    if(result) {
	    	plugin.getServer().broadcastMessage("[PDGHTeste] "+e.getPlayer().getName()+" é original!");
	    }else{
	    	plugin.getServer().broadcastMessage("[PDGHTeste] "+e.getPlayer().getName()+" é pirata!");
	    }
	}
	
	
	
}