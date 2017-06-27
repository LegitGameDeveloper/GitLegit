package gitter.privacy.gitlegit.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gitter.privacy.gitlegit.MainActivity;
import gitter.privacy.gitlegit.R;

/**
 * Created by jahmale_c on 15/06/2017.
 */

public class GoodWebsiteFragment extends BaseFragment {

    public static final String TAG = "GoodWebsiteFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = bindXMLToFragment(R.layout.good_website_view, inflater, container);
        ButterKnife.bind(this, parentView);

        return parentView;
    }

    @OnClick(R.id.cleaner_job)
    public void goToCleanerJobDetail(){
        GoodJobDetailFragment fragment = new GoodJobDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(GoodJobDetailFragment.JOB_CHOSEN, GoodJobDetailFragment.CLEANER_JOB);
        fragment.setArguments(bundle);

        ((MainActivity)getActivity()).switchToDifferentScreen(fragment, GoodJobDetailFragment.TAG, false);
    }

    @OnClick(R.id.lawyer_job)
    public void goToLawyerJobDetail(){
        GoodJobDetailFragment fragment = new GoodJobDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(GoodJobDetailFragment.JOB_CHOSEN, GoodJobDetailFragment.LAWYER_JOB);
        fragment.setArguments(bundle);

        ((MainActivity)getActivity()).switchToDifferentScreen(fragment, GoodJobDetailFragment.TAG, false);
    }

    @OnClick(R.id.real_job)
    public void goToRealJobDetail(){
        GoodJobDetailFragment fragment = new GoodJobDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(GoodJobDetailFragment.JOB_CHOSEN, GoodJobDetailFragment.REAL_JOB);
        fragment.setArguments(bundle);

        ((MainActivity)getActivity()).switchToDifferentScreen(fragment, GoodJobDetailFragment.TAG, false);
    }

    @OnClick(R.id.back_btn)
    public void goBackToSearchResults(){
        ((MainActivity)getActivity()).switchToDifferentScreen(new SearchEngineFragment(), SearchEngineFragment.TAG, false);
    }

}
