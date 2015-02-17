package co.mobilemakers.wikipediatrekships;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ariel.cattaneo on 17/02/2015.
 */
public class WikiQuery {
    @SerializedName("categorymembers")
    List<WikiCategoryMember> mCategoryMembers;

    public List<WikiCategoryMember> getCategoryMembers() {
        return mCategoryMembers;
    }
}
