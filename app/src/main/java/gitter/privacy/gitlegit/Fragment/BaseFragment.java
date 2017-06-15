package gitter.privacy.gitlegit.Fragment;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import gitter.privacy.gitlegit.MainActivity;

/**
 * Created by jahmale_c on 15/06/2017.
 */

public class BaseFragment extends Fragment {

    private static final String TAG = BaseFragment.class.getSimpleName();
    protected View parentView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    /**
     * will return a view, which needs to be returned in the 'onCreateView' method of the child class to bind xml with Fragment
     * @param xmlFile
     * @param inflater
     * @param container
     * @return
     */
    public View bindXMLToFragment(@LayoutRes int xmlFile, LayoutInflater inflater, ViewGroup container){
        return inflater.inflate(xmlFile, container, false);
    }

}
