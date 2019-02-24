package com.E404.couglens;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.security.spec.EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import clarifai2.api.ClarifaiResponse;
import clarifai2.dto.model.output.ClarifaiOutput;
import clarifai2.dto.prediction.Prediction;

public class MainActivity extends AppCompatActivity {

    private int RESULT_LOAD_IMAGE = 1;
    private File imageFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //static final int REQUEST_TAKE_PHOTO = 1;
    public void openCamera(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        imageFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "test.jpg");
        Uri tempUri = Uri.fromFile(imageFile);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, tempUri);
        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 0) {
            switch (resultCode) {
                case Activity.RESULT_OK:
                    if(imageFile.exists()) {
                        Toast.makeText(this, "The File was saved at " + imageFile.getAbsolutePath(), Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(this, "There was an error saving the file", Toast.LENGTH_LONG).show();
                    }
                    break;
                case Activity.RESULT_CANCELED:

                    break;

                default:
                    break;
            }
        }
    }

    public void openUpload(View view) {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        if(galleryIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
        }
    }


}
