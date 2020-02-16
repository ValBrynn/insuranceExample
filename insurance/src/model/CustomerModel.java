/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class CustomerModel {
    

    private String firstName;
    private String lastName;
    private long ssn ;
    private ArrayList<InsuranceModel> insuranceList;
    
    public CustomerModel(String firstName,String lastName,long ssn){
    
        this.firstName=firstName;
        this.lastName=lastName;
        this.ssn=ssn;
        insuranceList=new ArrayList<>();
    }
   
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getSSN() {
        return ssn;
    }

    public void setSSN(int ssn) {
        this.ssn = ssn;
    }
    
    public void addInsurance(InsuranceModel insurance){
    
          insuranceList.add(insurance);
    }
    
    public ArrayList<InsuranceModel> getInsurance(){
    
           return (ArrayList<InsuranceModel>)insuranceList.clone();
    }

    @Override
    public String toString() {
        return "{" + "firstName=" + firstName + ", lastName=" + lastName + ", SSN=" + ssn + ", insuranceList=" + insuranceList + "}" +"\n";
    }
    
    
}
