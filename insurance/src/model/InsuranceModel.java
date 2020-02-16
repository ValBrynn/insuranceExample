/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Administrator
 */
public class InsuranceModel {
    
    private int customerID;
    private double cost;
    private String insuranceType;
    
    public InsuranceModel(double cost,String insuranceType, int customerID){
        
        this.customerID=customerID;
        this.cost=cost;
        this.insuranceType=insuranceType;
    }
    
    public int getCustomerId() {
        return customerID;
    }

    public void setCustomerId(int customerID){
        this.customerID = customerID;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    @Override
    public String toString() {
        return "{" + "customerID=" + customerID + ", cost=" + cost + ", insuranceType=" + insuranceType + '}'+"\n";
    }
    
    
    
}
