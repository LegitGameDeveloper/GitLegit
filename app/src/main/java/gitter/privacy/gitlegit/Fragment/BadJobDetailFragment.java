package gitter.privacy.gitlegit.Fragment;

import android.os.Bundle;
import android.os.Handler;
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

    @BindView(R.id.form_name)
    TextView formName;
    @BindView(R.id.form_address)
    TextView formAddress;
    @BindView(R.id.form_socialsecuritynr)
    TextView formSocialSecurityNr;
    @BindView(R.id.form_surname)
    TextView formSurname;

    private Handler handler;
    private boolean enteredInformation = false;

    public static final String BAD_JOB_KEY_TITLE = "bad_job_key_name";
    public static final String BAD_JOB_KEY_DESCRIPTION = "bad_job_key_description";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = bindXMLToFragment(R.layout.bad_job_detail_view, inflater,container);
        ButterKnife.bind(this, parentView);
        handler = new Handler();
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
        if(!enteredInformation){
            ((MainActivity)getActivity()).setStoryContainerVisible(true);
            ((MainActivity)getActivity()).bringStoryToFront();
            ((MainActivity)getActivity()).setStoryText("I'll fill in my information", "John");
            enteredInformation = true;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    formName.setText("John");
                    formSurname.setText("Doe");
                    formSocialSecurityNr.setText("0936759201");
                    formAddress.setText("WhoseVille 95");
                    ((MainActivity)getActivity()).setStoryContainerVisible(false);
                }
            },750);
        }else{
            ((MainActivity)getActivity()).setStoryContainerVisible(true);
            ((MainActivity)getActivity()).bringStoryToFront();
            ((MainActivity)getActivity()).setStoryText("Can't wait until I get called back!", "John");
            ((MainActivity)getActivity()).setWrongWebsiteChosen(true);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    ((MainActivity)getActivity()).setStoryContainerVisible(false);
                    ((MainActivity)getActivity()).switchToDifferentScreen(new EndingFragment(), EndingFragment.class.getSimpleName(),false);
                }
            },1000);
        }
        //TODO: if clicked once, john will say he didnt fill anything, so he will fill it out, and say let's try that again
    }

}
