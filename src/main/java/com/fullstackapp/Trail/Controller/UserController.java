package com.fullstackapp.Trail.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin
@RestController
public class UserController {
    public int count=0;
    @RequestMapping(value = "/trying",method = RequestMethod.GET)
    public String getUsers()
    {
        count++;
        System.out.println("API got hit "+count);
        return "HELLO HERE";

    }
}
