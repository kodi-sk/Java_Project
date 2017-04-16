package models;

import java.text.*;

import java.util.*;
import java.sql.*;

public class userDao {
	static Connection currentCon = null;
	static ResultSet rs = null;
	
	public static user login(user u){
			    
		String username = u.getName();    
		String password = u.getPass();
		//Date regDate= u.getregDate();
		//String email = u.getEmail();
		Statement stmt = null;

		String searchQuery = "select * from Student where username=" + "'" + username + "'" + " and password ='" + password + "'";
		 
		 try{
			 currentCon = ConnectionManager.getConnection();
	         stmt=currentCon.createStatement();
	         rs = stmt.executeQuery(searchQuery);
	         if (rs.next()) {
	        	u.setValid(true);
	        	u.setName(rs.getString("username"));
	        	u.setRegDate(rs.getDate("regDate"));
	        	u.setEmail(rs.getString("email"));
	         } /*else {
	        	 u.setValid(false);
	             System.out.println("Invalid password ");
	         }*/

		 }
		 catch(Exception e){}
		
		return u;	
	}
	public static ArrayList<Company> show(){
		//Company c[] =  null;
		ArrayList<Company> c=new ArrayList<Company>();
		try{
			currentCon = ConnectionManager.getConnection();
			Statement st = currentCon.createStatement();
			rs = st.executeQuery("select * from Company");
			//c = new Company[4];
			while(rs.next()){
				Company a = new Company();
				//c[i] = new Company();
				a.setCname(rs.getString("Cname"));
				a.setCid(rs.getInt("Cid"));
				a.setCpackage(rs.getInt("package"));
				a.setCount(rs.getInt("count"));
				c.add(a);
			}
		}
		catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        } 
		finally {
            if (currentCon != null) {
                try {
                	currentCon.close();
                	}
                catch (SQLException ex) {
                    ex.printStackTrace();
            	}
            }
        }
		return c;
	}
	public static void IncCount(Company c){
		try{
			currentCon = ConnectionManager.getConnection();
			Statement st = currentCon.createStatement();
			int p = st.executeUpdate("update Company set count=count+1 where Cid = " + c.getCid());
			System.out.println(p);
		}
		catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        } 
		finally {
            if (currentCon != null) {
                try {
                	currentCon.close();
                	}
                catch (SQLException ex) {
                    ex.printStackTrace();
            	}
            }
        }
	}
	/*public static void main(String args[]){
		Company allcomp[] = null;
		user u = new user();
		u=login(u);
		allcomp = userDao.show();
		IncCount(allcomp[0]);
	}*/
}
