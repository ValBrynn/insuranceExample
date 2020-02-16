/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dbConnection.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.InsuranceModel;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class InsuranceDAO implements InterfaceInsuranceDAO {

    @Override
    public ArrayList<InsuranceModel> getInsurance(long ssn) throws SQLException {
        Connection conn = db.getConnection();
        ArrayList<InsuranceModel> insuranceList=null;
        int id = 0;
        try {
            String customerQuery = "SELECT customer.id FROM customer WHERE ssn=?";
            PreparedStatement stmt = conn.prepareStatement(customerQuery);
            stmt.setLong(1, ssn);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {

                id = rs.getInt("id");

            }

            String query = "SELECT insurance.cost, insurance.insuranceType, insurance.customerID FROM insurance WHERE customerID=?";
            PreparedStatement stmtQ = conn.prepareStatement(query);
            stmtQ.setInt(1, id);
            ResultSet rsQ = stmtQ.executeQuery();
            insuranceList=new ArrayList<>();
            while(rsQ.next()) {
                
                double cost = rsQ.getDouble("cost");
                String insuranceType = rsQ.getString("insuranceType");
                int customerID = rsQ.getInt("customerID");
                
                 
                insuranceList.add(new InsuranceModel(cost, insuranceType, customerID));
               
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return insuranceList;
    }

    @Override
    public boolean insertInsurance(InsuranceModel insurance, long ssn) throws SQLException {
        Connection conn = db.getConnection();
        int id = 0;
        try {
            String customerQuery = "SELECT customer.id FROM customer WHERE ssn=?";
            PreparedStatement stmt = conn.prepareStatement(customerQuery);
            stmt.setLong(1, ssn);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {

                id = rs.getInt("id");

            }

            PreparedStatement ps = conn.prepareStatement("INSERT INTO insurance(cost,insuranceType,customerID) VALUES ( ?, ?, ?)");
            ps.setDouble(1, insurance.getCost());
            ps.setString(2, insurance.getInsuranceType());
            ps.setInt(3, id);
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return true;
    }

    @Override
    public boolean deleteInsurance(String insuranceType,long ssn) throws SQLException {
        Connection conn = db.getConnection();
        int id=0;
        try {
            String customerQuery = "SELECT customer.id FROM customer WHERE ssn=?";
            PreparedStatement stmt = conn.prepareStatement(customerQuery);
            stmt.setLong(1, ssn);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {

                id = rs.getInt("id");

            }
            PreparedStatement ps = conn.prepareStatement("DELETE FROM insurance WHERE customerID=? AND insuranceType=?");
            ps.setInt(1, id);
            ps.setString(2, insuranceType);
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
