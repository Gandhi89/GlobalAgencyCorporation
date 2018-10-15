/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package globalagenciescooperation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Shivam
 */
public class UpdateFile {
    
     private String Name;
    private String Mission;
    private String Country;
    private String Date = "08092020";
    private String AgencyName; 
   
    public void updateFile(String name, String mission, String country, String date, String agancyName)
    {
        
        Name = name;
        Mission = mission;
        Country = country;
        Date = date;
        AgencyName = agancyName;
        
        try(FileWriter fw = new FileWriter("globalAgencies.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw))
            {
                 out.print(Name+",");
                 out.print(Mission+",");
                 out.print(Country+",");
                 out.print(Date+",");
                 out.println(AgencyName+",");
                 
            }   
        catch (IOException e) {
                 //exception handling left as an exercise for the reader
                 System.out.println("File Updating Error");
            }
    }
    
}
