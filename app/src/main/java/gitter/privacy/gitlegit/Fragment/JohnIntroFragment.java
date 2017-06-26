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
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gitter.privacy.gitlegit.MainActivity;
import gitter.privacy.gitlegit.R;

import static gitter.privacy.gitlegit.R.id.button1;
import static gitter.privacy.gitlegit.R.id.button2;
import static gitter.privacy.gitlegit.R.id.supermarket_birthday;
import static gitter.privacy.gitlegit.R.id.supermarket_cellphomeNR;
import static gitter.privacy.gitlegit.R.id.supermarket_email;
import static gitter.privacy.gitlegit.R.id.supermarket_name;
import static gitter.privacy.gitlegit.R.id.supermarket_resident;
import static gitter.privacy.gitlegit.R.id.supermarket_signup;

/**
 * Created by jahmale_c on 15/06/2017.
 */

public class JohnIntroFragment extends BaseFragment implements View.OnClickListener {

    public static final String TAG = "JohnIntroFragment";
    private boolean containerIsVisible = false;
    private int textCounter = 0;

    Button myButton1, myButton2, myRegisterButton;

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

    EditText mSuperMarktName_et, mSuperMarktBirthday_et, mSuperMarktResident_et, mSuperMarktCellPhone_et, mSuperMarktEmail;

    SharedPreferences sharedPref;
    SharedPreferences sharedPrefChoices;

    int stap;

    private Handler handler;
    private boolean didSignup = false;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setTextContainerListener();
        parentView = bindXMLToFragment(R.layout.john_intro_view, inflater, container);
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

        sharedPref = getActivity().getSharedPreferences("MyPref", 0);
        sharedPrefChoices = getActivity().getSharedPreferences("MyPref", 0);
        handler = new Handler();

        return parentView;
    }

    private ClickableSpan clickableSpan = new ClickableSpan() {
        @Override
        public void onClick(View textView) {
            Toast.makeText(getContext(),"Good choice!", Toast.LENGTH_SHORT).show();
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
                    break;
                case 10:
                    mSuperMarktName_et.setVisibility(View.VISIBLE);
                    mSuperMarktBirthday_et.setVisibility(View.VISIBLE);
                    mSuperMarktResident_et.setVisibility(View.VISIBLE);
                    mSuperMarktCellPhone_et.setVisibility(View.VISIBLE);
                    mSuperMarktEmail.setVisibility(View.VISIBLE);
                    myRegisterButton.setVisibility(View.VISIBLE);
                    ((MainActivity)getActivity()).setStoryContainerVisible(false);
                    break;
                case 11:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario2_4), "Supermarket seller Patrick");
                    break;
                case 12:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario2_5), "John");
                    break;

                case 13:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario3_2), "John");
                    break;

                case 14:
                    stap = 3;
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario3_2_5), "John");
                    textview1.setText(R.string.john_scenario3_2_question);
                    myButton1.setText(R.string.john_scenario3_2_answer_mac);
                    myButton2.setText(R.string.john_scenario3_2_answer_2);
                    myButton1.setVisibility(View.VISIBLE);
                    myButton2.setVisibility(View.VISIBLE);
                    textview1.setVisibility(View.VISIBLE);
                    ((MainActivity)getActivity()).setStoryContainerVisible(false);

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


                    System.out.println(sharedPrefChoices.getString("stap1", null));
                    System.out.println(sharedPrefChoices.getString("stap2", null));
                    System.out.println(sharedPrefChoices.getString("stap3", null));
                    System.out.println(sharedPrefChoices.getString("stap4", null));
                    break;
                case 18:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario3_5), "John");
                    break;
                case 19:
                    // here moet de selfie komen
                    break;
                case 20:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario3_6), "");
                    textCounter = 29;
                    break;
                case 21:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario3_7), "");
                    break;
                case 22:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario3_8), "");
                    break;
                case 23:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario3_9), "");
                    break;
                case 24:
                    // hier moet nog de popup komen
                    regularView.setVisibility(View.GONE);
                    websitePopup.setVisibility(View.VISIBLE);
                    ((MainActivity)getActivity()).setStoryContainerVisible(false);
                    break;
//                case 25:
//                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario3_10), "");
//                    break;
//                case 26:
//                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario3_11), "");
//                    break;
//                case 27:
//                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario3_12), "");
//                    break;
                case 28:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario3_13), "");
                    break;
                case 29:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario3_14), "");
                    break;
                case 30:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario3_15), "");
                    break;
                default:
                    Log.e(TAG, "playStory: unknown story counter for introduction given, why u do dis");
            }
            textCounter++;
        }
    };

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
        Toast.makeText(getContext(), "getHacked", Toast.LENGTH_SHORT).show();
        termsAndConditionsContainer.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        SharedPreferences.Editor edit = sharedPrefChoices.edit();

        switch (v.getId()) {
            case button1: // keuze 1
                if (stap == 1) {
                    edit.putString("stap1", "aldi");
                } else if (stap == 2) {
                    edit.putString("stap2", "yes");
                } else if (stap == 3) {
                    edit.putString("stap3", "McDonalds");
                } else if (stap == 4) {
                    edit.putString("stap4", "yes");
                }

                edit.commit();
                myButton1.setVisibility(View.INVISIBLE);
                myButton2.setVisibility(View.INVISIBLE);
                textview1.setVisibility(View.INVISIBLE);
                ((MainActivity)getActivity()).setStoryContainerVisible(true);
                break;
            case button2: // keuze 2
                if (stap == 1) {
                    edit.putString("stap1", "badsupermarket");
                } else if (stap == 2) {
                    edit.putString("stap2", "no");
                    textCounter = 12;
                } else if (stap == 3) {
                    edit.putString("stap3", "BurgerKing");
                } else if (stap == 4) {
                    edit.putString("stap4", "no");
                    textCounter = 21;
                }
                edit.commit();
                myButton1.setVisibility(View.INVISIBLE);
                myButton2.setVisibility(View.INVISIBLE);
                textview1.setVisibility(View.INVISIBLE);
                ((MainActivity)getActivity()).setStoryContainerVisible(true);
                break;
            case supermarket_signup:
                if(!didSignup){
                    ((MainActivity)getActivity()).setStoryContainerVisible(true);
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
                        }
                    },1000);
                    didSignup = true;
                }else{
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
