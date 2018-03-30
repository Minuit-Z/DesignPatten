package principle.util2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/10/25 0025.
 */

public class ImageLoader {
    private static ImageLoader instance;
    //图片缓存
    private ImageCache mImageCache = new ImageCache();
    //线程池,使用线程来进行网络请求获取图片
    ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static ImageLoader getInstance() {
        if (instance == null) {
            instance = new ImageLoader();
        }
        return instance;
    }

    public void displayImage(final String url, final ImageView imageView) {
        Bitmap bitmap = mImageCache.get(url);
        if (null != bitmap) {
            imageView.setImageBitmap(bitmap);
        } else {
            imageView.setTag(url);

            mExecutorService.submit(new Runnable() {
                @Override
                public void run() {
                    Bitmap bitmap = downloadImage(url);
                    if (null == bitmap) {
                        return;
                    }
                    if (imageView.getTag().equals(url)) {
                        imageView.setImageBitmap(bitmap);
                    }
                    mImageCache.put(url, bitmap);
                }
            });
        }
    }

    private Bitmap downloadImage(String urls) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(urls);
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStream inputStream = conn.getInputStream();

            bitmap = BitmapFactory.decodeStream(inputStream);
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return bitmap;
        }
    }

}
