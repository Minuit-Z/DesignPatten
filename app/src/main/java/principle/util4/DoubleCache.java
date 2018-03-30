package principle.util4;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 2017/10/25 0025.
 */

public class DoubleCache implements ImageCache {
    ImageCache mMemoryCache=new MemoryCache();
    ImageCache mDiskCache=new DiskCache();

    @Override
    public Bitmap get(String url) {
        Bitmap bitmap = mMemoryCache.get(url);
        if (null==bitmap){
            bitmap=mDiskCache.get(url);
        }
        return bitmap;
    }

    @Override
    public void put(String url, Bitmap bitmap) {
        mMemoryCache.put(url,bitmap);
        mDiskCache.put(url,bitmap);
    }
}
