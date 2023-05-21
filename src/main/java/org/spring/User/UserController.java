package org.spring.User;

import org.spring.Log.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(value="user")
public class UserController {
    protected Service userService;
    org.spring.Log.Service logservice ;;//= new org.spring.Log.Service();



    @RequestMapping(value="set",method= RequestMethod.POST)
    ResponseEntity<String> setUser(@RequestBody User user) throws SQLException, ClassNotFoundException {
        userService = new Service();
        return userService.setUser(user);
    }
    @RequestMapping(value="getlog",method=RequestMethod.GET)
    ResponseEntity<List<Log>> getlog(@RequestParam String userid) throws SQLException, ClassNotFoundException {
        logservice = new org.spring.Log.Service();
        return logservice.getLogById(userid);
    }
    @RequestMapping(value="getlogs",method=RequestMethod.GET)
    ResponseEntity<List<Log>> getlogs() throws SQLException, ClassNotFoundException {
        logservice = new org.spring.Log.Service();
        return logservice.getSuperAdminLog();
    }

}
