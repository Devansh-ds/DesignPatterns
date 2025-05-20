package com.devansh.Ducks.quack;

import com.devansh.Ducks.Duck;
import com.devansh.Ducks.fly.FlyWithWings;

public class MallardDuck extends Duck {

    public MallardDuck() {
        quackBehaviour = new Quack();
        flyBehaviour = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("Mallard Duck display");
    }
}
