package com.enviroteer.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.enviroteer.R;
import com.google.android.material.textfield.TextInputEditText;

import java.io.ByteArrayOutputStream;

public class CreateVolunteerProgram extends AppCompatActivity {
    private static final int REQUEST_GALLERY = 1;
    private static final int REQUEST_LOCATION = 2;
    private TextInputEditText editVolunteerName;
    private TextInputEditText editVolunteerDate;
    private TextInputEditText editVolunteerLocation;
    private TextInputEditText editVolunteerDescription;
    private ImageView imageVolunteer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_volunteer_program);

        editVolunteerName = findViewById(R.id.editVolunteerName);
        editVolunteerDate = findViewById(R.id.editVolunteerDate);
        editVolunteerLocation = findViewById(R.id.editVolunteerLocation);
        editVolunteerDescription = findViewById(R.id.editVolunteerDescription);
        imageVolunteer = findViewById(R.id.imageVolunteer);

        Button btnSelectImage = findViewById(R.id.btnSelectImage);
        btnSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImageFromGallery();
            }
        });

        Button btnSave = findViewById(R.id.btnSaveVolunteerActivity);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        Button btnSelectLocation = findViewById(R.id.btnSelectLocation);
        btnSelectLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateVolunteerProgram.this, MapActivity.class);
                startActivityForResult(intent, REQUEST_LOCATION);
            }
        });

    }

    private void selectImageFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, REQUEST_GALLERY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_GALLERY:
                if (requestCode == REQUEST_GALLERY && resultCode == RESULT_OK && data != null) {
                    Uri selectedImageUri = data.getData();
                    imageVolunteer.setImageURI(selectedImageUri);
                }
                break;

            case REQUEST_LOCATION:
                if (requestCode == REQUEST_LOCATION && resultCode == Activity.RESULT_OK) {
                    double lat = data.getDoubleExtra("lat", 0);
                    double lng = data.getDoubleExtra("lng", 0);


                    String locationText = "Lat: " + lat + ", Lng: " + lng;
                    editVolunteerLocation.setText(locationText);
                }
                break;


        }



    }

    private void saveData() {
        String name = editVolunteerName.getText().toString();
        String date = editVolunteerDate.getText().toString();
        String location = editVolunteerLocation.getText().toString();
        String description = editVolunteerDescription.getText().toString();

        // Convertir la imagen del ImageView a ByteArray para Firebase
        Bitmap bitmap = ((BitmapDrawable) imageVolunteer.getDrawable()).getBitmap();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageData = baos.toByteArray();


    }
}