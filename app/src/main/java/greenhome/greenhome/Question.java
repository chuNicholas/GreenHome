package greenhome.greenhome;

import android.app.ActionBar;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.sax.TextElementListener;
import android.support.annotation.DrawableRes;
import android.view.ContextThemeWrapper;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by kashi on 2/17/2018.
 */
public class Question {
    private String questionText;
    private energyType qType;
    public Question(String q, energyType val)
    {
        questionText = q;
        qType = val;
    }
    public void CreateQuestion(RelativeLayout rl)
    {
        ImageView banner = rl.findViewById(R.id.questionBan);
        ImageView icon = rl.findViewById(R.id.typeIcon);
        TextView text = rl.findViewById(R.id.questionText);

        /*
        ImageView banner = new ImageView(rl.getContext());
        banner.setImageResource(R.drawable.questioncard);

        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.ALIGN_PARENT_TOP,RelativeLayout.TRUE);
        banner.setLayoutParams(lp);
        TextView txt = new TextView(rl.getContext());
        txt.setLayoutParams(lp);
        txt.setText(questionText);
        txt.setTextSize(20f);
        txt.setX(90);
        txt.setY(180);
        txt.setTextColor(Color.WHITE);
        ImageView Icon = new ImageView((rl.getContext()));
        lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT,RelativeLayout.TRUE);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT,RelativeLayout.TRUE);
        params.width = 120;
        params.height = 120;
        Icon.setX(5);
        Icon.setY(30);
        Icon.setImageResource(getIcon());
        Icon.setLayoutParams(params);

        Button yes = new Button(rl.getContext());
        yes.setText("Yes");
        yes.setX(90);
        yes.setY(360);
        yes.setLayoutParams(lp);
        Button no = new Button(rl.getContext());
        no.setText("No");
        no.setX(360);
        no.setY(360);
        no.setLayoutParams(lp);
        rl.addView(banner);
        rl.addView(Icon);
        rl.addView(txt);
        rl.addView(yes);
        rl.addView(no);
        */
    }

    private @DrawableRes int getIcon()
    {
        if (qType == energyType.Electric)
            return R.drawable.electricicon;
        else if (qType == energyType.Transportation)
            return R.drawable.travelicon;
        else
            return R.drawable.watericon;
    }

}
