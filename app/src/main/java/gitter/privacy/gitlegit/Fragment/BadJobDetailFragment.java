package gitter.privacy.gitlegit.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gitter.privacy.gitlegit.MainActivity;
import gitter.privacy.gitlegit.R;

/**
 * Created by jahmale_c on 21/06/2017.
 */

public class BadJobDetailFragment extends BaseFragment {

    @BindView(R.id.background_frame)
    ViewGroup background_frame;

    @BindView(R.id.job_title)
    TextView jobTitle;
    @BindView(R.id.job_description)
    TextView jobDescription;

    @BindView(R.id.apply_btn)
    Button applyBtn;

    @BindView(R.id.applyForm)
    ScrollView form;

    public static final String BAD_JOB_KEY_TITLE = "bad_job_key_name";
    public static final String BAD_JOB_KEY_DESCRIPTION = "bad_job_key_description";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = bindXMLToFragment(R.layout.bad_job_detail_view, inflater,container);
        ButterKnife.bind(this, parentView);
        form.setVisibility(View.GONE);
        background_frame.getBackground().setAlpha(0);

        jobTitle.setText(getArguments().getString(BAD_JOB_KEY_TITLE));
        jobDescription.setText(getArguments().getString(BAD_JOB_KEY_DESCRIPTION));

        return parentView;
    }

    @OnClick(R.id.apply_btn)
    public void showForm(){
        form.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.sendFormBtn)
    public void sendForm(){
        ((MainActivity)getActivity()).setStoryContainerVisible(true);
        //TODO: if clicked once, john will say he didnt fill anything, so he will fill it out, and say let's try that again
    }

}
