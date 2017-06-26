package gitter.privacy.gitlegit.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gitter.privacy.gitlegit.MainActivity;
import gitter.privacy.gitlegit.R;

/**
 * Created by jahmale_c on 20/06/2017.
 */

public class SearchEngineFragment extends BaseFragment {

    public static final String TAG = "SearchEngineFragment";
    @BindView(R.id.search_et)
    EditText searchBar;
    @BindView(R.id.bad_website)
    ViewGroup mBadWebsite;
    @BindView(R.id.good_website)
    ViewGroup mGoodWebsite;
    @BindView(R.id.no_results_view)
    ViewGroup mNoResultView;
    @BindView(R.id.results_found_view)
    ViewGroup mResultsFoundView;
    @BindView(R.id.searchpage_view)
    ViewGroup mSearchPageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = bindXMLToFragment(R.layout.search_results_view, inflater,container);
        ButterKnife.bind(this, parentView);
        
        ((MainActivity)getActivity()).setStoryContainerVisible(true);
        ((MainActivity)getActivity()).setStoryText(getString(R.string.search_engine_text1),"John");

        ((MainActivity)getActivity()).setmStoryContainerListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // doesn't do anything
            }
        });
        
        return parentView;
    }

    @OnClick(R.id.search_btn)
    public void doSearch(){
        String textToEvaluate = searchBar.getText().toString();
        textToEvaluate = textToEvaluate.trim().replaceAll(" +", " ");
        if(textToEvaluate.equalsIgnoreCase("apply for job")){
            ((MainActivity)getActivity()).setStoryContainerVisible(false);
            mSearchPageView.setVisibility(View.GONE);
            mResultsFoundView.setVisibility(View.VISIBLE);
        }else{
            mSearchPageView.setVisibility(View.GONE);
            mNoResultView.setVisibility(View.VISIBLE);
        }
    }

    @OnClick(R.id.try_again_btn)
    public void doOtherSearch(){
        mNoResultView.setVisibility(View.GONE);
        mSearchPageView.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.bad_website)
    public void goToBadWebsite(){
        ((MainActivity)getActivity()).switchToDifferentScreen(new BadWebsiteFragment(), "BadWebsiteFragment", false);
    }

    @OnClick(R.id.good_website)
    public void goToGoodWebsite(){
        ((MainActivity)getActivity()).switchToDifferentScreen(new GoodWebsiteFragment(), "GoodWebsiteFragment", false);
    }

}
