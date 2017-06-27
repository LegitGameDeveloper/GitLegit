package gitter.privacy.gitlegit.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gitter.privacy.gitlegit.MainActivity;
import gitter.privacy.gitlegit.R;

/**
 * Created by jahmale_c on 21/06/2017.
 */

public class EndingFragment extends BaseFragment {

    private Handler handler;
    private static int counter = 0;

    @BindView(R.id.time_pass_bg)
    ViewGroup timePassBackground;
    @BindView(R.id.restart_btn)
    ViewGroup restartBtn;

    boolean isGoodEnding = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = bindXMLToFragment(R.layout.ending_fragment,inflater,container);
        ButterKnife.bind(this, parentView);
        ((MainActivity)getActivity()).setStoryContainerVisible(false);

        handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                timePassBackground.setVisibility(View.GONE);
                if(((MainActivity)getActivity()).isWrongApplicationSent() || ((MainActivity)getActivity()).isWrongWebsiteChosen()
                        ||((MainActivity)getActivity()).isPopupAccepted()){
                    isGoodEnding = false;
                    playBadEnding();
                }else{
                    //todo: do the good ending
                    Toast.makeText(getActivity(), "U MADE IT", Toast.LENGTH_SHORT).show();
                }
            }
        },1000);

        return parentView;
    }

    private void showRestartBtn(){

    }

    private void playBadEnding(){
        ((MainActivity)getActivity()).setMainBackgroundImage(R.drawable.homesweethome);
        ((MainActivity)getActivity()).hideMainBackgroundImage(false);
        ((MainActivity)getActivity()).setCharacterImage(R.drawable.cop_char);
        ((MainActivity)getActivity()).setStoryContainerVisible(true);
        ((MainActivity)getActivity()).setStoryText("*knock, knock* Hello, John Doe? This is the police, we have a warrant for your arrest", "Officer");

        ((MainActivity)getActivity()).setmStoryContainerListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNextText();
                counter++;
            }
        });
    }

    private void setNextText(){
        if(isGoodEnding){

        }else{
            switch (counter){
                case 0:
                    ((MainActivity)getActivity()).setCharacterImage(R.drawable.char_side_view);
                    ((MainActivity)getActivity()).setStoryText("A warrant for my arrest? but what for?", "John");
                    break;
                case 1:
                    boolean oneChosen = false;
                    ((MainActivity)getActivity()).setCharacterImage(R.drawable.cop_char);
                    String copText = "It seems you have been involved with some strange activity\n";
                    if(((MainActivity) getActivity()).isWrongApplicationSent()){
                        oneChosen = true;
                        copText += " your name has been found to be connected to bankfraude! ";
                    }
                    if(((MainActivity) getActivity()).isPopupAccepted()){
                        if(oneChosen){
                            copText += " also ";
                        }
                        copText += " you have purchased multiple vehicles on payment, but the companies haven't received anything from you ";
                    }
                    ((MainActivity)getActivity()).setStoryText(copText, "Officer");
                    break;
                case 2:
                    ((MainActivity)getActivity()).setCharacterImage(R.drawable.chara);
                    ((MainActivity)getActivity()).setStoryText("I didn't do any of those things!", "John");
                    break;
                case 3:
                    ((MainActivity)getActivity()).setCharacterImage(R.drawable.cop_char);
                    ((MainActivity)getActivity()).setStoryText("Your legitimate information was used to do these things, I am sorry but I will have to arrest you" +
                            ", you can think about your mistakes in jail!", "Officer");
                    break;
                case 4:
                    ((MainActivity)getActivity()).setMainBackgroundImage(R.drawable.jail);
                    ((MainActivity)getActivity()).setCharacterImage(0);
                    ((MainActivity)getActivity()).setStoryText("John has been arrested for fraude, by use of his personal information! " +
                            "Perhaps, something went wrong when he was looking for his job, Be careful not to give away any personal information" +
                            "not everything is as safe as it seems, go back to the menu and try again!", "");
                    break;
                case 5:
                    restartBtn.setVisibility(View.VISIBLE);
                    //todo: go back to main menu;
            }
        }

    }

    @OnClick(R.id.restart_btn)
    public void goBackToMenu(){

    }
}
