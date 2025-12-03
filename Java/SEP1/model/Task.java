package model;

import java.io.Serializable;

public class Task implements Serializable
{
  private String description;
  private int reward;
  public Task(String description, int reward)
  {
    this.description=description;
    this.reward=reward;
  }
  public String getDescription()
  {
    return description;
  }
  public int getReward()
  {
    return reward;
  }
  public String toString()
  {
    return "Task: " + description + "\nReward: " + reward + "\n";
  }
  public boolean equals(Object obj)
  {
    if (obj==null || obj.getClass()!=getClass())
      return false;
    Task other= (Task) obj;
    if (description.equals(other.description) && reward==other.reward)
      return true;
    return false;
  }
}
