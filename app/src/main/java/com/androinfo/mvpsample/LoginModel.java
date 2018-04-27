/**
 * @file LoginModel.java
 * @brief This is a login model class, which handles all the business logic
 * @author Shrikant
 * @date 27/04/2018
 */
package com.androinfo.mvpsample;

import com.androinfo.mvpsample.LoginContract.Presenter.OnSuccessListener;

public class LoginModel implements LoginContract.Model {


    // Here you can add all you business logic
    @Override
    public void performLogin(String username, String password, OnSuccessListener onSuccessListener) {

        // Validating credentials
        if (username.isEmpty()) {
            onSuccessListener.onError("Username can not be empty");
        } else if (password.isEmpty()) {
            onSuccessListener.onError("Password can not be empty");
        } else if (username.equals(getName()) && password.equals(getPass())) {
            onSuccessListener.onSuccess();
        } else {
            onSuccessListener.onError("Invalid username or password");
        }

    }

    /**
     * This function will return dummy username
     *
     * @return String username
     */
    public String getName() {
        return "user";
    }

    /**
     * This function will return dummy passoword
     *
     * @return String password
     */
    public String getPass() {
        return "password";
    }
}
