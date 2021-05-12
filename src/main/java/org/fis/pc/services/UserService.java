package org.fis.pc.services;

import java.util.Objects;

public class UserService {

    public static String encodePassword(String salt, String password)
    {
        return password;
    }


    public static boolean checkLoginCredentials(String username, String password){
        if(Objects.equals(password,encodePassword(username,password))) {
            System.out.println("login successful");
            return true;
        }
        return false;
    }
}

