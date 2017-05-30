package com.example.sreetej.cashkarosample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.concurrent.Callable;

public class LoginActivity extends AppCompatActivity {

    private CallbackManager mFacebookCallbackManager;
    private LoginButton mFacebookSignInButton;

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String USERID = "userID";

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Login Page");

        FacebookSdk.sdkInitialize(getApplicationContext());
        mFacebookCallbackManager = CallbackManager.Factory.create();

        setContentView(R.layout.activity_login);

        mFacebookSignInButton = (LoginButton) findViewById(R.id.facebook_sign_in_button);
        mFacebookSignInButton.setReadPermissions("email");

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        if (sharedpreferences.getString(USERID, null) != null) {
            loginSuccess();
        } else {

            mFacebookSignInButton.registerCallback(mFacebookCallbackManager,
                    new FacebookCallback<LoginResult>() {
                        @Override
                        public void onSuccess(final LoginResult loginResult) {

                            SharedPreferences.Editor editor = sharedpreferences.edit();
                            editor.putString(USERID, loginResult.getAccessToken().getUserId());
                            editor.apply();

                            loginSuccess();

                        }

                        @Override
                        public void onCancel() {

                        }

                        @Override
                        public void onError(FacebookException error) {
                            Log.d(LoginActivity.class.getCanonicalName(), error.getMessage());

                        }
                    }
            );

        }

    }

    private void loginSuccess() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        mFacebookCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

}
