package modelovani;

import java.util.Arrays;

/**
 *
 * @author tomas
 */
public class Year {
    
    int holiday[] = {1, 96, 121, 128, 186, 187, 271, 301, 321, 358, 359, 360};
    
    // je víkend?
    public boolean isWeekend(int numberOfDay){
        return numberOfDay % 6 == 0 || numberOfDay % 7 == 0;
    }
    
    public boolean isFriday(int numberOfDay){
        return numberOfDay % 5 == 0;
    }
    
    // jsou prázdniny?
    public boolean isHoliday(int numberOfDay){
        return Arrays.asList(holiday).contains(numberOfDay);
    }
    
    public int getSeason(int numberOfDay){
        return numberOfDay / 4;
    }
    
    // pocet aktorů dle dne
    public int getNumberOfActorFromNumberOfDay(int dayNumber, int min, int max){
        boolean holiday = isHoliday(dayNumber);
        int result = Utils.randInt(min, max);
      
        while(result > max){
            // pokud je svátek, bude počet aktorů menší. 
            if(holiday){
                int r = Utils.randInt(1, 10);

                if(r < result)
                    result -= Utils.randInt(1, 10);
            }

            // Pokud nejsou prázdniny a zároveň není víkend, bude počet aktorů vyšší. 
            if(!holiday && !isWeekend(dayNumber)){
                result += Utils.randInt(1, 15);
            }

            if(isFriday(dayNumber)){
                result += Utils.randInt(1, 5);
            }
        }
        
        return result;
    }
    
}
