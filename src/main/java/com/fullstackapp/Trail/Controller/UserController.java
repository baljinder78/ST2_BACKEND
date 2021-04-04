package com.fullstackapp.Trail.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin
@RestController
public class UserController {
    public int count=0;
    @RequestMapping(value = "/trying",method = RequestMethod.GET)
    public HashMap<String,String> getUsers()
    {
        count++;
        System.out.println("API got hit "+count);
        HashMap<String,String> hm=new HashMap<>();
        hm.put("username","Baljinder");
        hm.put("mobile","9780796694");
        hm.put("password","Baljinder@123");
        return hm;

    }
}
