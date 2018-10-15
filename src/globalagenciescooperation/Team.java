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
public class Team extends Agent{
    
    String teamCode;
    String startDate;
    String endDate;

    public Team(String agentName, String agencyName) {
        super(agentName, agencyName);
    }

    public Team(String teamCode, String startDate, String endDate, String agentName, String agencyName) {
        super(agentName, agencyName);
        this.teamCode = teamCode;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String getAgentName() {
        return agentName;
    }

    @Override
    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    @Override
    public String getAgencyName() {
        return agencyName;
    }

    @Override
    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }
    
    
    
}
