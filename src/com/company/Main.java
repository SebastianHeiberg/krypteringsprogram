package com.company;

import java.util.Scanner;

public class Main {

  final public Scanner keyboard = new Scanner(System.in);


  //Alle metoder der printer til Vigenere
  public void printVigenereOptions() {
    printBetweenOptions();
    System.out.println("Indtast dit valg.");
    System.out.println("1: Krypter tekst");
    System.out.println("2: Dekrypter tekst ");
    System.out.println("3: Tilbage til hovedmenu ");
    System.out.print("Indtast dit valg: ");

  }

  public void printVigeneretekst () {

    printBetweenOptions();
    System.out.print("Først indtast den tekst du ønsker kodet:");

  }

  public void printVigenereKodeord () {
    System.out.printf("""
        \nFor at krypterer din tekst, skal du vælge et kodeord, som bruges til at gøre din tekst
        ugenkendelig. Husk at gemme kodeordet, hvis du vil konverterer teksten tilbage eller andre skal 
        kunne afkrypterer den.
        """);
    System.out.print("\nIndtast dit kodeord, et ord uden brug af mellemrum: ");
  }


  //Alle metoder der printer til cæsar

  public void printOptions() {
    printBetweenOptions();
    System.out.println("Indtast dit valg.");
    System.out.println("1: Cæsarkryptering");
    System.out.println("2: Vigenère");
    System.out.println("3: Afslut program ");
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
    //print options
    printOptions();

    //vælg imellem valgene
    int valg = keyboard.nextInt();

    switch (valg) {
      case 1 -> startCæsarOptions();
      case 2 -> startVigenereOptions();
      case 3 -> System.out.println("Program afsluttet");
      default -> startOptions();

    }

  }

  public void startCæsarOptions() {
    //printer menuen
    printCæsarOptions();

    //bruger indtaster sit valg
    int valg = keyboard.nextInt();

    switch (valg) {
      case 1 -> cæsarKrypter();
      case 2 -> cæsarDekrypter();
      case 3 -> startOptions();
      default -> startCæsarOptions();
    }
  }

  public void startVigenereOptions() {
    //printer menuen
    printVigenereOptions();

    //bruger indtaster sit valg
    int valg = keyboard.nextInt();

    switch (valg) {
      case 1 -> vigenereKrypter();
      case 2 -> System.out.println("dekrypter");
      case 3 -> startOptions();
      default -> startVigenereOptions();
    }
  }

  //Metoder for begge cæsarfunktioner
  public String indtastString() {
    //Brugeren indtaster en string, som returneres
    keyboard.nextLine();
    String almindeligTekst = keyboard.nextLine();
    almindeligTekst = almindeligTekst.toUpperCase();
    return almindeligTekst;
  }

  public int forskydning() {
    //først printes der, derefter indtastes forskydningen
    printForskydning();
    int forskydning = keyboard.nextInt();
    return forskydning;

  }

  public char[] stringTilArray(String almtekst) {
    //tager teksten og laver den om til et array med char
    char[] charArray = almtekst.toCharArray();
    return charArray;
  }

  public int bogstavTilTal(char bogstav) {
    //Laver et bogstav om til et tal, der sendes tilbage
    String alfabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";
    int bogstavTalværdi = alfabet.indexOf(bogstav);
    return bogstavTalværdi;

  }

  public char fraTalTilBogstav(int talværdi) {
    //tager et tal ind og leveret bogstavet på pladsen
    String alfabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";
    char nytBogstav = alfabet.charAt(talværdi);
    return nytBogstav;

  }


  //cæsar krypter

  public void cæsarKrypter() {

    //Menu
    printCæsarKrypter();

    //teksten til kryptering og lav et array
    String almindeligTekst = indtastString();
    char[] almindeligTekstSomArray = stringTilArray(almindeligTekst);

    printBetweenOptions();

    //indtaste forskydning
    int forskydning = forskydning();

    printBetweenOptions();

    //kald til kryptering
    krypterTekst(almindeligTekstSomArray, forskydning);

  }

  public void krypterTekst(char[] stringArray, int forskydningVærdi) {
    //Starten en tekst der kan printes ud
    StringBuilder krypteretTekst = new StringBuilder();

    //et loop der gennemgår arrayen der gives metoden og krypterer den
    for (int i = 0; i < stringArray.length; i++) {

      int bogstavVærdi = bogstavTilTal(stringArray[i]); //lav char til tal

      bogstavVærdi = forskydBogstavVærdi(bogstavVærdi, forskydningVærdi); // tilføjer forskydning til værdien

      char kodetBogstav = fraTalTilBogstav(bogstavVærdi); //laver tal om til bogstav

      krypteretTekst.append(kodetBogstav); //tilføjer bogstav til sætningen

    }

    String krypteretToLowercase = krypteretTekst.toString().toLowerCase(); //Store bogstaver føles som at den råber

    //udskriv resultat
    printKrypteretKode(krypteretToLowercase);

    //retur til Menu
    startCæsarOptions();


  }

  public int forskydBogstavVærdi(int bogstavVærdi, int forskydning) {

    if (bogstavVærdi == 0) { //mellemrum er uændret
      return bogstavVærdi;
    } else {
      bogstavVærdi += forskydning; //opdaterer værdien
    }

    if (bogstavVærdi >= 30) { //søger for at gå tiltage til start, hvis man går over længden af alfabetet
      bogstavVærdi -= 29;
    }

    return bogstavVærdi;

  }


  // cæsar dekrypter

  public void cæsarDekrypter() {

    //Menu, bemærk at den bentter den samme start som cæsar
    printCæsarKrypter();

    //teksten til kryptering og lav et array
    String krypteretTekst = indtastString();
    char[] krypteretTekstSomArray = stringTilArray(krypteretTekst);

    printBetweenOptions();

    //indtaste forskydning
    int forskydning = deforskydning();

    printBetweenOptions();

    //kald til afkryptering
    afkrypterTekst(krypteretTekstSomArray, forskydning);


  }

  public int deforskydning() {
    //forskydning med dekrypteret tekst info
    printdeforskydning();
    int forskydning = keyboard.nextInt();
    return forskydning;

  }

  public void afkrypterTekst(char[] stringArray, int forskydningVærdi) {
    //en stringbuilder til den nye tekst
    StringBuilder normalTekst = new StringBuilder();

    //et loop der gennemgår arrayen der gives metoden og krypterer den
    for (int i = 0; i < stringArray.length; i++) {

      int bogstavVærdi = bogstavTilTal(stringArray[i]); //lav char til tal

      bogstavVærdi = deforskydBogstavVærdi(bogstavVærdi, forskydningVærdi); // tilføjer forskydning til værdien

      char kodetBogstav = fraTalTilBogstav(bogstavVærdi); //laver tal om til bogstav

      normalTekst.append(kodetBogstav); //tilføjer bogstav til sætningen

    }
    String krypteretToLowercase = normalTekst.toString().toLowerCase(); //Store bogstaver føles som at den råber

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


  //Vigenère

  public void vigenereKrypter () {

    //Menu, bemærk at den bentter den samme start som cæsar
    printVigeneretekst();

    //teksten til kryptering og lav et array
    String krypteretTekst = indtastString();
    char[] krypteretTekstSomArray = stringTilArray(krypteretTekst);

    printBetweenOptions();

    //indtaste forskydningskodeordet
    String vigenereKodeord = indtastVigenereKodeord();

    System.out.println(vigenereKodeord);


    printBetweenOptions();

    //kald til kryptering


  }

  public String vigenereForskydning () {
    //print tekst
    printVigenereKodeord();
    //lav en string
    String vigenereKodeord = indtastString();
    //returner string
    return vigenereKodeord;
  }

  public String indtastVigenereKodeord() {
    //Brugeren indtaster en string, som returneres
    String kodeord = keyboard.nextLine();
    kodeord = kodeord.toUpperCase();
    return kodeord;
  }


  public static void main(String[] args) {

    Main obj = new Main();

    obj.startOptions();

  }
}
