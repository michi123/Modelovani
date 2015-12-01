package modelovani;

import javax.rmi.CORBA.Util;

/**
 *
 * @author Michal
 */
public class Logic {

    Day days[] = new Day[365];
    
    int numberOfDay = 1;
    Year year; 
    double quantityPeople;
    int magicNumber = 24 + Utils.randInt(0, 5);
    
     
    public Logic(double quantityPeople) {
        
        for(int i = 0; i < days.length; i++){
            days[i] = new Day();
        }
        
        year = new Year();
        this.quantityPeople = quantityPeople;
        
        for(int i = numberOfDay; i <= 365; i++){
           step();
           numberOfDay++;
        }   
    }
    
    private boolean crash(Osoba a, Osoba b){
        int sum      = 0;
      
        switch(year.getSeason(numberOfDay)){
            case 1: sum += Utils.randInt(3, 6); break; // jaro
            case 2: sum += Utils.randInt(0, 3); break; // léto
            case 3: sum += Utils.randInt(3, 6); break; // podzim
            case 4: sum += Utils.randInt(4, 7); break; // zima
        }
        
        if(year.isHoliday(numberOfDay) && !year.isWeekend(numberOfDay) ){
            sum += Utils.randInt(1, 3);
        }
        
        if(!year.isHoliday(numberOfDay) && year.isWeekend(numberOfDay) ){
            sum -= Utils.randInt(1, 3);
        }
        
        if(numberOfDay %5 == 0){ // pátek
            sum += Utils.randInt(0, 5);
        }
        
        sum += (a.promile *3 + a.spechat + a.bezohlednost)/3;
        sum += (b.promile *3 + b.spechat + b.bezohlednost)/3;
        
        if(days[numberOfDay-1].deaths > Utils.randInt(0, 3)){
            sum -= Utils.randInt(0, 5);
        }
       
        return sum > magicNumber;
    }
    
    public void step(){   
        int c = 0, t = 0, n = 0;
        
        Osoba actors[] = new Osoba[(int)(year.getNumberOfActorFromNumberOfDay(numberOfDay)*quantityPeople)];
        for(int i = 0; i<actors.length; i++){
            actors[i] = new Osoba();
        }
        
        for(Osoba o: actors){
            for(Osoba a: actors){
                if( a != o &&  (a.getPoziceX() == o.getPoziceX()) && a.getPoziceY() == o.getPoziceY() ){
                    c++;
                    if(crash(a, o)){
                        n++;
                    };
                }
            }
            t++;
        }
        
        days[t].deaths = n;
    }
    
}
