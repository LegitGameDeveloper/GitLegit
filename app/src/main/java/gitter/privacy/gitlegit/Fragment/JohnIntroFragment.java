package gitter.privacy.gitlegit.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import gitter.privacy.gitlegit.MainActivity;
import gitter.privacy.gitlegit.R;

import static gitter.privacy.gitlegit.R.id.QuestionToAsk;
import static gitter.privacy.gitlegit.R.id.button1;
import static gitter.privacy.gitlegit.R.id.button2;

/**
 * Created by jahmale_c on 15/06/2017.
 */

public class JohnIntroFragment extends BaseFragment implements View.OnClickListener {

    public static final String TAG = "JohnIntroFragment";
    private boolean containerIsVisible = false;
    private int textCounter = 0;

    Button myButton1, myButton2;
    TextView textview1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setTextContainerListener();
        parentView = bindXMLToFragment(R.layout.john_intro_view, inflater, container);

        myButton1 = (Button) parentView.findViewById(button1);
        myButton1.setOnClickListener(this);
        myButton2 = (Button) parentView.findViewById(button2);
        myButton2.setOnClickListener(this);

        textview1 = (TextView) parentView.findViewById(QuestionToAsk);

        return parentView;
    }

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
//                    ((MainActivity)getActivity()).switchToDifferentScreen(new RegisterSupermarketFragment(),RegisterSupermarketFragment.TAG, false);
                    break;
                case 10:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario2_4), "Supermarket seller Patrick");
                    break;
                case 11:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario2_5), "Supermarket seller Patrick");
                    break;

                case 12:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario3_1), "John");
                    break;
                case 13:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario3_2), "John");
                    break;

                case 14:
//                    question which fast food to visit
                    break;

                case 15:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario3_3), "John");
                    break;
                case 16:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_scenario3_3), "Waiter Linda");
                    break;

                default:
                    Log.e(TAG, "playStory: unknown story counter for introduction given, why u do dis");
            }

            textCounter++;
        }
    };


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case button1:
                myButton1.setVisibility(View.INVISIBLE);
                myButton2.setVisibility(View.INVISIBLE);
                textview1.setVisibility(View.INVISIBLE);
                ((MainActivity)getActivity()).setStoryContainerVisible(true);
                // keuze 1

                break;
            case button2:
                myButton1.setVisibility(View.INVISIBLE);
                myButton2.setVisibility(View.INVISIBLE);
                textview1.setVisibility(View.INVISIBLE);
                ((MainActivity)getActivity()).setStoryContainerVisible(true);
                // keuze 2

            default:
                break;
        }
    }
}
