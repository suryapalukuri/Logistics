package com.example.admin.logistics;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.File;

public class BreakageActivity extends AppCompatActivity {
    Button captureImage,uploaddata;
    private Uri mImageUri;
    String photo_path;
    ImageView breakageimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakage);

        captureImage=findViewById(R.id.captureimage);
        breakageimage=findViewById(R.id.breakageimage);
        uploaddata=findViewById(R.id.uploaddata);
        captureImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CropImage.activity()
                        .setGuidelines(CropImageView.Guidelines.ON)
                        .start(BreakageActivity.this);
            }
        });
        uploaddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(BreakageActivity.this,Depo.class);
                startActivity(in);
            }
        });
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                mImageUri = resultUri;
//                prof_image.setImageURI(resultUri);
                photo_path = resultUri.getPath();
                Picasso.get().load(new File(photo_path)).into(breakageimage);
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }
}
