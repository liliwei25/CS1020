import java.util.*;

/* Client class to simulate the messaging application */
public class MessageApp 
{
  private static Queue<User> listOfUsers;
  private static int users;
  
  public static void main(String[] args) 
  {
    Scanner scn = new Scanner(System.in);
    
    listOfUsers = new LinkedList<User>();
    
    users = scn.nextInt();
    for(int i = 0; i < users; i++)
    {
      listOfUsers.offer(new User(scn.next()));
    }
    int numOfQueries = scn.nextInt();
    for(int i = 0; i < numOfQueries; i++)
    {
      String input = scn.next();
      if(input.equals("message"))
      {
        message(scn.next(), scn.next(), scn.nextInt());
      }
      else if(input.equals("reply"))
      {
        reply(scn.next(), scn.next(), scn.nextInt(), scn.nextInt());
      }
      printUsers();
    }
  }
  private static void reply(String sender, String receiver, int reply, int text)
  {
    System.out.println("reply " + sender + " " + receiver + " " +reply + " " + text);
    for(int i = 0; i < users; i++)
    {
      if(sender.equals(listOfUsers.peek().getName()) || receiver.equals(listOfUsers.peek().getName()))
      {
        listOfUsers.peek().removeMessage(text);
        listOfUsers.peek().addMessage(text);
        listOfUsers.peek().addMessage(reply);
      }
      listOfUsers.offer(listOfUsers.poll());
    }
  }
  private static void printUsers()
  {
    Queue<User> temp = new LinkedList<User>();
    for(int i = 0; i < users; i++)
    {
      System.out.println(listOfUsers.peek().toString());
      temp.offer(listOfUsers.poll());
    }
    listOfUsers = temp;
    System.out.println();
  }
  private static void message(String sender, String receiver, int text)
  {
    System.out.println("message " + sender + " " + receiver + " " +text);
    for(int i = 0; i < users; i++)
    {
      if(sender.equals(listOfUsers.peek().getName()))
      {
        listOfUsers.peek().addMessage(text);
      }
      if(receiver.equals(listOfUsers.peek().getName()))
      {
        listOfUsers.peek().addMessage(text);
      }
      listOfUsers.offer(listOfUsers.poll());
    }
  }
}

/* Service class representing a user */
class User 
{
  private String _name;
  private Queue<Integer> _messages;
  private int numOfMessages;
  
  public User(String name)
  {
    _name = name;
    _messages = new LinkedList<Integer>();
    numOfMessages = 0;
  }
  public String getName(){return _name;}
  public Queue<Integer> getMessages(){return _messages;}
  public void addMessage(int message)
  {
    if(numOfMessages == 10)
    {
      _messages.poll();
      numOfMessages--;
    }
    _messages.offer(message);
    numOfMessages++;
  }
  public void removeMessage(int message)
  {
    Queue<Integer> temp = new LinkedList<Integer>();
    boolean flag = false;
    while(_messages.peek()!= null)
    {
      if(flag == false && _messages.peek() == message)
      {  
        numOfMessages--;
        _messages.poll();
        flag = true;
      }
      temp.offer(_messages.poll());
    }
    _messages = temp;
  }
  public String toString()
  {
    if(_messages.peek() == null)
      return (_name + " @");
    else
    {
      String output = "";
      Queue<Integer> temp = new LinkedList<Integer>();
      int num = _messages.poll();
      output+= num;
      temp.offer(num);
      while(_messages.peek()!= null)
      {
        num = _messages.poll();
        output+= "," + num;
        temp.offer(num);
      }
      _messages = temp;
      return _name + " "  + output;
    }
  }
}
