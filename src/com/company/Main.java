package com.company;

import java.util.Scanner;

public class Main {

  final public Scanner keyboard = new Scanner(System.in);


  //Alle metoder der printer
  public void printOptions() {
    printBetweenOptions();
    System.out.println("Indtast dit valg.");
    System.out.println("1: Cæsarkryptering");
    System.out.println("2: Afslut program ");
    System.out.print("Indtast dit valg: ");

  }

  public void printCæsarOptions() {
    printBetweenOptions();
    System.out.println("Indtast dit valg.");
    System.out.println("1: Krypter tekst");
    System.out.println("2: Dekrypter tekst ");
    System.out.println("3: Tilbage til hovedmenu ");
    System.out.print("Indtast dit valg: ");

  }

  public void printBetweenOptions() {
    System.out.println();
    System.out.println("-".repeat(30));
    System.out.println();
  }

  public void printCæsarKrypter() {
    printBetweenOptions();
    System.out.print("Først indtast den tekst du ønsker kodet:");
  }

  public void printForskydning() {

    System.out.printf("""
        \nFor at krypterer din tekst, skal du vælge et forskydningsnummer, som forrykker alfabetet og gør din tekst
        ugenkendelig. Husk at gemme forskydningsnummeret, hvis du vil konverterer teksten tilbage eller andre skal 
        kunne afkrypterer den.
        """);
    System.out.print("\nIndtast dit forskydningsnummer, et helt tal mellem 1 og 29: ");
  }

  public void printKrypteretKode(String krypteretKode) {

    System.out.println("Din krypterede Kode er:");
    System.out.println(krypteretKode);

  }


  //hovedMenuer
  public void startOptions() {

    printOptions();

    int valg = keyboard.nextInt();

    switch (valg) {
      case 1 -> cæsarOptions();
      case 2 -> System.out.println("Program afsluttet");
      default -> startOptions();

    }

  }

  public void cæsarOptions() {
    printCæsarOptions();
    int valg = keyboard.nextInt();

    switch (valg) {
      case 1 -> cæsarKrypter();
      case 2 -> System.out.println("dekrypter tekst");
      case 3 -> startOptions();
      default -> cæsarOptions();
    }
  }

  //kryptering

  public void cæsarKrypter() {

    //Menu
    printCæsarKrypter();

    //teksten til kryptering og lav et array
    String almindeligTekst = indtastString();
    char[] almindeligTekstSomArray = almStringTilArray(almindeligTekst);

    printBetweenOptions();

    //indtaste forskydning
    int forskydning = forskydning();

    printBetweenOptions();

    //kald til kryptering
    krypterTekst(almindeligTekstSomArray, forskydning);

  }

  public String indtastString() {
    keyboard.nextLine();
    String almindeligTekst = keyboard.nextLine();
    almindeligTekst = almindeligTekst.toUpperCase();
    return almindeligTekst;
  }

  public int forskydning() {

    printForskydning();
    int forskydning = keyboard.nextInt();
    return forskydning;

  }

  public void krypterTekst(char[] stringArray, int forskydningVærdi) {

    StringBuilder krypteretTekst = new StringBuilder();

    for (int i = 0; i < stringArray.length; i++) {

      int bogstavVærdi = bogstavTilTal(stringArray[i]);
      bogstavVærdi = forskydBogstavVærdi(bogstavVærdi, forskydningVærdi);
      char kodetBogstav = fraTalTilBogstav(bogstavVærdi);
      krypteretTekst.append(kodetBogstav);

    }
    String krypteretToLowercase = krypteretTekst.toString().toLowerCase();

    //udskriv resultat
    printKrypteretKode(krypteretToLowercase);

    //retur til Menu
    cæsarOptions();


  }

  public int bogstavTilTal(char bogstav) {

    String alfabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";
    int bogstavTalværdi = alfabet.indexOf(bogstav);
    return bogstavTalværdi;

  }

  public char fraTalTilBogstav(int talværdi) {
    String alfabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";
    char nytBogstav = alfabet.charAt(talværdi);
    return nytBogstav;

  }

  public int forskydBogstavVærdi(int bogstavVærdi, int forskydning) {

    if (bogstavVærdi == 0) { //mellemrum er uændret
      return bogstavVærdi;
    } else {
      bogstavVærdi += forskydning;
    }

    if(bogstavVærdi >= 30) {
      bogstavVærdi -= 29;
    }

    return bogstavVærdi;

  }

  public char[] almStringTilArray(String almtekst) {

    char[] charArray = almtekst.toCharArray();
    return charArray;
  }


  public static void main(String[] args) {

    Main obj = new Main();

    obj.startOptions();

  }
}
