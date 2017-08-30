/**
 * Name         : Li Liwei
 * Matric No.   : A0155991R
 * Plab Acct.   :
 */
import java.util.*;

public class Storage 
{    
	public void run() 
	{
		// treat this as your "main" method
		Scanner scn = new Scanner(System.in);

		int numOfB = scn.nextInt();
		int maxHold = scn.nextInt();
		int sizeOfB = scn.nextInt();
		int numOfQ = scn.nextInt();

		String input;
		int numI = 0;
		int currentHold = 0;
		Vector<String> evan = new Vector<String>(maxHold);
		int largestPrice = 0;
		String largestName = " ";
		boolean updated = false;

		Item[] allItems = new Item[numOfQ];
		Box[] allBoxes = new Box[numOfB];
		for(int i = 0; i < numOfB; i++)
			allBoxes[i] = new Box(sizeOfB);
		for(int i = 0; i < numOfQ; i++)
		{
			input = scn.next();
			switch(input)
			{
				case "valuable":
					if(numI == 0) System.out.println("No items");
					else
					{
						for(int n = 0; n < numI; n++)
						{
							if(allItems[n].getPrice() > largestPrice)
							{
								largestPrice = allItems[n].getPrice();
								largestName = allItems[n].getName();
							}
							else if(allItems[n].getPrice() == largestPrice)
							{
								if(largestName.compareTo(allItems[n].getName()) > 0)
								{
									largestPrice = allItems[n].getPrice();
									largestName = allItems[n].getName();
								}
							}
						}
						System.out.println(largestName);
					}
				break;
				case "purchase": 
					allItems[numI] = new Item(scn.next(), scn.nextInt());
					if(currentHold < maxHold)
					{
						evan.add(currentHold++, allItems[numI].getName());
						System.out.println("item " + allItems[numI++].getName() + " is now being held");
					}
					else
						updated = storeInBoxs(allItems[numI++], allBoxes, numOfB);
				break;
				case "deposit":
					input = scn.next();
					updated = false;
					if(numI == 0) System.out.println("item " + input + " does not exist");
					for(int n = 0; n < numI; n++)
					{
						if(input.equals(allItems[n].getName()))
						{
							updated = storeInBoxs(allItems[n], allBoxes, numOfB);
							break;
						}
						if(n == numI-1)
						{
							System.out.println("item " + input + " does not exist");
						}
					}
					if(updated)
					{
						evan.remove(input);
						currentHold--;
					}
				break;
				case "location":
					input = scn.next();
					if(numI == 0) System.out.println("item " + input + " does not exist");
					for(int j = 0; j < numI; j++)
					{
						if(input.equals(allItems[j].getName()))
						{
							for(int n = 0; n < currentHold; n++)
							{
								if(evan.elementAt(n).equals(input)) System.out.println("item " + input +" is being held");
							}
							for(int n =0; n < numOfB; n++)
							{
								if(allBoxes[n].checkItem(allItems[j])) System.out.println("item " + input +" is in box " + (n+1));
							}
							break;
						}
						else if(j == numI-1) System.out.println("item " + input + " does not exist");
					}
				break;
				case "withdraw":
					input = scn.next();
					updated = false;
                    if(evan.contains(input))
					{
						updated = true;
                        System.out.println("item " + input + " is already being held");
					}
					else
					{
						for(int n = 0; n < numI; n++)
						{
							if(input.equals(allItems[n].getName()))
							{
								for(int j = 0; j < numOfB; j++)
								{
									if(allBoxes[j].checkItem(allItems[n]))       
									{
										if(currentHold >= maxHold) break;
										allBoxes[j].removeItem(allItems[n]);
										evan.add(currentHold++, input);
										System.out.println("item " + input + " has been withdrawn");
										updated = true;
										break;
									}
								}
								break;
							}
							if(n == numI-1)
							{
								System.out.println("item " + input + " does not exist");
								updated = true;
							}
						}
					}
					if(!updated) System.out.println("cannot hold any more items");
				break;
			}
		}
	}

	public static boolean storeInBoxs(Item a, Box[] boxs, int num)
	{
		for(int i = 0; i < num; i++)
		{
			if(boxs[i].checkItem(a))
			{
				System.out.println("item " + a.getName() + " is already in storage");
				return false;
			}
		}
		for(int	i = 0; i < num; i++)
		{
			if(boxs[i].checkSpace())
			{
				boxs[i].addItem(a);
				System.out.println("item " + a.getName() + " has been deposited to box " + (i+1));
				return true;
			}
		}
		System.out.println("storage full");
		return false;
	}

	public static void main(String[] args) {
		Storage myStorageSystem = new Storage();
		myStorageSystem.run();
	}
}

class Box 
{
	// define appropriate attributes, constructor, and methods
	private int size;
	private Vector<Item> listOfItems;

	public Box(int size)
	{
		this.size = size;
		listOfItems = new Vector<Item>();
	}
	public void addItem(Item a)
	{
		listOfItems.add(a);
	}
	public void removeItem(Item a)
	{
		listOfItems.remove(a);
	}
	public boolean checkItem(Item a)
	{
		return listOfItems.contains(a);
	}
	public boolean checkSpace()
	{
		if(listOfItems.size()< size) return true;
		return false;
	}
}

class Item 
{
	// define appropriate attributes, constructor, and methods
	private String name;
	private int price;

	public Item(String name, int price)
	{
		this.name = name;
		this.price = price;
	}
	public String getName()
	{
		return name;
	}
	public int getPrice()
	{
		return price;
	}
}
