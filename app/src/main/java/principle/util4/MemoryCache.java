package principle.util4;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by Administrator on 2017/10/25 0025.
 */

public class MemoryCache implements ImageCache{
    private LruCache<String,Bitmap> mMemoryCache;

    @Override
    public Bitmap get(String url) {
        return mMemoryCache.get(url);
    }

    @Override
    public void put(String url, Bitmap bitmap) {
        mMemoryCache.put(url,bitmap);
    }
}
