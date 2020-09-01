package com.pochekuev.application.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.pochekuev.application.PreferencesManager;
import com.pochekuev.application.R;
import com.pochekuev.application.main.MainActivity;

public class LoginActivity extends AppCompatActivity implements LoginActivityContract.View {

    private LoginActivityContract.Presenter presenter;

    private ProgressBar progressBar;
    private EditText editTextLogin, editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginActivityPresenter(PreferencesManager.getInstance(this));
        presenter.attachView(this);

        progressBar = findViewById(R.id.progress_bar);

        editTextLogin = findViewById(R.id.login);
        editTextLogin.addTextChangedListener(inputTextWatcher);

        editTextPassword = findViewById(R.id.password);
        editTextPassword.addTextChangedListener(inputTextWatcher);

        buttonLogin = findViewById(R.id.login_button);
        buttonLogin.setOnClickListener(proceedLogin);
    }

    /**
     *
     * */
    private View.OnClickListener proceedLogin = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String textLogin = editTextLogin.getText().toString().trim();
            String textPassword = editTextPassword.getText().toString().trim();

            //Example: "Mikhail_IU__KHachai", "fohadubn"
            presenter.onLoginButtonClicked(textLogin, textPassword);
            //presenter.onLoginButtonClicked("Mikhail_IU__KHachai", "fohadubn");
        }
    };

    /**
     *
     * */
    private TextWatcher inputTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String textLogin = editTextLogin.getText().toString().trim();
            String textPassword = editTextPassword.getText().toString().trim();

            buttonLogin.setEnabled(presenter.validateCredentials(textLogin, textPassword));
        }

        @Override
        public void afterTextChanged(Editable s) { }
    };


    @Override
    public void showProgress() {
        buttonLogin.setEnabled(false);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        buttonLogin.setEnabled(true);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onSuccess(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        startActivity(new Intent(this, MainActivity.class));
        this.finish();
    }

    @Override
    public void onError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.detachView();
        if(isFinishing()) {
            presenter.destroy();
        }
    }
}
