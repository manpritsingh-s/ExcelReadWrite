package com.example;

public class Exceptioncar {
    static void display(String color) throws car{
        if(color!="red"){
            throw new car("Color is not red");
        }
        System.out.println("the Color is:- "+color);

        
    }
}
