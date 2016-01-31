package fr.seijuro.PvP;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.ScoreboardManager;

public class GameListener
  implements Listener
{
  Main plugin;
  public static ItemStack soup;
  public static ItemStack vanilla1;
  public static ItemStack vanilla2;
  public static ItemStack soup2;
  public static ItemStack vanilla3;
  public static ItemStack vanilla4;
  public static ItemStack cheat;
  
  public static ItemStack rankedcheat;
  public static ItemStack ranked;
  
  public GameListener(Main instance)
  {
    this.plugin = instance;
  }
  
  ScoreboardManager manager = Bukkit.getScoreboardManager();
  public static ItemStack kitSelectorItem = new ItemStack(Material.SULPHUR);
  
  static
  {
    ItemMeta kitMeta = kitSelectorItem.getItemMeta();
    kitMeta.setDisplayName(ChatColor.YELLOW + "Rejoindre l");
    kitSelectorItem.setItemMeta(kitMeta);
    kitSelectorItem.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
    
    soup = new ItemStack(Material.WOOD_SWORD);
    ItemMeta soupMeta = kitSelectorItem.getItemMeta();
    soupMeta.setDisplayName("&6Soup PvP &b(Cliquez droit sur un joueur)");
    soup.setItemMeta(soupMeta);
    soup.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
    
    vanilla1 = new ItemStack(Material.IRON_SWORD);
    ItemMeta vanilla1Meta = kitSelectorItem.getItemMeta();
    vanilla1Meta.setDisplayName("&6Vanilla PvP &b(Cliquez droit sur un joueur)");
    vanilla1.setItemMeta(vanilla1Meta);
    vanilla1.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
    
    vanilla2 = new ItemStack(Material.DIAMOND_SWORD);
    ItemMeta vanilla2Meta = kitSelectorItem.getItemMeta();
    vanilla2Meta.setDisplayName("&6Vanilla PvP Potion &b(Cliquez droit sur un joueur)");
    vanilla2.setItemMeta(vanilla2Meta);
    vanilla2.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
    /**
     * AJOUTS BLASTFIGHT
     * 
     * */
    soup2 = new ItemStack(Material.TOPAZ_SWORD);
    ItemMeta soup2Meta = kitSelectorItem.getItemMeta();
    soup2Meta.setDisplayName("&eTopaz Soup &7(Cliquez droit sur un joueur)");
    soup2.setItemMeta(soup2Meta);
    soup2.addUnsafeEnchantment(Enchantment.DURABILITY, 1);

    vanilla3 = new ItemStack(Material.RUBY_SWORD);
    ItemMeta vanilla3Meta = kitSelectorItem.getItemMeta();
    vanilla3Meta.setDisplayName("&eRuby Vanilla &7(Cliquez droit sur un joueur)");
    vanilla3.setItemMeta(vanilla3Meta);
    vanilla3.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
    
    vanilla4 = new ItemStack(Material.EMERALD_SWORD);
    ItemMeta vanilla4Meta = kitSelectorItem.getItemMeta();
    vanilla4Meta.setDisplayName("&eZircon Potion &7(Cliquez droit sur un joueur)");
    vanilla4.setItemMeta(vanilla4Meta);
    vanilla4.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
    
    cheat = new ItemStack(Material.ZIRCON_SWORD);
    ItemMeta cheatMeta = kitSelectorItem.getItemMeta();
    cheatMeta.setDisplayName("&ePVP CHEAT &c(Cliquez droit sur un joueur)");
    cheat.setItemMeta(cheatMeta);
    cheat.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
    
    ranked = new ItemStack(Material.TOPAZ_KEY);
    ItemMeta rankedMeta = kitSelectorItem.getItemMeta();
    rankedMeta.setDisplayName("&6Ranked vanilla &7(Bient&t)");
    ranked.setItemMeta(rankedMeta);
    ranked.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
    
    
    rankedcheat = new ItemStack(Material.ZIRCON_KEY);
    ItemMeta rankedcheatMeta = kitSelectorItem.getItemMeta();
    rankedcheatMeta.setDisplayName("&bRanked cheat &7(Bient&t)");
    rankedcheat.setItemMeta(rankedcheatMeta);
    rankedcheat.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
  }
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onPlayerInteract(PlayerInteractEvent event)
  {
    Player p = event.getPlayer();
    if (((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK)) && (p.getItemInHand().isSimilar(kitSelectorItem)))
    {
      p.teleport(this.plugin.getArena());
      p.getInventory().clear();
      p.getInventory().setItem(0, soup);
      p.getInventory().setHeldItemSlot(0);
      p.getInventory().setItem(1, vanilla1);
      p.getInventory().setItem(2, vanilla2);
      
      /**
       * AJOUTS BLASTFIGHT
       * 
       **/
      
      p.getInventory().setItem(4, cheat);
      p.getInventory().setItem(6, soup2);
      p.getInventory().setItem(7, vanilla3);
      p.getInventory().setItem(8, vanilla4);
      p.getInventory().setItem(3, ranked);
      p.getInventory().setItem(5, rankedcheat);
      p.updateInventory();
      p.sendMessage(ChatColor.YELLOW + ">>> " + ChatColor.GRAY + "Vous avez rejoins l'ar&ne d'entrainement !");
      p.sendMessage(ChatColor.YELLOW + ">>> " + ChatColor.GRAY + "Pour combatre contre quelqu'un cliquez droit avec la bonne &p&e sur quelqu'un !");
      p.sendMessage(ChatColor.YELLOW + ">>> " + ChatColor.GRAY + "Pour que cette personne accepte le combat elle doit reproduire la m&me action sur vous avec la bonne &p&e !");
      p.sendMessage(ChatColor.YELLOW + ">>> " + ChatColor.GRAY + "Bon jeu sur le serveur training de BlastFight!");
      event.setCancelled(true);
      this.plugin.getDuelManager().enter(p);
      return;
    }//Apr&s on rajoute la gestion des ranked
    else if (((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK)) && (p.getItemInHand().isSimilar(ranked)))
    {
    	//Clic avec l'item ranked
    	
    }
    else if (((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK)) && (p.getItemInHand().isSimilar(rankedcheat)))
    {
    	//Clic avec l'item ranked cheat
    }
  }
  
  @EventHandler
  public void onInventoryClick(InventoryClickEvent e)
  {
    if (e.getCurrentItem().isSimilar(soup))
    {
      e.setCancelled(true);
      return;
    }
    if (e.getCurrentItem().isSimilar(vanilla1))
    {
      e.setCancelled(true);
      return;
    }
    if (e.getCurrentItem().isSimilar(vanilla2))
    {
      e.setCancelled(true);
      return;
    }
    
    if (e.getCurrentItem().isSimilar(vanilla3))
    {
      e.setCancelled(true);
      return;
    }
    
    if (e.getCurrentItem().isSimilar(vanilla4))
    {
      e.setCancelled(true);
      return;
    }
    if (e.getCurrentItem().isSimilar(soup2))
    {
      e.setCancelled(true);
      return;
    }
    
    if (e.getCurrentItem().isSimilar(cheat))
    {
      e.setCancelled(true);
      return;
    }
    if (e.getCurrentItem().isSimilar(kitSelectorItem))
    {
      e.setCancelled(true);
      return;
    }
    
    if (e.getCurrentItem().isSimilar(ranked))
    {
      e.setCancelled(true);
      return;
    }
    
    if (e.getCurrentItem().isSimilar(rankedcheat))
    {
    	
      e.setCancelled(true);
      return;
    }
     
   }


  @EventHandler
  public void onPlayerDropItem(PlayerDropItemEvent event) {
  Player p = event.getPlayer();

  if (event.getItemDrop().getItemStack().getType() ==  Material.ZIRCON_KEY) {
  event.setCancelled(true);
  p.sendMessage(ChatColor.RED + "Vous ne pouvez pas jetter cette objets !");
  }
  if (event.getItemDrop().getItemStack().getType() ==  Material.TOPAZ_KEY) {
	  event.setCancelled(true);
	  p.sendMessage(ChatColor.RED + "Vous ne pouvez pas jetter cette objets !");
	  }
  if (event.getItemDrop().getItemStack().getType() ==  Material.SULPHUR) {
	  event.setCancelled(true);
	  p.sendMessage(ChatColor.RED + "Vous ne pouvez pas jetter cette objets !");
	  }
  if (event.getItemDrop().getItemStack().getType() ==  Material.DIAMOND_SWORD) {
	  event.setCancelled(true);
	  p.sendMessage(ChatColor.RED + "Vous ne pouvez pas jetter cette objets !");
	  }
  if (event.getItemDrop().getItemStack().getType() ==  Material.WOOD_SWORD) {
	  event.setCancelled(true);
	  p.sendMessage(ChatColor.RED + "Vous ne pouvez pas jetter cette objets !");
	  }
  
  if (event.getItemDrop().getItemStack().getType() ==  Material.IRON_SWORD) {
	  event.setCancelled(true);
	  p.sendMessage(ChatColor.RED + "Vous ne pouvez pas jetter cette objets !");
	  }
  if (event.getItemDrop().getItemStack().getType() ==  Material.TOPAZ_SWORD) {
	  event.setCancelled(true);
	  p.sendMessage(ChatColor.RED + "Vous ne pouvez pas jetter cette objets !");
	  }
  if (event.getItemDrop().getItemStack().getType() ==  Material.EMERALD_SWORD) {
	  event.setCancelled(true);
	  p.sendMessage(ChatColor.RED + "Vous ne pouvez pas jetter cette objets !");
	  }
  
  if (event.getItemDrop().getItemStack().getType() ==  Material.RUBY_SWORD) {
	  event.setCancelled(true);
	  p.sendMessage(ChatColor.RED + "Vous ne pouvez pas jetter cette objets !");
	  }
  
  if (event.getItemDrop().getItemStack().getType() ==  Material.ZIRCON_SWORD) {
	  event.setCancelled(true);
	  p.sendMessage(ChatColor.RED + "Vous ne pouvez pas jetter cette objets !");
	  }
  }
  
  @EventHandler
  public void onPlayerInteractEntityEvent(PlayerInteractEntityEvent evt)
  {
    Player player = evt.getPlayer();
    if ((isItem(player.getItemInHand())) && 
      (this.plugin.getDuelManager().isOneVsOne(player)) && 
      ((evt.getRightClicked() instanceof Player)))
    {
      Player target = (Player)evt.getRightClicked();
      if (this.plugin.getDuelManager().isOneVsOne(target))
      {
        if (!this.plugin.getDuelManager().isInDuel(target)) {
          this.plugin.getDuelManager().inviteDuel(player, target, ChatColor.stripColor(player.getItemInHand().getItemMeta().getDisplayName()));
        } else {
          player.sendMessage(ChatColor.RED + target.getName() + " est d&j& en combat !");
        }
      }
      else {
        player.sendMessage(ChatColor.RED + target.getName() + " n'a pas encore rejoins le training !");
      }
    }
  }
  
  @EventHandler
  public void onJoin(PlayerJoinEvent e)
  {
	    
         
                  
            
    
    Player p = e.getPlayer();
    p.teleport(this.plugin.getLobby());
    p.getInventory().clear();
    p.getInventory().setHelmet(null);
    p.getInventory().setChestplate(null);
    p.getInventory().setLeggings(null);
    p.getInventory().setBoots(null);
    p.setGameMode(GameMode.SURVIVAL);
    p.sendMessage(ChatColor.GOLD + ">>> Bienvenue sur le serveur " + ChatColor.AQUA + "Training de BlastFight");
    p.sendMessage(ChatColor.GOLD + ">>> Developp& en java par : " + ChatColor.AQUA + "Naruhiko315 , Seijuro , Mahdinchina & Gwenzy");
    p.sendMessage(ChatColor.GOLD + ">>> Pour rejoindre le jeu : " + ChatColor.YELLOW + "Cliquez droit !");
    p.setHealth(20.0D);
    p.setFoodLevel(20);
    p.setExp(0.0F);
    p.getInventory().setItem(0, kitSelectorItem);
    
    Firework f = (Firework) e.getPlayer().getWorld().spawn(e.getPlayer().getLocation(), Firework.class);
    
    FireworkMeta fm = f.getFireworkMeta();
    fm.addEffect(FireworkEffect.builder()
                    .flicker(false)
                    .trail(true)
                    .with(Type.STAR)
                    .withColor(Color.YELLOW)
                    .withFade(Color.YELLOW)
                    .build());
    fm.setPower(2);
    f.setFireworkMeta(fm);
  }
  
  public boolean isItem(ItemStack is)
  {
    if ((is.isSimilar(soup)) || 
    		(is.isSimilar(vanilla1)) || 
    		(is.isSimilar(vanilla2) || 
    				(is.isSimilar(vanilla3) || 
    						(is.isSimilar(vanilla4) || (is.isSimilar(soup2) || (is.isSimilar(cheat)))) || (is.isSimilar(ranked)) || (is.isSimilar(rankedcheat))         ) )) {
      return true;
    }
    return false;
  }
  
  @EventHandler
  public void onPlayerQuitEvent(PlayerQuitEvent evt)
  {
    this.plugin.getDuelManager().leave(evt.getPlayer(), false);
  }
  
  @EventHandler
  public void onPlayerKickEvent(PlayerKickEvent evt)
  {
    this.plugin.getDuelManager().leave(evt.getPlayer(), false);
  }
  
  @EventHandler
  public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent evt)
  {
    if (((evt.getEntity() instanceof Player)) && 
      ((evt.getDamager() instanceof Player)))
    {
      Player player = (Player)evt.getEntity();
      Player damager = (Player)evt.getDamager();
      if ((!this.plugin.getDuelManager().isInDuel(damager)) && (this.plugin.getDuelManager().isOneVsOne(damager)))
      {
        evt.setCancelled(true);
        return;
      }
      if ((!this.plugin.getDuelManager().isInDuel(player)) && (this.plugin.getDuelManager().isOneVsOne(player)))
      {
        evt.setCancelled(true);
        return;
      }
    }
  }
  
  @EventHandler
  public void onPlayerDeathEvent(PlayerDeathEvent evt)
  {
	  
	
       
    Player p1 = evt.getEntity();
    if (this.plugin.getDuelManager().isOneVsOne(p1))
    {
      evt.getDrops().clear();
      evt.setDroppedExp(0);
      if (this.plugin.getDuelManager().isInDuel(p1))
      {
        this.plugin.getDuelManager().endDuel(p1);
        evt.setDeathMessage(null);
        
      }
    }
    Firework f = (Firework) evt.getEntity().getWorld().spawn(evt.getEntity().getLocation(), Firework.class);
    
    FireworkMeta fm = f.getFireworkMeta();
    fm.addEffect(FireworkEffect.builder()
                    .flicker(true)
                    .trail(true)
                    .with(Type.CREEPER)
                    .withColor(Color.RED)
                    .withFade(Color.RED)
                    .build());
    fm.setPower(2);
  }
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onPlayerRespawnEvent(PlayerRespawnEvent evt)
  {
    if (this.plugin.getDuelManager().isOneVsOne(evt.getPlayer()))
    {
      evt.setRespawnLocation(this.plugin.getDeath());
      Player p = evt.getPlayer();
      p.getInventory().setItem(0, soup);
      p.getInventory().setHeldItemSlot(0);
      p.getInventory().setItem(1, vanilla1);
      p.getInventory().setItem(2, vanilla2);
      
      /**
       * BLASTFIGHT ADD
       * 
       * */
      
      p.getInventory().setItem(4, cheat);
      p.getInventory().setItem(6, soup2);
      p.getInventory().setItem(7, vanilla3);
      p.getInventory().setItem(8, vanilla4);
      p.getInventory().setItem(3, ranked);
      p.getInventory().setItem(5, rankedcheat);
      p.updateInventory();
    }
  }
  
  @EventHandler
  public void onFoodChange(FoodLevelChangeEvent event)
  {
      if (event.getEntity() instanceof Player)
      {
          Player player = (Player) event.getEntity();
          if (player.hasPermission("food.foody"))
              event.setCancelled(true);
      }
  }
}
