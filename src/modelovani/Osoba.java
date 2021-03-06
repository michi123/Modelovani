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
   double promile;
   int bezohlednost;
   int spechat;
   String rocniObdobi;
   String typ;
   
   boolean accident = false;

    public Osoba() {
        this.poziceX = randomInteger(1, 10);
        this.poziceY = randomInteger(1, 10);
        this.promile = randomInteger(0, 10) < randomInteger(0, 1)? randomInteger(0, randomInteger(0, 50))/10d:0.0;
        this.bezohlednost = randomInteger(1, 10);
        this.spechat = randomInteger(1, 10);
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

    public double getPromile() {
        return promile;
    }

    public void setPromile(double promile) {
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
   
 
   
   
   public int randomInteger(int min, int max) {

    Random rand = new Random();

    // nextInt excludes the top value so we have to add 1 to include the top value
    int randomNum = rand.nextInt((max - min) + 1) + min;

    return randomNum;
}

    @Override
    public String toString() {
        return "Osoba{" + "poziceX=" + poziceX + ", poziceY=" + poziceY + ", promile=" + promile + ", bezohlednost=" + bezohlednost + ", spechat=" + spechat +  ", typ=" + typ + '}';
    }

    public void setAccident(boolean accident) {
        this.accident = accident;
    }
    
    public boolean hasAccident() {
        return accident;
    }
    
}
