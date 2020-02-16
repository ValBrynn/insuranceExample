/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import model.InsuranceModel;

/**
 *
 * @author Administrator
 */
public interface InterfaceInsuranceDAO {
    
    ArrayList<InsuranceModel> getInsurance(long ssn) throws SQLException;
    boolean insertInsurance(InsuranceModel insurance, long ssn)throws SQLException;
    boolean deleteInsurance(String insuranceType,long ssn)throws SQLException;
    
}
