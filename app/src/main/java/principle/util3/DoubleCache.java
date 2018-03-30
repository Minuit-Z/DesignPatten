package principle.util3;


import android.graphics.Bitmap;

/**
 * Created by Administrator on 2017/10/25 0025.
 */

public class DoubleCache {
    ImageCache mMemoryCache = new ImageCache();
    DiskCache diskCache = new DiskCache();

    public Bitmap get(String url) {
        //先从缓存获取
        Bitmap bitmap = mMemoryCache.get(url);
        //如果缓存没有数据, 从sd卡中获取
        if (null == bitmap) {
            bitmap = diskCache.get(url);
        }
        return bitmap;
    }

    public void put(String url, Bitmap bitmap) {
        mMemoryCache.put(url, bitmap);
        diskCache.put(url, bitmap);
    }
}
