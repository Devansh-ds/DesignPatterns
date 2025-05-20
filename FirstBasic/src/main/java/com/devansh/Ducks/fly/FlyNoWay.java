package com.devansh.Ducks.fly;

import com.devansh.Ducks.FlyBehaviour;

public class FlyNoWay implements FlyBehaviour {
    public void fly() {
        System.out.println("I cannot fly");
    }
}
