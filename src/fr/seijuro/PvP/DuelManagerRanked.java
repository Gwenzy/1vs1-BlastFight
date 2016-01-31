package fr.seijuro.PvP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;

public class DuelManagerRanked
{
  Main plugin;
  public static List<String> ovo = new ArrayList();
  public HashMap<String, String> mode = new HashMap();
  private DuelGamesRanked duels = new DuelGamesRanked();
  
  public DuelManagerRanked(Main plugin)
  {
    this.plugin = plugin;
  }
  
  public void createDuel(Player p1, Player p2, String mode)
  {
    DuelRanked duel = new DuelRanked(this.plugin, p1.getName(), p2.getName(), mode);
    
    //this.invites.removeAll(p1.getName());
    //this.invites.removeAll(p2.getName());
    
    p1.getInventory().clear();
    p2.getInventory().clear();
    





    p1.updateInventory();
    p2.updateInventory();
    
    p1.setHealth(20.0D);
    p2.setHealth(20.0D);
    
    this.duels.add(duel);
    duel.setTaskID(Bukkit.getScheduler().scheduleSyncRepeatingTask(this.plugin, duel, 0L, 10L));
    for (String s : ovo)
    {
      Player p = Bukkit.getPlayerExact(s);
      if ((!p.getName().equals(p1.getName())) && (!p.getName().equals(p2.getName())))
      {
        p1.hidePlayer(p);
        p2.hidePlayer(p);
      }
    }
  }
  
  public void inviteDuel(Player p1, Player p2, String s)
  {
    if (p1.getName().equals(p2.getName()))
    {
      p1.sendMessage(ChatColor.RED + "Vous ne pouvez pas vous inviter vous m�me!");
      return;
    }
   
   
  }

  public void endDuel(Player p1)
  {
    Player p2 = this.duels.getOpponent(p1.getName());
    this.plugin.clearPlayer(p2);
    p2.getInventory().setItem(0, GameListener.soup);
    p2.getInventory().setHeldItemSlot(0);
    p2.getInventory().setItem(1, GameListener.vanilla1);
    p2.getInventory().setItem(2, GameListener.vanilla2);
    
    /**
     * BLASTFIGHT ADD
     * 
     * */
    p2.getInventory().setItem(4, GameListener.cheat);
    p2.getInventory().setItem(6, GameListener.soup2);
    p2.getInventory().setItem(7, GameListener.vanilla3);
    p2.getInventory().setItem(8, GameListener.vanilla4);
    p2.getInventory().setItem(3, GameListener.ranked);
    p2.getInventory().setItem(5, GameListener.rankedcheat);
    
    /**
     * BLASTFIGHT ADD
     * 
     * */
    p2.setHealth(20.0D);
    
    p2.sendMessage(ChatColor.GOLD + ">>> Vous avez gagn� le combat face � " + ChatColor.AQUA + p1.getName() + "!");
    p1.sendMessage(ChatColor.RED + ">>> Vous avez perdu le combat face � " + ChatColor.AQUA + p2.getName() + "!");
    
    this.duels.remove(p1.getName());
    for (String s : ovo) {
      if ((!s.equals(p1.getName())) && (!s.equals(p2.getName())))
      {
        Player cP = Bukkit.getPlayerExact(s);
        p1.showPlayer(cP);
        p2.showPlayer(cP);
      }
    }
  }
  
  
  
  public void enter(Player p1)
  {
    if (p1.getVehicle() == null)
    {
      p1.sendMessage(ChatColor.YELLOW + "Vous �tes entr� dans le training !");
      
      this.plugin.clearPlayer(p1);
      p1.getInventory().setItem(0, GameListener.soup);
      p1.getInventory().setHeldItemSlot(0);
      p1.getInventory().setItem(1, GameListener.vanilla1);
      p1.getInventory().setItem(2, GameListener.vanilla2);
      
      
      /**
       * BLASTFIGHT ADD
       * 
       * */
      p1.getInventory().setItem(4, GameListener.cheat);
      p1.getInventory().setItem(6, GameListener.soup2);
      p1.getInventory().setItem(7, GameListener.vanilla3);
      p1.getInventory().setItem(8, GameListener.vanilla4);
      p1.getInventory().setItem(3, GameListener.ranked);
      p1.getInventory().setItem(5, GameListener.rankedcheat);
      
      /**
       * 
       * BLASTFIGHT ADD END
       * 
       **/
      p1.teleport(this.plugin.getArena());
      p1.setHealth(20.0D);
      p1.setFoodLevel(20);
     
      ovo.add(p1.getName());
      
      Iterator<DuelRanked> it = this.duels.iterator();
      while (it.hasNext())
      {
        DuelRanked d = (DuelRanked)it.next();
        d.getPlayer1().hidePlayer(p1);
        d.getPlayer2().hidePlayer(p1);
      }
    }
    else
    {
      p1.sendMessage(ChatColor.RED + "Vous ne pouvez pas rejoindre en �tant sur un objets non identifi� " + p1.getVehicle().getType().toString().toLowerCase());
    }
  }
  
  public boolean isInDuel(Player p1)
  {
    return this.duels.containsPlayer(p1.getName());
  }
  
  public boolean isOneVsOne(Player p1)
  {
    return ovo.contains(p1.getName());
  }
  
 
}
