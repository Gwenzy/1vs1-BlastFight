package fr.seijuro.PvP;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

public class DuelRanked
  implements Runnable
{
  private String mode;
  private int taskID;
  private Main plugin;
  private int count = 10;
  private Player p1;
  private Player p2;
  
  public DuelRanked(Main plugin, String p1, String p2, String mod)
  {
    this.mode = mod;
    this.plugin = plugin;
    this.p1 = Bukkit.getPlayerExact(p1);
    this.p2 = Bukkit.getPlayerExact(p2);
  }
  
  public void setTaskID(int taskID)
  {
    this.taskID = taskID;
  }
  
  public void run()
  {
    if ((!this.p1.isOnline()) || (!this.p2.isOnline())) {
      cancel();
    }
    this.p1.teleport(this.plugin.getFirst());
    this.p2.teleport(this.plugin.getSecond());
    if (this.count == 10)
    {
      this.p1.sendMessage(ChatColor.GOLD + "Le combat commence dans " + ChatColor.AQUA + this.count / 2 + ChatColor.GOLD + " secondes!");
      this.p2.sendMessage(ChatColor.GOLD + "Le combat commence dans " + ChatColor.AQUA + this.count / 2 + ChatColor.GOLD + " secondes!");
      this.p1.playSound(this.p1.getLocation(), Sound.NOTE_PLING, 1.0F, 1.0F);
      this.p2.playSound(this.p1.getLocation(), Sound.NOTE_PLING, 1.0F, 1.0F);
    }
    else if (this.count >= 1)
    {
      if (this.count % 2 == 0)
      {
        this.p1.sendMessage(ChatColor.AQUA + "" + this.count / 2 + ChatColor.GOLD + " secondes...");
        this.p2.sendMessage(ChatColor.AQUA + "" + this.count / 2 +  ChatColor.GOLD + " secondes...");
        this.p1.playSound(this.p1.getLocation(), Sound.NOTE_PLING, 1.0F, 1.0F);
        this.p2.playSound(this.p1.getLocation(), Sound.NOTE_PLING, 1.0F, 1.0F);
      }
    }
    else if (this.count == 0)
    {
      this.p1.sendMessage(ChatColor.YELLOW + "C'est l'heure du-du-du-duel !");
      this.p2.sendMessage(ChatColor.YELLOW + "C'est l'heure du-du-du-duel !");
      this.p1.playSound(this.p1.getLocation(), Sound.NOTE_PLING, 1.0F, 2.0F);
      this.p2.playSound(this.p1.getLocation(), Sound.NOTE_PLING, 1.0F, 2.0F);
      if (this.mode.equalsIgnoreCase("Soup PvP (Cliquez droit sur un joueur)"))
      {
    	ItemStack popoSpeed2Splash = new ItemStack(Material.POTION, 3, (short) 16418);
        ItemStack dsword = new ItemStack(Material.DIAMOND_SWORD);
        ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
        PlayerInventory inv1 = this.p1.getInventory();
        inv1.setItem(0, dsword);
        inv1.setItem(1, popoSpeed2Splash);
        inv1.setItem(2, soup);
        inv1.setItem(3, soup);
        inv1.setItem(4, soup);
        inv1.setItem(5, soup);
        inv1.setItem(6, soup);
        inv1.setItem(7, soup);
        inv1.setItem(8, soup);
        inv1.setItem(9, soup);
        inv1.setItem(10, soup);
        inv1.setItem(11, soup);
        inv1.setItem(12, soup);
        inv1.setItem(13, soup);
        inv1.setItem(14, soup);
        inv1.setItem(15, soup);
        inv1.setItem(16, soup);
        inv1.setItem(17, soup);
        inv1.setItem(18, soup);
        inv1.setItem(19, soup);
        inv1.setItem(20, soup);
        inv1.setItem(21, soup);
        inv1.setItem(22, soup);
        inv1.setItem(23, soup);
        inv1.setItem(24, soup);
        inv1.setItem(25, soup);
        inv1.setItem(26, soup);
        inv1.setItem(27, soup);
        inv1.setItem(28, soup);
        inv1.setItem(29, soup);
        inv1.setItem(30, soup);
        inv1.setItem(31, soup);
        inv1.setItem(32, soup);
        inv1.setItem(33, soup);
        inv1.setItem(34, soup);
        this.p1.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
        this.p1.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        this.p1.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        this.p1.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
        
        PlayerInventory inv2 = this.p2.getInventory();
        inv2.setItem(0, dsword);
        inv2.setItem(1, popoSpeed2Splash);
        inv2.setItem(2, soup);
        inv2.setItem(3, soup);
        inv2.setItem(4, soup);
        inv2.setItem(5, soup);
        inv2.setItem(6, soup);
        inv2.setItem(7, soup);
        inv2.setItem(8, soup);
        inv2.setItem(9, soup);
        inv2.setItem(10, soup);
        inv2.setItem(11, soup);
        inv2.setItem(12, soup);
        inv2.setItem(13, soup);
        inv2.setItem(14, soup);
        inv2.setItem(15, soup);
        inv2.setItem(16, soup);
        inv2.setItem(17, soup);
        inv2.setItem(18, soup);
        inv2.setItem(19, soup);
        inv2.setItem(20, soup);
        inv2.setItem(21, soup);
        inv2.setItem(22, soup);
        inv2.setItem(23, soup);
        inv2.setItem(24, soup);
        inv2.setItem(25, soup);
        inv2.setItem(26, soup);
        inv2.setItem(27, soup);
        inv2.setItem(28, soup);
        inv2.setItem(29, soup);
        inv2.setItem(30, soup);
        inv2.setItem(31, soup);
        inv2.setItem(32, soup);
        inv2.setItem(33, soup);
        inv2.setItem(34, soup);
        this.p2.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
        this.p2.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        this.p2.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        this.p2.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
      }
      else if (this.mode.equalsIgnoreCase("Vanilla PvP (Cliquez droit sur un joueur)"))
      {
        ItemStack dsword = new ItemStack(Material.STONE_SWORD);
        PlayerInventory inv1 = this.p1.getInventory();
        inv1.setItem(0, dsword);
        this.p1.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
        this.p1.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        this.p1.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        this.p1.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
        
        PlayerInventory inv2 = this.p2.getInventory();
        inv2.setItem(0, dsword);
        this.p2.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
        this.p2.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        this.p2.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        this.p2.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
      }
      
      this.p1.updateInventory();this.p2.updateInventory();
      cancel();
    }
    this.count -= 1;
  }
  
  public Player getPlayer1()
  {
    return this.p1;
  }
  
  public Player getPlayer2()
  {
    return this.p2;
  }
  
  public void cancel()
  {
    Bukkit.getScheduler().cancelTask(this.taskID);
  }
  
  public String getMode()
  {
    return this.mode;
  }
}
