package com.example.projectaviao;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    private EditText textPassword;
    private ImageButton showPasswordButton;
    private boolean isPasswordVisible = false;
     
    public static final String TAG ="Activity Main";
    TextView mTextViewForgotPassword;
    Button mButtonLogin, mWebConnector;

    EditText mEditTextEmail, mEditTextPassword;
    String mStringEmail,mStringPassword;
    SharedPreferences mSharedPreferences;

    private boolean isRequiredPassword(){
        return TextUtils.isEmpty(mEditTextPassword.getText());
    }
    private boolean isValidEmail(String mStringEmail){
      if(mStringEmail==null || mStringEmail.isEmpty()){
          return false; 
      }
      return Patterns.EMAIL_ADDRESS.matcher(mStringEmail).matches();
      
    }
    private void showProduct(){
        Intent mIntent = new Intent(getApplicationContext() , HomeActivity.class);
        startActivity(mIntent);
        finish();
    }
    private void verifyLogged(){
        if (mSharedPreferences.getString("logged","false").equals("true")){
            showProduct();
        }

    }
    private void postData() {
        mStringEmail = String.valueOf(mEditTextEmail.getText()).toLowerCase(Locale.ROOT);
        mStringPassword = String.valueOf(mEditTextPassword.getText());


        if (!isValidEmail(mStringEmail)) {
            String mTextMessage = getString(R.string.text_email_not_valid);
            Toast.makeText(getApplicationContext(), mTextMessage, Toast.LENGTH_SHORT).show();
            return;
        }

        if (isRequiredPassword()) {
            String mTextMessage = getString(R.string.text_Password_not_valid);
            Toast.makeText(getApplicationContext(), mTextMessage, Toast.LENGTH_SHORT).show();
            return;

        }


        User mUser = new User(mStringEmail, mStringPassword);

        String mResult = UserDao.authenticateUser(mUser, getApplicationContext());

         if(mResult.isEmpty()|| mResult.equals("") || mResult.equals("Exception")){
             String mTextMessage;
             mTextMessage=getString(R.string.text_email_or_password_incorrect);
             if (mResult.equals("Exception")){

             }
Toast.makeText(getApplicationContext(), mTextMessage, Toast.LENGTH_SHORT).show();
         return;
         }
SharedPreferences.Editor mEditor =mSharedPreferences.edit();
         mEditor.putString("logged", "True");
         mEditor.putString("Email",mStringEmail);
         mEditor.putString( "Password",mResult);
         mEditor.apply();

         //clicou no botão vai para tela HomeActivity
         Intent mIntent = new Intent(getApplicationContext(), HomeActivity.class);
    mIntent.putExtra("EXTRA_FULL_NAME", mResult);
    startActivity(mIntent);
    finish();
    }

    public class ClickButtonLogin implements  View.OnClickListener{
        @Override
        public void onClick(View view) {
            postData();
        }
    }

    //-- CASO TENHA UMA TELA DE CADASTRO//

  //  private void showSignUp(){
    // Intent mIntent = new Intent(getApplicationContext(), Activity.class);
    // startActivity(mIntent);
    //finish();
  //  }
  // public class ClickNewUserSignUp implements  View.OnClickListener{

    //  @Override
   //   public void onClick(View view) {
      //    showSignUP();
    //  }
 // }

   // private void showForgotPassword(){
    //    Intent mIntent = new Intent(getApplicationContext(), ResetPasswordActivity.class);
    //    startActivity(mIntent);
   //     finish();
  //  }
  //  public class ClickMyForgotPassword implements View.OnClickListener{
      //  @Override
     //   public void onClick(View view) {
      //    showForgotPassword();
      //  }
  //  }

    public class EditMyTextAction implements TextView.OnEditorActionListener{
        @Override
        public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
            if (actionId== EditorInfo.IME_ACTION_DONE){
                postData();
            }
            return false;
        }
    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextEmail= findViewById(R.id.textEmail);
        mEditTextPassword= findViewById(R.id.textPassword);
          mEditTextPassword.setOnEditorActionListener(new EditMyTextAction( ));

        mButtonLogin = findViewById(R.id.loginbtn);
        mButtonLogin.setOnClickListener(new ClickButtonLogin());


        //mTextViewNewUser.setOnCLickListener(new ClickNewUserSignUp());
        //mTextViewForgotPassword = findViewById(R.id.textView_forgot_password);
        //mTextViewForgotPassword.setOnClickListener(new ClickMyForgotPassword());

        mSharedPreferences = getSharedPreferences("MyAppName", MODE_PRIVATE);
        verifyLogged();
    }
    // Método chamado quando o botão é clicado
    public void abrirLink(View view) {
        // URL que você deseja abrir
        String url = "https://vensco-executive-airlines-production.up.railway.app/cadastro";

        // Cria uma intenção para abrir o navegador com o URL
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));

        // Inicia a atividade do navegador
        startActivity(intent);
    }


}
