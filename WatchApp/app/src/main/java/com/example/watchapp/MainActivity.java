package com.example.watchapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class MainActivity extends WearableActivity {
    private SensorManager sensorManager;
    private Sensor acceleromterSensor;
    private Sensor gyroscopeSensor;
    private Sensor heartrateSensor;
    private static final String TAG = "MainActivity";
    private int id;
    private long time;
    private ArrayList<ArrayList<Float>> data1;//acceleration data
    private ArrayList<ArrayList<Float>> data2;//gyroscope data
    private ArrayList<ArrayList<Float>> data3;//ppg data
    private ArrayList<ArrayList<Float>> data4;//HR data

    private float AccTime;
    private double currentAccTime;


    private float GyrTime;
    private double currentGyrTime;

    private float PPGRecordTime;
    private double currentPpgTime;

    private float HRTime;
    private double currentHRTime;


    private boolean isMeasuring;
    private Button startButton;
    private boolean isFirst;
    private EditText idText;

    //Xiaomi:65572 Huawei:65537
    private int ppgSensorID = 65572;

    private String filename;

    private FileOutputStream AccOut;
    private FileOutputStream GyrOut;
    private FileOutputStream PpgOut;
    private FileOutputStream HROut;
    public String comma = ",";
    public String newline = "\n";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = findViewById(R.id.start);
        idText = findViewById(R.id.id_text);
        isMeasuring = false;
        time = 01;
        id = 0;

        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        acceleromterSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        heartrateSensor = sensorManager.getDefaultSensor(Sensor.TYPE_HEART_RATE);

        // Enables Always-on
        setAmbientEnabled();




    }

    SensorEventListener _SensorEventListener=   new SensorEventListener() {



        @Override
        public void onSensorChanged(SensorEvent event) {
            float x = event.values[0];
//            float y = event.values[1];
//            float z = event.values[2];
//            float z1 = event.values[3];
//            float z2 = event.values[4];

            if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                //Log.d(TAG, "acc: " + x + ", " + y + ", " + z);
                if(isMeasuring){
                    if (isFirst)
                    {
                        time = event.timestamp;
                        isFirst = false;
                    }
                    AccTime = event.timestamp - time;
                    currentAccTime = System.currentTimeMillis();

                    try{

                        for(int i= 0; i<3;i++)
                        {
                            AccOut.write(String.valueOf(event.values[i]).getBytes());
                            AccOut.write(comma.getBytes());
                        }

                        AccOut.write(String.format("%.6f", AccTime/1000000000f).getBytes());
                        AccOut.write(comma.getBytes());
                        AccOut.write(String.valueOf(currentAccTime).getBytes());
                        AccOut.write(newline.getBytes());


                    } catch (FileNotFoundException e) {
                        Log.d(TAG, "Cannot open file.");
                        e.printStackTrace();
                    } catch (IOException e) {
                        Log.d(TAG, "Cannot write string.");
                        e.printStackTrace();
                    }

                }
            }
            else if(event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
                //Log.d(TAG, "gyr: " + x + ", " + y + ", " + z);
                if(isMeasuring){
                    if (isFirst)
                    {
                        time = event.timestamp;
                        isFirst = false;
                    }
                    GyrTime = event.timestamp - time;
                    currentGyrTime = System.currentTimeMillis();

                    try{

                        for(int i= 0; i<3;i++)
                        {
                            GyrOut.write(String.valueOf(event.values[i]).getBytes());
                            GyrOut.write(comma.getBytes());
                        }

                        GyrOut.write(String.format("%.6f", GyrTime/1000000000f).getBytes());
                        GyrOut.write(comma.getBytes());
                        GyrOut.write(String.valueOf(currentGyrTime).getBytes());
                        GyrOut.write(newline.getBytes());

                    } catch (FileNotFoundException e) {
                        Log.d(TAG, "Cannot open file.");
                        e.printStackTrace();
                    } catch (IOException e) {
                        Log.d(TAG, "Cannot write string.");
                        e.printStackTrace();
                    }


                }
            }
            else if(event.sensor.getType() == ppgSensorID) {
                Log.d(TAG, "ppg: " + x + ", " + event.values[1] + ", " + event.values[2]+ ", " + event.values[3]+ ", " + event.values[4]+ ", " + event.values[5]);
                //Log.d(TAG, "ppg: " + x + ", " + event);
                if(isMeasuring){

                    if (isFirst)
                    {
                        time = event.timestamp;
                        isFirst = false;
                    }
                    PPGRecordTime = event.timestamp - time;
                    currentPpgTime = System.currentTimeMillis();

                    try{

                        for(int i= 0; i<3;i++)
                        {
                            PpgOut.write(String.valueOf(event.values[i]).getBytes());
                            PpgOut.write(comma.getBytes());
                        }

                        PpgOut.write(String.format("%.6f", PPGRecordTime/1000000000f).getBytes());
                        PpgOut.write(comma.getBytes());
                        PpgOut.write(String.valueOf(currentPpgTime).getBytes());
                        PpgOut.write(newline.getBytes());


                    } catch (FileNotFoundException e) {
                        Log.d(TAG, "Cannot open file.");
                        e.printStackTrace();
                    } catch (IOException e) {
                        Log.d(TAG, "Cannot write string.");
                        e.printStackTrace();
                    }


                }
            }
            else if(event.sensor.getType() == Sensor.TYPE_HEART_RATE) {
                //Log.d(TAG, "Heart Rate: " + x );
                if(isMeasuring){

                    if (isFirst)
                    {
                        time = event.timestamp;
                        isFirst = false;
                    }
                    HRTime = event.timestamp - time;
                    currentHRTime = System.currentTimeMillis();

                    try{
                        HROut.write(String.valueOf(event.values[0]).getBytes());
                        HROut.write(comma.getBytes());
                        HROut.write(String.format("%.6f", HRTime/1000000000f).getBytes());
                        HROut.write(comma.getBytes());
                        HROut.write(String.valueOf(currentHRTime).getBytes());
                        HROut.write(newline.getBytes());

                    } catch (FileNotFoundException e) {
                        Log.d(TAG, "Cannot open file.");
                        e.printStackTrace();
                    } catch (IOException e) {
                        Log.d(TAG, "Cannot write string.");
                        e.printStackTrace();
                    }


                }
            }
            else{
                Log.d(TAG, "Sensor: " + event.sensor.getType());
            }

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }



    };

    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void myBtnClick(View v) {
        //按STOP键后的操作
        if(isMeasuring){
            isMeasuring = false;
            startButton.setText("START");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    OutputFile();
                }
            }).start();

        }
        //按START键后的操作
        else {
            if (idText.getText().toString().equals("")) {
                Toast.makeText(this, "Input your ID", Toast.LENGTH_SHORT).show();
            }
            else {
                isMeasuring = true;
                isFirst = true;
                startButton.setText("STOP");

                id = Integer.parseInt(idText.getText().toString());

                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_kkmmss");
                filename = sdf.format(date) + ".csv";
                Log.d(TAG, filename);

                try{
                    AccOut = openFileOutput("Watch_Acc" + String.format("%03d", id) + "_" + filename, MODE_PRIVATE);
                    GyrOut = openFileOutput("Watch_Gyr" + String.format("%03d", id) + "_" + filename, MODE_PRIVATE);
                    PpgOut = openFileOutput("Watch_Ppg" + String.format("%03d", id) + "_" + filename, MODE_PRIVATE);
                    HROut = openFileOutput("Watch_HR" + String.format("%03d", id) + "_" + filename, MODE_PRIVATE);

                    AccOut.write("ax,ay,az,time,localTime\n".getBytes());
                    GyrOut.write("gx,gy,gz,time,localTime\n".getBytes());
                    PpgOut.write("R,G,B,time,localTime\n".getBytes());
                    HROut.write("HR,time,localTime\n".getBytes());


                } catch (FileNotFoundException e) {
                    Log.d(TAG, "Cannot open file.");
                    e.printStackTrace();
                } catch (IOException e) {
                    Log.d(TAG, "Cannot write string.");
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(_SensorEventListener, acceleromterSensor, SensorManager.SENSOR_DELAY_FASTEST);
        sensorManager.registerListener(_SensorEventListener, gyroscopeSensor, SensorManager.SENSOR_DELAY_FASTEST);
        sensorManager.registerListener(_SensorEventListener, sensorManager.getDefaultSensor(ppgSensorID),SensorManager.SENSOR_DELAY_FASTEST);
        sensorManager.registerListener(_SensorEventListener, heartrateSensor,SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sensorManager.unregisterListener(_SensorEventListener);

    }



    private void OutputFile() {

        try {

            AccOut.close();
            GyrOut.close();
            PpgOut.close();
            HROut.close();

            Log.d(TAG, "File created.");
        } catch (FileNotFoundException e) {
            Log.d(TAG, "Cannot open file.");
            e.printStackTrace();
        } catch (IOException e) {
            Log.d(TAG, "Cannot write string.");
            e.printStackTrace();
        }
    }
}