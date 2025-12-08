package main;

import model.*;
import parser.XmlJsonParser;

public class LoadInitialData
{
  public static void main(String[] args)
  {
    XmlJsonParser parser = new XmlJsonParser();

    // ---------- USERS ----------
    UserList users = new UserList();
    users.add(new User("Alice", 100, true, 10));
    users.add(new User("Bob", 50, false, 0));
    users.add(new User("Charlie", 200, true, 20));

    try {
      parser.toXmlFile(users, "src/model/users.xml");
    } catch (Exception e) {
      System.out.println("Error saving users.xml: " + e.getMessage());
    }

    // ---------- TASKS ----------
    TaskList tasks = new TaskList();
    tasks.add(new Task("Clean room", 10));
    tasks.add(new Task("Wash dishes", 5));
    tasks.add(new Task("Do homework", 20));

    try {
      parser.toXmlFile(tasks, "src/model/tasks.xml");
    } catch (Exception e) {
      System.out.println("Error saving tasks.xml: " + e.getMessage());
    }

    // ---------- GREEN TASKS ----------
    GreenTaskList greenTasks = new GreenTaskList();
    greenTasks.add(new GreenTask("Recycle paper", 10));
    greenTasks.add(new GreenTask("Bike to school", 15));

    try {
      parser.toXmlFile(greenTasks, "src/model/greenTasks.xml");
    } catch (Exception e) {
      System.out.println("Error saving greenTasks.xml: " + e.getMessage());
    }

    // ---------- TRADE OFFERS ----------
    TradeOfferList trades = new TradeOfferList();
    trades.add(new TradeOffer("Old iPad", 150, users.getByName("Alice")));
    trades.add(new TradeOffer("Headphones", 40, users.getByName("Charlie")));

    try {
      parser.toXmlFile(trades, "src/model/trades.xml");
    } catch (Exception e) {
      System.out.println("Error saving trades.xml: " + e.getMessage());
    }

    System.out.println("Initial XML data created successfully!");
  }
}
