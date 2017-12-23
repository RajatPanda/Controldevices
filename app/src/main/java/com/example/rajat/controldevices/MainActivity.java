package com.example.rajat.controldevices;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    Switch s1,s2,s3;
    BluetoothAdapter bluetoothAdapter;
    AudioManager audioManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s1= (Switch) findViewById(R.id.blue);
        s2= (Switch) findViewById(R.id.silent);
        s3= (Switch) findViewById(R.id.vib);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        //Bluetooth on/off.
        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    Intent i = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivity(i);
                }
                else
                    bluetoothAdapter.disable();
            }
        });
        s2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                    audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                else
                    audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
            }
        });
        s3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                    audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                else
                    audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
            }
        });
    }
}
