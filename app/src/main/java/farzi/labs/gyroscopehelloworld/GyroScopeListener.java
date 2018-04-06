package farzi.labs.gyroscopehelloworld;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;

/**
 * Created by abhinav.srivastava on 4/6/18.
 */

public class GyroScopeListener implements SensorEventListener {
    @Override
    public void onSensorChanged(SensorEvent event) {
        MainActivity.dataViewX.setText(event.values[0]+"");
        MainActivity.dataViewY.setText(event.values[1]+"");
        MainActivity.dataViewZ.setText(event.values[2]+"");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        Log.d(MainActivity.TAG, "onAccuracyChanged");
    }
}
