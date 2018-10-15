/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package globalagenciescooperation;

/**
 *
 * @author Shivam
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Handler {
   
    private static Handler single_instance = null;
  
    /*
    public  Handler()
    {
    
    }
    */
    public static Handler getInstance()
    {
        if (single_instance == null)
            single_instance = new Handler();
 
        return single_instance;
    }
    
    CreateFile createFile;
    UpdateFile updateFile;
    String Agenrt_NAME;
    List<Agent> newAgents =  new ArrayList<>();
    List<Team> allTeams = new ArrayList<>();
    
    List<Team> tempTeams = new ArrayList<>();
    
    List<Team> justOneTeam = new ArrayList<>();
    List<TeamAgencyConnection> teamAgencyConnections = new ArrayList<>();
    List<String> agencyOfTeam = new ArrayList<>();
    List<String> allNamesTeam = new ArrayList<>();
    List<String> exactTeamNames = new ArrayList<>();
    List<String> agencyNamesInTeam = new ArrayList<>();
    List<Integer> countAgencyNamesInTeam = new ArrayList<>();
    //Helper helper = new Helper();
    String TeamName;
    String AgencyName;
    String AgentName;
    String StartDate;
    String EndDate;
    List<String> allTeamNames = new ArrayList<>();
    
    
    // ------------------------------------------------------------------------- //
    
    /**
     * Method to store all teams
     */
    public void addTeam(String one, String two, String three, String four, String five)
    {
      
        allTeams.add(new Team(one, two, three, four, five));
       
    }
    
     // ------------------------------------------------------------------------- //
    
    /**
     * Method to return all teams
     */
    public List<Team> showTeam()
    {
       
        return allTeams;
    }
    
    // ------------------------------------------------------------------------- //
    
    /**
     * Method to add just one (recently added) team
     */
    public void justOneTeam(String one, String two, String three, String four, String five)
    {
       
        justOneTeam.add(new Team(one, two, three, four, five));
    }
    
    // ------------------------------------------------------------------------- //
    
    /**
     * Method to show just one (recently added) team
     */
     public List<Team> showLastAddedTeam()
    {
        return justOneTeam;
    }
     
    // ------------------------------------------------------------------------- //
    
    /**
     * Method to clear array of recently added team
     */
     public void clearJustOnTeamArray()
     {
     
        justOneTeam.clear();
         
     }
    
    public void TeamAgencyConnection(String team, String agency, String agentName,String sDate, String eDate)
    {
        teamAgencyConnections.add(new TeamAgencyConnection(team,agency,agentName,sDate,eDate));
    }
    
    public List<TeamAgencyConnection> getTeamAgencyConnection()
    {
        return teamAgencyConnections;
    }
    
    // ------------------------------------------------------------------------- //
    
    /**
     * Method to get all AgencyName of a Team
     */
    public List<String> AgencyofTeam(String team)
    {
        List<Team> list = new ArrayList<>();
        list = showTeam();
        agencyOfTeam.clear();
        String teamName = team;
        for (int i = 0; i < (list.size()); i++) {
            
            if (list.get(i).teamCode.equals(teamName)) {
                
                agencyOfTeam.add(list.get(i).agencyName);
                
            }
            
        }
            return agencyOfTeam;
    }
    
    // ------------------------------------------------------------------------- //
    
    /**
     * Method to get all Agents of a Team
     */
    public List<String> AgentofTeam(String team)
    {
        List<Team> list = new ArrayList<>();
        list = showTeam();
        List<String> agents = new ArrayList<>();
         
        String teamName = team;
        for (int i = 0; i < (list.size()); i++) {
            
            if (list.get(i).teamCode.equals(teamName)) {
                
                agents.add(list.get(i).agentName);
                
            }
            
        }
            return agents;
    }
    
    // ------------------------------------------------------------------------- //
    
    /**
     * Method to get repetitive team names
     */
    public void allTeamName(String teamName)
    {
        
        allNamesTeam.add(teamName);
        
    }
    public List<String> getAllTeamNames()
    {
        return allNamesTeam;
    }
    
    // ------------------------------------------------------------------------- //
    
    /**
     * Method to get list of team names
     */
    public List<String> perfectTeamNames()
    {
        boolean b = true;
        List<String> allName = getAllTeamNames();
        
       
        for (int i = 0; i < allName.size(); i++) {
            
            for (int j = 0; j < exactTeamNames.size(); j++) {
                
                if(allName.get(i).equals(exactTeamNames.get(j)))
                {
                    b = false;
       
                }
                
            }
            if (b) {
                exactTeamNames.add(allName.get(i));         
            }
                b = true;
        }
    return exactTeamNames;
    }
    
    // ------------------------------------------------------------------------- //
    
    /**
     * Method to get Number of agency (how many time appears)
     */
    public void countAgencyPerTeam(List<String> agency)
    {
        
        List<String> agencyNames = agency;
        agencyNamesInTeam.clear();
        countAgencyNamesInTeam.clear();
        int c=0; boolean b=true;
        
        for (int i = 0; i < agencyNames.size(); i++) {
            
            for (int j = 0; j < agencyNamesInTeam.size(); j++) {
                
                if (agencyNames.get(i).equals(agencyNamesInTeam.get(j))) {
                    
                    b=false;
                }
                
            }
            if (b) {
                  agencyNamesInTeam.add(agencyNames.get(i));
                }
            
            if (b) {
                
                for (int k = 0; k < agencyNames.size(); k++) {
                    
                    if (agencyNames.get(i).equals(agencyNames.get(k))) {
                        c++;
                    }
                }
            countAgencyNamesInTeam.add(c);     
            }
            c = 0;
            b=true;
            
        }
        
    }
 
    // ------------------------------------------------------------------------- //
    
    /**
     * Method to get agencyNamesInTeam
     */
    public List<String> getAgencyNamesInTeam()
    {
        return agencyNamesInTeam;
    }
    
    // ------------------------------------------------------------------------- //
    
    /**
     * Method to get countAgencyNamesInTeam
     */
    public List<Integer> getCountAgencyNamesInTeam()
    {
        return countAgencyNamesInTeam;
    }
    
    // ------------------------------------------------------------------------- //
    
    /**
     * Method to getIndex of biggest number
     */
    public int getIndexOfBiggestNumber(List<Integer> data)
    {
        int index=0;
        int max=data.get(0);
        
        
        for (int i = 0; i < data.size(); i++) {
            
            if (data.get(i)>max) {
                
                max = data.get(i);
                index = i;
            }
        }
       
        return index;
        
    }
    
    public void clearTeamAgencyConnections()
    {
        
        teamAgencyConnections.clear();
        
    }
    
    // ------------------------------------------------------------------------- //
    
    /**
     * Method to check team status : Active/Not Active
     */
    public String teamActiveSatus(String team, int date)
    {
        String status="Not Active";
        
        List<Team> list = new ArrayList<>();
        list = showTeam();
        List<String> startDate = new ArrayList<>();
        List<String> endDate = new ArrayList<>();
         int Date = date;
        String teamName = team;
        for (int i = 0; i < (list.size()); i++) {
            
            if (list.get(i).teamCode.equals(teamName)) {
                
                startDate.add(list.get(i).startDate);
                endDate.add(list.get(i).startDate);
                
                if ( Date > Integer.parseInt(list.get(i).startDate))
                {
                    if ( Date < Integer.parseInt(list.get(i).endDate))
                    {
                        status = "Active";
                    }
                }
                
            }
            
        }
        return status;
    }

    void createFile() {
    
        createFile = new CreateFile();
                createFile.openFile();
                System.out.println("File Created");
                userWish();
    
    }

    private void userWish() {
    
        
        String inputValue;
        
        Scanner s = new Scanner(System.in);
        System.out.println("Do You Want to Continue?");
        System.out.println("Press Y - to continue");
        System.out.println("Press N - to continue");
        
        inputValue = s.nextLine();
        
        if(inputValue.equals("Y") || inputValue.equals("y"))
        {
            Helper helper = new Helper();
            helper.userChoice();
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

    // ------------------------------------------------------------------------- //
    
    /**
     * Method to insert data into file
     */
    void insertIntoFile() {
    
        Scanner scanner = new Scanner(System.in);
                System.out.println("Enter NAME : ");
                String NAME = scanner.nextLine();
                // encryption
                String EncriptedName = encryption(NAME.toUpperCase());
                System.out.println("Enter MISSION : ");
                String MISSION = scanner.nextLine();
                // encryption
                String EncriptedMission = encryption(MISSION.toUpperCase());
                System.out.println("Enter COUNTRY : ");
                String COUNTRY = scanner.nextLine();
                // encryption
                String EncriptedCountry = encryption(COUNTRY.toUpperCase());
                System.out.println("Enter DATE : ");
                String DATE = scanner.nextLine();
                // encryption
                String EncriptedDate = encryptionForDate(DATE);
                System.out.println(""+EncriptedDate);
             
                System.out.println("Enter AGENCY : ");
                String AGENCY = scanner.nextLine();
                // encryption
                String EncriptedAgency = encryption(AGENCY.toUpperCase());
                
                // update file with Encypted Data
                updateFile = new UpdateFile();
                updateFile.updateFile(EncriptedName, EncriptedMission, EncriptedCountry, EncriptedDate, EncriptedAgency);
                System.out.println("New Data Inserted");
                userWish();
                
    
    }
 
    // ------------------------------------------------------------------------- //
    
    /**
     * Method to Encrypt String Data
     */
    private String encryption(String Data) {
    
        HashMap<String, Integer> map = new HashMap();
    
        map.put("A", 2);
        map.put("B", 3);
        map.put("C", 5);
        map.put("D", 7);
        
        map.put("E", 11);
        map.put("F", 13);
        
        map.put("G", 17);
        map.put("H", 19);
      
        
        map.put("I", 23);
        map.put("J", 29);
        
        map.put("K", 31);
        map.put("L", 37);
        
        map.put("M", 41);
        map.put("N", 43);
        
        map.put("O", 47);
        map.put("P", 53);
        
        map.put("Q", 59);
        map.put("R", 61);
        
        map.put("S", 67);
        map.put("T", 71);
        
        map.put("U", 73);
        map.put("V", 79);
       
        map.put("W", 83);
        map.put("X", 89);
        
        map.put("Y", 97);
        map.put("Z", 101);
  
        String temp="";
        String EncryptedString="";
                
        int count = Data.length();
      
        for (int i = 0; i< count; i++)
        {
            String a_letter = Character.toString(Data.charAt(i));
          
            if (a_letter.equals(" ")) {
                
                temp = "#";
                
            }
            
            else
            {
            
            Iterator<String> keySetIterator = map.keySet().iterator();
        
            while (keySetIterator.hasNext()) {
            String key = keySetIterator.next();
            
            if (key.contains(a_letter)) {
                
                    if (i == count-1) {
                        temp = map.get(key)+"";
                        }
                    else
                    {
                        temp = map.get(key)+"/";
                    }        
                }
            }
                
            }
            
            EncryptedString += temp;
        }
             
       return EncryptedString;
    }

    public String encryptionForDate(String data) {
        
        String DateOutput = "";
        HashMap<Integer,String> DateEncryption = new HashMap();
    
        DateEncryption.put(0,"S");
        DateEncryption.put(1,"A");
        DateEncryption.put(2,"C");
        DateEncryption.put(3,"E");
        
        DateEncryption.put(4,"G");
        DateEncryption.put(5,"I");
        
        DateEncryption.put(6,"K");
        DateEncryption.put(7,"M");
      
        DateEncryption.put(8,"O");
        DateEncryption.put(9,"Q");
       
        Character oneChar ;
        String tempString = "";
        
        for(int i = 0 ; i < data.length(); i++)
        {
                oneChar = data.charAt(i);
        
                int IntOneChar = oneChar - '0';
         Iterator<Integer> keySetIterator = DateEncryption.keySet().iterator();
        
                while (keySetIterator.hasNext()) {
                Integer key = keySetIterator.next();
                 
                if (key == IntOneChar) {
                        tempString = DateEncryption.get(key)+"";               
                       
                }
            }
        DateOutput += tempString;
        }
        
         System.out.println("encrypted date -> "+DateOutput);
    
        return DateOutput;
    }

    // ------------------------------------------------------------------------- //
    
    /**
     * Method to display file
     */
    void displayFile() throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("globalAgencies.txt"));
               
                String line;
                int c =0;
                while((line = in.readLine()) != null)
                {
                    System.out.print(" "+c+" ");
                    String o = decrytion(line);
                    System.out.println(" AGENCY:-> "+o);
                    c++;
                }
                
                in.close();
                userWish();
               }
    
    // ------------------------------------------------------------------------- //
    
    /**
     * Method to Decrypt data of File
     */
    private String decrytion(String Line) {
    
         HashMap<Integer,String> mapDecrypt = new HashMap();
    
        mapDecrypt.put(2,"A");
        mapDecrypt.put(3,"B");
        mapDecrypt.put(5,"C");
        mapDecrypt.put(7,"D");
        
        mapDecrypt.put(11,"E");
        mapDecrypt.put(13,"F");
        
        mapDecrypt.put(17,"G");
        mapDecrypt.put(19,"H");
        
        mapDecrypt.put(23,"I");
        mapDecrypt.put(29,"J");
        
        mapDecrypt.put(31,"K");
        mapDecrypt.put(37,"L");
        
        mapDecrypt.put(41,"M");
        mapDecrypt.put(43,"N");
        
        mapDecrypt.put(47,"O");
        mapDecrypt.put(53,"P");
        
        mapDecrypt.put(59,"Q");
        mapDecrypt.put(61,"R");
        
        mapDecrypt.put(67,"S");
        mapDecrypt.put(71,"T");
        
        mapDecrypt.put(73,"U");
        mapDecrypt.put(79,"V");
       
        mapDecrypt.put(83,"W");
        mapDecrypt.put(89,"X");
        
        mapDecrypt.put(97,"Y");
        mapDecrypt.put(101,"Z");
  
        String temp="";
        String DecryptedString="";
        String b_letter="";
        String c_letter="";
        
        String MISSION="";
        String COUNTRY="";
        String DATE="";
        String AGENCY="";
        int count = 0;
        int one;
        
         int length = Line.length();
         
         for (int i = 0; i < length; i++) {
            
             String a_letter = Character.toString(Line.charAt(i));
             //   System.out.print(" a_letter: "+a_letter);
             if (i+1 < length-1) {
                b_letter  = Character.toString(Line.charAt(i+1));
             //   System.out.print(" b_letter: "+b_letter);
            }
             else
             {
                 b_letter  = "-";
             }
            if (i+2 < length-1)
            {
                c_letter = Character.toString(Line.charAt(i+2));
             //  System.out.println(" c_letter: "+c_letter);
            }
            else
            {
                c_letter = "-";
            }
            
  
            if (count == 3) {
                
                 String getDateString = "";
              
                for (int i1=0;i1<8;i1++)
                {
                        
                    a_letter = Character.toString(Line.charAt(i));
                    getDateString = getDateString + "" +a_letter;
                    i++;
                   
                }
                String dateDecrypted = decryptionForDate(getDateString);    
                 
               DecryptedString = dateDecrypted;
               System.out.print(" DATE:-> "+DecryptedString);
               count ++;
               DecryptedString = "";
            }
            
             if ((!"/".equals(a_letter)) && (!",".equals(a_letter)) && (!"#".equals(a_letter))){
                 
                 // condition check
                 if((!" ".equals(a_letter)) && ("-".equals(b_letter)) && ("-".equals(c_letter)))
                 {
                 
                     one = Integer.parseInt(a_letter);
                     
                     
                         Iterator<Integer> keySetIterator = mapDecrypt.keySet().iterator();
        
                        while (keySetIterator.hasNext()) {
                        Integer key = keySetIterator.next();
                 
                        if (key == one) {
                
                        temp = mapDecrypt.get(key)+"";
                 
                                    }
                            }
                        
                        DecryptedString += temp; 
                     i = length+7;
                 }
                 
                 // condition check
                 if ((!"/".equals(b_letter)) && (!",".equals(b_letter)) && (!"#".equals(b_letter))) {
                  
                     if ((!"-".equals(b_letter)) && ("-".equals(c_letter)))
                     {
                        one = Integer.parseInt(a_letter);
                        one = one*10;
                        one = one + Integer.parseInt(b_letter);
                
                         Iterator<Integer> keySetIterator = mapDecrypt.keySet().iterator();
        
                        while (keySetIterator.hasNext()) {
                        Integer key = keySetIterator.next();
                 
                        if (key == one) {
                
                        temp = mapDecrypt.get(key)+"";
                 
                                    }
                            }
                        
                        DecryptedString += temp; 
                        i++;
                        i++;
                        
                      }
                     
                     
                     // condition check 1
                     if ("/".equals(c_letter))
                     {
                        one = Integer.parseInt(a_letter);
                        one = one*10;
                        one = one + Integer.parseInt(b_letter);
                
                         Iterator<Integer> keySetIterator = mapDecrypt.keySet().iterator();
        
                        while (keySetIterator.hasNext()) {
                        Integer key = keySetIterator.next();
                 
                        if (key == one) {
                
                        temp = mapDecrypt.get(key)+"";
                 
                                    }
                            }
                        
                        DecryptedString += temp; 
                        i++;
                        i++;
                        
                      }
                     
                     // condition check 2
                     if (",".equals(c_letter))
                     {
                        one = Integer.parseInt(a_letter);
                        one = one*10;
                        one = one + Integer.parseInt(b_letter);
                
                         Iterator<Integer> keySetIterator = mapDecrypt.keySet().iterator();
        
                        while (keySetIterator.hasNext()) {
                        Integer key = keySetIterator.next();
                 
                        if (key == one) {
                
                        temp = mapDecrypt.get(key)+"";
                 
                                    }
                            }
                        
                        DecryptedString += temp; 
                        i++;
                        i++;
                        
                        switch (count) {
                    case 0:
                        Agenrt_NAME = DecryptedString;
                        DecryptedString = "";
                        count++;
                          System.out.print("NAME:-> "+Agenrt_NAME);
               
                        break;
                    case 1:
                        MISSION = DecryptedString;
                        DecryptedString = "";
                        count++;
                          System.out.print(" MISSION:-> "+MISSION);
               
                        break;
                    case 2:
                        COUNTRY = DecryptedString;
                        DecryptedString = "";
                        count++;
                          System.out.print(" COUNTRY:-> "+COUNTRY);
               
                        break;
                    case 3:
                        String getDateString = "";
              
                        for (int i1=0;i1<Line.length();i1++)
                        {
                        a_letter = Character.toString(Line.charAt(i));
                        getDateString = getDateString + "" +a_letter;
                        i++;
                        }
                        String dateDecrypted = decryptionForDate(getDateString);    
                 
                        DecryptedString = dateDecrypted;
                        count ++;
            
                        break;
                    case 4:
                        AGENCY = DecryptedString;
                        DecryptedString = "";
                        count++;
                          System.out.print(" AGENCY:-> "+AGENCY);
                        break;
                    default:
                        break;
                        }    
                     }
                     
                     // condition check 3
                     if("#".equals(c_letter))
                     {
                        one = Integer.parseInt(a_letter);
                        one = one*10;
                        one = one + Integer.parseInt(b_letter);
                
                         Iterator<Integer> keySetIterator = mapDecrypt.keySet().iterator();
        
                        while (keySetIterator.hasNext()) {
                        Integer key = keySetIterator.next();
                 
                        if (key == one) {
                
                        temp = mapDecrypt.get(key)+"";
                 
                                    }
                            }
                        
                        DecryptedString += temp; 
                        DecryptedString += " ";
                        i++;
                        i++;
                        
                     }
                  
                 }
                 // condition check 4
                 if("/".equals(b_letter))
                 {
                        one = Integer.parseInt(a_letter);
                        
                        Iterator<Integer> keySetIterator = mapDecrypt.keySet().iterator();
        
                        while (keySetIterator.hasNext()) {
                        Integer key = keySetIterator.next();
                 
                        if (key == one) {
                
                        temp = mapDecrypt.get(key)+"";
                 
                                    }
                            }
                        
                        DecryptedString += temp; 
                        i++;
                     
                 }
                 // condition check 5
                 if("#".equals(b_letter))
                 {
                        one = Integer.parseInt(a_letter);
                        
                        Iterator<Integer> keySetIterator = mapDecrypt.keySet().iterator();
        
                        while (keySetIterator.hasNext()) {
                        Integer key = keySetIterator.next();
                 
                        if (key == one) {
                
                        temp = mapDecrypt.get(key)+"";
                 
                                    }
                            }
                        
                        DecryptedString += temp; 
                        DecryptedString = DecryptedString + " ";
                        i++;
                        
                 }
                 // condition check 6
                 if (",".equals(b_letter))
                     {
                        one = Integer.parseInt(a_letter);
                        
                        Iterator<Integer> keySetIterator = mapDecrypt.keySet().iterator();
        
                        while (keySetIterator.hasNext()) {
                        Integer key = keySetIterator.next();
                 
                        if (key == one) {
                
                        temp = mapDecrypt.get(key)+"";
                 
                                    }
                            }
                        
                        DecryptedString += temp; 
                        i++;
                        
                        switch (count) {
                    case 0:
                        Agenrt_NAME = DecryptedString;
                        DecryptedString = "";
                        count++;
                          System.out.print("NAME:-> "+Agenrt_NAME);
               
                        break;
                    case 1:
                        MISSION = DecryptedString;
                        DecryptedString = "";
                        count++;
                          System.out.print(" MISSION:-> "+MISSION);
               
                        break;
                    case 2:
                        COUNTRY = DecryptedString;
                        DecryptedString = "";
                        count++;
                          System.out.print(" COUNTRY:-> "+COUNTRY);
               
                        break;
                    case 3:
                        String getDateString = "";
              
                        for (int i1=0;i1<Line.length();i1++)
                        {
                        a_letter = Character.toString(Line.charAt(i));
                        getDateString = getDateString + "" +a_letter;
                        i++;
                        }
                        String dateDecrypted = decryptionForDate(getDateString);    
                 
                        DecryptedString = dateDecrypted;
                        count ++;
            
                        break;
                    case 4:
                          System.out.print(" a_letter: "+a_letter);
                          System.out.print(" b_letter: "+b_letter);
                          System.out.print(" c_letter: "+c_letter);
                        AGENCY = DecryptedString;
                        DecryptedString = "";
                        count++;
                          System.out.print(" AGENCY:-> "+AGENCY);
               
                        break;
                    default:
                        break;
                        }    
                     }
                 
             }
             // condition check 7
             if ((!"/".equals(a_letter)) && (!",".equals(a_letter)) && ("#".equals(a_letter))) {
                 
                        DecryptedString += " ";
                        
                  
             }
            
        }
         return DecryptedString;
    }
   

    
    public String decryptionForDate(String date) {
        HashMap<String,Integer> DateDecryption = new HashMap();
    
        DateDecryption.put("S",0);
        DateDecryption.put("A",1);
        DateDecryption.put("C",2);
        DateDecryption.put("E",3);
        
        DateDecryption.put("G",4);
        DateDecryption.put("I",5);
        
        DateDecryption.put("K",6);
        DateDecryption.put("M",7);
      
        DateDecryption.put("O",8);
        DateDecryption.put("Q",9);
        
        String decryptedNumberString="";
        
         for (int i1= 0;i1<date.length();i1++)
            {
            Character c = date.charAt(i1);
            Iterator<String> keySetIterator = DateDecryption.keySet().iterator();
        
                while (keySetIterator.hasNext()) {
                String key = keySetIterator.next();
                 
                if (key.equals(c.toString())) {
                    
                        decryptedNumberString = ""+decryptedNumberString + ""+DateDecryption.get(key);
         
                            }
                    }
            }
        return decryptedNumberString;
    }

    // ------------------------------------------------------------------------- //
    
    /**
     * Method to Create new Team
     */
    public void createTeam() throws FileNotFoundException, IOException {
        
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter TeamName:-> ");
            String tName = sc.nextLine();
            System.out.println("Enter Team StartDate:-> ");
            String tStartDate = sc.nextLine();
            System.out.println("Enter Team EndDate:-> ");
            String tEndDate = sc.nextLine();
            System.out.println("How many agents to this team?:-> ");
            int teamMember = sc.nextInt();
                System.out.println("");
            System.out.println("To select enter Integer digit shown before Agent Name");
                System.out.println("");
            int agentNumber;
            for (int p= 0; p<teamMember; p++)
            {
           // Show all agents
                 BufferedReader inn = new BufferedReader(new FileReader("globalAgencies.txt"));
               String AgencyName;
                String linee;
                int c1 =1;
                int lineNumber = 1;
                while((linee = inn.readLine()) != null)
                {
                    System.out.print(" "+c1+" ");
                    AgencyName = decrytion(linee);
                    System.out.println(" AGENCY:-> "+AgencyName);
                   c1++;
                   lineNumber++;
                }
                
                inn.close();
                // userInput for Agent
                agentNumber=sc.nextInt();
                int t=1;
                String aName = "";
                    BufferedReader BR = new BufferedReader(new FileReader("globalAgencies.txt"));
                    String l;
                    for (int j = 1;j<c1+1;j++)
                    {
                        if (agentNumber == j)
                        {
                            
                            while((l = BR.readLine()) != null)
                            {
                                if(agentNumber == t)
                                {
                                    System.out.println("Your Agent is:->");
                                    aName = decrytion(l);
                                    System.out.println(" AGENCY:-> "+aName);
                                }
                                t++;
                            } 
                        }
                    }
                 
                allTeams.add(new Team(tName, tStartDate,tEndDate,Agenrt_NAME ,aName));
                justOneTeam(tName, tStartDate,tEndDate,Agenrt_NAME ,aName);
                System.out.println("");
                System.out.println(""+(teamMember-p-1)+" Agents are remaining.");
                System.out.println("");
            }
              
                
               userWish();
               
    }

    // ------------------------------------------------------------------------- //
    
    /**
     * Method to show every entry of file
     */
    public void showAllFileEntries() {
                
                List<Team> TeamNames = showTeam();
                System.out.println("teamSize -> "+allTeams.size());
                for (int i = 0; i < TeamNames.size(); i++) {
                System.out.print("Team Code :-> "+TeamNames.get(i).getTeamCode()+ " Team StartDate:-> "+TeamNames.get(i).getStartDate()+" Team EndDate:-> "+TeamNames.get(i).getEndDate());
                System.out.println(" Agent Name:-> "+TeamNames.get(i).getAgentName()+" Agency Name:-> "+TeamNames.get(i).getAgencyName());
                }
                userWish();
    }

    // ------------------------------------------------------------------------- //
    
    /**
     * Method to show all Teams
     */
    public void showAllTeams() {
    
            List<String> teamN ;
            List<Team> team = allTeams;
            
                for (int i = 0; i < team.size(); i++) {
                TeamName = team.get(i).getTeamCode();
                allTeamName(TeamName);
                AgencyName = team.get(i).getAgencyName();
                AgentName = team.get(i).getAgentName();
                StartDate = team.get(i).getStartDate();
                EndDate = team.get(i).getEndDate();
                TeamAgencyConnection(TeamName, AgencyName, AgentName,StartDate,EndDate);
                }
          
              teamN = perfectTeamNames();
              for (int i = 0; i < teamN.size(); i++) {
                
                  System.out.println(""+i+ ": Team Name :-> "+teamN.get(i));
                
              }
            userWish();
    
    }

    // ------------------------------------------------------------------------- //
    
    /**
     * Method to agency with most agents
     */
    public void agencyWithMostAgents() throws FileNotFoundException, IOException {
      
            List<String> allAgency = new ArrayList<>();
            List<String> Agencies = new ArrayList<>();
            List<Integer> No = new ArrayList<>();
            BufferedReader in = new BufferedReader(new FileReader("globalAgencies.txt"));
               
                String line;
               
                while((line = in.readLine()) != null)
                {
                    String o = decryptuinForAgency(line);
                    allAgency.add(o);
                }
                countAgencyPerTeam(allAgency);
                Agencies = getAgencyNamesInTeam();
                No=getCountAgencyNamesInTeam();
                int ind = getIndexOfBiggestNumber(No);
                System.out.println(" Agency "+Agencies.get(ind)+" with "+No.get(ind)+" Agents is Agency with most number of Agents");
                
                in.close();
                userWish();
    }

    // ------------------------------------------------------------------------- //
    
    /**
     * Method to decrypt
     */
    public String decryptuinForAgency(String Line)
    {
        
         HashMap<Integer,String> mapDecrypt = new HashMap();
    
        mapDecrypt.put(2,"A");
        mapDecrypt.put(3,"B");
        mapDecrypt.put(5,"C");
        mapDecrypt.put(7,"D");
        
        mapDecrypt.put(11,"E");
        mapDecrypt.put(13,"F");
        
        mapDecrypt.put(17,"G");
        mapDecrypt.put(19,"H");
      
        
        mapDecrypt.put(23,"I");
        mapDecrypt.put(29,"J");
        
        mapDecrypt.put(31,"K");
        mapDecrypt.put(37,"L");
        
        mapDecrypt.put(41,"M");
        mapDecrypt.put(43,"N");
        
        mapDecrypt.put(47,"O");
        mapDecrypt.put(53,"P");
        
        mapDecrypt.put(59,"Q");
        mapDecrypt.put(61,"R");
        
        mapDecrypt.put(67,"S");
        mapDecrypt.put(71,"T");
        
        mapDecrypt.put(73,"U");
        mapDecrypt.put(79,"V");
       
        mapDecrypt.put(83,"W");
        mapDecrypt.put(89,"X");
        
        mapDecrypt.put(97,"Y");
        mapDecrypt.put(101,"Z");
  
        String temp="";
        String DecryptedString="";
        String b_letter="";
        String c_letter="";
        
        String MISSION="";
        String COUNTRY="";
        String DATE="";
        String AGENCY="";
        int count = 0;
        int one;
        
         int length = Line.length();
         
         for (int i = 0; i < length; i++) {
            
             String a_letter = Character.toString(Line.charAt(i));
             //   System.out.print(" a_letter: "+a_letter);
             if (i+1 < length-1) {
                b_letter  = Character.toString(Line.charAt(i+1));
            }
             else
             {
                 b_letter  = "-";
             }
            if (i+2 < length-1)
            {
                c_letter = Character.toString(Line.charAt(i+2));
            }
            else
            {
                c_letter = "-";
            }
            
            if (count == 3) {
                
                 String getDateString = "";
              
                for (int i1=0;i1<8;i1++)
                {
                        
                    a_letter = Character.toString(Line.charAt(i));
                    getDateString = getDateString + "" +a_letter;
                    i++;
                   
                }
                String dateDecrypted = decryptionForDate(getDateString);    
                 
               DecryptedString = dateDecrypted;
               count ++;
               DecryptedString = "";
            }
            
             if ((!"/".equals(a_letter)) && (!",".equals(a_letter)) && (!"#".equals(a_letter))){
                 
                 // condition check
                 if((!" ".equals(a_letter)) && ("-".equals(b_letter)) && ("-".equals(c_letter)))
                 {
                 
                     one = Integer.parseInt(a_letter);
                     
                     
                        Iterator<Integer> keySetIterator = mapDecrypt.keySet().iterator();
        
                        while (keySetIterator.hasNext()) {
                        Integer key = keySetIterator.next();
                 
                        if (key == one) {
                
                        temp = mapDecrypt.get(key)+"";
                 
                                    }
                            }
                        
                        DecryptedString += temp; 
                     i = length+7;
                 }
                 
                 // condition check
                 if ((!"/".equals(b_letter)) && (!",".equals(b_letter)) && (!"#".equals(b_letter))) {
                  
                     if ((!"-".equals(b_letter)) && ("-".equals(c_letter)))
                     {
                        one = Integer.parseInt(a_letter);
                        one = one*10;
                        one = one + Integer.parseInt(b_letter);
                
                         Iterator<Integer> keySetIterator = mapDecrypt.keySet().iterator();
        
                        while (keySetIterator.hasNext()) {
                        Integer key = keySetIterator.next();
                 
                        if (key == one) {
                
                        temp = mapDecrypt.get(key)+"";
                 
                                    }
                            }
                        
                        DecryptedString += temp; 
                        i++;
                        i++;
                        
                      }
                     
                     
                     // condition check 1
                     if ("/".equals(c_letter))
                     {
                        one = Integer.parseInt(a_letter);
                        one = one*10;
                        one = one + Integer.parseInt(b_letter);
                
                         Iterator<Integer> keySetIterator = mapDecrypt.keySet().iterator();
        
                        while (keySetIterator.hasNext()) {
                        Integer key = keySetIterator.next();
                 
                        if (key == one) {
                
                        temp = mapDecrypt.get(key)+"";
                 
                                    }
                            }
                        
                        DecryptedString += temp; 
                        i++;
                        i++;
                        
                      }
                     
                     // condition check 2
                     if (",".equals(c_letter))
                     {
                        one = Integer.parseInt(a_letter);
                        one = one*10;
                        one = one + Integer.parseInt(b_letter);
                
                         Iterator<Integer> keySetIterator = mapDecrypt.keySet().iterator();
        
                        while (keySetIterator.hasNext()) {
                        Integer key = keySetIterator.next();
                 
                        if (key == one) {
                
                        temp = mapDecrypt.get(key)+"";
                 
                                    }
                            }
                        
                        DecryptedString += temp; 
                        i++;
                        i++;
                        
                        switch (count) {
                    case 0:
                        Agenrt_NAME = DecryptedString;
                        DecryptedString = "";
                        count++;
               
                        break;
                    case 1:
                        MISSION = DecryptedString;
                        DecryptedString = "";
                        count++;
               
                        break;
                    case 2:
                        COUNTRY = DecryptedString;
                        DecryptedString = "";
                        count++;
               
                        break;
                    case 3:
                        String getDateString = "";
              
                        for (int i1=0;i1<Line.length();i1++)
                        {
                        a_letter = Character.toString(Line.charAt(i));
                        getDateString = getDateString + "" +a_letter;
                        i++;
                        }
                        String dateDecrypted = decryptionForDate(getDateString);    
                 
                        DecryptedString = dateDecrypted;
                        count ++;
            
                        break;
                    case 4:
                        AGENCY = DecryptedString;
                        DecryptedString = "";
                        count++;
                        break;
                    default:
                        break;
                        }    
                     }
                     
                     // condition check 3
                     if("#".equals(c_letter))
                     {
                        one = Integer.parseInt(a_letter);
                        one = one*10;
                        one = one + Integer.parseInt(b_letter);
                
                         Iterator<Integer> keySetIterator = mapDecrypt.keySet().iterator();
        
                        while (keySetIterator.hasNext()) {
                        Integer key = keySetIterator.next();
                 
                        if (key == one) {
                
                        temp = mapDecrypt.get(key)+"";
                 
                                    }
                            }
                        
                        DecryptedString += temp; 
                        DecryptedString += " ";
                        i++;
                        i++;
                        
                     }
                  
                 }
                 // condition check 4
                 if("/".equals(b_letter))
                 {
                        one = Integer.parseInt(a_letter);
                        
                        Iterator<Integer> keySetIterator = mapDecrypt.keySet().iterator();
        
                        while (keySetIterator.hasNext()) {
                        Integer key = keySetIterator.next();
                 
                        if (key == one) {
                
                        temp = mapDecrypt.get(key)+"";
                 
                                    }
                            }
                        
                        DecryptedString += temp; 
                        i++;
                     
                 }
                 // condition check 5
                 if("#".equals(b_letter))
                 {
                        one = Integer.parseInt(a_letter);
                        
                        Iterator<Integer> keySetIterator = mapDecrypt.keySet().iterator();
        
                        while (keySetIterator.hasNext()) {
                        Integer key = keySetIterator.next();
                 
                        if (key == one) {
                
                        temp = mapDecrypt.get(key)+"";
                 
                                    }
                            }
                        
                        DecryptedString += temp; 
                        DecryptedString = DecryptedString + " ";
                        i++;
                        
                 }
                 // condition check 6
                 if (",".equals(b_letter))
                     {
                        one = Integer.parseInt(a_letter);
                        
                        Iterator<Integer> keySetIterator = mapDecrypt.keySet().iterator();
        
                        while (keySetIterator.hasNext()) {
                        Integer key = keySetIterator.next();
                 
                        if (key == one) {
                
                        temp = mapDecrypt.get(key)+"";
                 
                                    }
                            }
                        
                        DecryptedString += temp; 
                        i++;
                        
                        switch (count) {
                    case 0:
                        Agenrt_NAME = DecryptedString;
                        DecryptedString = "";
                        count++;
                        break;
                    
                    case 1:
                        MISSION = DecryptedString;
                        DecryptedString = "";
                        count++;
                        break;
                    
                    case 2:
                        COUNTRY = DecryptedString;
                        DecryptedString = "";
                        count++;
                        break;
              
                    case 3:
                        String getDateString = "";
              
                        for (int i1=0;i1<Line.length();i1++)
                        {
                        a_letter = Character.toString(Line.charAt(i));
                        getDateString = getDateString + "" +a_letter;
                        i++;
               
                        }
                        String dateDecrypted = decryptionForDate(getDateString);    
                        DecryptedString = dateDecrypted;
                        count ++;
                        break;
            
                    case 4:
                          System.out.print(" a_letter: "+a_letter);
                          System.out.print(" b_letter: "+b_letter);
                          System.out.print(" c_letter: "+c_letter);
                        AGENCY = DecryptedString;
                        DecryptedString = "";
                        count++;
               
                        break;
                    default:
                        break;
                        }    
                     }
                 
             }
             // condition check 7
             if ((!"/".equals(a_letter)) && (!",".equals(a_letter)) && ("#".equals(a_letter))) {
                 
                        DecryptedString += " ";
               
                        
                  
             }
            
        }
         return DecryptedString;
    }

    // ------------------------------------------------------------------------- //
    
    /**
     * Method to calculate Team Agency Relation
     */
    public void teamAgencyRelation() {
    
        List<String> ag = new ArrayList<>();
        
            clearTeamAgencyConnections();
            List<Team> Tname = showTeam();
            for (int i = 0; i < Tname.size(); i++) {
             
                TeamName = Tname.get(i).getTeamCode();
                allTeamName(TeamName);
                AgencyName = Tname.get(i).getAgencyName();
                AgentName = Tname.get(i).getAgentName();
                StartDate = Tname.get(i).getStartDate();
                EndDate = Tname.get(i).getEndDate();
                TeamAgencyConnection(TeamName, AgencyName, AgentName,StartDate,EndDate);
                }
                allTeamNames = perfectTeamNames();
                System.out.println(" No of teams "+allTeamNames.size());
                for (int i = 0; i < allTeamNames.size(); i++) {
                
                    System.out.println(""+i+ ": Team Name :-> "+allTeamNames.get(i));
                }
                
                Scanner scr = new Scanner(System.in);
                System.out.println("Enter Team Number Appeared Before TeamName:-> ");
                int choice = scr.nextInt();
                
                if (choice > allTeamNames.size()-1) {
                System.out.println("Invalid Option Selected. Try Again");   
                System.out.println("IF YOUR INPUT IS WRONG ONE MORE TIME , PROGRAE WILL CLOSE.");       
                System.out.println("Enter Team Number Appeared Before TeamName:-> ");
                 
                choice = scr.nextInt();
                        
                         if (choice > allTeamNames.size()-1) {
                
                             System.out.println("PROGRAME CLOSE :- WRONG ATTEMPTS");
                             
                    }
                }
               
                    ag.clear();
                    
                    ag = AgencyofTeam(allTeamNames.get(choice));
                    System.out.println(" Team Name :-> "+allTeamNames.get(choice));
                    
                    for (int j = 0; j < ag.size(); j++) {
                         System.out.println(" Agency Name :-> "+ag.get(j));
                    }
                
                countAgencyPerTeam(ag);
                List<String> tempo = getAgencyNamesInTeam();
                List<Integer> tempoo = countAgencyNamesInTeam;
               
                    
                int index = getIndexOfBiggestNumber(tempoo);

                         System.out.println(" Team belong to :-> "+tempo.get(index)+" Agency");
                        
                         userWish();
                   }

    // ------------------------------------------------------------------------- //
    
    /**
     * Method to calculate Team Agent Agency relation
     */
    public void teamAgentAgencyRelation() {
        List<String> ag = new ArrayList<>();
            List<Team> Teamname = showTeam();
            for (int i = 0; i < Teamname.size(); i++) {
             
                TeamName = Teamname.get(i).getTeamCode();
                allTeamName(TeamName);
                AgencyName = Teamname.get(i).getAgencyName();
                AgentName = Teamname.get(i).getAgentName();
                StartDate = Teamname.get(i).getStartDate();
                EndDate = Teamname.get(i).getEndDate();
                TeamAgencyConnection(TeamName, AgencyName, AgentName,StartDate,EndDate);
                }
                List<String> agents = new ArrayList<>();
                allTeamNames = perfectTeamNames();
                System.out.println(" No of teams "+allTeamNames.size());
                for (int i = 0; i < allTeamNames.size(); i++) {
                
                    System.out.println(""+i+ ": Team Name :-> "+allTeamNames.get(i));
                }
                
                Scanner scrn = new Scanner(System.in);
                System.out.println("Enter Team Number Appeared Before TeamName:-> ");
                int choice1 = scrn.nextInt();
                
                if (choice1 > allTeamNames.size()-1) {
                System.out.println("Invalid Option Selected. Try Again");   
                System.out.println("IF YOUR INPUT IS WRONG ONE MORE TIME , PROGRAE WILL CLOSE.");       
                System.out.println("Enter Team Number Appeared Before TeamName:-> ");
                 
                choice1 = scrn.nextInt();
                        
                         if (choice1 > allTeamNames.size()-1) {
                
                             System.out.println("PROGRAME CLOSE :- WRONG ATTEMPTS");
                             
                    }
                }
               
                    ag.clear();
                    
                    ag = AgencyofTeam(allTeamNames.get(choice1));
                    agents=AgentofTeam(allTeamNames.get(choice1));
                    System.out.println(" Team Name :-> "+allTeamNames.get(choice1));
                    
                    for (int j = 0; j < ag.size(); j++) {
                         System.out.println(" Agency Name :-> "+ag.get(j) +" Agent Name :-> "+agents.get(j));
                    }
            
            userWish();}

    // ------------------------------------------------------------------------- //
    
    /**
     * Method to calculate Team status
     */
    public void teamStatus() {
        
            List<String> teamNames ;
            List<Team> tname = showTeam();
            
                for (int i = 0; i < tname.size(); i++) {
                TeamName = tname.get(i).getTeamCode();
                allTeamName(TeamName);
                AgencyName = tname.get(i).getAgencyName();
                AgentName = tname.get(i).getAgentName();
                StartDate = tname.get(i).getStartDate();
                EndDate = tname.get(i).getEndDate();
                TeamAgencyConnection(TeamName, AgencyName, AgentName,StartDate,EndDate);
                }
                Scanner scrn1 = new Scanner(System.in);
                teamNames = perfectTeamNames();
                
                System.out.println("Enter Date to be checked: ");
                int date = scrn1.nextInt();
                for (int i1 = 0; i1 < teamNames.size(); i1++) {
                String status1 = teamActiveSatus(teamNames.get(i1), date);
                  
                    if (status1.equals("Active")) {
                          System.out.println(""+i1+ ": Team Name :-> "+teamNames.get(i1)+" Status:-> "+status1);
                    }
                }
           
            userWish();
    }
}
