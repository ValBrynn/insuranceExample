/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.InsuranceDAO;
import DAO.InterfaceInsuranceDAO;
import model.InsuranceModel;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Administrator
 */
public class InsuranceController {
    
    InterfaceInsuranceDAO insurance=new InsuranceDAO();
    
    public ArrayList<InsuranceModel> getInsurance (long ssn) throws SQLException{
    
     return insurance.getInsurance(ssn);
    }
    
    public boolean insertInsurance(InsuranceModel insurance,long ssn) throws SQLException{
    
      return this.insurance.insertInsurance(insurance, ssn);
    } 
    
    public boolean deleteInsurance(String insuranceType, long ssn) throws SQLException{
    
           return insurance.deleteInsurance(insuranceType, ssn);
    }
}
