package principle.util4;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 2017/10/25 0025.
 */

public interface ImageCache {

    public Bitmap get(String url);
    public void put(String url,Bitmap bitmap);
}
