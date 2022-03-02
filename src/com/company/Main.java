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

  public void printCæsarDekrypter() {
    printBetweenOptions();
    System.out.print("Først indtast den tekst du ønsker dekodet:");
  }

  public void printForskydning() {

    System.out.printf("""
        \nFor at krypterer din tekst, skal du vælge et forskydningsnummer, som forrykker alfabetet og gør din tekst
        ugenkendelig. Husk at gemme forskydningsnummeret, hvis du vil konverterer teksten tilbage eller andre skal 
        kunne afkrypterer den.
        """);
    System.out.print("\nIndtast dit forskydningsnummer, et helt tal mellem 1 og 29: ");
  }

  public void printdeforskydning() {

    System.out.print("\nIndtast dit forskydningsnummer til afkodningen, det er et helt tal mellem 1 og 29: ");
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
      case 1 -> startCæsarOptions();
      case 2 -> System.out.println("Program afsluttet");
      default -> startOptions();

    }

  }

  public void startCæsarOptions() {
    printCæsarOptions();
    int valg = keyboard.nextInt();

    switch (valg) {
      case 1 -> cæsarKrypter();
      case 2 -> cæsarDekrypter();
      case 3 -> startOptions();
      default -> startCæsarOptions();
    }
  }

  //Metoder for begge cæsarfunktioner
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

  public char[] almStringTilArray(String almtekst) {

    char[] charArray = almtekst.toCharArray();
    return charArray;
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

  //cæsarkryptering

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
    startCæsarOptions();


  }

  public int forskydBogstavVærdi(int bogstavVærdi, int forskydning) {

    if (bogstavVærdi == 0) { //mellemrum er uændret
      return bogstavVærdi;
    } else {
      bogstavVærdi += forskydning;
    }

    if (bogstavVærdi >= 30) {
      bogstavVærdi -= 29;
    }

    return bogstavVærdi;

  }

  // dekrypter

  public void cæsarDekrypter() {

    //Menu
    printCæsarDekrypter();

    //teksten til kryptering og lav et array
    String krypteretTekst = indtastString();
    char[] krypteretTekstSomArray = almStringTilArray(krypteretTekst);

    printBetweenOptions();

    //indtaste forskydning
    int forskydning = deforskydning();

    printBetweenOptions();

    //kald til afkryptering
    afkrypterTekst(krypteretTekstSomArray, forskydning);


  }

  public int deforskydning() {

    printdeforskydning();
    int forskydning = keyboard.nextInt();
    return forskydning;

  }

  public void afkrypterTekst(char[] stringArray, int forskydningVærdi) {

    StringBuilder normalTekst = new StringBuilder();

    for (int i = 0; i < stringArray.length; i++) {

      int bogstavVærdi = bogstavTilTal(stringArray[i]);
      bogstavVærdi = deforskydBogstavVærdi(bogstavVærdi, forskydningVærdi);
      char kodetBogstav = fraTalTilBogstav(bogstavVærdi);
      normalTekst.append(kodetBogstav);

    }
    String krypteretToLowercase = normalTekst.toString().toLowerCase();

    //udskriv resultat
    printKrypteretKode(krypteretToLowercase);

    //retur til Menu
    startCæsarOptions();


  }

  public int deforskydBogstavVærdi(int bogstavVærdi, int forskydning) {

    if (bogstavVærdi == 0) { //mellemrum er uændret
      return bogstavVærdi;
    } else {
      bogstavVærdi -= forskydning;
    }

    if (bogstavVærdi <= 0) {
      bogstavVærdi += 29;
    }

    return bogstavVærdi;

  }


  public static void main(String[] args) {

    Main obj = new Main();

    obj.startOptions();

  }
}
