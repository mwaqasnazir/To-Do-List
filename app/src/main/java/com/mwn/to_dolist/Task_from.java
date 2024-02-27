package com.mwn.to_dolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mwn.to_dolist.databinding.ActivityTaskFromBinding;

public class Task_from extends AppCompatActivity {
    ActivityTaskFromBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityTaskFromBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent();
                intent.putExtra("titleEditText",binding.titleEditText.getText().toString());
                intent.putExtra("descEditText",binding.descEditText.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
