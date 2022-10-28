package com.dh.pizzeria;

import com.dh.pizzeria.service.Cocinero;
import com.dh.pizzeria.service.impl.CocineroNoVeggie;
import com.dh.pizzeria.service.impl.CocineroVeggie;

public class Main {

    public static void main(String[] args) {
        Cocinero cocineroVeggie = new CocineroVeggie();
        Cocinero cocineroNoVeggie = new CocineroNoVeggie();

        cocineroVeggie.hacerPizza();
        cocineroNoVeggie.hacerPizza();
    }
}
