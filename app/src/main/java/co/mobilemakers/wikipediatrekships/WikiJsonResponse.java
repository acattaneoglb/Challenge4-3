package co.mobilemakers.wikipediatrekships;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ariel.cattaneo on 17/02/2015.
 */
public class WikiJsonResponse {
    @SerializedName("query")
    WikiQuery mQuery;

    public WikiQuery getQuery() {
        return mQuery;
    }
}
