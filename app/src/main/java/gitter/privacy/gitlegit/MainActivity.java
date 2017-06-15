package gitter.privacy.gitlegit;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @BindView(R.id.storyContainer)
    LinearLayout mStoryContainer;
    @BindView(R.id.storyText)
    TextView mStoryText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_view);
        ButterKnife.bind(this);

        Log.d(TAG, "onCreate: going to do some preparing");
    }

    public void setStoryText(String textToDisplayInBubble){
        if(mStoryContainer.getVisibility() == View.INVISIBLE || mStoryContainer.getVisibility() == View.INVISIBLE){
            Log.e(TAG, "setStoryText: the story container(Bubble is not visible," +
                    " call setStoryContainerVisible from mainactivity)");
        }
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
}
