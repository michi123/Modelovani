/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package export;

/**
 *
 * @author Ja
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import modelovani.Day;

public class Csv
{
    Day days[];
    
    
    public Csv(Day days[], int fileName) {
        this.days=days;
        generateCsvFile(fileName+".csv");
    }
 
    
	   

   
   private void generateCsvFile(String sFileName)
   {
       try
	{
            FileWriter writer = new FileWriter("./csvExport/"+sFileName);
            
            writer.append("Pocet aktoru");
            writer.append(';');
            writer.append("Pocet nehod");
            writer.append(';');
            writer.append("Pocet nehod pod vlivem alkoholu");
            writer.append('\n');
                
            for (int i = 0; i < this.days.length; i++) {
                writer.append(Integer.toString(this.days[i].actors));
                writer.append(';');
                writer.append(Integer.toString(this.days[i].accidents));
                writer.append(';');
                writer.append(Integer.toString(this.days[i].uid));
                writer.append('\n');
            }
            int n = 0, uid = 0, a = 0;
            for(Day d: days){
                n += d.accidents;
                uid += d.uid;
                a += d.actors;
            }   
            writer.append('\n');
            writer.append('\n');
            writer.append("Celkovy pocet aktoru");
            writer.append(';');
            writer.append("Celkovy pocet nehod");
            writer.append(';');
            writer.append("Celkovy pocet nehod pod vlivem alkoholu");
            writer.append('\n');
            writer.append(""+a);
            writer.append(';');
            writer.append(""+n);
            writer.append(';');
            writer.append(""+uid);
             writer.append('\n');
              writer.append('\n');
               writer.append('\n');
            
	    writer.flush();
	    writer.close();
	}
	catch(IOException e)
	{
	     e.printStackTrace();
	} 
    }
}