package model;

import java.io.Serializable;
import java.util.ArrayList;

public class GreenTaskList implements Serializable
{
  private ArrayList<GreenTask> tasks;
  public GreenTaskList()
  {
    tasks = new ArrayList<GreenTask>();
  }
  public void add(GreenTask task)
  {
    tasks.add(task);
  }
  public void set(GreenTask task, int index)
  {
    tasks.set(index,task);
  }
  public GreenTask get(int index)
  {
    if (index<tasks.size())
      return tasks.get(index);
    else return null;
  }
  public GreenTask get(String description)
  {
    for (int i=0;i<tasks.size();i++)
    {
      GreenTask temp = tasks.get(i);
      if (temp.getDescription().equals(description))
        return temp;
    }
    return null;
  }
  public GreenTask getByReward(int reward)
  {
    for (int i=0;i<tasks.size();i++)
    {
      GreenTask temp = tasks.get(i);
      if (temp.getReward()==reward)
        return temp;
    }
    return null;
  }
  public int getIndexByReward(int reward)
  {
    for (int i=0;i<tasks.size();i++)
    {
      GreenTask temp = tasks.get(i);
      if (temp.getReward()==reward)
        return i;
    }
    return -1;
  }
  public int getIndex(String description)
  {
    for (int i=0;i<tasks.size();i++)
    {
      GreenTask temp = tasks.get(i);
      if (temp.getDescription().equals(description))
        return i;
    }
    return -1;
  }
  public int size()
  {
    return tasks.size();
  }
  public String toString()
  {
    String returnStr = "";

    for(int i = 0; i<tasks.size(); i++)
    {
      GreenTask temp = tasks.get(i);

      returnStr += temp +"\n";
    }
    return returnStr;
  }
}
