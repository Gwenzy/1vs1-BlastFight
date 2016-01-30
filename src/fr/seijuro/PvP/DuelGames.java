package fr.seijuro.PvP;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bukkit.entity.Player;

public class DuelGames
{
  List<Duel> list = new ArrayList();
  
  public void add(Duel d)
  {
    this.list.add(d);
  }
  
  public void remove(String name)
  {
    for (int i = 0; i < this.list.size(); i++) {
      if ((((Duel)this.list.get(i)).getPlayer1().getName().equals(name)) || (((Duel)this.list.get(i)).getPlayer2().getName().equals(name)))
      {
        this.list.remove(i);
        return;
      }
    }
  }
  
  public boolean containsPlayer(String name)
  {
    for (int i = 0; i < this.list.size(); i++) {
      if ((((Duel)this.list.get(i)).getPlayer1().getName().equals(name)) || (((Duel)this.list.get(i)).getPlayer2().getName().equals(name))) {
        return true;
      }
    }
    return false;
  }
  
  public Player getOpponent(String name)
  {
    for (int i = 0; i < this.list.size(); i++)
    {
      if (((Duel)this.list.get(i)).getPlayer1().getName().equals(name)) {
        return ((Duel)this.list.get(i)).getPlayer2();
      }
      if (((Duel)this.list.get(i)).getPlayer2().getName().equals(name)) {
        return ((Duel)this.list.get(i)).getPlayer1();
      }
    }
    return null;
  }
  
  public Iterator<Duel> iterator()
  {
    return this.list.iterator();
  }
}
