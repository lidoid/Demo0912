package app.demo0912;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageLoader extends com.youth.banner.loader.ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load(path).into(imageView);
//        Picasso.with(context).load(path).into(imageView);
    }
}
