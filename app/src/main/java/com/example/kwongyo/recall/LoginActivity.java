package com.example.kwongyo.recall;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;


import com.example.kwongyo.recall.core.LoginController;
import com.example.kwongyo.recall.model.CustomPreference;

import com.example.kwongyo.recall.model.ServiceR;


import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 앱 처음 실행시 실행되는 화면이다. 로그인이 되었는지 체크하고, 이미 로그인 되었다면 메인페이지로 이동시켜준다.
 */
public class LoginActivity extends AppCompatActivity {
    /**
     * 사용자가 이메일을 입력할 EditText 객체입니다.
     */
    @Bind(R.id.inputId)
    EditText inputId;

    /**
     * 사용자가 비밀번호를 입력할 EditText 객체입니다.
     */
    @Bind(R.id.inputPwd)
    EditText inputPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        Intent intent = new Intent(this,ServiceR.class);
        //startService(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        /*로그인 체크하는 부분. 로그아웃을 하지 않았다면 자동으로 로그인처리 해준다.*/
        CustomPreference customPreference = CustomPreference.getInstance(this);
        //if(customPreference.getValue("login",false)) {
            startActivity(new Intent(getApplicationContext(),RecallMainActivity.class));
        //}
        inputId.setText("");
        inputPwd.setText("");
    }

    /**
     * 로그인 버튼이 클릭되었을 떄 발생하는 이벤트 콜백 메소드.
     * @param view
     */
    @OnClick(R.id.loginBtn)
    public void loginBtnClick(View view) {
        //로그인 성공시.
        LoginController loginController = LoginController.getInstance();
        loginController.requestLogin(this, inputId.getText().toString(), inputPwd.getText().toString());
    }

    /**
     * 앱 처음 실행시, 보이는 화면에서 하단의 가입하기 버튼을 클릭할 시, 발생되는 이벤트 리스너입니다.
     * 본 이벤트는 회원가입을 할 수 있는 페이지로 이동합니다.
     * 페이지 이동은 startActivityForResult 메소드를 통하여 이동합니다.
     * REGISTER_ACTIVITY = 2
     * @param view registerTextView객체.
     */
    @OnClick(R.id.registerTextView)
    public void registerTextViewClick(View view) {
        Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
        startActivityForResult(intent, StaticInfomation.REGISTER_ACTIVITY);
    }
}