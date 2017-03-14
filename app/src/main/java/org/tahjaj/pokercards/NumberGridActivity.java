package org.tahjaj.pokercards;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.tahjaj.pokercards.org.taHjaj.wo.pokercards.showcard.*;
import org.tahjaj.pokercards.shake.ShakeSensorActivity;

import icepick.Icepick;
import timber.log.Timber;

public class NumberGridActivity extends AppCompatActivity {

    public static final String ORG_TAHJAJ_WO_POKERCARDS_SHOWCARD = "org.taHjaj.wo.pokercards.SHOWCARD";


    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.five,
            R.drawable.eight,
            R.drawable.thirteen,
            R.drawable.twenty,
            R.drawable.forty,
            R.drawable.hundred,
            R.drawable.questionmark,
            R.drawable.coffee
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);

        Timber.plant(new Timber.DebugTree());

        setContentView(R.layout.activity_number_grid);
        final GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this, mThumbIds));
        gridview.setNumColumns(3);

        // Initialize data
        final List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
        final SparseArray<Class<? extends Activity>> activityMapping = new SparseArray<Class<? extends Activity>>();

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                final Intent launchIntent = new Intent(NumberGridActivity.this, ShakeSensorActivity.class);

                Timber.d("Launching showcard");

                launchIntent.putExtra(ORG_TAHJAJ_WO_POKERCARDS_SHOWCARD, mThumbIds[position]);
                startActivity(launchIntent);
            }

        }    );
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Icepick.saveInstanceState(this, outState);
    }
}
