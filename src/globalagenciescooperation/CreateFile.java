/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package globalagenciescooperation;

import java.io.FileNotFoundException;
import java.util.Formatter;

/**
 *
 * @author Shivam
 */
public class CreateFile {
    
    private Formatter x;
    private String Name ;
    private String Mission;
    
    
    public void openFile()
    {
        try
        {
            x = new Formatter("globalAgencies.txt");
        }
        catch(FileNotFoundException e)
        {
            System.out.println("error accured");
        }
    }
    
    public void addRecords(String name,String mission)
    {
        Name= name;
        Mission = mission;
        x.format("%s%s%s", "13 ", Name ,Mission);
    }
    
    public void closeFile()
    {
        x.close();
    }
    
    
}
