/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package globalagenciescooperation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Shivam
 */
public class Helper {
    
    public Helper()
    {
    }
    
    int userSelection ;
    CreateFile createFile;
    UpdateFile updateFile;
    private String Agenrt_NAME;
    Handler h = Handler.getInstance();
     
    List<Team> myTeams = new ArrayList<>();
   // ask user to choose one option 
    String TeamName;
    String AgencyName;
    String AgentName;
    String StartDate;
    String EndDate;
    List<String> allTeamNames = new ArrayList<>();
   
    // Enter user choice - Base Function
    public void userChoice() 
    {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("What would you like to do ?");
            System.out.println("Press 1 - Create Agent File");
            System.out.println("Press 2 - Add Date to Agent File");
            System.out.println("Press 3 - View Agent File");
            System.out.println("Press 4 - Create Team");
            System.out.println("Press 5 - Show All Team Entries");
            System.out.println("Press 6 - Reports");
            userSelection = sc.nextInt();
            userChoiceAction(userSelection);
        } catch (IOException ex) {
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
    // Act according to user choice
   public void userChoiceAction(int number) throws FileNotFoundException, IOException
   {
       
        switch (number) {
            case 1:
                
                h.createFile();
                
                break;
            case 2:
                
                h.insertIntoFile();
                
                 break;
            case 3:
               
                
                h.displayFile();
                
               
                break;
            case 4:
                
                h.createTeam();
                
                break;
            case 5:
                
      
                h.showAllFileEntries();
                
                break;
            case 6:
                
                // case 6- Reports
                Scanner scnr = new Scanner(System.in);
                System.out.println("Select One of Following:->");
                System.out.println("Press 0 - All TEAMS");
                System.out.println("Press 1 - AGENCY with Most AGENTS");
                System.out.println("Press 2 - Relation Between TEAM and AGENCY");
                System.out.println("Press 3 - Relation Between TEAM and AGENCY and AGENTS");
                System.out.println("Press 4 - TEAM status");
                int report = scnr.nextInt();
                
                showReprts(report);
                
                break;
            default:
                System.out.println("Please Select Valid Option");
                userChoice();
                break;
        }
   }


    public void userWish() {
        
        String inputValue;
        
        Scanner s = new Scanner(System.in);
        System.out.println("Do You Want to Continue?");
        System.out.println("Press Y - to continue");
        System.out.println("Press N - to continue");
        
        inputValue = s.nextLine();
        
        if(inputValue.equals("Y") || inputValue.equals("y"))
        {
            userChoice();
        }
        else if(inputValue.equals("N") || inputValue.equals("n"))
        {
            System.out.println("Good Bye.");
        }
        else
        {
            System.out.println("Plese Select Valid Option");
            userWish();
        }
    }


     public int askUserInput() {
        Scanner s = new Scanner(System.in);
        System.out.println("Press 1 - to generate team");
        System.out.println("Press 2 - to quit");
        int y = s.nextInt();
        return y;
    }

     // Act according to user choice (Reports)
    private void showReprts(int report) throws IOException {
     
        switch(report)
        {
        case 0:
            
            h.showAllTeams();
              
            break;
        
        case 1:
            
            h.agencyWithMostAgents();
            
            break;
        case 2:
            
            h.teamAgencyRelation();
            
            break;
        case 3:
            
            h.teamAgentAgencyRelation();
            
            break;
        case 4:
     
            h.teamStatus();
            
            break;
        }
        
    }
}
