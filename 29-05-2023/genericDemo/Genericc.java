package genericDemo;
class MyArray<T>
{
    T A[] = (T[]) new Object[10];
    int len = 0;
    public void append(T v)
    {
        A[len++]=v;
    }
    public void display()
    {
        for(int i=0;i<len;i++)
        {
            System.out.println(A[i]);
        }
    }
}
public class Genericc
{
    public static void main(String[] args)
    {
        MyArray<Object> ma = new MyArray<>();
        ma.append("ACV");
        ma.append("SDFGG");
        ma.append(103);
        ma.append(105);
        ma.append(1056);
        ma.display();

    }
}