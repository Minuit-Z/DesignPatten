package mvpframe.bean;

import android.support.annotation.DrawableRes;

/**
 * Created by Administrator on 2018/4/4 0004.
 */

public class Girl {
    public int imgId;
    public String desc;

    public Girl(@DrawableRes int imgId, String desc) {
        this.imgId = imgId;
        this.desc = desc;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
