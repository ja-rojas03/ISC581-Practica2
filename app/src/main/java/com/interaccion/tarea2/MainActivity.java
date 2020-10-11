package com.interaccion.tarea2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {

    public static int GPS_PERMISSION_CODE = 1;
    public static int READ_EXTERNAL_STORAGE_CODE = 2;
    public static int CAMERA_CODE = 3;
    public static int PHONE_CODE = 4;
    public static int CONTACTS_CODE = 5;

    private Button continueBtn;
    private Button cancelBtn;
    private SwitchCompat storageSwitch;
    private SwitchCompat locationSwitch;
    private SwitchCompat cameraSwitch;
    private SwitchCompat phoneSwitch;
    private SwitchCompat contactsSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        continueBtn = findViewById(R.id.continue_btn);
        cancelBtn = findViewById(R.id.cancel_btn);
        storageSwitch = findViewById(R.id.storage_switch);
        locationSwitch = findViewById(R.id.location_switch);
        cameraSwitch = findViewById(R.id.camera_switch);
        phoneSwitch = findViewById(R.id.phone_switch);
        contactsSwitch = findViewById(R.id.contacts_switch);

        checkFields();

        storageSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, READ_EXTERNAL_STORAGE_CODE);
                }else {
                    if(checkSelfPermission( Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                        storageSwitch.setChecked(true);
                      }
                }
            }
        });

        locationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, GPS_PERMISSION_CODE);
                }else {
                    if(checkSelfPermission( Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        locationSwitch.setChecked(true);
                    }
                }
            }
        });

        cameraSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    requestPermissions(new String[]{Manifest.permission.CAMERA}, CAMERA_CODE);
                }else {
                    if(checkSelfPermission( Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                        cameraSwitch.setChecked(true);
                    }
                }
            }
        });

        phoneSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, PHONE_CODE);
                }else {
                    if(checkSelfPermission( Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                        phoneSwitch.setChecked(true);
                    }
                }
            }
        });

        contactsSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, CONTACTS_CODE);
                }else {
                    if(checkSelfPermission( Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
                        contactsSwitch.setChecked(true);
                    }
                }
            }
        });


        cancelBtn.setOnClickListener(v-> {
            android.os.Process.killProcess(android.os.Process.myPid());
        });


        continueBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        });




    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void checkFields() {
        if(checkSelfPermission( Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            storageSwitch.setChecked(true);
        }else {
            storageSwitch.setChecked(false);
        }

        if(checkSelfPermission( Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            locationSwitch.setChecked(true);
        }else {
            locationSwitch.setChecked(false);
        }

        if(checkSelfPermission( Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            cameraSwitch.setChecked(true);
        }else {
            cameraSwitch.setChecked(false);
        }

        if(checkSelfPermission( Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            phoneSwitch.setChecked(true);
        }else {
            phoneSwitch.setChecked(false);
        }

        if(checkSelfPermission( Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
            contactsSwitch.setChecked(true);
        }else {
            contactsSwitch.setChecked(false);
        }
    }


}