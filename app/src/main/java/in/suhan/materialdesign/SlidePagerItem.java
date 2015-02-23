package in.suhan.materialdesign;

import android.graphics.Color;

/**
 * Created by ssaha8 on 17/02/2015.
 */
public class SlidePagerItem {
    public SlidePagerItem(String title, int indicatorColor, int dividerColor) {
        this.title = title;
        this.indicatorColor = indicatorColor;
        this.dividerColor = dividerColor;
    }

    private String title;

    public String getTitle() {
        return title;
    }

    public int getIndicatorColor() {
        return indicatorColor;
    }

    public int getDividerColor() {
        return dividerColor;
    }

    private int indicatorColor;
    private int dividerColor;

}
