package com.example.kwongyo.recall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kwongyo.recall.core.LoginController;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 앱 처음 실행시 실행되는 화면이다. 로그인이 되었는지 체크하고, 이미 로그인 되었다면 메인페이지로 이동시켜준다.
 */
public class LoginActivity extends AppCompatActivity {
    @Bind(R.id.inputId)
    EditText inputId;
    @Bind(R.id.inputPwd)
    EditText inputPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);



    }
    @OnClick(R.id.loginBtn)
    public void loginBtnClick(View view) {
        //로그인 성공시.
        if(!LoginController.getInstance().requestLogin(inputId.getText().toString(),inputPwd.getText().toString())) {
            Intent intent = new Intent();
            intent.setClass(getApplicationContext(),RecallMainActivity.class);
            startActivity(intent);
        }
        //로그인 실패라면
        else {
            Toast.makeText(getApplicationContext(),"로그인실패띵",Toast.LENGTH_SHORT).show();
        }
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

