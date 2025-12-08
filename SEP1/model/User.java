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
    this.name = name;
    this.balance = balance;
    this.activity = activity;
    this.boost = boost;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String n)
  {
    name = n;
  }

  public int getBalance()
  {
    return balance;
  }

  public void setBalance(int b)
  {
    balance = b;
  }

  public boolean getActivity()
  {
    return activity;
  }

  public void setActivity(boolean a)
  {
    activity = a;
  }

  public int getBoost()
  {
    return boost;
  }

  public void setBoost(int b)
  {
    boost = b;
  }

  public String toString()
  {
    return "User: " + name + ", Balance: " + balance + ", Activity: " + activity
        + ", Boost: " + boost + "%";
  }

  public boolean equals(Object obj)
  {
    if (obj == null || obj.getClass() != getClass())
      return false;
    User other = (User) obj;
    return name.equals(other.name) && balance == other.balance
        && activity == other.activity && boost == other.boost;
  }
}
