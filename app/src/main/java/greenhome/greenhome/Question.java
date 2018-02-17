package greenhome.greenhome;

import android.app.ActionBar;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by kashi on 2/17/2018.
 */
public class Question {
    private String txt;
    private energyType qType;
    public Question(String q, energyType val)
    {
        txt = q;
        qType = val;
    }
    public void CreateQuestion(RelativeLayout rl)
    {
        ImageView banner = new ImageView(rl.getContext());
        banner.setImageResource(R.drawable.questioncard);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        banner.setLayoutParams(lp);
        rl.addView(banner);
    }
}
