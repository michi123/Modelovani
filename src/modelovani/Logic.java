package modelovani;

import javax.rmi.CORBA.Util;

/**
 *
 * @author Michal
 */
public class Logic {

    int numberOfDay = 1;
    Year year; 
    int days[] = new int[365];
    
    int magicNumber = 24 + Utils.randInt(0, 5);
     
    public Logic() {
        year = new Year();
        
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
        
        if(days[numberOfDay-1] > 2){
            sum -= Utils.randInt(0, 5);
        }
        
        //System.out.println(sum);
        
        return sum > magicNumber;
    }
    
    public void step(){    
        Osoba actors[] = new Osoba[year.getNumberOfActorFromNumberOfDay(numberOfDay)];
        for(int i = 0; i<actors.length; i++){
            actors[i] = new Osoba();
        }
        
        int c = 0;
        int t = 0;
        int n = 0;
        
        for(Osoba o: actors){
            for(Osoba a: actors){
                if( a != o &&  (a.getPoziceX() == o.getPoziceX()) && a.getPoziceY() == o.getPoziceY() ){
                    c++;
                    if(crash(a, o)){
                        n++;
                    };
                }
            }
            days[t] = n;
            t++;
        }
        
        System.out.println(numberOfDay + " " + n + "/" + c + "/" + t);
    }
    
}
