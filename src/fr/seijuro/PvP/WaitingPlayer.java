package fr.seijuro.PvP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;

import org.bukkit.entity.Player;

public class WaitingPlayer {

	private UUID uuid;
	private int time;
	
	public WaitingPlayer(Player p)
	{
		this.uuid = p.getUniqueId();
		this.time = 0;
	}
	
	public WaitingPlayer(UUID uniqueId) {
		this.uuid = uniqueId;
		this.time = 0;
	}

	public UUID getUUID()
	{
		return this.uuid;
	}
	
	public int getElo()
        {
            int elo = 0;
            
            try{
            Connection con;
            Statement state;
            ResultSet result;
            con = DriverManager.getConnection("jdbc:sqlite:plugins/1vs1-Blastfight/data.db");
            state = con.createStatement();
            
            result = state.executeQuery("SELECT * FROM ");
            Class.forName("org.sqlite.JDBC");
            
            }catch(Exception e){e.printStackTrace();}
            return elo;
        }
	public int getTime()
	{
		return this.time;
	}
	
	public void addSecond()
	{
		this.time++;
	}
	public void setTime(int time)
	{
		this.time = time;
	}
	
	
	
}
