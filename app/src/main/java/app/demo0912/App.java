package app.demo0912;

import android.app.Application;

import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * Created by dell on 2017/9/12.
 */

public class App extends Application{

    {
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
    }

    //对sdk进行初始化  开启DEBUG模式

    @Override
    public void onCreate() {
        super.onCreate();
        UMShareAPI.get(this);
        //导包导import com.umeng.socialize.Config;
        Config.DEBUG = true;
    }




}
