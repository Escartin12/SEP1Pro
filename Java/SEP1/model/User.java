package model;

import java.io.Serializable;

public class User implements Serializable
{
  private String name;
  private int balance;
  private boolean activity;
  private int boost;
  public User(String name, int balance, boolean activity, int boost)
  {
    this.name=name;
    this.balance=balance;
    this.activity=activity;
    this.boost=boost;
  }
  public String getName()
  {
    return name;
  }
  public int getBalance()
  {
    return balance;
  }
  public boolean getActivity()
  {
    return activity;
  }
  public int getBoost()
  {
    return boost;
  }
  public String toString()
  {
    return "User: " + name + "\nBalance: " + balance + "\nActivity: " + activity + "\nBoost: " + boost + "%" + "\n";
  }
  public boolean equals(Object obj)
  {
    if (obj==null || obj.getClass()!=getClass())
      return false;
    User other= (User) obj;
    if (name.equals(other.name) && balance==other.balance && activity==other.activity && boost==other.boost)
      return true;
    return false;
  }
}
