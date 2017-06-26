package gitter.privacy.gitlegit.Fragment;

import android.os.Bundle;
import android.os.Handler;
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
import gitter.privacy.gitlegit.Util.Values;

import static android.util.TypedValue.COMPLEX_UNIT_SP;

/**
 * Created by jahmale_c on 15/06/2017.
 */

public class GoodJobDetailFragment extends BaseFragment {

    public static final String TAG = "GoodJobDetailFragment";

    @BindView(R.id.frame_view)
    ViewGroup  frameView;
    @BindView(R.id.sendMailView)
    ViewGroup sendMailView;
    @BindView(R.id.job_info_view)
    ViewGroup jobInfoView;
    @BindView(R.id.job_title)
    TextView mJobTitle;
    @BindView(R.id.job_description)
    TextView mJobDescription;
    @BindView(R.id.mail_sender)
    TextView senderView;
    @BindView(R.id.sketchy_popup)
    ViewGroup sketchyView;
    @BindView(R.id.sketchy_title)
    TextView mSketchyTitle;
    @BindView(R.id.sketch_tel)
    TextView sketchyTel;

    public static final String JOB_CHOSEN = "job_John_chose";
    public static final String CLEANER_JOB = "cleaner";
    public static final String VOLUNTEER_JOB = "volunteer";
    public static final String REAL_JOB = "real_job";
    public static final String LAWYER_JOB = "lawyer_job";

    private boolean showingSketchy = false;

    private static final String senderPrefix = "To: ";
    private boolean enteredNumberSketchy = false;

    private chosenJob currentJob;
    private Handler delayHandler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = bindXMLToFragment(R.layout.good_job_detail_view, inflater, container);
        ButterKnife.bind(this, parentView);
        ((MainActivity)getActivity()).setmStoryContainerListener(null);

        frameView.getBackground().setAlpha(0);

        String userjob = getArguments().getString(JOB_CHOSEN);
        if(userjob == null){
            currentJob = chosenJob.CLEANER;
        }else{
            switch (userjob){
                case CLEANER_JOB:
                    currentJob = chosenJob.CLEANER;
                    break;
                case LAWYER_JOB:
                    currentJob = chosenJob.LAWYER;
                    break;
                case REAL_JOB:
                    currentJob = chosenJob.LEGIT;
                    break;
                default:
                    currentJob = chosenJob.CLEANER;
                    break;
            }
        }

        setJobDetails();

        return parentView;
    }

    public void setJobDetails(){
        String infoText = "";
        if(currentJob == chosenJob.CLEANER){
            mJobTitle.setText(getString(R.string.cleaner_job_title));
            infoText = getString(R.string.cleaner_job_description) +
                    "\n send us a mail with a valid social security" +
                    " number and we will contact you within 24hours";
        }else if(currentJob == chosenJob.LAWYER){
            mJobTitle.setText(getString(R.string.lawyer_job_title));
            infoText = getString(R.string.lawyer_job_description) +
                    "\n send us a mail with a valid social security number, " +
                    "\n upon receiving it you will be able to start within 3 days";
        }else if(currentJob == chosenJob.LEGIT){
            mJobTitle.setText(getString(R.string.legit_job_title));
            infoText = getString(R.string.legit_job_title) + "hit apply and linked will send us your" +
                    " name and telephone number so that we can contact you!";
        }

        mJobDescription.setText(infoText);
    }

    @OnClick(R.id.applyBtn)
    public void doApply(){
        if(currentJob == chosenJob.LAWYER || currentJob == chosenJob.CLEANER){

            jobInfoView.setVisibility(View.GONE);
            sendMailView.setVisibility(View.VISIBLE);
            frameView.getBackground().setAlpha(255);

            if(currentJob == chosenJob.LAWYER){
                senderView.setText(senderPrefix+"bcslawyers@bcs.com");
            }else if(currentJob == chosenJob.CLEANER){
                senderView.setText(senderPrefix+"optionalcleaning@info.com");
            }

        }else if(currentJob == chosenJob.LEGIT){
            mJobDescription.setText("Great we have informed the company that you are interested, they will contact you soon!");
            doPopupTransition(true);
        }
    }

    private void doPopupTransition(boolean delayFirst){
        delayHandler = new Handler();

        if(delayFirst){
            delayHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    ((MainActivity)getActivity()).setStoryContainerVisible(true);
                    ((MainActivity)getActivity()).setStoryText("Alright, now I just need to wait until the company calls me!", "John");
                }
            },1500);
        }else{
            ((MainActivity)getActivity()).setStoryContainerVisible(true);
            ((MainActivity)getActivity()).setStoryText("Alright, now I just need to wait until the company calls me!", "John");
        }

        delayHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ((MainActivity)getActivity()).setStoryContainerVisible(false);
                sketchyView.setVisibility(View.VISIBLE);
            }
        },3000);

        delayHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ((MainActivity)getActivity()).bringStoryToFront();
                ((MainActivity)getActivity()).setStoryContainerVisible(true);
                ((MainActivity)getActivity()).setStoryText("Ooh, this seems like a great job offer", "John");
            }
        },4000);

        delayHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ((MainActivity)getActivity()).setStoryContainerVisible(false);
                showingSketchy = true;
            }
        },5500);
    }

    @OnClick(R.id.sketchy_send_btn)
    public void sendSketchyConfirm(){
        if(enteredNumberSketchy){
            switchToEnding();
        }else{
            enteredNumberSketchy = true;
            ((MainActivity)getActivity()).setStoryContainerVisible(true);
            ((MainActivity)getActivity()).setStoryText("Okay, let me enter my number", "John");
            sketchyTel.setText("tel: 031-5703423");
            delayHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    ((MainActivity)getActivity()).setStoryContainerVisible(false);
                }
            },1000);

        }
    }

    @OnClick(R.id.sketch_cancel_btn)
    public void cancelSketch(){
        switchToEnding();

    }

    private void switchToEnding(){
        ((MainActivity)getActivity()).setStoryContainerVisible(true);
        ((MainActivity)getActivity()).setStoryText("Alright, I'll head home for now!", "John");
        delayHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ((MainActivity)getActivity()).switchToDifferentScreen(new EndingFragment(), EndingFragment.class.getSimpleName(), false);
            }
        },1500);
    }

    @OnClick(R.id.sendMailBtn)
    public void sendMail(){
        sendMailView.setVisibility(View.GONE);
        doPopupTransition(false);
    }

    @OnClick(R.id.cancelMailBtn)
    public void cancelMail(){
        frameView.getBackground().setAlpha(0);
        sendMailView.setVisibility(View.GONE);
        jobInfoView.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.back_btn)
    public void goBackToGoodWebsiteJobOverview(){
        if(showingSketchy){
            mSketchyTitle.setTextSize(COMPLEX_UNIT_SP, Values.pixelsToSp(getActivity(),mSketchyTitle.getTextSize())+2);
        }else{
            ((MainActivity)getActivity()).switchToDifferentScreen(new GoodWebsiteFragment(), GoodWebsiteFragment.TAG, false);
        }
    }

    public enum chosenJob{
        CLEANER, LAWYER, LEGIT
    }
}
