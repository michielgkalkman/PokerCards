package org.tahjaj.pokercards.shake;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;

import org.tahjaj.pokercards.NumberGridActivity;
import org.tahjaj.pokercards.R;
import org.tahjaj.pokercards.org.taHjaj.wo.pokercards.showcard.ShowPokerCard;

import icepick.Icepick;
import timber.log.Timber;

public class ShakeSensorActivity extends AppCompatActivity {
    // The following are used for the shake detection
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake_sensor);

        Icepick.restoreInstanceState(this, savedInstanceState);

        final RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);


        // ShakeDetector initialization
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager
                .getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector();
        mShakeDetector.setOnShakeListener(new ShakeDetector.OnShakeListener() {

            @Override
            public void onShake(int count) {
				/*
				 * The following method, "handleShakeEvent(count):" is a stub //
				 * method you would use to setup whatever you want done once the
				 * device has been shook.
				 */
                Intent intent = getIntent();
                final int id = intent.getIntExtra( NumberGridActivity.ORG_TAHJAJ_WO_POKERCARDS_SHOWCARD, 0);

                final Intent launchIntent = new Intent(ShakeSensorActivity.this, ShowPokerCard.class);

                launchIntent.putExtra(NumberGridActivity.ORG_TAHJAJ_WO_POKERCARDS_SHOWCARD, id);
                startActivity(launchIntent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        // Add the following line to register the Session Manager Listener onResume
        mSensorManager.registerListener(mShakeDetector, mAccelerometer,	SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onPause() {
        // Add the following line to unregister the Sensor Manager onPause
        mSensorManager.unregisterListener(mShakeDetector);
        super.onPause();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Icepick.saveInstanceState(this, outState);
    }
}
