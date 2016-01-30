package fr.seijuro.PvP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;

public class Main
  extends JavaPlugin
{
  private DuelManager duelManager;
  private DuelManagerRanked duelManagerRanked;
  private List<WaitingPlayer> waitingPlayers;
  public void onEnable()
  {
    this.duelManager = new DuelManager(this);
    getServer().getPluginManager().registerEvents(new GameListener(this), this);
    this.waitingPlayers = new ArrayList<WaitingPlayer>();
    
    final Main main = this;
    //SQLITE INIT
    
    try
    {
        Connection con;
        Statement state;
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:plugins/1vs1-Blastfight/data.db");
        state = con.createStatement();
        state.executeUpdate("CREATE TABLE Ranked " +
                   "(ID INT PRIMARY KEY     NOT NULL," +
                   " UUID           TEXT    NOT NULL, " + 
                   " AGE            INT     NOT NULL, " + 
                   " ADDRESS        CHAR(50), " + 
                   " SALARY         REAL)");
        
    }
    //Test commentary
    catch(Exception e){}
    //SQLITE INIT END
    Bukkit.getServer().getScheduler().runTaskTimerAsynchronously(this, new Runnable(){

		@Override
		public void run() {
                    
                        duelManagerRanked = new DuelManagerRanked(main);

			// Chaque seconde, on v�rifie les joueurs en file d'attente
			
			//On add une seconde dans leur timer
			for(WaitingPlayer wp : waitingPlayers)
			{
				wp.addSecond();
			}
			
			//On check si un joueur dans la plage d'elo 75-125% existe | 
			for(WaitingPlayer wp : waitingPlayers)
                        {
                            if(wp.)
                        }
			
			//Si oui, on lance des confirmations aux deux joueurs
			
			
			//Si les deux acceptent, on les enl�ve de la liste d'attente et on les fait combattre
			
			
			//On start un duel classique
			
			
			//Quand un des deux meurt, on effectue le calcul du nouvel elo en fonction de la fonction dans la config
			
			
			//Si un des deux refuse, on enl�ve celui qui a refus� de la file et on remet l'autre
			
			
			
			
		}
    	
    }, 0, 20);
  }
  
  public void onDisable() {}
  
  public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args)
  {
    if (cmdLabel.equalsIgnoreCase("setlobby"))
    {
      if ((sender instanceof Player))
      {
        Player p = (Player)sender;
        if (!p.isOp())
        {
          p.sendMessage(ChatColor.RED + "Vous n'avez pas la permissions de faire ca.");
          return true;
        }
        if (args.length <= 0)
        {
          getConfig().set("Lobby.world", p.getLocation().getWorld().getName());
          getConfig().set("Lobby.x", Double.valueOf(p.getLocation().getX()));
          getConfig().set("Lobby.y", Double.valueOf(p.getLocation().getY()));
          getConfig().set("Lobby.z", Double.valueOf(p.getLocation().getZ()));
          getConfig().set("Lobby.yaw", Float.valueOf(p.getLocation().getYaw()));
          getConfig().set("Lobby.pitch", Float.valueOf(p.getLocation().getPitch()));
          p.sendMessage(ChatColor.GREEN + "Lobby du serveur training bien enregistr�.");
          saveConfig();
        }
        else
        {
          p.sendMessage(ChatColor.RED + "Probl�me de syntaxe essayez :" + ChatColor.AQUA +  "'/setlobby'.");
        }
      }
      else
      {
        sender.sendMessage(ChatColor.RED + "Commande uniquement executable dans le jeu ! (Naruhiko wsh, tu fais quoi)");
      }
    }
    else if (cmdLabel.equalsIgnoreCase("setfirst"))
    {
      if ((sender instanceof Player))
      {
        Player p = (Player)sender;
        if (args.length <= 0)
        {
          if (!p.isOp())
          {
            p.sendMessage(ChatColor.RED + "Vous n'avez pas la permission de faire �a.");
            return true;
          }
          getConfig().set("First.world", p.getLocation().getWorld().getName());
          getConfig().set("First.x", Double.valueOf(p.getLocation().getX()));
          getConfig().set("First.y", Double.valueOf(p.getLocation().getY()));
          getConfig().set("First.z", Double.valueOf(p.getLocation().getZ()));
          getConfig().set("First.yaw", Float.valueOf(p.getLocation().getYaw()));
          getConfig().set("First.pitch", Float.valueOf(p.getLocation().getPitch()));
          p.sendMessage(ChatColor.GREEN + "Premi�re place du combat d�fini.");
          saveConfig();
        }
        else
        {
            p.sendMessage(ChatColor.RED + "Probl�me de syntaxe essayez :" + ChatColor.AQUA +  "'/setfirst'.");
        }
      }
      else
      {
    	  sender.sendMessage(ChatColor.RED + "Commande uniquement executable dans le jeu ! (Naruhiko wsh, tu fais quoi)");
      }
    }
    else if (cmdLabel.equalsIgnoreCase("setsecond")) {
      if ((sender instanceof Player))
      {
        Player p = (Player)sender;
        if (args.length <= 0)
        {
          if (!p.isOp())
          {
            p.sendMessage(ChatColor.RED + "You don't have permission.");
            return true;
          }
          getConfig().set("Second.world", p.getLocation().getWorld().getName());
          getConfig().set("Second.x", Double.valueOf(p.getLocation().getX()));
          getConfig().set("Second.y", Double.valueOf(p.getLocation().getY()));
          getConfig().set("Second.z", Double.valueOf(p.getLocation().getZ()));
          getConfig().set("Second.yaw", Float.valueOf(p.getLocation().getYaw()));
          getConfig().set("Second.pitch", Float.valueOf(p.getLocation().getPitch()));
          p.sendMessage(ChatColor.GREEN + "Deuxi�me position du combat enregistr�.");
          saveConfig();
        }
        else
        {
            p.sendMessage(ChatColor.RED + "Probl�me de syntaxe essayez :" + ChatColor.AQUA +  "'/setsecond'.");
        }
      }
      else
      {
    	  sender.sendMessage(ChatColor.RED + "Commande uniquement executable dans le jeu ! (Naruhiko wsh, tu fais quoi)");
      }
    }  else if (cmdLabel.equalsIgnoreCase("setArena"))
    {
        if ((sender instanceof Player))
        {
          Player p = (Player)sender;
          if (args.length <= 0)
          {
            if (!p.isOp())
            {
              p.sendMessage(ChatColor.RED + "Vous n'avez pas la permission de faire �a.");
              return true;
            }
            getConfig().set("Arena.world", p.getLocation().getWorld().getName());
            getConfig().set("Arena.x", Double.valueOf(p.getLocation().getX()));
            getConfig().set("Arena.y", Double.valueOf(p.getLocation().getY()));
            getConfig().set("Arena.z", Double.valueOf(p.getLocation().getZ()));
            getConfig().set("Arena.yaw", Float.valueOf(p.getLocation().getYaw()));
            getConfig().set("Arena.pitch", Float.valueOf(p.getLocation().getPitch()));
            p.sendMessage(ChatColor.GREEN + "Place de combat du combat d�fini.");
            saveConfig();
          }
          else
          {
              p.sendMessage(ChatColor.RED + "Probl�me de syntaxe essayez :" + ChatColor.AQUA +  "'/setarena'.");
          }
        }
        else
        {
      	  sender.sendMessage(ChatColor.RED + "Commande uniquement executable dans le jeu ! (Naruhiko wsh, tu fais quoi)");
        }
      } else if (cmdLabel.equalsIgnoreCase("setdeath"))
      {
          if ((sender instanceof Player))
          {
            Player p = (Player)sender;
            if (args.length <= 0)
            {
              if (!p.isOp())
              {
                p.sendMessage(ChatColor.RED + "Vous n'avez pas la permission de faire �a.");
                return true;
              }
              getConfig().set("Death.world", p.getLocation().getWorld().getName());
              getConfig().set("Death.x", Double.valueOf(p.getLocation().getX()));
              getConfig().set("Death.y", Double.valueOf(p.getLocation().getY()));
              getConfig().set("Death.z", Double.valueOf(p.getLocation().getZ()));
              getConfig().set("Death.yaw", Float.valueOf(p.getLocation().getYaw()));
              getConfig().set("Death.pitch", Float.valueOf(p.getLocation().getPitch()));
              p.sendMessage(ChatColor.GREEN + "Place de mort du combat d�fini.");
              saveConfig();
            }
            else
            {
                p.sendMessage(ChatColor.RED + "Probl�me de syntaxe essayez :" + ChatColor.AQUA +  "'/setdeath'.");
            }
          }
          else
          {
        	  sender.sendMessage(ChatColor.RED + "Commande uniquement executable dans le jeu ! (Naruhiko wsh, tu fais quoi)");
          }
        }    else if (cmdLabel.equalsIgnoreCase("setrankedfirst"))
        {
            if ((sender instanceof Player))
            {
              Player p = (Player)sender;
              if (args.length <= 0)
              {
                if (!p.isOp())
                {
                  p.sendMessage(ChatColor.RED + "Vous n'avez pas la permission de faire �a.");
                  return true;
                }
                getConfig().set("Rankedfirst.world", p.getLocation().getWorld().getName());
                getConfig().set("Rankedfirst.x", Double.valueOf(p.getLocation().getX()));
                getConfig().set("Rankedfirst.y", Double.valueOf(p.getLocation().getY()));
                getConfig().set("Rankedfirst.z", Double.valueOf(p.getLocation().getZ()));
                getConfig().set("Rankedfirst.yaw", Float.valueOf(p.getLocation().getYaw()));
                getConfig().set("Rankedfirst.pitch", Float.valueOf(p.getLocation().getPitch()));
                p.sendMessage(ChatColor.GREEN + "Premi�re place du combat ranked d�fini.");
                saveConfig();
              }
              else
              {
                  p.sendMessage(ChatColor.RED + "Probl�me de syntaxe essayez :" + ChatColor.AQUA +  "'/setrankedfirst'.");
              }
            }
            else
            {
          	  sender.sendMessage(ChatColor.RED + "Commande uniquement executable dans le jeu ! (Naruhiko wsh, tu fais quoi)");
            }
          }
          else if (cmdLabel.equalsIgnoreCase("setrankedsecond")) {
            if ((sender instanceof Player))
            {
              Player p = (Player)sender;
              if (args.length <= 0)
              {
                if (!p.isOp())
                {
                  p.sendMessage(ChatColor.RED + "You don't have permission.");
                  return true;
                }
                getConfig().set("Rankedsecond.world", p.getLocation().getWorld().getName());
                getConfig().set("Rankedsecond.x", Double.valueOf(p.getLocation().getX()));
                getConfig().set("Rankedsecond.y", Double.valueOf(p.getLocation().getY()));
                getConfig().set("Rankedsecond.z", Double.valueOf(p.getLocation().getZ()));
                getConfig().set("Rankedsecond.yaw", Float.valueOf(p.getLocation().getYaw()));
                getConfig().set("Rankedsecond.pitch", Float.valueOf(p.getLocation().getPitch()));
                p.sendMessage(ChatColor.GREEN + "Deuxi�me position du combat ranked enregistr�.");
                saveConfig();
              }
              else
              {
                  p.sendMessage(ChatColor.RED + "Probl�me de syntaxe essayez :" + ChatColor.AQUA +  "'/setrankedsecond'.");
              }
            }
            else
            {
          	  sender.sendMessage(ChatColor.RED + "Commande uniquement executable dans le jeu ! (Naruhiko wsh, tu fais quoi)");
            
            }
          }
    return true;
  }
  
  public Location getLobby()
  {
    Location loc = null;
    String world = getConfig().getString("Lobby.world");
    double x = getConfig().getDouble("Lobby.x");
    double y = getConfig().getDouble("Lobby.y");
    double z = getConfig().getDouble("Lobby.z");
    float yaw = (float)getConfig().getDouble("Lobby.yaw");
    float pitch = (float)getConfig().getDouble("Lobby.pitch");
    loc = new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
    return loc;
  }
  
  public Location getDeath()
  {
    Location loc = null;
    String world = getConfig().getString("Death.world");
    double x = getConfig().getDouble("Death.x");
    double y = getConfig().getDouble("Death.y");
    double z = getConfig().getDouble("Death.z");
    float yaw = (float)getConfig().getDouble("Death.yaw");
    float pitch = (float)getConfig().getDouble("Death.pitch");
    loc = new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
    return loc;
  }
  
  public Location getArena()
  {
    Location loc = null;
    String world = getConfig().getString("Arena.world");
    double x = getConfig().getDouble("Arena.x");
    double y = getConfig().getDouble("Arena.y");
    double z = getConfig().getDouble("Arena.z");
    float yaw = (float)getConfig().getDouble("Arena.yaw");
    float pitch = (float)getConfig().getDouble("Arena.pitch");
    loc = new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
    return loc;
  }
  
  public Location getFirst()
  {
    Location loc = null;
    String world = getConfig().getString("First.world");
    double x = getConfig().getDouble("First.x");
    double y = getConfig().getDouble("First.y");
    double z = getConfig().getDouble("First.z");
    float yaw = (float)getConfig().getDouble("First.yaw");
    float pitch = (float)getConfig().getDouble("First.pitch");
    loc = new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
    return loc;
  }
  
  public Location getSecond()
  {
    Location loc = null;
    String world = getConfig().getString("Second.world");
    double x = getConfig().getDouble("Second.x");
    double y = getConfig().getDouble("Second.y");
    double z = getConfig().getDouble("Second.z");
    float yaw = (float)getConfig().getDouble("Second.yaw");
    float pitch = (float)getConfig().getDouble("Second.pitch");
    loc = new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
    return loc;
  }
  
  public DuelManager getDuelManager()
  {
    return this.duelManager;
  }
  
  public boolean addWaitingPlayer(Player p)
  {
	  if(isPlayerWaiting(p))
		  return false;
	  else
	  {
		  this.waitingPlayers.add(new WaitingPlayer(p.getUniqueId()));
		  return true;
	  }
  }
  
  public boolean isPlayerWaiting(Player p)
  {
	  for(WaitingPlayer wp : this.waitingPlayers)
	  {
		  if(wp.getUUID().equals(p.getUniqueId()))
			  return true;
	  }
	  return false;
  }
  
  public boolean removeWaitingPlayer(Player p)
  {
	  if(isPlayerWaiting(p))
	  {
		  for(WaitingPlayer wp : this.waitingPlayers)
		  {
			  if(wp.getUUID().equals(p.getUniqueId()))
			  {
				  this.waitingPlayers.remove(wp);
				  return true;
			  }
		  }
	  }
	  else
		  return false;
	return false;
  }
  public void clearPlayer(Player p1)
  {
    p1.getInventory().clear();
    p1.getInventory().setArmorContents(null);
    for (PotionEffect pe : p1.getActivePotionEffects()) {
      p1.removePotionEffect(pe.getType());
    }
  }
}
