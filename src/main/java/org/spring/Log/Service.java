package org.spring.Log;

import org.spring.Config;
import org.spring.User.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.UUID;
public class Service {
    String id;
    Connection connection;
    public Service() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        this.connection= DriverManager.getConnection(Config.url, Config.username, Config.password);
    }
   public ResponseEntity<String> setLog(Log log)  {
        try {
            id = UUID.randomUUID().toString().replace("-", "").substring(0, 9);
            int res = this.connection.createStatement().executeUpdate("insert into sessionlog values('"+id+"','"+log.getLogtype()+"','"+log.getLogdescription()+"','"+log.getUserid()+"',now());");
            if (res==0){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch(Exception ex){
           ex.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    public ResponseEntity<List<Log>> getLogById(String userId){
        List<Log> data = new ArrayList<>();
        Log log ;
        try{
            String sql = "select sessionlog.logid,sessionlog.logtype,sessionlog.logdescription , sessionlog.createdat,users.username from sessionlog inner join users on users.userid=sessionlog.userid where sessionlog.userid='"+userId+"';";

            ResultSet rs = connection.createStatement().executeQuery(sql);
            User u ;
            while(rs.next()){
                log = new Log();
                log.setLogid(rs.getString("logid"));
                log.setLogdescription(rs.getString("logdescription"));
                log.setLogtype(rs.getString("logtype"));
                log.setCreatedat(rs.getDate("createdat"));
                log.setUserid(userId);
                u = new User();
                u.setUserid(rs.getString("username"));
                log.setUser(u);
                data.add(log);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
  public ResponseEntity<List<Log>> getSuperAdminLog(){
       List<Log> data = new ArrayList<>();
       Log log ;
       try{
           String sql = "select sessionlog.logid,sessionlog.logtype,sessionlog.logdescription , sessionlog.createdat,users.username ,users.userid ,users.username from sessionlog inner join users on users.userid=sessionlog.userid ;";
           ResultSet rs = connection.createStatement().executeQuery(sql);
           User u ;
           while(rs.next()){
               log = new Log();
               log.setLogid(rs.getString("logid"));
               log.setLogdescription(rs.getString("logdescription"));
               log.setLogtype(rs.getString("logtype"));
               log.setCreatedat(rs.getDate("createdat"));
               log.setUserid(rs.getString("userid"));
               u = new User();
               u.setUserid(rs.getString("userid"));
               u.setUsername(rs.getString("username"));
               log.setUser(u);
               data.add(log);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return new ResponseEntity<>(data, HttpStatus.OK);
    }

}
