import java.util.*;

public class Packing 
{
  public static void main(String[] args) 
  {
    Scanner scn = new Scanner(System.in);
    ArrayList<Item> items = new ArrayList<Item>();
    
    //read in the data
    int size = scn.nextInt();
    
    while (scn.hasNext()) 
    {
      items.add(new Item(scn.nextInt(), scn.nextInt()));
    }
       
    int[] result = select(items, new ArrayList<Item>(), size, 0);
    System.out.println(result[1] + " " + result[0]);
    scn.close();
  }
  
  private static int[] select(ArrayList<Item> items, ArrayList<Item> selected, int maxSize, int index)
  {
    int[] result = sumItems(selected);
    if(result[1] == maxSize) return result;
    if(result[1] > maxSize) return null;
    if(index >= items.size()) return result;
    else
    {
      int[] result1 = select(items, selected, maxSize, index + 1);
      ArrayList<Item> temp = new ArrayList<Item>(selected);
      temp.add(items.get(index));
      int[] result2 = select(items, temp, maxSize, index + 1);
      
      if(result1 == null) return result2;
      if(result2 == null) return result1;
      if(result1[0] > result2[0]) return result1;
      else if(result2[0] > result1[0]) return result2;
      else if(result1[1] > result2[1]) return result2;
      else return result1;
    }
  }
  private static int[] sumItems(ArrayList<Item> items)
  {
    int[] result = new int[2];
    for(int i = 0; i < items.size(); i++)
    {
      result[0] += items.get(i).getValue();
      result[1] += items.get(i).getSize();
    }
    return result;
  }
  //this method makes a copy of an existing Arraylist
  public static ArrayList<Item> copy(ArrayList<Item> arrlist) {
    return new ArrayList<Item>(arrlist);
    
  }
  
  //add other methods if you need
  
}

class Item{
  private int value;
  private int size;
  
  public Item(int size,int value) {
    this.value=value;
    this.size=size;
  }
  public int getValue(){return value;}
  public int getSize(){return size;}
}
