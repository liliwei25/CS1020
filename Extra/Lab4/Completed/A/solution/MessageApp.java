import java.util.*;

/* Service class representing a user */
class User {

    private LinkedList<Integer> messageList;
    private String name;

    public User(String aName) {
        name = aName;
        messageList = new LinkedList<Integer>();        
    }

    public String getName() {return name;}

    public int getNumMessages() { return messageList.size(); }

    /*
	pre: msg is a new message and must not already exist
	post: msg is added to tail of messageList
    */
    public void addMessage(int msg) { messageList.addLast(msg); }

    /*
	pre: 
	post: message at the head of messageList is removed if any
    */
    public void removeLeastRecentMessage() { messageList.poll(); }

    /*
	pre: msg must exist in messageList
	post: msg is moved to tail of messageList
    */
    public void makeMessageMostRecent(int msg) {
        int index = messageList.indexOf(msg); // find index of msg

        messageList.remove(index);
        messageList.addLast(msg);
    }

    public String toString() {
        if (messageList.size() == 0) 
            return name+" @";
        else {
            String stringToPrint = name+" "+messageList.get(0).toString();
            
            for (int i=1; i < messageList.size(); i++)
                stringToPrint += ","+messageList.get(i).toString();
            return stringToPrint;
        }
    }
}

/* Client class to simulate the messaging application */
public class MessageApp {

    private static final int MAX_NUM_MESSAGES = 10;
    private LinkedList<User> userList;

    public MessageApp(Scanner sc) {
        int numUsers = Integer.parseInt(sc.nextLine());
        userList = new LinkedList<User>();

        for (int i=0; i < numUsers; i++) {
            String name = sc.nextLine();

            userList.add(new User(name));
        }
    }

    public void simulate(Scanner sc) {
        int numOperations = Integer.parseInt(sc.nextLine());

        for (int i=0; i < numOperations; i++) {
	    String line = new String(sc.nextLine()); // read in line
	    Scanner sc1 = new Scanner(line); // scan line
            String operation = sc1.next();
            String user1 = sc1.next();
            String user2 = sc1.next();
            
            if (operation.equals("message")) { // message       
                int msg = sc1.nextInt();

                message(user1,msg);
                message(user2,msg);
            }
            else { // reply             
                int reply = sc1.nextInt();
                int msg = sc1.nextInt();

		// add reply to message list of user1 & user2 
		// and change order of msg in their message list
                reply(user1,reply,msg); 
                reply(user2,reply,msg);
            }
    	    // print out the operation + messagelist of each user after the
	    // operation is executed
	    System.out.println(line+"\n"+toString());
        }
    }

    /*
	pre: user with userName must exist in userList, msg must not already exist
	post: msg is added as most recent message in userName's message
	      list which is maintained at <= 10 messages by removing
	      least recent message if neccessary
    */
    public void message(String userName, int msg) {                
        User user = findUser(userName);

        if (user.getNumMessages() >= 10)
            user.removeLeastRecentMessage();
        user.addMessage(msg);
    }
    
    /*
	pre: user with userName must exist. msg must exist. reply must not already exist
	post: msg becomes 2nd most recent msg in userName's message list,
	      while reply is added as the most recent. Message list is
	      maintained at <= 10 messages by removign least recent message
	      if necessary.
    */
    public void reply(String userName, int reply, int msg) {       
        User user = findUser(userName);

        user.makeMessageMostRecent(msg); // make msg most recent message
        message(userName,reply); // add reply which now becomes most recent
    }

    /*
	pre: user with userName must exist
	post: return user with userName in userList
    */
    private User findUser(String userName) {
	// go through userList to find user with UserName
        for (int i=0; i < userList.size(); i++) {
            if (userList.get(i).getName().equals(userName))
                return userList.get(i);
        }
        return null;
    }

    public String toString() {
        String stringToPrint = "";

        for (int i=0; i < userList.size(); i++)
            stringToPrint += userList.get(i)+"\n";

        return stringToPrint;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MessageApp msgApp = new MessageApp(sc);

        msgApp.simulate(sc);
    }
}
