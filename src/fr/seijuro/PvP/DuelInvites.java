package fr.seijuro.PvP;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DuelInvites
{
  private List<Invite> list = new ArrayList();
  
  public void add(Invite p)
  {
    this.list.add(p);
  }
  
  public void removeAll(String s)
  {
    for (int i = this.list.size() - 1; i >= 0; i--) {
      if ((((Invite)this.list.get(i)).getInviter().equals(s)) || (((Invite)this.list.get(i)).getInvited().equals(s))) {
        this.list.remove(i);
      }
    }
  }
  
  public boolean containsInviter(String invited)
  {
    for (int i = this.list.size() - 1; i >= 0; i--) {
      if (((Invite)this.list.get(i)).getInviter().equals(invited)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean containsInvited(String inviter)
  {
    for (int i = this.list.size() - 1; i >= 0; i--) {
      if (((Invite)this.list.get(i)).getInvited().equals(inviter)) {
        return true;
      }
    }
    return false;
  }
  
  public String getInviter(String invited)
  {
    for (int i = this.list.size() - 1; i >= 0; i--) {
      if (((Invite)this.list.get(i)).getInvited().equals(invited)) {
        return ((Invite)this.list.get(i)).getInviter();
      }
    }
    return null;
  }
  
  public String getSpecificInviter(String invited, String inviter)
  {
    for (int i = this.list.size() - 1; i >= 0; i--) {
      if ((((Invite)this.list.get(i)).getInvited().equals(invited)) && 
        (((Invite)this.list.get(i)).getInviter().equals(inviter))) {
        return ((Invite)this.list.get(i)).getInviter();
      }
    }
    return null;
  }
  
  public Iterator<Invite> iterator()
  {
    return this.list.iterator();
  }
}
