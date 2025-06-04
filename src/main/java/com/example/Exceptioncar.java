package com.example;

public class Exceptioncar {
    static void display(String color) throws car{
        if(color!="red"){
            throw new car("Color is not red");
        }
        System.out.println("the Color is:- "+color);

    }
    public static void main(String[] args) {
        try {
            display("red");
        } catch (Exception e) {
            System.out.print("Exception occurs:"+e.getMessage());
        }
        
    }
}
