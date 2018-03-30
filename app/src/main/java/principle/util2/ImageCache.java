package principle.util2;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by Administrator on 2017/10/25 0025.
 */

public class ImageCache {
    private LruCache<String, Bitmap> mImageCache;

    public ImageCache() {
    }

    public void initImageCache() {
        final int maxMemory = (int) (Runtime.getRuntime().freeMemory() / 1024);

        final int cacheSize = maxMemory / 4;
        mImageCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                // 计算Bitmap占用的内存
                return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
            }
        };
    }

    public void put(String url, Bitmap bitmap) {
        mImageCache.put(url, bitmap);
    }

    public Bitmap get(String url) {
        return mImageCache.get(url);
    }
}
