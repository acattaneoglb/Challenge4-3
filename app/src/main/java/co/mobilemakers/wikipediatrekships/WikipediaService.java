package co.mobilemakers.wikipediatrekships;

import android.util.Base64;

import java.util.List;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.http.GET;

/**
 * Wikipedia access service
 *
 * Created by ariel.cattaneo on 17/02/2015.
 */
public class WikipediaService {

    // http://en.wikipedia.org/w/api.php?action=query&list=categorymembers&cmtitle=Category:Physics
    final static String WIKIPEDIA_API_URL = "http://en.wikipedia.org/w";
    final static String SHIPS_ENDPOINT =
            "/api.php?action=query&list=categorymembers&cmtitle=Category:Star_Trek_spacecraft&format=json";
//    final static String SHIP_INFO_ENDPOINT = "/projects/{id}/items.json";
    final static String ACCEPTED_DATA = "application/json";

    public interface ApiInterface {
        @GET(SHIPS_ENDPOINT)
        void getShips(Callback<WikiJsonResponse> callback);

/*
        @GET(PROJECT_TASKS_ENDPOINT)
        void getTasksForProjectId(@Path("id")String id, Callback<List<TodolyTask>> callback);
*/
    }

    public WikipediaService() {

    }

    public ApiInterface generateServiceInterface() {
        RestAdapter.Builder builder = new RestAdapter.Builder();
/*
        builder.setEndpoint(WIKIPEDIA_API_URL)
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
                        request.addHeader("Accept", ACCEPTED_DATA);
                    }
                });
*/
        builder.setEndpoint(WIKIPEDIA_API_URL);

        RestAdapter restAdapter = builder.build();

        return restAdapter.create(ApiInterface.class);
    }
}
