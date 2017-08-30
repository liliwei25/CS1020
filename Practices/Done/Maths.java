/**
 * name   : Li Liwei
 * matric no.: A0155991R
 */

import java.util.*;


class Maths 
{
  Matrix matrix;
  private void run()
  {
    Scanner scn = new Scanner(System.in);
    
    matrix = new Matrix(scn.nextInt(), scn.nextInt(), scn.nextInt(), scn.nextInt());
    int power = scn.nextInt();
    int subtractor = scn.nextInt();
    
    matrix = multiplying(matrix, power);
    matrix.subtract(subtractor);
    System.out.println(matrix);
  }
  private Matrix multiplying(Matrix matrix, int power)
  {
    return multiplying(matrix, matrix, new Matrix(1, 0, 0, 1), power);
  }
  private Matrix multiplying(Matrix original, Matrix current, Matrix sum, int power)
  {
    sum = sum.add(current);
    if(power == 1) return sum;
    else
    {
      //System.out.println(sum);
      return (multiplying(original, current.multiply(original), sum, power -1 ));
    }
  }
 public static void main(String[] args) 
 {
   Maths newThis = new Maths();
   newThis.run();
 }
}
class Matrix 
{
  private long a, b, c, d;
  
  public Matrix(long a, long b, long c, long d)
  {
    this.a = a;
    this.b = b;
    this.c = c;
    this.d = d;
  }
  public long getA(){return a;}
  public long getB(){return b;}
  public long getC(){return c;}
  public long getD(){return d;}
  public Matrix multiply(Matrix multiplier)
  {
    long tempA, tempB, tempC, tempD;
    
    tempA = (this.a * multiplier.a + this.b*multiplier.c);
    tempB = (this.a * multiplier.b + this.b*multiplier.d);
    tempC = (this.c * multiplier.a + this.d*multiplier.c);
    tempD = (this.c * multiplier.b + this.d*multiplier.d);
    return new Matrix(tempA, tempB, tempC, tempD);
  }
  public void subtract(int subtractor)
  {
    while(this.a >= subtractor)
      a-= subtractor;
    while(this.b >= subtractor)
      b-= subtractor;
    while(this.c >= subtractor)
      c-= subtractor;
    while(this.d >= subtractor)
      d-= subtractor;
  }
  public Matrix add(Matrix adder)
  {
    return new Matrix(this.a + adder.a, this.b + adder.b, this.c + adder.c, this.d+adder.d);
  }
  public String toString()
  {
    return (a + " "  + b + "\n" + c + " "  + d);
  }
}

