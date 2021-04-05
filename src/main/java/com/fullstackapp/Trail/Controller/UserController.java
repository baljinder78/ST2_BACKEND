package com.fullstackapp.Trail.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fullstackapp.Trail.Model.User;
import com.fullstackapp.Trail.service.Userservice;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    Userservice userservice;



    @RequestMapping(value = "/trying",method = RequestMethod.POST)
    public void addnewuser(@RequestBody String data) throws JsonProcessingException {

        User user = new ObjectMapper().readValue(data, User.class);
        System.out.println(user.toString());

    }

    @RequestMapping(value = "/trying",method = RequestMethod.GET)
    public List<User> getallUsers()
    {

        List<User> userList=userservice.getalluser();
       /* List<User> userList =new ArrayList<>();
        User user1 = new User();
        user1.setName("Baljinder");
        user1.setEmail("Hira@123.com");
        user1.setMobile_no("5461561846");


        User user2 = new User();
        user2.setName("Tapu");
        user2.setEmail("tipy@123.com");
        user2.setMobile_no("jdfdbsdks");

        userList.add(user1);
        userList.add(user2);
       */
        System.out.println(userList);
        return userList;

   }

}
