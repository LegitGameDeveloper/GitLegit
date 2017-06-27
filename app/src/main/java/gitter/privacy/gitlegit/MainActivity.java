package gitter.privacy.gitlegit;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.DrawableRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import gitter.privacy.gitlegit.Fragment.CreditsFragment;
import gitter.privacy.gitlegit.Fragment.MenuFragment;
import gitter.privacy.gitlegit.Fragment.TipsAndTricksFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @BindView(R.id.storyContainer)
    LinearLayout mStoryContainer;
    @BindView(R.id.storyText)
    TextView mStoryText;
    @BindView(R.id.storyTeller)
    TextView mStoryTeller;
    @BindView(R.id.imageViewMainPort)
    ImageView importantImageView;
    @BindView(R.id.imageJohnDoeMainPort)
    ImageView johnDoeImage;

    private boolean wrongWebsiteChosen = false;
    private boolean wrongApplicationSent = false;
    private boolean popupAccepted = false;
    private boolean backPressed = false;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_view);
        ButterKnife.bind(this);
        handler = new Handler();

        Log.d(TAG, "onCreate: going to do some preparing");
        switchToDifferentScreen(new MenuFragment(), "MenuFragment", false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.back_to_main_item) {
            switchToDifferentScreen(new MenuFragment(), "MenuFragment", false);
            return true;
        }

        if(id == R.id.credits_item){
            switchToDifferentScreen(new CreditsFragment(), "CreditsFragment", false);
            return true;
        }

        if(id == R.id.tips_tricks_item){
            switchToDifferentScreen(new TipsAndTricksFragment(), "TipsNTricks", false);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void hideMainBackgroundImage(boolean hide){
        if(hide){
            importantImageView.setVisibility(View.GONE);
        }else{
            importantImageView.setVisibility(View.VISIBLE);
        }
    }

    public void setMainBackgroundImage(@DrawableRes int image){
        if(image == 0){
            importantImageView.setVisibility(View.GONE);
            return;
        }
        importantImageView.setVisibility(View.VISIBLE);
        importantImageView.setImageDrawable(ContextCompat.getDrawable(this,image));
    }

    public void setCharacterImage(@DrawableRes int image){
        if(image == 0){
            johnDoeImage.setVisibility(View.GONE);
            return;
        }
        johnDoeImage.setVisibility(View.VISIBLE);
        johnDoeImage.setImageDrawable(ContextCompat.getDrawable(this,image));
    }

    public boolean isWrongWebsiteChosen(){
        return wrongWebsiteChosen;
    }

    public boolean isWrongApplicationSent(){
        return wrongApplicationSent;
    }

    public boolean isPopupAccepted(){
        return popupAccepted;
    }

    public void setWrongWebsiteChosen(boolean wrongWebsiteChosen){
        this.wrongWebsiteChosen = wrongWebsiteChosen;
    }

    public void setWrongApplicationSent(boolean wrongApplicationSent){
        this.wrongApplicationSent = wrongApplicationSent;
    }

    public void setPopupAccepted(boolean popupAccepted){
        this.popupAccepted = popupAccepted;
    }

    public void bringStoryToFront(){
        mStoryContainer.bringToFront();
    }

    public void setStoryText(String textToDisplayInBubble, String personTalking){
        if(mStoryContainer.getVisibility() == View.INVISIBLE || mStoryContainer.getVisibility() == View.INVISIBLE){
            Log.e(TAG, "setStoryText: the story container(Bubble is not visible," +
                    " call setStoryContainerVisible from mainactivity)");
        }
        mStoryTeller.setText(personTalking);
        mStoryText.setText(textToDisplayInBubble);
    }

    public void setStoryContainerVisible(boolean show){
        if(show){
            mStoryContainer.setVisibility(View.VISIBLE);
        }else{
            mStoryContainer.setVisibility(View.GONE);
        }
    }

    /**
     * method used to apply a new listener to the textContainer (I.E, to handle what happens when the user taps the bubble)
     * @param listener
     */
    public void setmStoryContainerListener(View.OnClickListener listener){
        if(listener == null){
            listener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //don't do anything
                }
            };
        }
        mStoryContainer.setOnClickListener(listener);
    }

    /**
     * used to simply hide the keyboard if it is visible
     */
    private void hideKeyboard(){
        View view = getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /**
     * Use this method to switch to a different screen, call this as:
     * switchToDifferentScreen(new NextFragment(), NextFragment.TAG, false)
     * from within a fragment call it as:
     * '((MainActivity)getActivity).switchToDifferentScreen(new NextFragment(), NextFragment.TAG, false);'
     */
    public void switchToDifferentScreen(Fragment fragment, String TAG, boolean addToBackStack){
        hideKeyboard();

        if (addToBackStack) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, fragment)
                    .addToBackStack(TAG)
                    .commit();
        } else {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, fragment)
                    .commit();
        }
    }

    @Override
    public void onBackPressed() {
        if(!backPressed){
            Toast.makeText(getApplicationContext(), "Press again to end app",Toast.LENGTH_SHORT).show();
            backPressed = true;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    backPressed = false;
                }
            },1000);
        }else{
            super.onBackPressed();
        }
    }
}
