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
    String rocniObdobi;
    String typ;

    public Osoba() {
        this.poziceX      = Utils.randInt(1, 10);
        this.poziceY      = Utils.randInt(1, 10);
        this.promile      = Utils.randInt(0, 10);
        this.bezohlednost = Utils.randInt(1, 10);
        this.spechat      = Utils.randInt(1, 10);
       
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

    private String getType() {
        switch (Utils.randInt(0, 3)) {
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

    private String getRocniObdobiRandom() {
        switch (Utils.randInt(1, 4)) {
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

    @Override
    public String toString() {
        return "Osoba{" + "poziceX=" + poziceX + ", poziceY=" + poziceY + ", promile=" + promile + ", bezohlednost=" + bezohlednost + ", spechat=" + spechat + ", rocniObdobi=" + rocniObdobi + ", typ=" + typ + '}';
    }

}
