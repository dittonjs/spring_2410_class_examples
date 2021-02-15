package com.usu.josephditton.gridlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(3);

        for(int i = 0; i < 3; i ++) {
            for (int j = 0; j < 3; j++) {
                AppCompatTextView textView = new AppCompatTextView(this);
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.rowSpec = GridLayout.spec(i, 1f);


//                params.setMargins(48,48,48, 48);
                textView.setText("(" + i + "," + j + ")");
                if (j == 0 && i == 0) {
                    params.columnSpec = GridLayout.spec(j, 2, 1f);
                    j++;
                }  else {
                    params.columnSpec = GridLayout.spec(j,1f);
                }
                textView.setLayoutParams(params);
                gridLayout.addView(textView);

            }
        }

        setContentView(gridLayout);


    }
}