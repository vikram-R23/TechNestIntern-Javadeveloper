class calc
{
    int sum;
    int diff;
    int mult;
    int div;

    public void calculator(int a,int b)
    {
        sum = a + b;
        diff = a - b;
        mult = a * b;
        div = a / b;
    }
    public void getsum()
    {
        System.out.println("the sum of A and B is:" + sum);
    }
    public void getdiff()
    {
        System.out.println("the difference of A and B is:" + diff);
    }
    public void getmult()
    {
        System.out.println("the multiplication of A and B is:"+mult);
    }

    public void getdiv()
    {
        System.out.println("the division of A and B is:"+div);
    }
}
public class calculator
{
    public static void main(String[]args)
    {
        calc c=new calc();
        c.calculator(10,20);
        c.getsum();
        c.getdiff();
        c.getmult();
        c.getdiv();
    }
}
