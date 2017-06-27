package gitter.privacy.gitlegit.Fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gitter.privacy.gitlegit.MainActivity;
import gitter.privacy.gitlegit.R;

import static gitter.privacy.gitlegit.R.id.button1;
import static gitter.privacy.gitlegit.R.id.button2;
import static gitter.privacy.gitlegit.R.id.end;
import static gitter.privacy.gitlegit.R.id.supermarket_birthday;
import static gitter.privacy.gitlegit.R.id.supermarket_cellphomeNR;
import static gitter.privacy.gitlegit.R.id.supermarket_email;
import static gitter.privacy.gitlegit.R.id.supermarket_name;
import static gitter.privacy.gitlegit.R.id.supermarket_resident;
import static gitter.privacy.gitlegit.R.id.supermarket_signup;

/**
 * Created by jahmale_c on 15/06/2017.
 */

public class FoodIntroFragment extends BaseFragment implements View.OnClickListener {

    public static final String TAG = "FoodIntroFragment";
    private boolean containerIsVisible = false;
    private int textCounter = 0;

    Button myButton1, myButton2, myRegisterButton;

    @BindView(R.id.restart_btn)
    LinearLayout restartBtn;
    @BindView(R.id.QuestionToAsk)
    TextView textview1;
    @BindView(R.id.regularView)
    ViewGroup regularView;
    @BindView(R.id.websitePopup)
    ViewGroup websitePopup;
    @BindView(R.id.terms_conditions_overview)
    ViewGroup termsAndConditionsContainer;
    @BindView(R.id.terms_conditions_scroll)
    ScrollView termsAndConditionsScroll;
    @BindView(R.id.terms_conditions_text)
    TextView termsNConditionsText;
    @BindView(R.id.accept_terms)
    Button acceptTermButton;

    EditText mSuperMarktName_et, mSuperMarktBirthday_et, mSuperMarktResident_et, mSuperMarktCellPhone_et, mSuperMarktEmail;

    int stap;

    private Handler handler;
    private boolean didSignup = false;
    private boolean selfieDone = false;
    private boolean termsDone = false;
    private String choice = "";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setTextContainerListener();
        parentView = bindXMLToFragment(R.layout.food_intro_view, inflater, container);
        ButterKnife.bind(this, parentView);

        myButton1 = (Button) parentView.findViewById(button1);
        myButton1.setOnClickListener(this);
        myButton2 = (Button) parentView.findViewById(button2);
        myButton2.setOnClickListener(this);

        mSuperMarktName_et = (EditText) parentView.findViewById(supermarket_name);
        mSuperMarktBirthday_et = (EditText) parentView.findViewById(supermarket_birthday);
        mSuperMarktResident_et = (EditText) parentView.findViewById(supermarket_resident);
        mSuperMarktCellPhone_et = (EditText) parentView.findViewById(supermarket_cellphomeNR);
        mSuperMarktEmail = (EditText) parentView.findViewById(supermarket_email);
        myRegisterButton = (Button) parentView.findViewById(supermarket_signup);
        myRegisterButton.setOnClickListener(this);
        handler = new Handler();

        return parentView;
    }

    // deny terms
    private ClickableSpan clickableSpan = new ClickableSpan() {
        @Override
        public void onClick(View textView) {
            termsAndConditionsContainer.setVisibility(View.GONE);

            ((MainActivity)getActivity()).setStoryText("Done!", "John");
            textCounter = 38;
            ((MainActivity)getActivity()).setStoryContainerVisible(true);
            acceptTermButton.setVisibility(View.GONE);
            termsNConditionsText.setVisibility(View.GONE);
            termsAndConditionsScroll.setVisibility(View.GONE);
            websitePopup.setVisibility(View.GONE);
        }
    };

    public void setTextContainerListener(){
        ((MainActivity)getActivity()).setmStoryContainerListener(storyListener);
        ((MainActivity)getActivity()).setStoryText(getString(R.string.john_introduction_info_1),"");
        textCounter++;
    }

    private View.OnClickListener storyListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(!containerIsVisible){
                ((MainActivity)getActivity()).setStoryContainerVisible(true);
                containerIsVisible = true;
            }

            switch (textCounter){
                case 0:
                    //((MainActivity)getActivity()).setMainBackgroundImage(R.drawable.);
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_introduction_info_1),"");
                    break;
                case 1:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_introduction_info_2),"");
                    break;
                case 2:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_introduction_1),"John");
                    break;
                case 3:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_introduction_2),"John");
                    break;
                case 4:
                    //                   ((MainActivity)getActivity()).switchToDifferentScreen(new SearchingForJobFragment(),SearchingForJobFragment.TAG, false);
                case 5:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario2_1),"");
                    break;
                case 6:
                    stap = 1;
                    myButton1.setVisibility(View.VISIBLE);
                    myButton2.setVisibility(View.VISIBLE);
                    textview1.setVisibility(View.VISIBLE);
                    ((MainActivity)getActivity()).setStoryContainerVisible(false);
                    ((MainActivity)getActivity()).setMainBackgroundImage(0);

                case 7:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario2_2),"Supermarket seller Patrick");
                    break;
                case 8:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario2_3),"Supermarket seller Patrick");
                    break;

                case 9:
                    stap = 2;
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario3_4_5), " ");
                    textview1.setText(R.string.john_scenario3_4_question);
                    myButton1.setText(R.string.john_scenario3_4_answer_1);
                    myButton2.setText(R.string.john_scenario3_4_answer_2);
                    myButton1.setVisibility(View.VISIBLE);
                    myButton2.setVisibility(View.VISIBLE);
                    textview1.setVisibility(View.VISIBLE);
                    ((MainActivity)getActivity()).setStoryContainerVisible(false);
                    ((MainActivity)getActivity()).setMainBackgroundImage(0);
                    break;
                case 10:
                    mSuperMarktName_et.setVisibility(View.VISIBLE);
                    mSuperMarktBirthday_et.setVisibility(View.VISIBLE);
                    mSuperMarktResident_et.setVisibility(View.VISIBLE);
                    mSuperMarktCellPhone_et.setVisibility(View.VISIBLE);
                    mSuperMarktEmail.setVisibility(View.VISIBLE);
                    myRegisterButton.setVisibility(View.VISIBLE);
                    mSuperMarktName_et.setEnabled(false);
                    mSuperMarktBirthday_et.setEnabled(false);
                    mSuperMarktResident_et.setEnabled(false);
                    mSuperMarktCellPhone_et.setEnabled(false);
                    mSuperMarktEmail.setEnabled(false);
                    ((MainActivity)getActivity()).setStoryContainerVisible(false);
                    break;
                case 11:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario2_4), "Supermarket seller Patrick");
                    ((MainActivity)getActivity()).setMainBackgroundImage(R.drawable.casier);
                    break;
                case 12:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario2_5), "John");
                    break;
                case 13:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario3_2), "John");
                    break;
                case 14:
                    ((MainActivity)getActivity()).setMainBackgroundImage(0);
                    stap = 3;
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario3_2_5), "John");
                    textview1.setText(R.string.john_scenario3_2_question);
                    myButton1.setText(R.string.john_scenario3_2_answer_mac);
                    myButton2.setText(R.string.john_scenario3_2_answer_2);
                    myButton1.setVisibility(View.VISIBLE);
                    myButton2.setVisibility(View.VISIBLE);
                    textview1.setVisibility(View.VISIBLE);
                    ((MainActivity)getActivity()).setStoryContainerVisible(false);
                    break;
                case 15:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario3_3), "John");
                    break;
                case 16:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario3_4), "Waiter Linda");
                    break;
                case 17:
                    stap = 4;
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario3_4_5), "John");
                    textview1.setText(R.string.john_scenario3_4_question);
                    myButton1.setText(R.string.john_scenario3_4_answer_1);
                    myButton2.setText(R.string.john_scenario3_4_answer_2);
                    myButton1.setVisibility(View.VISIBLE);
                    myButton2.setVisibility(View.VISIBLE);
                    textview1.setVisibility(View.VISIBLE);
                    ((MainActivity)getActivity()).setStoryContainerVisible(false);
                    ((MainActivity)getActivity()).setMainBackgroundImage(0);
                    break;
                case 18:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario3_5), "");
                    ((MainActivity)getActivity()).setMainBackgroundImage(R.drawable.selfieburgerking);
                    break;
                case 19:
                    // here moet de selfie komen
                    break;
                case 20:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario3_6), "");
                    textCounter = 29;
                    selfieDone = true;
                    ((MainActivity)getActivity()).setMainBackgroundImage(R.drawable.selfiebillboard);
                    break;
                case 21:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario3_7), "");
                    ((MainActivity)getActivity()).setMainBackgroundImage(R.drawable.homesweethome);
                    break;
                case 22:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario3_8), "");
                    break;
                case 23:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario3_9), "");
                    textCounter++;
                    break;
                case 25:
                    // hier moet nog de popup komen
                    ((MainActivity)getActivity()).setMainBackgroundImage(0);
                    regularView.setVisibility(View.GONE);
                    websitePopup.setVisibility(View.VISIBLE);
                    ((MainActivity)getActivity()).setStoryContainerVisible(false);
                    break;
                case 27:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario3_12), "");
                    ((MainActivity)getActivity()).setMainBackgroundImage(R.drawable.homesweethome);
                    break;
                case 28:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario3_13), "John Doe");
                    ((MainActivity)getActivity()).setMainBackgroundImage(R.drawable.spam);
                    break;
                case 29:
                    termsDone = true;
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario3_14), "John Doe");
                    ((MainActivity)getActivity()).setMainBackgroundImage(R.drawable.terms);
                    break;
                case 30:
                    String endText = "";
                    if(termsDone){
                        endText = "Busted! A common privacy pitfall is to get fed a load of terms and conditions and to just press 'accept'.\n" +
                                " Make sure to read through it all before accepting. Some internet apps also like to sneakily hide their deny button, hint hint!";
                    }else if(selfieDone){
                        endText ="Busted! It seems like a restaurant is using your image around the city to get some profit!\n" +
                                "Be careful next time to not give away personal information so easily, nice picture by the way~";
                    }

                    termsDone = false;
                    selfieDone = false;
                    ((MainActivity)getActivity()).setStoryText(endText, "");
                    //game over
                    restartBtn.setVisibility(View.VISIBLE);
                    textCounter= 100;
                    break;
                case 31:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario2_aldi_no_1), "Cashier");
                    break;
                case 32:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario2_aldi_no_2), "John Doe");
                    break;
                case 33:
                    stap = 5;
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario3_4_5), " ");
                    textview1.setText(R.string.john_scenario2_aldi_no_question);
                    myButton1.setText(R.string.john_scenario2_aldi_mac);
                    myButton2.setText(R.string.john_scenario2_aldi_burgerking);
                    myButton1.setVisibility(View.VISIBLE);
                    myButton2.setVisibility(View.VISIBLE);
                    textview1.setVisibility(View.VISIBLE);
                    ((MainActivity)getActivity()).setStoryContainerVisible(false);
                    break;
                case 34:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario2_aldi_fastfood), "Waiter Linda");
                    break;
                case 35:
                    stap = 6;
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario3_4_5), " ");
                    textview1.setText(R.string.john_scenario2_question);
                    myButton1.setText(R.string.john_scenario2_answer_1);
                    myButton2.setText(R.string.john_scenario2_answer_2);
                    myButton1.setVisibility(View.VISIBLE);
                    myButton2.setVisibility(View.VISIBLE);
                    textview1.setVisibility(View.VISIBLE);
                    ((MainActivity)getActivity()).setStoryContainerVisible(false);
                    break;
                case 36:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario2_offer_yes), " ");
                    ((MainActivity)getActivity()).setMainBackgroundImage(R.drawable.selfieburgerking);
                    break;
                case 37:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario2_offer_yes_2), " ");
                    textCounter=29;
                    ((MainActivity)getActivity()).setMainBackgroundImage(R.drawable.selfiebillboard);
                    break;
                case 38:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario3_skip_popup_1), "John Doe");
                    break;
                case 39:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario3_skip_popup_2), "John Doe");
                    break;
                case 40:
                    //victory
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario3_skip_popup_3), " ");
                    ((MainActivity)getActivity()).setMainBackgroundImage(R.drawable.winning);
                    break;
                default:
                    Log.e(TAG, "playStory: unknown story counter for introduction given, why u do dis");
            }
            Log.d(TAG, "onClick: current counter: "+textCounter);
            textCounter++;
        }
    };

    @OnClick(R.id.restart_btn)
    public void goBackToMainMenu(){
        ((MainActivity)getActivity()).switchToDifferentScreen(new MenuFragment(), "MenuFragment", false);
    }

    @OnClick(R.id.cook_hamburger)
    public void cookBurger(){
        SpannableString ss = new SpannableString(termsNConditionsText.getText().toString());
        ss.setSpan(clickableSpan, (termsNConditionsText.getText().toString().length()-10), termsNConditionsText.getText().toString().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        termsNConditionsText.setText(ss);
        termsNConditionsText.setMovementMethod(LinkMovementMethod.getInstance());
        termsAndConditionsContainer.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.cook_spaghetti)
    public void cookSpaghetti(){
        SpannableString ss = new SpannableString(termsNConditionsText.getText().toString());
        ss.setSpan(clickableSpan, (termsNConditionsText.getText().toString().length()-10), termsNConditionsText.getText().toString().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        termsNConditionsText.setText(ss);
        termsNConditionsText.setMovementMethod(LinkMovementMethod.getInstance());
        termsAndConditionsContainer.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.cook_steak)
    public void cookSteak(){
        SpannableString ss = new SpannableString(termsNConditionsText.getText().toString());
        ss.setSpan(clickableSpan, (termsNConditionsText.getText().toString().length()-10), termsNConditionsText.getText().toString().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        termsNConditionsText.setText(ss);
        termsNConditionsText.setMovementMethod(LinkMovementMethod.getInstance());
        termsAndConditionsContainer.setVisibility(View.VISIBLE);
    }


    @OnClick(R.id.accept_terms)
    public void acceptTerms(){
        //Toast.makeText(getContext(), "Done!", Toast.LENGTH_SHORT).show();
        termsAndConditionsContainer.setVisibility(View.GONE);

        ((MainActivity)getActivity()).setStoryText("Done!", "John");
        textCounter = 27;
        ((MainActivity)getActivity()).setStoryContainerVisible(true);
        acceptTermButton.setVisibility(View.GONE);
        termsNConditionsText.setVisibility(View.GONE);
        termsAndConditionsScroll.setVisibility(View.GONE);
        websitePopup.setVisibility(View.GONE);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case button1: // keuze 1
                if (stap == 1) {
                    choice = "aldi";
                    ((MainActivity)getActivity()).setMainBackgroundImage(R.drawable.aldiview);
                }else if (stap == 3) {
                    ((MainActivity)getActivity()).setMainBackgroundImage(R.drawable.mcdonalds);
                }
                myButton1.setVisibility(View.INVISIBLE);
                myButton2.setVisibility(View.INVISIBLE);
                textview1.setVisibility(View.INVISIBLE);
                ((MainActivity)getActivity()).setStoryContainerVisible(true);
                break;
            case button2: // keuze 2
                if (stap == 1) {
                    choice = "badsupermarket";
                    ((MainActivity)getActivity()).setMainBackgroundImage(R.drawable.sketchystoreview);
                } else if (stap == 2) {
                    ((MainActivity)getActivity()).setStoryContainerVisible(true);
                    if (choice.trim().equalsIgnoreCase("aldi")){
                        textCounter= 31;
                    }else {
                        textCounter = 12;
                    }
                } else if (stap == 3) {
                    ((MainActivity)getActivity()).setMainBackgroundImage(R.drawable.burgerking);
                } else if (stap == 4) {
                    textCounter = 21;
                }else if (stap==6){
                    textCounter=21;
                }
                myButton1.setVisibility(View.INVISIBLE);
                myButton2.setVisibility(View.INVISIBLE);
                textview1.setVisibility(View.INVISIBLE);
                ((MainActivity)getActivity()).setStoryContainerVisible(true);
                break;
            case supermarket_signup:
                if(!didSignup){
                    ((MainActivity)getActivity()).setStoryContainerVisible(true);
                    ((MainActivity)getActivity()).setmStoryContainerListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //do nothing
                        }
                    });
                    ((MainActivity)getActivity()).setStoryText("Alright I'll fill in my information!", "John");
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ((MainActivity)getActivity()).setStoryContainerVisible(false);
                            mSuperMarktName_et.setText("John");
                            mSuperMarktBirthday_et.setText("27-03-1981");
                            mSuperMarktCellPhone_et.setText("031-5703423");
                            mSuperMarktResident_et.setText("WhoseVille 95");
                            mSuperMarktEmail.setText("john@coolmail.com");
                            ((MainActivity)getActivity()).setmStoryContainerListener(storyListener);
                        }
                    },1000);
                    didSignup = true;
                }else{
                    if (choice.trim().equalsIgnoreCase("badsupermarket")){
                        textCounter= 30;
                    }
                    mSuperMarktName_et.setVisibility(View.INVISIBLE);
                    mSuperMarktBirthday_et.setVisibility(View.INVISIBLE);
                    mSuperMarktResident_et.setVisibility(View.INVISIBLE);
                    mSuperMarktCellPhone_et.setVisibility(View.INVISIBLE);
                    mSuperMarktEmail.setVisibility(View.INVISIBLE);
                    myRegisterButton.setVisibility(View.INVISIBLE);
                    ((MainActivity)getActivity()).setStoryContainerVisible(true);
                    ((MainActivity)getActivity()).setStoryText("Done!", "John");
                }
            default:
                break;
        }
    }
}