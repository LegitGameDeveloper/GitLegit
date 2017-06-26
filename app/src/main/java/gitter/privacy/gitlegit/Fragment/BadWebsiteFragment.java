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
 * Created by jahmale_c on 20/06/2017.
 */

public class BadWebsiteFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = bindXMLToFragment(R.layout.bad_website_fragment, inflater,container);
        ButterKnife.bind(this, parentView);

        return parentView;
    }

    @OnClick(R.id.fake_job1)
    public void goToFakeJob1(){
        BadJobDetailFragment fragment = new BadJobDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BadJobDetailFragment.BAD_JOB_KEY_TITLE, getString(R.string.fake_job_1_title));
        bundle.putString(BadJobDetailFragment.BAD_JOB_KEY_DESCRIPTION, getString(R.string.fake_job_1_description));
        fragment.setArguments(bundle);

        ((MainActivity)getActivity()).switchToDifferentScreen(fragment, BadJobDetailFragment.class.getSimpleName(), false);
    }

    @OnClick(R.id.fake_job2)
    public void goToFakeJob2(){
        BadJobDetailFragment fragment = new BadJobDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BadJobDetailFragment.BAD_JOB_KEY_TITLE, getString(R.string.fake_job_2_title));
        bundle.putString(BadJobDetailFragment.BAD_JOB_KEY_DESCRIPTION, getString(R.string.fake_job_2_description));
        fragment.setArguments(bundle);

        ((MainActivity)getActivity()).switchToDifferentScreen(fragment, BadJobDetailFragment.class.getSimpleName(), false);
    }

    @OnClick(R.id.fake_job3)
    public void goToFakeJob3(){
        BadJobDetailFragment fragment = new BadJobDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BadJobDetailFragment.BAD_JOB_KEY_TITLE, getString(R.string.fake_job_3_title));
        bundle.putString(BadJobDetailFragment.BAD_JOB_KEY_DESCRIPTION, getString(R.string.fake_job_3_description));
        fragment.setArguments(bundle);

        ((MainActivity)getActivity()).switchToDifferentScreen(fragment, BadJobDetailFragment.class.getSimpleName(), false);
    }

    @OnClick(R.id.fake_job4)
    public void goToFakeJob4(){
        BadJobDetailFragment fragment = new BadJobDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BadJobDetailFragment.BAD_JOB_KEY_TITLE, getString(R.string.fake_job_4_title));
        bundle.putString(BadJobDetailFragment.BAD_JOB_KEY_DESCRIPTION, getString(R.string.fake_job_4_description));
        fragment.setArguments(bundle);

        ((MainActivity)getActivity()).switchToDifferentScreen(fragment, BadJobDetailFragment.class.getSimpleName(), false);
    }
}
