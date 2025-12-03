package model;

import java.io.Serializable;

public class TradeOffer implements Serializable
{
  private int price;
  private String description;
  private User user;
  public TradeOffer(int price, String description, User user)
  {
    this.price=price;
    this.description=description;
    this.user=user;
  }
  public int getPrice()
  {
    return price;
  }
  public String getDescription()
  {
    return description;
  }
  public String toString()
  {
    return  "Trade offer: " + description + "\nPrice: " + price +"\nSeller " + user.getName() + "\n";
  }
  public boolean equals(Object obj)
  {
    if (obj==null || obj.getClass()!=getClass())
      return false;
    TradeOffer other = (TradeOffer) obj;
    if (price==other.price && description.equals(other.description) && user.equals(other.user))
      return true;
    return false;
  }
}
