package model;

import parser.XmlJsonParser;

public class ModelManager {

  private String usersFile;
  private String tasksFile;
  private String greenTasksFile;
  private String tradesFile;

  private XmlJsonParser parser;

  public ModelManager(String usersFile, String tasksFile,
      String greenTasksFile, String tradesFile) {

    this.usersFile = usersFile;
    this.tasksFile = tasksFile;
    this.greenTasksFile = greenTasksFile;
    this.tradesFile = tradesFile;
    this.parser = new XmlJsonParser();
  }

  // USERS
  public UserList getAllUsers() {
    try {
      return parser.fromXmlFile(usersFile, UserList.class);
    } catch (Exception e) {
      System.out.println("Error reading users XML: " + e.getMessage());
      return new UserList();
    }
  }

  public void saveUsers(UserList users) {
    try {
      parser.toXmlFile(users, usersFile);
    } catch (Exception e) {
      System.out.println("Error saving users XML");
    }
  }

  public void addUser(User user) {
    UserList list = getAllUsers();
    list.add(user);
    saveUsers(list);
  }

  public boolean removeUser(String name) {
    UserList list = getAllUsers();
    User found = list.getByName(name);
    if (found != null) {
      list.remove(found);
      saveUsers(list);
      return true;
    }
    return false;
  }

  // TASKS
  public TaskList getAllTasks() {
    try {
      return parser.fromXmlFile(tasksFile, TaskList.class);
    } catch (Exception e) {
      System.out.println("Error reading tasks XML: " + e.getMessage());
      return new TaskList();
    }
  }

  public void saveTasks(TaskList tasks) {
    try {
      parser.toXmlFile(tasks, tasksFile);
    } catch (Exception e) {
      System.out.println("Error saving tasks XML");
    }
  }

  public void addTask(Task task) {
    TaskList list = getAllTasks();
    list.add(task);
    saveTasks(list);
  }

  public boolean removeTask(String description) {
    TaskList list = getAllTasks();
    Task found = list.get(description);
    if (found != null) {
      list.remove(found);
      saveTasks(list);
      return true;
    }
    return false;
  }

  // GREEN TASKS
  public GreenTaskList getAllGreenTasks() {
    try {
      return parser.fromXmlFile(greenTasksFile, GreenTaskList.class);
    } catch (Exception e) {
      System.out.println("Error reading green tasks XML: " + e.getMessage());
      return new GreenTaskList();
    }
  }

  public void saveGreenTasks(GreenTaskList tasks) {
    try {
      parser.toXmlFile(tasks, greenTasksFile);
    } catch (Exception e) {
      System.out.println("Error saving green tasks XML");
    }
  }

  public void addGreenTask(GreenTask task) {
    GreenTaskList list = getAllGreenTasks();
    list.add(task);
    saveGreenTasks(list);
  }

  public boolean removeGreenTask(String description) {
    GreenTaskList list = getAllGreenTasks();
    GreenTask found = list.get(description);
    if (found != null) {
      list.remove(found);
      saveGreenTasks(list);
      return true;
    }
    return false;
  }

  // TRADE OFFERS
  public TradeOfferList getAllTradeOffers() {
    try {
      return parser.fromXmlFile(tradesFile, TradeOfferList.class);
    } catch (Exception e) {
      System.out.println("Error reading trades XML: " + e.getMessage());
      return new TradeOfferList();
    }
  }

  public void saveTradeOffers(TradeOfferList list) {
    try {
      parser.toXmlFile(list, tradesFile);
    } catch (Exception e) {
      System.out.println("Error saving trades XML");
    }
  }

  public void addTradeOffer(TradeOffer offer) {
    TradeOfferList list = getAllTradeOffers();
    list.add(offer);
    saveTradeOffers(list);
  }

  public boolean removeTradeOffer(String description) {
    TradeOfferList list = getAllTradeOffers();
    TradeOffer found = list.get(description);
    if (found != null) {
      list.remove(found);
      saveTradeOffers(list);
      return true;
    }
    return false;
  }
}
