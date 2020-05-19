package com.example.tomandjerry;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    int player = 0;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    //0 = Tom; 1 = jerry; 2 = empty;
    int[][] winningPositions = {{0,1,2}, {0,3,6}, {0,4,8}, {1,4,7}, {2,5,8},{2,4,6}, {3,4,5}, {6,7,8}};
    boolean gameOver = false;
     //player values in the above positions should be same for a win
    public void onClick(View view) {
        ImageView image = (ImageView) view;
        int tag = Integer.parseInt(image.getTag().toString());
        gameState[tag] = player;
        Log.i("tag status", Arrays.toString(gameState));


        if (image.getDrawable() == null && !gameOver) {

            if (player == 0) {
                player = 1;
                image.setImageResource(R.drawable.tom);
            } else {
                player = 0;
                image.setImageResource(R.drawable.jerry);
            }

            for (int[] x : winningPositions) {

                if (gameState[x[0]] == gameState[x[1]] && gameState[x[0]] != 2 && gameState[x[1]] == gameState[x[2]]) {
                    String winner;
                    if (player == 1) {

                        winner = "Tom";
                    } else {
                        winner = "Jerry";
                    }

                    Toast.makeText(this, winner + " has won", Toast.LENGTH_SHORT).show();
                   // TextView text = findViewById(R.id.textView);
                   // text.setText(winner + " has Won");
                    gameOver = true;
                }

            }
        }



    }

    public void resetFunction(View view){
        ImageView image0 = findViewById(R.id.imageView0);
        image0.setImageDrawable(null);
        ImageView image1 = findViewById(R.id.imageView1);
        image1.setImageDrawable(null);
        ImageView image2 = findViewById(R.id.imageView2);
        image2.setImageDrawable(null);
        ImageView image3 = findViewById(R.id.imageView3);
        image3.setImageDrawable(null);
        ImageView image4 = findViewById(R.id.imageView4);
        image4.setImageDrawable(null);
        ImageView image5 = findViewById(R.id.imageView5);
        image5.setImageDrawable(null);
        ImageView image6 = findViewById(R.id.imageView6);
        image6.setImageDrawable(null);
        ImageView image7 = findViewById(R.id.imageView7);
        image7.setImageDrawable(null);
        ImageView image8 = findViewById(R.id.imageView8);
        image8.setImageDrawable(null);
        player = 0;
        gameOver = false;
        Arrays.fill(gameState, 2);

       // }

    }


    public void myText(View view){

    TextView x = findViewById(R.id.textView2);

    x.animate().rotationBy(3600).alpha(1);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
}
