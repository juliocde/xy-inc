package br.com.zup.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
import br.com.zup.model.Products;

/**
 * Classe responsavel pelas conexões JDBC
 * @author Julio Escobar
 * @since 19/07/2016
 */

 
public class Connect {
       Connection con = null;
 
       public Connect() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
             String url = "jdbc:mysql://localhost:3306/zup";
             String products = "root";
             String password = "123456";
 
        Class.forName("com.mysql.jdbc.Driver").newInstance();
             con = DriverManager.getConnection(url, products, password);
       }
 
       public void closeConnection() throws SQLException {
             con.close();
       }
 
       public void insertProducts(Products products) {
 
             try {
 
                    PreparedStatement preparedStatement = con
                                  .prepareStatement("insert products (id, name, description, price, category) values(?,?,?,?,?)");
                    preparedStatement.setInt(1, products.getId());
                    preparedStatement.setString(2, products.getName());
                    preparedStatement.setString(3, products.getDescription());
                    preparedStatement.setDouble(4, products.getPrice());
                    preparedStatement.setString(5, products.getCategory());
                    preparedStatement.execute();
 
             } catch (SQLException ex) {
                    Logger lgr = Logger.getLogger(Connect.class.getName());
                    lgr.log(Level.SEVERE, ex.getMessage(), ex);
 
             }
       }
 
       public Products getProducts() {
 
             Products products = null;
             try {
 
                    PreparedStatement preparedStatement = con
                                  .prepareStatement("select * from products");
 
                    ResultSet rs = preparedStatement.executeQuery();
 
                    if (rs.next()) {
 
                           products = new Products();
                           products.setId(rs.getInt(1));
                           products.setName(rs.getString(2));
                           products.setDescription(rs.getString(3));
                           products.setPrice(rs.getDouble(4));
                           products.setCategory(rs.getString(5));
 
                    }
 
             } catch (SQLException ex) {
                    Logger lgr = Logger.getLogger(Connect.class.getName());
                    lgr.log(Level.SEVERE, ex.getMessage(), ex);
 
             }
             return products;
       }
       
       public Products getProductsById(int id) {
    	   
           Products products = null;
           try {

                  PreparedStatement preparedStatement = con
                                .prepareStatement("select * from products where id = ?");
                  preparedStatement.setInt(1, id);

                  ResultSet rs = preparedStatement.executeQuery();

                  if (rs.next()) {

                         products = new Products();
                         products.setId(rs.getInt(1));
                         products.setName(rs.getString(2));
                         products.setDescription(rs.getString(3));
                         products.setPrice(rs.getDouble(4));
                         products.setCategory(rs.getString(5));

                  }

           } catch (SQLException ex) {
                  Logger lgr = Logger.getLogger(Connect.class.getName());
                  lgr.log(Level.SEVERE, ex.getMessage(), ex);

           }
           return products;
     }
       
       
       public void deleteProducts(int id) {
 
             try {
 
                    PreparedStatement preparedStatement = con
                                  .prepareStatement("delete from products where id = ?");
                    preparedStatement.setInt(1, id);
 
                    preparedStatement.execute();
 
             } catch (SQLException ex) {
                    Logger lgr = Logger.getLogger(Connect.class.getName());
                    lgr.log(Level.SEVERE, ex.getMessage(), ex);
 
             }
       }
       
       public void editProducts(Products products) {
    	   
           try {

                  PreparedStatement preparedStatement = con
                                .prepareStatement("update products set name = ?, description = ?, price = ?, category = ? where id = ?");
                  preparedStatement.setString(1, products.getName());
                  preparedStatement.setString(2, products.getDescription());
                  preparedStatement.setDouble(3, products.getPrice());
                  preparedStatement.setString(4, products.getCategory());
                  preparedStatement.setInt(5, products.getId());

                  preparedStatement.execute();

           } catch (SQLException ex) {
                  Logger lgr = Logger.getLogger(Connect.class.getName());
                  lgr.log(Level.SEVERE, ex.getMessage(), ex);

           }
     }
}