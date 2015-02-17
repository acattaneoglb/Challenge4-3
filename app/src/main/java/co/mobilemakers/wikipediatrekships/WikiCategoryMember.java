package co.mobilemakers.wikipediatrekships;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ariel.cattaneo on 17/02/2015.
 */
public class WikiCategoryMember {
    @SerializedName("pageid")
    int mPageId;
    @SerializedName("title")
    String mTitle;

    public String getTitle() {
        return mTitle;
    }
}
