package farzi.labs.gyroscopehelloworld;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SensorManager sensorManager;
    private GyroScopeListener gyroScopeListener;
    public static String TAG = "GyroScopeHelloWorld";
    public static TextView dataViewX, dataViewY, dataViewZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    void initialize(){
        dataViewX = findViewById(R.id.gdatax);
        dataViewY = findViewById(R.id.gdatay);
        dataViewZ = findViewById(R.id.gdataz);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        gyroScopeListener = new GyroScopeListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(gyroScopeListener, sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE), SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        // unregister listener
        super.onPause();
        sensorManager.unregisterListener(gyroScopeListener);
    }
}
