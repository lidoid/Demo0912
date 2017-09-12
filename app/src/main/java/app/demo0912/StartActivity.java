package app.demo0912;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by Robot on 2017/9/12.
 */

//启动界面
public class StartActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private SharedPreferences preferences;
    private Handler handler =new Handler();
    private int count =3;
    private Runnable runnable =new Runnable() {
        @Override
        public void run() {

            int i = count % 3;
             if(i==0){
                 mViewPager.setCurrentItem(0);
             } else if(i==1){
                 mViewPager.setCurrentItem(1);
             } else if(i==2){
                 mViewPager.setCurrentItem(2);
               return;
             }
            count++;
            handler.postDelayed(runnable,2000);



        }

    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        initView();
        initData();


    }

    private void initData() {
        preferences = getSharedPreferences("gitdemo", MODE_PRIVATE);
        int git = preferences.getInt("git",0);
        if(git==1){
            startActivity(new Intent(StartActivity.this,LoginActivity.class));
        }else{
            ArrayList<View> views = new ArrayList<>();
            View view_one = LayoutInflater.from(StartActivity.this).inflate(R.layout.launchroastingchart_1, null);
            views.add(view_one);
            View view_two = LayoutInflater.from(StartActivity.this).inflate(R.layout.launchroastingchart_2, null);
            views.add(view_two);
            View view_three = LayoutInflater.from(StartActivity.this).inflate(R.layout.launchroastingchart_3, null);
            views.add(view_three);

            StartAdapter startAdapter = new StartAdapter(views);
            mViewPager.setAdapter(startAdapter);
            handler.postDelayed(runnable,2000);
            Button bt_start = view_three.findViewById(R.id.bt_start);
            bt_start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences.Editor edit = preferences.edit();
                    edit.putInt("git",1);
                    edit.commit();
                    startActivity(new Intent(StartActivity.this,LoginActivity.class));

                }
            });
        }



    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.mViewPager);
    }
}
