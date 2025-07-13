 class animal{
    public void eat()
    {
        System.out.println("Animal can eat");
    }
}
 class dog extends animal{ // it invoke the parent class animal properties
    public void bark(){
        System.out.println("Dog can bark");

    }
}
class cat extends animal{// it invoke the base class animal properties
    public void meow()
    {
        System.out.println("Cat can make a sound like meow");
    }
}

public class hierarchy {
    public static void main(String[]args)
    {
        dog d=new dog();
        d.eat();
        d.bark();
        cat c=new cat();
        c.eat();
        c.meow();
    }
    
}
