package app.demo0912;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robot on 2017/9/12.
 */

public class HomeFragment extends Fragment {

    Banner banner;
    //图片
    List<Integer> images = new ArrayList<>();
    List<Integer> images1 = new ArrayList<>();
    RecyclerView rv;
    DrawerLayout dl;
    NavigationView nv;
    Toolbar bar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);

        initView(view);

        initDrawer();

        initBanner();

        initRV();

        return view;
    }

    private void initDrawer() {
        ActionBarDrawerToggle ac = new ActionBarDrawerToggle(getActivity(), dl, bar, R.string.open, R.string.close);
        ac.syncState();
        dl.addDrawerListener(ac);
        View header = nv.getHeaderView(0);
        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "头部条目", Toast.LENGTH_SHORT).show();
            }
        });
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.center:
                        Toast.makeText(getActivity(), "个人中心", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.setting:
                        Toast.makeText(getActivity(), "设置", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
    }

    private void initRV() {
        for (int i = 0; i < 20; i++) {
            images1.add(R.mipmap.u98);
        }
        rv.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));
        rv.setAdapter(new HomeAdapter(getContext(), images1));
    }

    private void initView(View view) {
        banner = view.findViewById(R.id.banner);
        rv = view.findViewById(R.id.rv);
        dl = view.findViewById(R.id.dl);
        nv = view.findViewById(R.id.nv);
        bar = view.findViewById(R.id.bar);
    }

    private void initBanner() {
        images.add(R.mipmap.u3);
        images.add(R.mipmap.u5);
        images.add(R.mipmap.u7);
        banner.setImageLoader(new ImageLoader());
        banner.setImages(images);
        banner.start();
    }
}
