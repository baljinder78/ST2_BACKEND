package com.fullstackapp.Trail.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fullstackapp.Trail.Model.User;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@CrossOrigin
@RestController
public class UserController {
    public int count=0;

    public static ArrayList<User> list_user=new ArrayList<User>();

    static {
        User user1 = new User();
        user1.setName("Baljinder");
        user1.setEmail("Hira@123.com");
        user1.setMobile_no("5461561846");


        User user2 = new User();
        user2.setName("Tapu");
        user2.setEmail("tipy@123.com");
        user2.setMobile_no("jdfdbsdks");

        list_user.add(user1);
        list_user.add(user2);
    }

    @RequestMapping(value = "/trying",method = RequestMethod.POST)
    public void postUsers(@RequestBody String data) throws JsonProcessingException {
        count++;
        System.out.println("API got hit post "+count);
      /*  HashMap<String,String> hm=new HashMap<>();
        hm.put("username","Baljinder");
        hm.put("mobile","9780796694");
        hm.put("password","Baljinder@123");
        return hm;
*/
/*
        ArrayList<User> list_user=new ArrayList<User>();

        User user1=new User();
        user1.setName("Baljinder");
        user1.setEmail("Hira@123.com");
        user1.setMobile_no("5461561846");


        User user2=new User();
        user2.setName("Tapu");
        user2.setEmail("tipy@123.com");
        user2.setMobile_no("jdfdbsdks");

        list_user.add(user1);
        list_user.add(user2);

        return list_user;
*/
        User user = new ObjectMapper().readValue(data, User.class);
    list_user.add(user);

    }


    @RequestMapping(value = "/trying",method = RequestMethod.GET)
    public ArrayList<User> getUsers()
    {
        count++;
        System.out.println("API got hit get "+count);
      /*  HashMap<String,String> hm=new HashMap<>();
        hm.put("username","Baljinder");
        hm.put("mobile","9780796694");
        hm.put("password","Baljinder@123");
        return hm;
*/





        return list_user;



    }

}
