/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import DAO.CustomerDAO;
import DAO.InterfaceCustomerDAO;
import model.CustomerModel;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Administrator
 */
public class CustomerController {
    
    InterfaceCustomerDAO cd= new CustomerDAO();
    
    public CustomerModel getCustomer(long ssn) throws SQLException{
    
       return cd.getCustomer(ssn);
       
    }
    
    public boolean insertCustomer(CustomerModel customer) throws SQLException{
    
      return  cd.insertCustomer(customer); 
    }
    
    public boolean updatetCustomer(CustomerModel customer) throws SQLException{
    
      return  cd.updateCustomer(customer); 
    }
    
    
    public boolean deleteCustomer(int id) throws SQLException{
    
      return  cd.deleteCustomer(id); 
    }
    
    public ArrayList<CustomerModel> getAllCustomers() throws SQLException{
    
      return  cd.getAllCustomers(); 
    }
}
