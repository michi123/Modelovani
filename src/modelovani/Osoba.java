/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelovani;

import java.util.Random;

/**
 *
 * @author Michal
 */
public class Osoba {
    
   int poziceX;
   int poziceY;
   int promile;
   int bezohlednost;
   int spechat;
   String rocniObdobi;
   String typ;

    public Osoba() {
        this.poziceX = randomInteger(1, 10);
        this.poziceY = randomInteger(1, 10);
        this.promile = randomInteger(0, 10);
        this.bezohlednost = randomInteger(1, 10);
        this.spechat = randomInteger(1, 10);
        this.rocniObdobi = getRocniObdobiRandom();
        this.typ = getType();
    }

    public int getPoziceX() {
        return poziceX;
    }

    public void setPoziceX(int poziceX) {
        this.poziceX = poziceX;
    }

    public int getPoziceY() {
        return poziceY;
    }

    public void setPoziceY(int poziceY) {
        this.poziceY = poziceY;
    }

    public int getPromile() {
        return promile;
    }

    public void setPromile(int promile) {
        this.promile = promile;
    }

    public int getBezohlednost() {
        return bezohlednost;
    }

    public void setBezohlednost(int bezohlednost) {
        this.bezohlednost = bezohlednost;
    }

    public int getSpechat() {
        return spechat;
    }

    public void setSpechat(int spechat) {
        this.spechat = spechat;
    }

    public String getRocniObdobi() {
        return rocniObdobi;
    }

    public void setRocniObdobi(String rocniObdobi) {
        this.rocniObdobi = rocniObdobi;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }
   
   private String getType(){
       switch(randomInteger(0, 3)){
           case 1: 
               return "chodec";
           case 2: 
               return "ridic";               
           case 3: 
               return "cyklista";
            default: 
            return "chodec";
       }
   }
   
   private String getRocniObdobiRandom(){
       switch(randomInteger(1, 4)){
           case 1: 
               return "jaro";
           case 2: 
               return "leto";               
           case 3: 
               return "podzim";
            case 4: 
               return "zima";
            default: 
            return "jaro";
       }
   }
   
   
   public int randomInteger(int min, int max) {

    Random rand = new Random();

    // nextInt excludes the top value so we have to add 1 to include the top value
    int randomNum = rand.nextInt((max - min) + 1) + min;

    return randomNum;
}

    @Override
    public String toString() {
        return "Osoba{" + "poziceX=" + poziceX + ", poziceY=" + poziceY + ", promile=" + promile + ", bezohlednost=" + bezohlednost + ", spechat=" + spechat + ", rocniObdobi=" + rocniObdobi + ", typ=" + typ + '}';
    }
   
   
   
    
}
