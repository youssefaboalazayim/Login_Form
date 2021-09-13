package com.example.loginform.model;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

public class User implements IUser {
    String email;
    String password;

    public User(String email, String password){
        this.email= email;
        this.password = password;
    }

//    public void setEmail(String email){
//
//    }
//    public String getEmail(){
//        return email;
//    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int isValid() {
        if (TextUtils.isEmpty(getEmail())){
            return 0;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()){
            return 1;
        }

        else if (TextUtils.isEmpty(getPassword())){
            return 2;
        }

        else if (getPassword().length() < 8){
            return 3;
        }
         else {
             return -1;
        }

    }
}
