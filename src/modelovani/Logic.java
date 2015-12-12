package modelovani;

import export.Csv;
import javax.rmi.CORBA.Util;
import view.Panel;

/**
 *
 * @author Michal
 */
public class Logic {

    Day days[] = new Day[365];
    
    public static int min = 20;
    public static int max = 50;
    
    int numberOfDay = 1;
    Year year; 
    double quantityPeople;
     
    public Logic(double quantityPeople, Panel panel) {
        year = new Year();
        this.quantityPeople = quantityPeople;
        
        for(int i = 0; i < days.length; i++){
            days[i] = new Day();
        }
      
        for(int i = numberOfDay; i <= 365; i++){
           step();
           numberOfDay++;
           
        } 
        panel.graph(days);
        new Csv(days);
    }
 
  
    private boolean crash(Osoba a, Osoba b){
        int sum = 0;
      
        switch(year.getSeason(numberOfDay)){
            case 1: sum += Utils.randInt(1, 3); break; // jaro
            case 2: sum += Utils.randInt(3, 7); break; // léto
            case 3: sum += Utils.randInt(3, 6); break; // podzim
            case 4: sum += Utils.randInt(1, 3); break; // zima
        }
       
        if(year.isHoliday(numberOfDay) && !year.isWeekend(numberOfDay) ){
            sum += Utils.randInt(0, 3);
        }
        
        if(!year.isHoliday(numberOfDay) && year.isWeekend(numberOfDay) ){
            sum += Utils.randInt(0, 3);
        }
        
        if(numberOfDay %5 == 0){ // pátek
            sum += Utils.randInt(0, 3);
        }
        
        int x = (a.getPromile() > 0.5)? Utils.randInt(0, 3):0;
        int y = (b.getPromile() > 0.5)? Utils.randInt(0, 3):0;
        
        sum += (x + a.spechat + a.bezohlednost);
        sum += (y + b.spechat + b.bezohlednost);
        
        if(days[numberOfDay-1].accidents > Utils.randInt(0, 3)){
            sum -= Utils.randInt(0, 5);
        }
      
        return Utils.randInt(0, 190) >= sum*10;
    }
    
    public void step(){   
        int c = 0, t = 0, n = 0, uid = 0;
        
        Osoba actors[] = new Osoba[(int)(year.getNumberOfActorFromNumberOfDay(numberOfDay,min, max)*quantityPeople)];
        for(int i = 0; i<actors.length; i++){
            actors[i] = new Osoba();
        }
        
        for(Osoba o: actors){
            for(Osoba a: actors){
                if( a != o && (!a.hasAccident() && !o.hasAccident()) && (a.getPoziceX() == o.getPoziceX()) && a.getPoziceY() == o.getPoziceY() ){
                    c++;
                    if(crash(a, o)){
                        a.setAccident(true);
                        o.setAccident(true);
                        
                        if (a.getPromile() > 0.5 || o.getPromile() > 0.5){
                            uid++;
                        }
                        n++;
                    };
                }
            }
            t++;
        }
        
        days[numberOfDay-1].accidents = n;
        days[numberOfDay-1].actors = actors.length;
        days[numberOfDay-1].uid = uid;
        
    }
    
}
