/**
 * Name         : Li Liwei
 * Matric No    : A0155991R
 * Plab Acct.   : --
 *
 */

import java.util.*;

public class Cards 
{
    public void run() 
	{
        // implement your "main" method here
    	Scanner scn = new Scanner(System.in);
		
		int numOfCards = scn.nextInt();
		
		TailedLinkedList<Card> cardList = new TailedLinkedList<Card>();

		for(int i = 0; i < numOfCards; i++)
			cardList.addLast(new Card(scn.next(), scn.nextInt()));

		int numOfQ = scn.nextInt();
		
		String input;
		int index = 0;
		for(int i = 0; i < numOfQ; i++)
		{
			input = scn.next();
			switch(input)
			{
				case "swap":
					swapCards(cardList, scn.nextInt(), scn.nextInt(), scn.nextInt(), scn.nextInt());
					System.out.println("swap has been performed");
				break;
				case "details":
					index = scn.nextInt();
					System.out.println(cardList.get(index-1).getName() + " " +cardList.get(index-1).getAge());
				break;
				case "position":
					findName(cardList, scn.next());
				break;
				case "shuffle":
					index = numOfCards/2;
					cardList = shuffle(cardList, numOfCards-index, index);
				break;
				case "print":
					for(int n = 0; n < numOfCards; n++)
					{
						System.out.printf("%s", cardList.get(n).getName());
						if(n < numOfCards-1) System.out.printf(" ");
						else System.out.printf("\n");
					}
				break;
			}
		}
	}
	public static TailedLinkedList<Card> shuffle(TailedLinkedList<Card> cardList, int num1, int num2)
	{
		TailedLinkedList<Card> temp1 = new TailedLinkedList<Card>();
		TailedLinkedList<Card> temp2 = new TailedLinkedList<Card>();
		
		for(int i = 0; i < num1; i++)
			temp1.addLast(cardList.get(i));
		for(int i = num1; i < num1 + num2; i++)
			temp2.addLast(cardList.get(i));
		int count = 0;
		for(int i = 0; i < num2+ num1; i+=2)
		{
			temp1.addAfter(i, temp2.get(count++));
		}
		/*int count = 1;
		for(int i = num1; i < num2 + num1; i++)
		{
			for(int n = count; n < num1; n++)
			{
				swapCards(cardList, n+1, n+1, i+1, i+1);
			}
			count++;
		}
		swapCards(cardList, num1+count, num1+count, num1+num2, num1+num2);
		*/
		System.out.println("shuffle has been performed");
		return temp1;
	}
	public static void findName(TailedLinkedList<Card> cardList, String input)
	{
		for(int i = 0; i < cardList.size(); i++)
		{
			if(input.equals(cardList.get(i).getName()))
			{
				System.out.println(i+1);
				break;
			}
		}
	}
	public static void swapCards(TailedLinkedList<Card> cardList,int start1,int stop1,int start2,int stop2)
	{
		ListNode<Card> tempStart1 = cardList.getElement(start1-1);
		ListNode<Card> tempStart2 = cardList.getElement(start2-1);
		ListNode<Card> tempStop1 = cardList.getElement(stop1-1);
		ListNode<Card> tempStop2 = cardList.getElement(stop2-1);
		ListNode<Card> start1Bef = cardList.getElement(start1-2);
		ListNode<Card> start2Bef = cardList.getElement(start2-2);
		ListNode<Card> stop1Aft = cardList.getElement(stop1);
		ListNode<Card> stop2Aft = cardList.getElement(stop2);
		
		if(stop1 == start2 -1)
		{
			if(start1 == 1)
				cardList.setHead(tempStart2);
			else start1Bef.setNext(tempStart2);
			tempStop2.setNext(tempStart1);
			tempStop1.setNext(stop2Aft);
		}
		else
		{
			if(start1 == 1)
				cardList.setHead(tempStart2);
			else
				start1Bef.setNext(tempStart2);
			tempStop2.setNext(stop1Aft);
			start2Bef.setNext(tempStart1);
			tempStop1.setNext(stop2Aft);
		}
	}
    public static void main(String[] args) {
        Cards myCards = new Cards();
        myCards.run();
    }
}
class Card
{
	private String name;
	private int age;

	public Card(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	public String getName(){return name;}
	public int getAge(){return age;}
}
class TailedLinkedList<E> {
    // Data attributes
    private ListNode<E> head;
    private ListNode<E> tail;
    private int num_nodes;

    public TailedLinkedList() {
        this.head = null;
        this.tail = null;
        this.num_nodes = 0;
    }
	public E get(int item)
	{
		ListNode<E> current = head;
		for(int i = 0; i < num_nodes; i++)
		{
			if(i == item) return current.getElement();
			current = current.getNext();
		}
		return null;
	}
	public ListNode<E> getElement(int index)
	{
		ListNode<E> current = head;
		for(int i = 0; i < num_nodes; i++)
		{
			if(i == index) return current;
			current = current.getNext();
		}
		return null;
	}

    // Return true if list is empty; otherwise return false.
    public boolean isEmpty() {
        return (num_nodes == 0);
    }

    // Return number of nodes in list.
    public int size() {
        return num_nodes;
    }

     // Return value in the first node.
    public E getFirst() throws NoSuchElementException {
        if (head == null)
            throw new NoSuchElementException("can't get from an empty list");
        else
            return head.getElement();
    }

    // Return true if list contains item, otherwise return false.
    public boolean contains(E item) {
        for (ListNode<E> n = head; n != null; n = n.getNext())
            if (n.getElement().equals(item))
                return true;

        return false;
    }
    // Add item to front of list.
    public void addFirst(E item) {
        head = new ListNode<E>(item, head);
        num_nodes++;
        if (num_nodes == 1) tail = head;
    }
	public void addAfter(int index, E item)
	{
		ListNode<E> temp = head;

		for(int i = 0; i < num_nodes; i++)
		{
			if(i == index)
				temp.next = new ListNode<E>(item, temp.next);
			temp = temp.next;
		}
		num_nodes++;
	}

    // Return reference to first node.
    public ListNode<E> getHead() {
        return head;
    }
	public void setHead(ListNode<E> head)
	{
		this.head = head;
	}
    // Return reference to last node of list.
    public ListNode<E> getTail() {
        return tail;
    }

    // Add item to end of list.
    public void addLast(E item) {
        if (head != null) {
            tail.setNext(new ListNode<E>(item));
            tail = tail.getNext();
        } else {
            tail = new ListNode<E>(item);
            head = tail;
        }
        num_nodes++;
    }

    // Remove node after node referenced by current
    public E removeAfter(ListNode<E> current) throws NoSuchElementException {
        E temp;
        if (current != null) {
            ListNode<E> nextPtr = current.getNext();
            if (nextPtr != null) {
                temp = nextPtr.getElement();
                current.setNext(nextPtr.getNext());
                num_nodes--;
                if (nextPtr.getNext() == null) // last node is removed
                    tail = current;
                return temp;
            } else
                throw new NoSuchElementException("No next node to remove");
        } else { // if current is null, we want to remove head
            if (head != null) {
                temp = head.getElement();
                head = head.getNext();
                num_nodes--;
                if (head == null)
                    tail = null;
                return temp;
            } else
                throw new NoSuchElementException("No next node to remove");
        }
    }

    // Remove first node of list.
    public E removeFirst() throws NoSuchElementException {
        return removeAfter(null);
    }

    // Remove item from list
    public E remove(E item) throws NoSuchElementException {
        ListNode<E> current = head;
        if (current == null) {
            throw new NoSuchElementException("No node to remove");
        }
        if (current.getElement().equals(item)) {
            return removeAfter(null);
        }
        while (current.getNext().getElement() != null) {
            if (current.getNext().getElement().equals(item)) {
                return removeAfter(current);
            }
            current = current.getNext();
        }
        throw new NoSuchElementException("No node to remove");
    }
}

class ListNode<E> {
    protected E element;
    protected ListNode<E> next;

    /* constructors */
    public ListNode(E item) {
        this.element = item;
        this.next = null;
    }

    public ListNode(E item, ListNode<E> n) {
        element = item;
        next = n;
    }

    /* get the next ListNode */
    public ListNode<E> getNext() {
        return this.next;
    }

    /* get the element of the ListNode */
    public E getElement() {
        return this.element;
    }

    public void setNext(ListNode<E> item) {
        this.next = item;
    }

    public void setElement(E item) {
        this.element = item;
    }
}


