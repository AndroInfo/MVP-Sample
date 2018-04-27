/**
 * @file LoginActivity.java
 * @brief This activity is responsible for handling UI for Login screen
 * @author Shrikant
 * @date 27/04/2018
 */

package com.androinfo.mvpsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    // UI components
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private ProgressBar pbValidating;
    private TextView tvWelcomeMessage;
    private LinearLayout llLoginLayout;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initUI();
        setListeners();

        loginPresenter = new LoginPresenter(this);
    }

    /**
     * This method will initialize all UI components
     */
    private void initUI() {

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        pbValidating = findViewById(R.id.pb_validating);
        tvWelcomeMessage = findViewById(R.id.tv_welcome);
        llLoginLayout = findViewById(R.id.ll_login_layout);
    }

    /**
     * This method is responsible for setting listeners on views
     */
    private void setListeners() {

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loginPresenter.performLogin(etUsername.getText().toString(), etPassword.getText().toString());
            }
        });
    }

    @Override
    public void showProgressbar() {

        pbValidating.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressbar() {

        pbValidating.setVisibility(View.GONE);
    }

    @Override
    public void onLoginError(String errorMessage) {

        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLoginSuccess() {

        llLoginLayout.setVisibility(View.GONE);
        tvWelcomeMessage.setVisibility(View.VISIBLE);
    }
}
