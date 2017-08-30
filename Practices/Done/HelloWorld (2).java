/**
 *
 * author : [Li Liwei]
 * matric no: [A0155991R]
 * 
 */

import java.util.*;

public class HelloWorld {
 
 public static void main(String[] args) {

  // declare the necessary variables
   int mode;

  // declare a Scanner object to read input
   Scanner scn = new Scanner(System.in);

  // read input and process them accordingly
   mode = scn.nextInt();
   
   if(mode == 1) method1();
   else if(mode == 2) method2();
   else method3();
 }
 
 public static void method1()
 {
   Scanner scn = new Scanner(System.in);
   
   int number = scn.nextInt();
   int input1, input2;
   
   int[] result = new int[number];
   
   for(int i = 0; i < number; i++)
   {
     if((scn.next().toString()).compareToIgnoreCase("AND") == 0)
     {
       input1 = scn.nextInt();
       input2 = scn.nextInt();
       if( input1 == 1 && input2 == 1) result[i] = 1;
       else result[i] = 0;
     }
     else
     {
       input1 = scn.nextInt();
       input2 = scn.nextInt();
       if(input1 == 0 && input2 == 0) result[i] = 0;
       else result[i] = 1;
     }
   }
   for(int i = 0; i < number; i++)
     System.out.println(result[i]);
 }
 public static void method2()
 {
   Scanner scn = new Scanner(System.in);
   
   int[] result = new int[100];
   int input1, input2, i = 0;
   
   while(!scn.hasNextInt())
   {
     if((scn.next().toString()).compareToIgnoreCase("AND") == 0)
     {
       input1 = scn.nextInt();
       input2 = scn.nextInt();
       if( input1 == 1 && input2 == 1) result[i++] = 1;
       else result[i++] = 0;
     }
     else
     {
       input1 = scn.nextInt();
       input2 = scn.nextInt();
       if(input1 == 0 && input2 == 0) result[i++] = 0;
       else result[i++] = 1;
     }
   }
   for(int n = 0; n < i; n++)
     System.out.println(result[n]);
 }
 public static void method3()
 {
   Scanner scn = new Scanner(System.in);
   
   int[] result = new int[100];
   int input1, input2, i = 0;
   
   while(scn.hasNextLine())
   {
     if((scn.next().toString()).compareToIgnoreCase("AND") == 0)
     {
       input1 = scn.nextInt();
       input2 = scn.nextInt();
       if( input1 == 1 && input2 == 1) result[i++] = 1;
       else result[i++] = 0;
     }
     else
     {
       input1 = scn.nextInt();
       input2 = scn.nextInt();
       if(input1 == 0 && input2 == 0) result[i++] = 0;
       else result[i++] = 1;
     }
   }
   for(int n = 0; n < i; n++)
     System.out.println(result[n]);
 }
}
