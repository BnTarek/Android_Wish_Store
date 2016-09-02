package com.wishstore.bntarek.wish_store;

/**
 * Created by BnTarek on 2/9/2016.
 */

public class Product {
    private String mName;
    private String mDescription;
    private int mThumbnailUrl;

    public Product() {}

    public Product(String name, String description, int thumbnail) {
        this.setName(name);
        this.setDescription(description);
        this.setThumbnailUrl(thumbnail);
    }

    public String getName() {
        return mName;
    }

    public void setName(String mTitle) {
        this.mName = mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public int getThumbnailUrl() {
        return mThumbnailUrl;
    }

    public void setThumbnailUrl(int mThumbnailUrl) {
        this.mThumbnailUrl = mThumbnailUrl;
    }
}
