package fr.seijuro.PvP;

public class Invite
{
  private String inviter;
  private String invited;
  
  public Invite(String inviter, String invited)
  {
    this.inviter = inviter;
    this.invited = invited;
  }
  
  public String getInviter()
  {
    return this.inviter;
  }
  
  public String getInvited()
  {
    return this.invited;
  }
}
