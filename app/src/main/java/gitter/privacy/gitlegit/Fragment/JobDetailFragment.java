package gitter.privacy.gitlegit.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gitter.privacy.gitlegit.MainActivity;
import gitter.privacy.gitlegit.R;

/**
 * Created by jahmale_c on 15/06/2017.
 */

public class JobDetailFragment extends BaseFragment {

    public static final String TAG = "JobDetailFragment";

    @BindView(R.id.job_title)
    TextView mJobTitle;
    @BindView(R.id.job_description)
    TextView mJobDescription;

    public static final String JOB_CHOSEN = "job_John_chose";
    public static final String CLEANER_JOB = "cleaner";
    public static final String VOLUNTEER_JOB = "volunteer";
    public static final String REAL_JOB = "real_job";
    private chosenJob currentJob;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = bindXMLToFragment(R.layout.job_detail_view, inflater, container);
        ButterKnife.bind(this, parentView);

        String userjob = getArguments().getString(JOB_CHOSEN);
        if(userjob == null){
            currentJob = chosenJob.CLEANER;
        }else{
            switch (userjob){
                case CLEANER_JOB:
                    currentJob = chosenJob.CLEANER;
                    break;
                case VOLUNTEER_JOB:
                    currentJob = chosenJob.VOLUNTEER;
                    break;
                default:
                    currentJob = chosenJob.CLEANER;
                    break;
            }
        }

        //now that the job is set, we can apply the details
        setJobDetails();

        return parentView;
    }

    public void setJobDetails(){
        if(currentJob == chosenJob.CLEANER){
            mJobTitle.setText(getString(R.string.cleaner_job_title));
            mJobDescription.setText(getString(R.string.cleaner_job_description));
        }else if(currentJob == chosenJob.VOLUNTEER){
            mJobTitle.setText(getString(R.string.volunteer_job_title));
            mJobDescription.setText(getString(R.string.volunteer_job_description));
        }
    }

    @OnClick(R.id.applyBtn)
    public void doApply(){
        //TODO: show the aplication form for the user alongside his ID
        ((MainActivity)getActivity()).switchToDifferentScreen(new FillOutFormFragment(), FillOutFormFragment.TAG, false);
    }

    public enum chosenJob{
        CLEANER, VOLUNTEER
    }
}
