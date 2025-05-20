package com.devansh;

import com.devansh.Ducks.Duck;
import com.devansh.Ducks.quack.MallardDuck;

public class App 
{
    public static void main( String[] args )
    {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.display();
        mallardDuck.performFly();
        mallardDuck.performQuack();

    }
}
