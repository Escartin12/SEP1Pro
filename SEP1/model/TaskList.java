package model;

import java.io.Serializable;
import java.util.ArrayList;

public class TaskList implements Serializable
{
  private ArrayList<Task> tasks;
  public TaskList()
  {
    tasks = new ArrayList<Task>();
  }
  public void add(Task task)
  {
    tasks.add(task);
  }
  public void set(Task task, int index)
  {
    tasks.set(index,task);
  }
  public Task get(int index)
  {
    if (index<tasks.size())
      return tasks.get(index);
    else return null;
  }
  public Task get(String description)
  {
    for (int i=0;i<tasks.size();i++)
    {
      Task temp = tasks.get(i);
      if (temp.getDescription().equals(description))
        return temp;
    }
    return null;
  }
  public Task getByReward(int reward)
  {
    for (int i=0;i<tasks.size();i++)
    {
      Task temp = tasks.get(i);
      if (temp.getReward()==reward)
        return temp;
    }
    return null;
  }
  public int getIndexByReward(int reward)
  {
    for (int i=0;i<tasks.size();i++)
    {
      Task temp = tasks.get(i);
      if (temp.getReward()==reward)
        return i;
    }
    return -1;
  }
  public int getIndex(String description)
  {
    for (int i=0;i<tasks.size();i++)
    {
      Task temp = tasks.get(i);
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
      Task temp = tasks.get(i);

      returnStr += temp +"\n";
    }
    return returnStr;
  }
  public void remove(Task task)
  {
    tasks.remove(task);
  }
  public ArrayList<Task> getAll() {
    return tasks;
  }

  public Task[] toArray() {
    return tasks.toArray(new Task[0]);
  }


}
