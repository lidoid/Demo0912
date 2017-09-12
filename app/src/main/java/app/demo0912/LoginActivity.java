package app.demo0912;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Robot on 2017/9/12.
 */
//登陆界面
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView login_text;
    private EditText login_name;
    private EditText login_password;
    private Button login_button;
    private ImageView login_image1;
    private ImageView login_image2;
    private TextView login_text2;
    private TextView login_text3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }


    private void initView() {
        login_text = (TextView) findViewById(R.id.login_text);
        login_name = (EditText) findViewById(R.id.login_name);
        login_password = (EditText) findViewById(R.id.login_password);
        login_button = (Button) findViewById(R.id.login_button);
        login_image1 = (ImageView) findViewById(R.id.login_image1);
        login_image2 = (ImageView) findViewById(R.id.login_image2);

        login_button.setOnClickListener(this);
        login_text2 = (TextView) findViewById(R.id.login_text2);
        login_text2.setOnClickListener(this);
        login_text3 = (TextView) findViewById(R.id.login_text3);
        login_text3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:
                submit();

                break;
            case R.id.login_text2:
                Intent intent = new Intent(LoginActivity.this, GetBackActivity.class);
                startActivity(intent);

                break;
            case R.id.login_text3:
                Intent intent3 = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent3);
                break;
        }
    }

    private void submit() {
        // validate
        String name = login_name.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "请输入手机号或邮箱", Toast.LENGTH_SHORT).show();
            return;
        }

        String password = login_password.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }


        Join join = new Join();
        boolean email = join.isEmail(name);
        if (email==true){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);


        }else {
            Toast.makeText(this, "输入有误", Toast.LENGTH_SHORT).show();
        }






//        if (name.length() >= 6 && name.length() <= 12) {
//            if (password.length() >= 6 && password.length() <= 12) {
//
//                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                startActivity(intent);
//
//            }
//
//
//        }


    }
}
