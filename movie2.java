import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;  
import java.util.*;
import java.sql.DatabaseMetaData;  
public class movie2
{
Connection conn = null;
public void insert()
{
try
{
ResultSet rs = null;
Statement stmt = null;
// JDBC-SQLITE CONNECTION
String url = "jdbc:sqlite:C:/Program Files/DB Browser for SQLite/movie.db";
conn = DriverManager.getConnection(url);
System.out.println("JDBC-SQLITE CONNECTED");
stmt = conn.createStatement();

//CREATING TABLE BY USING JAVA
String query = "create table movies(sr integer not null primary key,movie text not null,actor  text not null,actress text not null,year integer not null,director  text not null)";
stmt.execute(query);
System.out.println("TABLE CREATED");

//INSERTING VALUES BY USING JAVA
String query3 = "insert into movies(sr,movie,actor,actress,year,director)values(1,'3Idiots','Amir khan ','kareena ','2009 ', 'Rajkumar ')";
stmt.execute(query3);
String query4 = "insert into movies(sr,movie,actor,actress,year,director)values(2,'ballbottom','akshay ','rohika ','2021 ', 'ram ')";
stmt.execute(query4);
String query5 = "insert into movies(sr,movie,actor,actress,year,director)values(3,'Bajrangi Bhaijan','Salman ','Kareena ','2015 ', 'kabir ')";
stmt.execute(query5);
String query6 = "insert into movies(sr,movie,actor,actress,year,director)values(4,'Tanhaji: The Unsung Warrior','Ajay ','Kajol ','2020', 'om raut ')";
stmt.execute(query6);
String query7 = "insert into movies(sr,movie,actor,actress,year,director)values(5,'Thappad','Ram ','Tapsee','2020 ', 'karan')";
stmt.execute(query7);
String query8 = "insert into movies(sr,movie,actor,actress,year,director)values(6,'Panga ','Jassie ','Kangana ','2020 ', 'rohit')";
stmt.execute(query8);
String query9 = "insert into movies(sr,movie,actor,actress,year,director)values(7,'Dil bechara','sushant ','sanjana','2020 ', 'om raut')";
stmt.execute(query9);
String query10 = "insert into movies(sr,movie,actor,actress,year,director)values(8,'Chichore','sushant ','shradha','2019', 'rohit')";
stmt.execute(query10);

// RETRIEVING DATA FROM DATABASE
String query1 = "select * from movies";
rs = stmt.executeQuery(query1);
while (rs.next()) {
 int sr =rs.getInt("sr");
String movie = rs.getString("movie");
String actor = rs.getString("actor");
String actress= rs.getString("actress");
int year = rs.getInt("year");
String director = rs.getString("director");
System.out.println(" sr : "  + sr + " || " + " Movie : "  + movie  + " || " + " Actor : " + actor + " || " +  " Actress : "  + actress  +  " || " + " Year : " + year + " || " + " Director "  + director );
 }
}
catch (SQLException e1) {
  System.out.println(e1.getMessage());
  } 
finally {
            try {
                if (conn != null)
                  {
                    conn.close();
                }
            } 
              catch (SQLException ex) {
                System.out.println(ex.getMessage());
             }
        }
}
public static void main(String[] args) 
{
movie2 m = new movie2();
       m.insert();
       
    }
}