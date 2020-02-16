/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import model.CustomerModel;
import java.sql.*;
import dbConnection.db;
import model.InsuranceModel;

/**
 *
 * @author Administrator
 */
public class CustomerDAO implements InterfaceCustomerDAO {

    @Override
    public CustomerModel getCustomer(long ssn) throws SQLException {
        Connection conn = db.getConnection();
        CustomerModel customer = null;
        try {
            String query = "SELECT * FROM customer,insurance WHERE ssn=? AND customerID=id";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setLong(1, ssn);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String fName = rs.getString("firstName");
                String lName = rs.getString("lastName");
                customer = new CustomerModel(fName, lName, ssn);

                do {
                    double cost = rs.getDouble("cost");
                    String insuranceType = rs.getString("insuranceType");
                    int cID = rs.getInt("customerID");
                    InsuranceModel iM = new InsuranceModel(cost, insuranceType, cID);
                    customer.addInsurance(iM);
                } while (rs.next());

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return customer;
    }

    private CustomerModel extractCustomerFromResultSet(ResultSet rs) throws SQLException {

        String fName = rs.getString("firstName");
        String lName = rs.getString("lastName");
        long ssn = rs.getLong("ssn");
        CustomerModel customer = new CustomerModel(fName, lName, ssn);
        return customer;
    }

    @Override
    public ArrayList<CustomerModel> getAllCustomers() throws SQLException {
        Connection conn = db.getConnection();
        ArrayList<CustomerModel> customers = new ArrayList<>();
        try {
            String query = "SELECT * FROM customer";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                CustomerModel customer = extractCustomerFromResultSet(rs);
                customers.add(customer);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return customers;
    }

    @Override
    public boolean insertCustomer(CustomerModel customer) throws SQLException {
        Connection conn = db.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO customer(firstName,lastName,ssn) VALUES ( ?, ?, ?)");
            //ps.setInt(1, customer.getId());
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setLong(3, customer.getSSN());
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateCustomer(CustomerModel customer) throws SQLException {
        Connection conn = db.getConnection();
        try {

            PreparedStatement ps = conn.prepareStatement("UPDATE customer SET firstName=?, lastName=? WHERE ssn=?");
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setLong(3, customer.getSSN());
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCustomer(long ssn) throws SQLException {

        Connection conn = db.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM customer WHERE ssn=?");
            ps.setLong(1, ssn);
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
