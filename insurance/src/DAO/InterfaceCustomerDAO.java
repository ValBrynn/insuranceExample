/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.CustomerModel;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author Administrator
 */
public interface InterfaceCustomerDAO {
    
    CustomerModel getCustomer(long ssn) throws SQLException;
    ArrayList<CustomerModel> getAllCustomers() throws SQLException;
    boolean insertCustomer(CustomerModel customer)throws SQLException;
    boolean updateCustomer(CustomerModel customer)throws SQLException;
    boolean deleteCustomer(long ssn)throws SQLException;
}
