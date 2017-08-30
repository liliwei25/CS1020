/**
*	Name		: Li Liwei
*	Matric No.	: A0155991R
*/

import java.util.*;

public class Passing 
{
	public static void main(String[] args) 
	{
		Scanner scn = new Scanner(System.in);
		LinkedList<Player> listOfPlayers = new LinkedList<Player>();

		int players = scn.nextInt();
		int turns = scn.nextInt();
		int limit = scn.nextInt();

		for(int i = 0; i < players; i ++)
			listOfPlayers.add(new Player(scn.next()));
	
		int input = 0;
		ListIterator <Player>li = listOfPlayers.listIterator();
		Player curr = li.next();
		int head;
		for(int n = 0; n < turns; n++)
		{
			head = li.previousIndex();
			input = scn.nextInt();
			for(int i = 0; i < input; i++)
			{
				if(!li.hasNext()) li = listOfPlayers.listIterator();
				curr = li.next();
			}
			System.out.println(curr.getName());
			curr.incCount();
			if(curr.getCount() >= limit) 
			{
				li.remove();
				if(!li.hasNext()) li = listOfPlayers.listIterator();
				curr = li.next();
			}
			else
			{
				Player temp = curr;
				li.set(listOfPlayers.get(head));
				listOfPlayers.set(head, temp);
				li = listOfPlayers.listIterator(head);
				curr = li.next();
			}
		}
	}
}

class Player{
	private String _name;
	private int _count = 0;

	public Player(String name)
	{
		_name = name;
	}
	public String getName(){return _name;}
	public int getCount(){return _count;}
	public void incCount(){_count++;}
}
	
