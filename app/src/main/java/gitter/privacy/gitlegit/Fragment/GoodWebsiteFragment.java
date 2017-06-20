package gitter.privacy.gitlegit.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
        ((MainActivity)getActivity()).setStoryContainerVisible(false);

        return parentView;
    }

    @OnClick(R.id.cleaner_job)
    public void goToCleanerJobDetail(){
        JobDetailFragment fragment = new JobDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(JobDetailFragment.JOB_CHOSEN, JobDetailFragment.CLEANER_JOB);
        fragment.setArguments(bundle);

        ((MainActivity)getActivity()).switchToDifferentScreen(fragment,JobDetailFragment.TAG, false);
    }

    @OnClick(R.id.volunteer_job)
    public void goToVolunteerJobDetail(){
        JobDetailFragment fragment = new JobDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(JobDetailFragment.JOB_CHOSEN, JobDetailFragment.VOLUNTEER_JOB);
        fragment.setArguments(bundle);

        ((MainActivity)getActivity()).switchToDifferentScreen(fragment,JobDetailFragment.TAG, false);
    }

}
