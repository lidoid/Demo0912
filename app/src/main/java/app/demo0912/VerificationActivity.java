package app.demo0912;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Robot on 2017/9/12.
 */

//验证界面
public class VerificationActivity extends AppCompatActivity implements View.OnClickListener {
    private Button ver_btton;
    private EditText ve_yanzheng;
    private int i = 60;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 200:
                    ver_btton.setText("重新发送" + i);
                    if (i == 0) {

                    } else {
                        handler.sendEmptyMessageDelayed(200, 1000);
                        i--;

                    }
                    break;
            }
        }
    };
    private Button button2;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verification);
        initView();

    }

    private void initView() {
        ver_btton = (Button) findViewById(R.id.ver_btton);

        ver_btton.setOnClickListener(this);
        ve_yanzheng = (EditText) findViewById(R.id.ve_yanzheng);
        ve_yanzheng.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ver_btton:

                ver_btton.setClickable(false);
                handler.sendEmptyMessageDelayed(200, 1000);
                break;
            case R.id.button2:
                Intent intent=new Intent(VerificationActivity.this,MainActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void submit() {
        // validate
        String yanzheng = ve_yanzheng.getText().toString().trim();
        if (TextUtils.isEmpty(yanzheng)) {
            Toast.makeText(this, "验证码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
