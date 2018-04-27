/**
 * @file LoginPresenter.java
 * @brief This is a presenter class, which handles the communication between login view and login model.
 * @author Shrikant
 * @date 27/04/2018
 */

package com.androinfo.mvpsample;

public class LoginPresenter implements LoginContract.Presenter, LoginContract.Presenter.OnSuccessListener {

    private LoginContract.View loginView;
    private LoginContract.Model loginModel;

    public LoginPresenter(LoginContract.View loginView) {
        this.loginView = loginView;
        loginModel = new LoginModel();
    }

    @Override
    public void onSuccess() {

        if (loginView != null) {
            loginView.hideProgressbar();
            loginView.onLoginSuccess();
        }
    }

    @Override
    public void onError(String errorMessage) {

        if (loginView != null) {
            loginView.hideProgressbar();
            loginView.onLoginError(errorMessage);
        }
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void performLogin(String username, String password) {

        if (loginView != null) {
            loginView.showProgressbar();
        }

        loginModel.performLogin(username, password, this);
    }
}
