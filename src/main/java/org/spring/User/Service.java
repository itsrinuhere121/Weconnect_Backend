package org.spring.User;

import org.spring.Config;
import org.spring.Log.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.UUID;

public class Service {
    final Connection connection;
    int res;
    String id;
    public Service() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        this.connection= DriverManager.getConnection(Config.url);
    }
   public ResponseEntity<String> setUser(User user){
        HttpStatus status;
       Log  log = new Log();
       org.spring.Log.Service l = null;
      try {
          id = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
          int h = (user.getUsername() + user.getPassword()).hashCode();
          user.setUserid(id);
          String sql = "insert into users values ('" + id+ "','"+user.getUsername()+"','" + user.getPassword() + "','" + h + "');";
         res =this.connection.createStatement().executeUpdate(sql);

          if(res==0){
              status = HttpStatus.INTERNAL_SERVER_ERROR;
              log.setLogdescription("Internal Server Error");
          }else{
              status = HttpStatus.CREATED;
              log.setLogdescription(user.getUserid()+" has  user create "+user.getUsername());
          }
          log.setUserid(user.getUserid());
          l = new org.spring.Log.Service();
      }catch(Exception ex){
          ex.printStackTrace();
          log.setLogdescription("Internal Error");
          status = HttpStatus.INTERNAL_SERVER_ERROR;
      }
      finally{
          log.setLogtype("create");
          assert l != null;
          l.setLog(log);
      }
      return new ResponseEntity<>(status);
    }
}
