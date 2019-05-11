/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mahmo
 */
public class Connnections {
    public static void main(String[] args) {
        
                IntializeJdbc("Essssss", "1568", "male",(Integer.parseInt("15")));

    }
            private static PreparedStatement st;
    private static void IntializeJdbc(String name , String pass , String gender , int age){

    try {
            
            // *********** Load The JDBC Driver ***********
            Class.forName("com.mysql.jdbc.Driver");
            
            // *********** Establish Connection ***********
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/smart", "root", "");
            
            // *********** Create Statement ***************
            st=con.prepareStatement("INSERT into personaldata (name,password,gender,age) values ('"+name+"','"+pass+"','"+gender+"',"+age+")");
              /*
        st.setString(1, name);
        st.setString(2, pass);
        st.setString(3, gender);
        st.setInt(4, age);*/
        st.executeUpdate();
        } catch (Exception ex) {
            
            System.out.println("at method connection  = "+ ex);
        }
    }        
    
}
