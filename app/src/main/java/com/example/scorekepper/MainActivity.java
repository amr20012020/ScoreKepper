package com.example.scorekepper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        private int mScore1 = 0;
        private int mScore2 = 0;
        private boolean mNightMode = false;

    static final String STATE_SCORE_1 = "Team 1 Score";
    static final String STATE_SCORE_2 = "Team 2 Score";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);


            mNightMode = getIntent().getBooleanExtra("nightMode", false);
            if(mNightMode){
                setTheme(R.style.AppThemeDark);
            } else {
                setTheme(R.style.AppTheme);
            }
            setContentView(R.layout.activity_main);


        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu, menu);
            if (mNightMode) {
                menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
            } else{
                menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
            }
            return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            if(item.getItemId()==R.id.night_mode){
                Intent intent = new Intent(this, MainActivity.class);
                if(!mNightMode){
                    intent.putExtra("nightMode",true);
                } else{
                    intent.putExtra("nightMode",false);
                }
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            }
            return super.onOptionsItemSelected(item);
        }

        public void minus1(View view) {
            mScore1--;
            TextView score_text = (TextView)findViewById(R.id.score_1);
            if (score_text != null) {
                score_text.setText(String.valueOf(mScore1));
            }
        }

        public void plus1(View view) {
            mScore1++;
            TextView score_text = (TextView)findViewById(R.id.score_1);
            if (score_text != null) {
                score_text.setText(String.valueOf(mScore1));
            }
        }

        public void minus2(View view) {
            mScore2--;
            TextView score_text = (TextView)findViewById(R.id.score_2);
            if (score_text != null) {
                score_text.setText(String.valueOf(mScore2));
            }
        }

        public void plus2(View view) {
            mScore2++;
            TextView score_text = (TextView)findViewById(R.id.score_2);
            if (score_text != null) {
                score_text.setText(String.valueOf(mScore2));
            }
        }

    protected void onSaveInstanceState(Bundle outState) {
        // Save the scores.
        outState.putInt(STATE_SCORE_1, mScore1);
        outState.putInt(STATE_SCORE_2, mScore2);
        super.onSaveInstanceState(outState);
    }


    }