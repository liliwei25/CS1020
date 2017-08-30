import java.util.*;

public class Subway {
  private LinkedList<String> stationMap;
 public Subway() {
  //constructor
   stationMap = new LinkedList<String>();
 }

 public void run() {
   Scanner scn = new Scanner(System.in);
   
   int numOfS = scn.nextInt();
   for(int i = 0; i < numOfS; i ++)
     stationMap.add(scn.next());
   
   int numOfQ = scn.nextInt();
   String input;
   for(int i = 0; i < numOfQ; i++)
   {
     input = scn.next();
     /*switch(input)
     {
       case "TIME":
         findTime(scn.next(), scn.next());
       break;
       case "BUILD":
         buildStation(scn.next(), scn.next());
       break;
       case "PATH":
         findPath(scn.next(), scn.next());
       break;
       case "PRINT":
         printStations(scn.next());
       break;
     }*/
     if(input.equals("TIME"))
       findTime(scn.next(), scn.next());
     else if(input.equals("BUILD"))
       buildStation(scn.next(), scn.next());
     else if(input.equals("PATH"))
       findPath(scn.next(), scn.next());
     else if(input.equals("PRINT"))
       printStations(scn.next());
   }
 }
 private void findTime(String startS, String endS)
 {
   int time = 0;
   int start = stationMap.indexOf(startS);
   int end = stationMap.indexOf(endS);
   if(start == end) time = 0;
   else if(start > end)
   {
     if((start - end) <= (stationMap.size()/2))
       time = (start - end -1)*3 + 2;
     else
       time = (stationMap.size()-start + end - 1)*3 + 2;
   }
   else
   {
     if((end - start) <= (stationMap.size()/2))
       time = (end - start- 1)*3 + 2;
     else
       time = (stationMap.size() - end + start - 1)*3 + 2;
   }
   System.out.println(time);
 }
 private void buildStation(String start, String newStation)
 {
   stationMap.add(stationMap.indexOf(start) + 1, newStation);
   System.out.println("station " + newStation + " has been built");
 }
 private void findPath(String start, String end)
 {
   int startIndex = stationMap.indexOf(start);
   int endIndex = stationMap.indexOf(end);
   
   if(startIndex > endIndex)
   {
     if((startIndex - endIndex) < (stationMap.size()/2))
     {
       ListIterator<String> ls = stationMap.listIterator(startIndex+1);
       for(int i = 0; i < (startIndex - endIndex +1); i++)
       {
         if(!ls.hasPrevious())
           ls = stationMap.listIterator(stationMap.size()-1);
         System.out.print(ls.previous());
         if(i != (startIndex - endIndex))
           System.out.print(" ");
         else System.out.println();
       }
     }
     else
     {
       ListIterator<String> ls = stationMap.listIterator(startIndex);
       for(int i = 0; i <stationMap.size()-(startIndex - endIndex)+1; i++)
       {
         if(!ls.hasNext())
           ls = stationMap.listIterator();
         System.out.print(ls.next());
         if(i != stationMap.size()-(startIndex - endIndex))
           System.out.print(" ");
         else System.out.println();
       }
     }
   }
   else
   {
     if((endIndex - startIndex) <= (stationMap.size()/2))
     {
       ListIterator<String> ls = stationMap.listIterator(startIndex);
       for(int i = 0; i <(endIndex - startIndex +1); i++)
       {
         if(!ls.hasNext())
           ls = stationMap.listIterator();
         System.out.print(ls.next());
         if(i != (endIndex - startIndex))
           System.out.print(" ");
         else System.out.println();
       }
     }
     else
     {
       ListIterator<String> ls = stationMap.listIterator(startIndex+1);
       for(int i = 0; i <stationMap.size()-(endIndex - startIndex)+1; i++)
       {
         if(!ls.hasPrevious())
           ls = stationMap.listIterator(stationMap.size());
         System.out.print(ls.previous());
         if(i != stationMap.size()-(endIndex - startIndex))
           System.out.print(" ");
         else System.out.println();
       }
     }
   }
 }
 private void printStations(String start)
 {
   ListIterator<String> ls = stationMap.listIterator(stationMap.indexOf(start));
   for(int i = 0; i < stationMap.size(); i++)
   {
     if(!ls.hasNext())
       ls = stationMap.listIterator();
     System.out.print(ls.next());
     if(i != stationMap.size() -1)
       System.out.print(" ");
     else System.out.println();
   }
 }
 public static void main(String[] args) {
  Subway newSubwayNetwork = new Subway();
  newSubwayNetwork.run();
 }
}