// This program computes the furthest distance (number of road units)
// a jogger can run from PGP and back. Road is divided into units,
// each unit is uphill, flat or downhill with an associated time.
import java.util.*;

public class Jogging {
 public static final int UP = 0;
 public static final int FLAT = 1;
 public static final int DOWN = 2;

 public static void main(String[] args) {

  // Read input data
  Scanner sc = new Scanner(System.in);
  int timeLimit = sc.nextInt();
  int roadUnits = sc.nextInt();
  int[] ufdTimes = new int[3]; // store times for uphill, flat, downhill
  ufdTimes[UP] = sc.nextInt();
  ufdTimes[FLAT] = sc.nextInt();
  ufdTimes[DOWN] = sc.nextInt();

  String roadData = sc.next();
  
  int[] time = new int[roadData.length()];
  for(int i = 0; i < roadData.length(); i++)
  {
    if(roadData.charAt(i) == 'u' || roadData.charAt(i) == 'd')
      time[i] = ufdTimes[UP] + ufdTimes[DOWN];
    else
      time[i] = 2*ufdTimes[FLAT];
  }
  System.out.println(calculateMaxDistance(timeLimit, time, 0, 0));
 }
 // Recursion to compute the number of road units he can run and
 // get back to PGP on time.
 public static int calculateMaxDistance(int timeLimit, int[] time, int currTime, int currDist)
 {
   if(currTime > timeLimit) return currDist - 1;
   if(currDist == time.length) return currDist;
   else
   {
     return calculateMaxDistance(timeLimit, time, currTime + time[currDist], currDist + 1);
   }
 }
}

