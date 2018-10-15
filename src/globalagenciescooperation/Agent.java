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
public class Agent {
    
    String agentName;
    String agencyName;
    //String[] allAgent ;

    public Agent(String agentName, String agencyName) {
        this.agentName = agentName;
        this.agencyName = agencyName;
    }

  

    Agent(String shivam, String gia, Agent agent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }
    
}
