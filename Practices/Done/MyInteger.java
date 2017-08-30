class MyInteger 
{
  public int x;
  
  public MyInteger(int n)
  {
    x = n;
  }
  public static void swap2(MyInteger a, MyInteger b)
  {
    int temp = a.x;
    a.x = b.x;
    b.x = temp;
  }
  public static void main(String[] args)
  {
    MyInteger a = new MyInteger(10);
    MyInteger b = new MyInteger(9);
    swap2(a, b);
    System.out.println(a.x +" "+ b.x);
  }
}