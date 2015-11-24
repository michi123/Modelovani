/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelovani;

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
   int rocniObdobi;
   String typ;

    public Osoba() {
        this.poziceX = poziceX;
        this.poziceY = poziceY;
        this.promile = promile;
        this.bezohlednost = bezohlednost;
        this.spechat = spechat;
        this.rocniObdobi = rocniObdobi;
        this.typ = getType();
        System.out.println(typ);
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

    public int getRocniObdobi() {
        return rocniObdobi;
    }

    public void setRocniObdobi(int rocniObdobi) {
        this.rocniObdobi = rocniObdobi;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }
   
   private String getType(){
       int cislo;
       cislo = (int) (Math.random()*((4 - 2))*100)/100;
       System.out.println((Math.random()*((4 - 2))*100)/100);
       System.out.println(cislo);
       switch(cislo){
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
    
}
