package model;

import java.io.Serializable;
import java.util.ArrayList;

public class UserList implements Serializable
{
  private ArrayList<User> users;
  public UserList()
  {
    users = new ArrayList<User>();
  }
  public void add(User user)
  {
    users.add(user);
  }
  public void set(User user, int index)
  {
    users.set(index,user);
  }
  public User get(int index)
  {
    if (index<users.size())
      return users.get(index);
    else return null;
  }
  public User get(String name)
  {
    for (int i=0;i<users.size();i++)
    {
      User temp = users.get(i);
      if (temp.getName().equals(name))
        return temp;
    }
    return null;
  }
  public int getIndex(String name)
  {
    for (int i=0;i<users.size();i++)
    {
      User temp = users.get(i);
      if (temp.getName().equals(name))
        return i;
    }
    return -1;
  }
  public int size()
  {
    return users.size();
  }
  public String toString()
  {
    String returnStr = "";

    for(int i = 0; i<users.size(); i++)
    {
      User temp = users.get(i);

      returnStr += temp +"\n";
    }
    return returnStr;
  }
}
