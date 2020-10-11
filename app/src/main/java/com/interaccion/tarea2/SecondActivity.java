package com.interaccion.tarea2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private Button storageBtn;
    private Button locationBtn;
    private Button cameraBtn;
    private Button phoneBtn;
    private Button contactsBtn;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        storageBtn = findViewById(R.id.storage_btn);
        locationBtn = findViewById(R.id.location_btn);
        cameraBtn = findViewById(R.id.camera_btn);
        phoneBtn = findViewById(R.id.phone_btn);
        contactsBtn = findViewById(R.id.contacts_btn);

        storageBtn.setOnClickListener(v-> {
            if(checkSelfPermission( Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                Toast.makeText(this, "No permissions were given for the storage to open", Toast.LENGTH_SHORT).show();
            }else {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivity(intent);
            }
        });

        locationBtn.setOnClickListener(v-> {
            if(checkSelfPermission( Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_DENIED) {
                Toast.makeText(this, "No permissions were given for the location to open", Toast.LENGTH_SHORT).show();
            }else {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps"));
                startActivity(intent);
            }
        });

        cameraBtn.setOnClickListener(v-> {
            if(checkSelfPermission( Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
                Toast.makeText(this, "No permissions were given for the camera to open", Toast.LENGTH_SHORT).show();
            }else {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });

        phoneBtn.setOnClickListener(v-> {
            if(checkSelfPermission( Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_DENIED) {
                Toast.makeText(this, "No permissions were given for a call to be made", Toast.LENGTH_SHORT).show();
            }else {
                String posted_by = "123-1233-213-2";
                String uri = "tel:" + posted_by.trim() ;
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(uri));
                startActivity(intent);
            }
        });

        contactsBtn.setOnClickListener(v-> {
            if(checkSelfPermission( Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_DENIED) {
                Toast.makeText(this, "No permissions were given for the contacts to open", Toast.LENGTH_SHORT).show();
            }else {
                Intent intent= new Intent(Intent.ACTION_PICK,  ContactsContract.Contacts.CONTENT_URI);
                startActivity(intent);
            }
        });


    }
}