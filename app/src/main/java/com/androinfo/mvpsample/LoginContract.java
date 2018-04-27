/**
 * @file LoginContract.java
 * @brief This is an interface class and it will expose the structure for model, view and presenter
 * @author Shrikant
 * @date 27/04/2018
 */
package com.androinfo.mvpsample;

public interface LoginContract {

    interface Model {

        void performLogin(String username, String password, Presenter.OnSuccessListener onSuccessListener);

    }

    interface View {

        void showProgressbar();

        void hideProgressbar();

        void onLoginError(String errorMessage);

        void onLoginSuccess();

    }

    interface Presenter {

        interface OnSuccessListener {
            void onSuccess();

            void onError(String errorMessage);
        }

        void onDestroy();

        void performLogin(String username, String password);
    }
}
