package com.study.android.memoproject;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.TypefaceProvider;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseNetworkException;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity  implements  GoogleApiClient.OnConnectionFailedListener{
    private static final String TAG = "lecture";
    public static CustomProgressDialog progressDialog = null;
    private Handler mHandler=new Handler();
   //시간제한
    public static int TIME_OUT = 1001;

    SignInButton button;
    BootstrapButton button1;
    BootstrapButton button2;
    private static final int RC_SIGN_IN = 10;
    private GoogleSignInClient mGoogleSignInClient;

    //이메일 비밀번호 로그인 모듈 변수
    private FirebaseAuth mAuth;
    private EditText etemail;
    private EditText etpwd;
    //현재 로그인 된 유저 정보를 담을 변수
    private FirebaseUser currentUser;
    private String UserName;
    //
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TypefaceProvider.registerDefaultIconSets();
        mAuth = FirebaseAuth.getInstance();



        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();


        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        //구글 로그인
        button = findViewById(R.id.login_google);
        //이메일로그인
        etemail = findViewById(R.id.et_email);
        etpwd = findViewById(R.id.et_pwd);
        button1 = findViewById(R.id.email_login);
        //이메일회원가입
        button2 = findViewById(R.id.email_join);

        // 구글로그인
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("클릭 테스트");
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, RC_SIGN_IN);
                //버튼4: 진행중 표시
                if(progressDialog == null || !progressDialog.isShowing()) {
                    // progressDialog = CustomProgressDialog.show(MainActivity.this, "", "", true,true
                    progressDialog = CustomProgressDialog.show(MainActivity.this, "",
                            "처리중입니다", true, true, null);
                }
            }
        });

        //이메일 회원가입버튼
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!etemail.getText().toString().equals("") && !etpwd.getText().toString().equals("")) {
                    System.out.println("이메일 회원가입 테스트메일 "+etemail.getText().toString() + "테스트 pwd:" +etpwd.getText().toString());
                    createUser(etemail.getText().toString(), etpwd.getText().toString());
                }else if(etemail.getText().toString().equals("")) {
                    System.out.println("초기화1");
                    Toast.makeText(MainActivity.this, "이메일 미입력", Toast.LENGTH_SHORT).show();
                    return;
                } else if(etpwd.getText().toString().equals("")){
                    System.out.println("초기화2");
                    Toast.makeText(MainActivity.this, "비밀번호 미입력", Toast.LENGTH_SHORT).show();
                    return;
                }

            }
        });


        //이메일 로그인버튼
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //버튼4: 진행중 표시
                if (progressDialog == null || !progressDialog.isShowing()) {
                    progressDialog = CustomProgressDialog.show(MainActivity.this, "",
                            "처리중입니다.", true, true, null);
                    // 시간처리
                    Handler mHandler = new Handler();
                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            progressDialog.dismiss();
                        }
                    }, 1500); // 2000ms
                    if (!etemail.getText().toString().equals("") && !etpwd.getText().toString().equals("")) {
                        System.out.println("이메일 로그인 테스트메일 " + etemail.getText().toString() + "테스트 pwd:" + etpwd.getText().toString());
                        loginUser(etemail.getText().toString(), etpwd.getText().toString());
                    } else if (etemail.getText().toString().equals("")) {
                        System.out.println("초기화1");
                        Toast.makeText(MainActivity.this, "이메일 미입력", Toast.LENGTH_SHORT).show();
                        return;
                    } else if (etpwd.getText().toString().equals("")) {
                        System.out.println("초기화2");
                        Toast.makeText(MainActivity.this, "비밀번호 미입력", Toast.LENGTH_SHORT).show();
                        return;
                    }

                }
            }
        });

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "로그인자동 성공", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(MainActivity.this, "로그인자동 실패", Toast.LENGTH_SHORT).show();
                }
            }
        };


    }

//    public void onBtnClicked(View v){
//        final Dialog loginDialog = new Dialog(this);
//        loginDialog.setContentView(R.layout.custom_dialog);
//        loginDialog.setTitle("로그인 화면");
//
//        final EditText username = loginDialog.findViewById(R.id.editText1);
//        final EditText password = loginDialog.findViewById(R.id.editText2);
//
//        Button login = loginDialog.findViewById(R.id.button1);
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (username.getText().toString().trim().length() > 0
//                        && password.getText().toString().trim().length() > 0) {
//                    Toast.makeText(getApplicationContext(), "로그인 성공",
//                            Toast.LENGTH_LONG).show();
//
//                    loginDialog.dismiss();
//                } else {
//                    Toast.makeText(getApplicationContext(), "다시 입력하세요.",
//                            Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//        Button cancel = loginDialog.findViewById(R.id.button2);
//        cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                loginDialog.dismiss();
//            }
//        });
//        loginDialog.show();
//    }

    //이메일 회원가입
    private void createUser(final String email, final String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            Toast.makeText(MainActivity.this, "회원가입 성공!",
                                    Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            ActionCodeSettings actionCodeSettings =
                                    ActionCodeSettings.newBuilder()
                                            // URL you want to redirect back to. The domain (www.example.com) for this
                                            // URL must be whitelisted in the Firebase Console.
                                            .setUrl("https://www.example.com/finishSignUp?cartId=1234")
                                            // This must be true
                                            .setHandleCodeInApp(true)
                                            .setIOSBundleId("com.example.ios")
                                            .setAndroidPackageName(
                                                    "com.example.android",
                                                    true, /* installIfNotAvailable */
                                                    "12"    /* minimumVersion */)
                                            .build();
                        }
                        else {
                            //보통 이메일이 이미 존재하거나, 이메일 형식이아니거나, 비밀번호가 6자리 이상
                            try {
                                throw task.getException();
                            } catch(FirebaseAuthWeakPasswordException e) {
                                Toast.makeText(MainActivity.this,"비밀번호가 간단해요.." ,Toast.LENGTH_SHORT).show();
                            } catch(FirebaseAuthInvalidCredentialsException e) {
                                Toast.makeText(MainActivity.this,"email 형식에 맞지 않습니다." ,Toast.LENGTH_SHORT).show();
                            } catch(FirebaseAuthUserCollisionException e) {
                                Toast.makeText(MainActivity.this,"이미존재하는 email 입니다." ,Toast.LENGTH_SHORT).show();
                            } catch(Exception e) {
                                Toast.makeText(MainActivity.this,"다시 확인해주세요.." ,Toast.LENGTH_SHORT).show();
                            }
                        }

                    }
                });
    }

    //이메일 로그인
    private void loginUser(String email,String password){
         //Toast.makeText(MainActivity.this,"login 함수 안으로" ,Toast.LENGTH_SHORT).show();
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //Toast.makeText(MainActivity.this,"mAuth. onComplete 함수" ,Toast.LENGTH_SHORT).show();
                if (!task.isSuccessful()) {
                    try {
                        throw task.getException();
                    } catch (FirebaseAuthWeakPasswordException e){
                        Toast.makeText(MainActivity.this,"비밀번호가 틀려요." ,Toast.LENGTH_SHORT).show();
                    } catch (FirebaseAuthInvalidUserException e) {
                        Toast.makeText(MainActivity.this,"존재하지 않는 email 입니다." ,Toast.LENGTH_SHORT).show();
                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        Toast.makeText(MainActivity.this,"이메일 or 비밀번호 형식이 맞지 않습니다." ,Toast.LENGTH_SHORT).show();
                    } catch (FirebaseNetworkException e) {
                        Toast.makeText(MainActivity.this,"Firebase NetworkException" ,Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this,"Exception" ,Toast.LENGTH_SHORT).show();
                    }

                }else{
                    currentUser = mAuth.getCurrentUser();
                    Toast.makeText(MainActivity.this, "로그인 성공"+ currentUser.getEmail()  ,Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, HomeActivity.class));
                    finish();
                }
            }
        });
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
                // ...
            }
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            currentUser = mAuth.getCurrentUser();

                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            System.out.println("로그인 테스트");
                            Toast.makeText(MainActivity.this, "구글로그인 성공" +user.getEmail(), Toast.LENGTH_SHORT).show();


                            //화면전환
                            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
//                            intent.putExtra("CustomerName","홍길동");
                            startActivity(intent);
                            finish();
                            System.out.println("클릭 테스트2");
                        } else {

                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(MainActivity.this, "로그인 실패", Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    protected void onStart(){
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop(){
        super.onStop();
        mAuth.removeAuthStateListener(mAuthListener);
    }
}
