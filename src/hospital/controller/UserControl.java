package hospital.controller;

import hospital.model.User;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;






public class UserControl {

    private Statement st;
    ResultSet rs;

    public void insert(User user) {
        try {
            st = DBconnect.getCon().createStatement();
            st.executeUpdate("INSERT into patient (fname,lname,age) values ('" + user.getFname() + "','" + user.getLname() + "','" + user.getAge() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(UserControl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Update(User user) {
        try {
            st = DBconnect.getCon().createStatement();
            st.executeUpdate("update patient set   fname = '" + user.getFname() + "'   , lname='" + user.getLname() + "'  ,    age=" + user.getAge() + "  where id=" + user.getId() + "    ");
        } catch (SQLException ex) {
            Logger.getLogger(UserControl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Delete(int id) {
        try {
            st = DBconnect.getCon().createStatement();
            st.executeUpdate("delete from patient where id=" + id + "");
        } catch (SQLException ex) {
            Logger.getLogger(UserControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

    public ObservableList<User> getData() {
        ObservableList<User> us = FXCollections.observableArrayList();
        
        try {
            st = DBconnect.getCon().createStatement();
            String query = "select * from patient";
            rs = st.executeQuery(query);
            rs.beforeFirst();
            
            while(rs.next()){
                User user=new User();
                user.setId(rs.getInt(1));
                user.setFname(rs.getString(2));
                user.setLname(rs.getString(3));
                user.setAge(rs.getInt(4));
                us.add(user);
             
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(us);
        return us;
            
    }
    
    public ObservableList<User> search(String name) {
        ObservableList<User> us = FXCollections.observableArrayList();
        
        try {
            st = DBconnect.getCon().createStatement();
            String query = "select * from patient where fname like '%"+name+"%'";
            rs = st.executeQuery(query);
            rs.beforeFirst();
            
            while(rs.next()){
                User user=new User();
                user.setId(rs.getInt(1));
                user.setFname(rs.getString(2));
                user.setLname(rs.getString(3));
                user.setAge(rs.getInt(4));
                us.add(user);
             
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(us);
        return us;
            
    }
    
}
