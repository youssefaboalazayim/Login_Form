package com.example.loginform.controller;

import com.example.loginform.view.ILoginView;
import com.example.loginform.model.User;

public class LoginController implements ILoginController {

    ILoginView iLoginView;

    public LoginController(ILoginView iLoginView){
        this.iLoginView = iLoginView;
    }

    @Override
    public void onLogin(String email, String password) {

        User user = new User(email, password);

        int logInCode = user.isValid();

        if(logInCode == 0){
            iLoginView.onLoginError("Please Enter Email");
        }
        else if (logInCode == 1){
            iLoginView.onLoginError("Please enter a valid email");
        }
        else if (logInCode == 2){
            iLoginView.onLoginError("Please enter a password");
        }
        else if (logInCode == 3){
            iLoginView.onLoginError("Please should be more than or equal 8 character");
        }
        else{
            iLoginView.onLoginSuccess("Login Success");
        }
    }
}
