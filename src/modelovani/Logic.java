package modelovani;

/**
 *
 * @author Michal
 */
public class Logic {

    int numberOfDay = 1;
    Year year;
    
    public Logic() {
        year = new Year();
        
        for(int i = numberOfDay; i < 365; i++){
           step();
           numberOfDay++;
        }   
    }
    
    public void step(){    
        Osoba actors[] = new Osoba[year.getNumberOfActorFromNumberOfDay(numberOfDay)];
        for(int i = 0; i<actors.length; i++){
            actors[i] = new Osoba();
        }
        
        for(Osoba o: actors){
            for(Osoba a: actors){
                if( (a.getPoziceX() == o.getPoziceX()) && a.getPoziceY() == o.getPoziceY() ){
                    System.out.println("A " + numberOfDay);
                }
            }
        }
        
    }
    
}
