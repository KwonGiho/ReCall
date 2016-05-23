package com.example.kwongyo.recall;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kwongyo.recall.core.RegisterController;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kwongyo on 2016-05-02.
 */
public class RegisterActivity extends AppCompatActivity {
    /**
     * 사용자 이름
     */
    @Bind(R.id.inputRegisterName)
    EditText inputRegisterName;

    /**
     * 사용자 이메일.
     */
    @Bind(R.id.inputRegisterEmail)
    EditText inputRegisterEmail;

    /**
     * 사용자 패스워드.
     */
    @Bind(R.id.inputRegisterPassword)
    EditText inputRegisterPassword;

    /**
     * 사용자 패스워드 확인창.
     */
    @Bind(R.id.inputRegisterPasswordComfirm)
    EditText inputRegisterPasswordComfirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        ButterKnife.bind(this);
    }

    /**
     * 사용자가 회원가입 버튼을 클릭했을 때.
     * @param v
     */
    @OnClick(R.id.registerCompleteBtn)
    public void registerBtnClick(View v) {
        if( !inputRegisterPassword.getText().toString().equals(inputRegisterPasswordComfirm.getText().toString() ) ) {
            Toast.makeText(getApplicationContext(),"비밀번호가 서로 일치하지 않습니다.",Toast.LENGTH_SHORT).show();
            return ;
        }
        RegisterController.getInstance().requestRegister(inputRegisterEmail.getText().toString(),inputRegisterName.getText().toString(),inputRegisterPassword.getText().toString());
        finish();


    }
}
