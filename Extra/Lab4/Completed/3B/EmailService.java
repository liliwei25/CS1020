
/* Class representing Email service scheduling */
import java.util.*;

public class EmailService 
{
    private Stack<Email> inbox;
    private Stack<Email> tempInbox;
    private Stack<Email> group;
    private void run()
    {
      Scanner scn = new Scanner(System.in);
      tempInbox = new Stack<Email>();
      group = new Stack<Email>();
      
      int numOfOperations = scn.nextInt();
      
      String input = "";
      
      for(int i = 0; i < numOfOperations; i++)
      {
        input = scn.next();
        if(input.equals("receive"))
        {
          Email temp = new Email(scn.next(), scn.next(), scn.next());
          if(inbox.empty())
            inbox.push(temp);
          else
          {
            mark(temp);
            inbox.push(temp);
          }
        }
        else if(input.equals("mark"))
        {
          Email temp = new Email(scn.next(), scn.next(), ""); 
          mark(temp);
        }
        else if(input.equals("read"))
          read(scn.nextInt());
        printInbox();
      }
    }
    private void mark(Email temp)
    {
      while(!inbox.empty())
      {
        if(inbox.peek().isSameThread(temp))
          group.push(inbox.pop());
        else
          tempInbox.push(inbox.pop());
      }
      while(!tempInbox.empty())
      {
        inbox.push(tempInbox.pop());
      }
      while(!group.empty())
      {
        inbox.push(group.pop());
      }
    }
    private void read(int count)
    {
      for(int n = 0; n < count; n++)
      {
        if(inbox.empty()) break;
        inbox.pop();
      }
    }
    private void printInbox()
    {
      if(inbox.empty()) System.out.println("Inbox empty!");
      else
      {
        while(!inbox.empty())
        {
          Email temp = inbox.pop();
          System.out.println(temp);
          tempInbox.push(temp);
        }
        while(!tempInbox.empty())
        {
          inbox.push(tempInbox.pop());
        }
      }
      System.out.println();
    }
    private EmailService()
    {
      inbox = new Stack<Email>();
    }
    public static void main(String[] args)
    {
      EmailService newThis = new EmailService();
      newThis.run();
    }
}
/* Class representing an Email */
class Email {
    String sender;
    String subject;
    String content;

    public Email(String sender, String subject, String content) {
        this.sender = sender;
        this.subject = subject;
        this.content = content;
    }
    public String getSender() {return sender;}
    public String getSubject() {return subject;}
    public String getContent() {return content;}
    public boolean isSameThread(Email mail1) {
        return (this.sender.equals(mail1.sender) && this.subject.equals(mail1.subject));
    }
    public String toString() {return new String(sender + "," + subject + "," + content);}
}
