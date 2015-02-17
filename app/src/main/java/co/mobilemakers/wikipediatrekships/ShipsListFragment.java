package co.mobilemakers.wikipediatrekships;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A placeholder fragment containing a simple view.
 */
public class ShipsListFragment extends ListFragment {

    final static String LOG_TAG = ShipsListFragment.class.getSimpleName();

    WikipediaService.ApiInterface mWikiApiInterface;
    ArrayAdapter<WikiCategoryMember> mAdapter;

    private void prepareListView() {
        List<WikiCategoryMember> projects = new ArrayList<>();
        mAdapter = new ArrayAdapter<>(getActivity(),
                R.layout.list_item_ship, R.id.text_view_ship_name, projects);
        setListAdapter(mAdapter);
/*
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ShipModel selectedShip = mAdapter.getItem(position);
                String pageId = Integer.toString(selectedShip.getPageId());
                Intent intent = new Intent(getActivity(), ShipInfoActivity.class);
                intent.putExtra(ShipInfoActivity.PROJECT_ID, pageId);
                startActivity(intent);
            }
        });
*/
    }

    public ShipsListFragment() {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        WikipediaService wikiService = new WikipediaService();
        mWikiApiInterface = wikiService.generateServiceInterface();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        prepareListView();
    }

    @Override
    public void onStart() {
        super.onStart();
        mWikiApiInterface.getShips(new Callback<WikiJsonResponse>() {
            @Override
            public void success(WikiJsonResponse wikiJsonResponse, Response response) {
                Log.e(LOG_TAG, response.getBody().toString());
                mAdapter.clear();
                mAdapter.addAll(wikiJsonResponse.getQuery().getCategoryMembers());
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e(LOG_TAG, "Project retrieval status problem: " + error.getBody());
            }
        });
    }
}
