package com.company;

import java.util.Scanner;

public class Main {

    final public Scanner keyboard = new Scanner(System.in);

    public void printOptions (){
        printBetweenOptions();
        System.out.println("Indtast dit valg.");
        System.out.println("1: Cæsarkryptering");
        System.out.println("2: Afslut program ");
        System.out.print("Indtast dit valg: ");

    }
    public void printCæsarOptions (){
        printBetweenOptions();
        System.out.println("Indtast dit valg.");
        System.out.println("1: Krypter tekst");
        System.out.println("2: Dekrypter tekst ");
        System.out.println("3: Tilbage til hovedmenu ");
        System.out.print("Indtast dit valg: ");

    }
    public void printBetweenOptions () {
        System.out.println();
        System.out.println("-".repeat(30));
        System.out.println();
    }

    public void startOptions () {

        printOptions();

        int valg = keyboard.nextInt();

        switch (valg) {
            case 1 -> cæsarOptions();
            case 2 -> System.out.println("Program afsluttet");
            default -> startOptions();

        }

    }
    public void cæsarOptions () {
        printCæsarOptions();
        int valg = keyboard.nextInt();

        switch (valg) {
            case 1 -> System.out.println("krypter tekst");
            case 2 -> System.out.println("dekrypter tekst");
            case 3 -> startOptions();
            default -> cæsarOptions();
        }
    }

    public static void main(String[] args) {

    Main obj = new Main();

    obj.startOptions();

    }
}
