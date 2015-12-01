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
    
    
    public Csv(Day days[]) {
        this.days=days;
        generateCsvFile("test.csv");
    }
 
    
	   

   
   private void generateCsvFile(String sFileName)
   {
       try
	{
            FileWriter writer = new FileWriter(sFileName);
            
            writer.append("Pocet aktoru");
            writer.append(';');
            writer.append("Pocet nehod");
            writer.append('\n');
                System.out.println("ahoj");
                
            for (int i = 0; i < this.days.length; i++) {
                writer.append(Integer.toString(this.days[i].actors));
                System.out.println(Integer.toString(this.days[i].actors));
                writer.append(';');
                writer.append(Integer.toString(this.days[i].accidents));
                System.out.println(Integer.toString(this.days[i].accidents));
                writer.append('\n');
            }
            
	    writer.flush();
	    writer.close();
	}
	catch(IOException e)
	{
	     e.printStackTrace();
	} 
    }
}