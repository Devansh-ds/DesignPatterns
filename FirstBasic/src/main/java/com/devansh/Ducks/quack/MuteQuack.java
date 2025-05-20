package com.devansh.Ducks.quack;

import com.devansh.Ducks.QuackBehaviour;

public class MuteQuack implements QuackBehaviour {
    public void quack() {
        System.out.println("<< Silence >>");
    }
}
