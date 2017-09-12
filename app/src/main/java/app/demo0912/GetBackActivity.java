package app.demo0912;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Robot on 2017/9/12.
 */

//找回密码界面
public class GetBackActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEt_suijishu;
    private Button mBtn_huoqu;
    private TimeCount time;
    private Button mBtn_tiaozhaun;
    private Button mBtn_fanhui;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getback);
        initView();

    }

    private void initView() {
        mEt_suijishu = (EditText) findViewById(R.id.mEt_suijishu);
        mBtn_huoqu = (Button) findViewById(R.id.mBtn_huoqu);

        mBtn_huoqu.setOnClickListener(this);
        time = new TimeCount(5000, 1000);
        mBtn_tiaozhaun = (Button) findViewById(R.id.mBtn_tiaozhaun);
        mBtn_tiaozhaun.setOnClickListener(this);
        mBtn_fanhui = (Button) findViewById(R.id.mBtn_fanhui);
        mBtn_fanhui.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mBtn_huoqu:
                int num = (int) ((Math.random() * 9 + 1) * 100000);
                time.start();
                mEt_suijishu.setText(String.valueOf(num));
                break;
            case R.id.mBtn_tiaozhaun:
                startActivity(new Intent(GetBackActivity.this, LoginActivity.class));
                finish();
                break;
            case R.id.mBtn_fanhui:
                startActivity(new Intent(GetBackActivity.this, LoginActivity.class));
                finish();
                break;
        }
    }

    class TimeCount extends CountDownTimer {
        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            mBtn_huoqu.setText("重新验证");
            mBtn_huoqu.setClickable(true);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            mBtn_huoqu.setClickable(false);
            mBtn_huoqu.setText(millisUntilFinished / 1000 + "秒");
        }
    }
}