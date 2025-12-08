package model;

import java.io.Serializable;

public class GreenTask implements Serializable
{
  private String description;
  private int reward;
  public GreenTask(String description, int reward)
  {
    this.description=description;
    this.reward=reward;
  }
  public String getDescription()
  {
    return description;
  }
  public void setDescription(String d)
  {
    description=d;
  }
  public int getReward()
  {
    return reward;
  }
  public void setReward(int r)
  {
    reward=r;
  }
  public String toString()
  {
    return "Task: " + description + ",\nReward: " + reward + ",\n";
  }
  public boolean equals(Object obj)
  {
    if (obj==null || obj.getClass()!=getClass())
      return false;
    GreenTask other= (GreenTask) obj;
    if (description.equals(other.description) && reward==other.reward)
      return true;
    return false;
  }
}
