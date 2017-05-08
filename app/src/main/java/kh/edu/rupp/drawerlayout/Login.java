package kh.edu.rupp.drawerlayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private TextView Edt_username, Edt_password;
    private CheckBox chb_rememberMe;
    private String USERNAME =  "username";
    private String PASSWORD = "password";

    public static final String KEY_USERNAME = "username";
    public static final String PREFERENCE_NAME = "ruppmad.pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Check if user is logged in
        String username = getRememberedUserName();
        if(username == null){
            setContentView(R.layout.activity_login);
        }else{
            startMainActivityAndFinishLogedInActivity(username);
        }


    }

    public void loginClick(View view) {
        Edt_username = (TextView)findViewById(R.id.user_name);
        Edt_password = (TextView)findViewById(R.id.password);
        chb_rememberMe = (CheckBox)findViewById(R.id.chb_rememberme);

        String username = Edt_username.getText().toString();
        String password = Edt_password.getText().toString();
        if (username.equals(USERNAME) && password.equals(PASSWORD))
        {
            if(chb_rememberMe.isChecked())
            {
                rememberLogedIn(username);
            }

            startMainActivityAndFinishLogedInActivity(username);

        }else{
            Toast.makeText(this,"wrong username and password", Toast.LENGTH_LONG).show();
        }

    }
    //remember when user login or put username to sharepreference
    private void rememberLogedIn(String username) {
        SharedPreferences preference = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.putString(KEY_USERNAME, username);
        editor.commit();
    }
    //get username when we need after user loged in
    private String getRememberedUserName()
    {
        SharedPreferences preference = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
        String username = preference.getString(KEY_USERNAME, null);
        return username;
    }
    public void startMainActivityAndFinishLogedInActivity(String username)
    {
        Intent nextAct = new Intent(this, MainActivity.class);
        nextAct.putExtra("username", username);
        startActivity(nextAct);
        finish();
    }
}
