import java.util.*;

public class Forum 
{
	private static HashMap<String,User> listOfUsers = new HashMap<String, User>();
	private static HashMap<String, Thread> mapOfThreads = new HashMap<String, Thread>();
	public static void main(String[] args) 
	{
        //define your main method here
		Scanner scn = new Scanner(System.in);

		int numOfU = scn.nextInt();
		String input;
		for(int i = 0; i < numOfU; i++)
		{
			input = scn.next();
			listOfUsers.put(input, new User(input));	
		}

		int numOfT = scn.nextInt();
		String name, thread, message;
		for(int i = 0; i < numOfT; i++)
		{
			input = scn.next();
			mapOfThreads.put(input, new Thread(input));
		}
		
		int numOfQ = scn.nextInt();
		for(int i = 0; i < numOfQ; i++)
		{
			input = scn.next();
			switch(input)
			{
				case "post": 
					thread = scn.next();
					name = scn.next();
					message = scn.nextLine().trim();
					newPost(thread, name, message);
					break;
				case "count":
					int count = scn.nextInt();
					int counter = 0;
					for(int n = 0; n < count; n++)
					{
						thread = scn.next();
						counter+= mapOfThreads.get(thread).getNum();
					}
					System.out.println(counter);
					break;
				case "numpost":
					name = scn.next();
					if(listOfUsers.get(name) != null)
						System.out.println(listOfUsers.get(name).getNum());
					else 
						System.out.println("no such user");
					break;
				case "maxpost":
					thread = scn.next();
					if(mapOfThreads.get(thread)!=null)
						System.out.println(mapOfThreads.get(thread).userPosts(listOfUsers.keySet().toArray()));
					else
						System.out.println("no such thread");
					break;
				case "content":
					thread = scn.next();
					int num = scn.nextInt();
					if(mapOfThreads.get(thread)!= null)
					{
						if(num > mapOfThreads.get(thread).getNum())
							System.out.println("no such post");
						else if(mapOfThreads.get(thread).containPost(num))
							System.out.println(mapOfThreads.get(thread).getMessage(num));
						else
							System.out.println("no such post");
					}
					else
						System.out.println("no such thread");
					break;
			}
		}	
	}
	public static void newPost(String thread, String name, String message)
	{
		if(mapOfThreads.get(thread)!= null)
		{
			if(listOfUsers.get(name)!= null)
			{
				mapOfThreads.get(thread).addPost(new Post(listOfUsers.get(name), message, thread));
				listOfUsers.get(name).addPost();
				System.out.println(message);
			}
			else
				System.out.println("no such user");
		}
		else
			System.out.println("no such thread");
	}
}

class Thread 
{
    //define the appropriate attributes, constructor, and methods here
	private String name;
	private ArrayList<Post> listOfPosts= new ArrayList<Post>();
	
	public Thread(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	public void addPost(Post post)
	{
		listOfPosts.add(post);
	}
	public String getMessage(int num)
	{
		return listOfPosts.get(num-1).getMessage();
	}
	public boolean containPost(int num)
	{
		if(listOfPosts.get(num-1)!= null) return true;
		else return false;
	}
	public String userPosts(Object[] listOfUsers)
	{	
		int count = 0;
		int max = -1;
		String maxName = " ";

		for(int i = 0; i < listOfUsers.length; i++)
		{
			for(int n = 0; n < listOfPosts.size(); n++)
				if(listOfUsers[i].toString().equals(listOfPosts.get(n).getUser()))
					count++;
			if(count > max)
			{
				max = count;
				maxName = listOfUsers[i].toString();
			}
			if(count == max)
			{
				if(maxName.compareTo(listOfUsers[i].toString()) > 0)
					maxName = listOfUsers[i].toString();
			}
			count = 0;
		}
		return maxName;
	}
	public int getNum()
	{
		return listOfPosts.size();
	}
}

class Post 
{
    //define the appropriate attributes, constructor, and methods here
	private User name;
	private String message;
	private String thread;

	public Post(User name, String message, String thread)
	{
		this.name = name;
		this.message = message;
		this.thread = thread;
	}
	public String getMessage()
	{
		return message;
	}
	public String getUser()
	{
		return name.getName();
	}
	public String getThread()
	{
		return thread;
	}
}

class User 
{
    //define the appropriate attributes, constructor, and methods here
	private String name;
	private int numOfPost = 0;

	public User(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	public int getNum()
	{
		return numOfPost;
	}
	public void addPost()
	{
		numOfPost++;
	}
}
