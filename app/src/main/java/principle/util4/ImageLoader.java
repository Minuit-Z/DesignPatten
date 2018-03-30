package principle.util4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/10/25 0025.
 */

public class ImageLoader {
    //缓存,默认初始化为内存缓存，可以通过方法设置成其他的缓存方式
    ImageCache imageCache = new MemoryCache();
    ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    //注入缓存
    public void setImageCache(ImageCache cache) {
        this.imageCache = cache;
    }

    public void displayImage(String url, ImageView imageView) {
        Bitmap bitmap = imageCache.get(url);
        if (null != bitmap) {
            //缓存中存在图片
            imageView.setImageBitmap(bitmap);
            return;
        }
        submitLoadRequest(url, imageView);
    }

    /**
     * @author 张子扬
     * @time 2017/10/25 0025 17:26
     * @desc 在线程池中缓存图片
     */
    private void submitLoadRequest(final String url, final ImageView imageView) {
        imageView.setTag(url);
        service.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = downloadBitmap(url);
                if (null==bitmap){
                    return;
                }
                if (imageView.getTag().equals(url)){
                    imageView.setImageBitmap(bitmap);
                }
                imageCache.put(url,bitmap);
            }
        });
    }

    private Bitmap downloadBitmap(String urls) {
        Bitmap bitmap = null;
        URL url = null;
        try {
            url = new URL(urls);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            bitmap= BitmapFactory.decodeStream(conn.getInputStream());
            conn.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
