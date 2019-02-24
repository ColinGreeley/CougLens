package com.E404.couglens;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

import com.E404.couglens.Clarifai.ClarifaiMain;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import clarifai2.api.ClarifaiResponse;
import clarifai2.dto.model.output.ClarifaiOutput;
import clarifai2.dto.prediction.Prediction;

public class MainActivity extends AppCompatActivity {

    ClarifaiResponse<List<ClarifaiOutput<Prediction>>> predictions;

    private static final int RESULT_LOAD_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    static final int REQUEST_TAKE_PHOTO = 1;
    public void openCamera(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            File photoFile = getTempFile(getApplicationContext(), "cougLens");
            if(photoFile != null) {
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));

                if (photoFile != null) {
                    try {
                        ClarifaiMain api = new ClarifaiMain(photoFile.getCanonicalPath());
                        predictions = api.getPredictions();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void openUpload(View view) {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        if(galleryIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
        }
    }

    private File getTempFile(Context context, String url) {
        File file = null;
        try {
            String fileName = Uri.parse(url).getLastPathSegment();
            file = File.createTempFile(fileName, ".jpg", context.getCacheDir());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
