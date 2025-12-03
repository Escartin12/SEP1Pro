package model;

import java.io.Serializable;
import java.util.ArrayList;

public class TradeOfferList implements Serializable
{
  private ArrayList<TradeOffer> trades;
  public TradeOfferList()
  {
    trades = new ArrayList<TradeOffer>();
  }
  public void add(TradeOffer trade)
  {
    trades.add(trade);
  }
  public void set(TradeOffer trade, int index)
  {
    trades.set(index,trade);
  }
  public TradeOffer get(int index)
  {
    if (index<trades.size())
      return trades.get(index);
    else return null;
  }
  public TradeOffer get(String description)
  {
    for (int i=0;i<trades.size();i++)
    {
      TradeOffer temp = trades.get(i);
      if (temp.getDescription().equals(description))
        return temp;
    }
    return null;
  }
  public TradeOffer getByPrice(int price)
  {
    for (int i=0;i<trades.size();i++)
    {
      TradeOffer temp = trades.get(i);
      if (temp.getPrice()==price)
        return temp;
    }
    return null;
  }
  public int getIndexByPrice(int price)
  {
    for (int i=0;i<trades.size();i++)
    {
      TradeOffer temp = trades.get(i);
      if (temp.getPrice()==price)
        return i;
    }
    return -1;
  }
  public int getIndex(String description)
  {
    for (int i=0;i<trades.size();i++)
    {
      TradeOffer temp = trades.get(i);
      if (temp.getDescription().equals(description))
        return i;
    }
    return -1;
  }
  public int size()
  {
    return trades.size();
  }
  public String toString()
  {
    String returnStr = "";

    for(int i = 0; i<trades.size(); i++)
    {
      TradeOffer temp = trades.get(i);

      returnStr += temp +"\n";
    }
    return returnStr;
  }
}
