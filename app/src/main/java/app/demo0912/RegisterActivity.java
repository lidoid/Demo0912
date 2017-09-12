package app.demo0912;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Robot on 2017/9/12.
 */

//注册界面
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText re_name;
    private EditText re_password;
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView() {
        re_name = (EditText) findViewById(R.id.re_name);
        re_password = (EditText) findViewById(R.id.re_password);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:

                String PHONE_PATTERN = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
                Pattern pattern = Pattern.compile(PHONE_PATTERN);
                Matcher matcher = pattern.matcher(re_name.getText().toString());
                String re_password1 = re_password.getText().toString();
                String format = "[a-zA-Z](@?+\\w){5,17}+";
                if (matcher.find()&&re_password1.matches(format)){
                    Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                break;
        }
    }

    private void submit() {
        // validate
        String name = re_name.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        String password = re_password.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "密码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
