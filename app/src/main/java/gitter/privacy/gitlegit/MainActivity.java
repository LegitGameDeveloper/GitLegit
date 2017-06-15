package gitter.privacy.gitlegit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.content)
    ViewGroup contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_view);
        ButterKnife.bind(this);

        Log.d(TAG, "onCreate: going to do some preparing");
    }

    @OnClick(R.id.btn_1)
    public void doButton1(){
    }

    @OnClick(R.id.btn_2)
    public void doButton2(){
    }
}
