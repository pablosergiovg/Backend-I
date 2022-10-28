package com.dh.pizzeria.service.impl;

import com.dh.pizzeria.service.Cocinero;

public class CocineroVeggie extends Cocinero {


    @Override
    protected void prepararIngredientes() {
        System.out.println("Preparando tomate y diferentes quesos");
    }

    @Override
    protected void agregarIngredientes() {
        System.out.println("Agregando quesos y tomate");

    }
}
