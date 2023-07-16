package com.sh_tab.arbavy;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends Activity {

    public MainActivity() {
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button changeColor = new Button(this);
        changeColor.setText("Hello my sugar slut!)");
        changeColor.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        changeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Random random = new Random();
                view.setBackgroundColor(random.nextInt());
            }
        });
        setContentView(changeColor);
    }
}
