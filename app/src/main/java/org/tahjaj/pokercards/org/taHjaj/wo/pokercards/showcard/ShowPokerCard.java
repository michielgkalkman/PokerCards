package org.tahjaj.pokercards.org.taHjaj.wo.pokercards.showcard;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.tahjaj.pokercards.NumberGridActivity;
import org.tahjaj.pokercards.R;

import timber.log.Timber;

public class ShowPokerCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_poker_card);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        final int id = intent.getIntExtra( NumberGridActivity.ORG_TAHJAJ_WO_POKERCARDS_SHOWCARD, 0);

        final ImageView imageView = (ImageView) findViewById(R.id.text_view_showcard);

        Timber.d("Test:" + id);

//            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setPadding(8, 8, 8, 8);
        imageView.setImageResource(id);

    }
}
