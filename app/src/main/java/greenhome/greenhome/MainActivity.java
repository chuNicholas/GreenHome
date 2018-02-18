package greenhome.greenhome;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private SectionsPageAdapter mSectionsPageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = findViewById(R.id.nextScreen);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, Welcome_Screen.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
        final RelativeLayout rl = (RelativeLayout)findViewById(R.id.r1);
        Stack<Question> Qs = new Stack<Question>();
        Stack<String> txt = new Stack<String>();
        txt.push("This Is one Question");
        txt.push("This is another");
        txt.push("Remind me to fill this properly");
        txt.push("Hardcode Life");

        for (int i = 0; i < txt.size(); i++)
        {
            Qs.push(new Question(txt.pop(), energyType.Electric));
        }
        Question Test = Qs.pop();
        Test.CreateQuestion(rl);



    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment(), "Home");
        adapter.addFragment(new AnalysisFragment(), "Analysis");
        adapter.addFragment(new GoalsFragment(), "Goals");

        viewPager.setAdapter(adapter);
    }

}
