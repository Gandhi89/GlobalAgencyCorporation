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
public class TeamAgencyConnection {
    
    String teamName;
    String agencyName;
    String agentName;
    String startDate;
    String endDate;

    TeamAgencyConnection(String team, String agency,String Name, String sDate,String eDate) {
       teamName = team;
       agencyName = agency;
       agentName =  Name;
       startDate = sDate;
       endDate = eDate;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String AgencyName) {
        this.agencyName = AgencyName;
    }
    
    
}
