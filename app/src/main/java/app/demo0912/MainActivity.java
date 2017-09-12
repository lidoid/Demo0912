package app.demo0912;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

//主页界面
public class MainActivity extends AppCompatActivity {

    NoScrollViewPager nsv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initNSV();

        initLinsenter();
    }

    private void initNSV() {
        nsv.setAdapter(new MainAdapter(getSupportFragmentManager()));
        nsv.setCurrentItem(0);
    }

    private void initLinsenter() {
        findViewById(R.id.home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //首页
                nsv.setCurrentItem(0);
            }
        });

        findViewById(R.id.shopping).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //购物车
                nsv.setCurrentItem(1);
            }
        });

        findViewById(R.id.map).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //地图
                nsv.setCurrentItem(2);
            }
        });
    }

    private void initView() {
        nsv = (NoScrollViewPager) findViewById(R.id.nsv);
    }
}
