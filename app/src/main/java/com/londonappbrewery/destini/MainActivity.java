package com.londonappbrewery.destini;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
     Button buttonTop;
     Button buttonBottom;
     TextView storyTextView;
     int mIndex;
     int story;
     int ans1;
     int ans2;

     //creating story bank
     private Story[] storyBank = new Story[]{
             new Story(R.string.T1_Story,R.string.T1_Ans1,R.string.T1_Ans2),
             new Story(R.string.T2_Story,R.string.T2_Ans1,R.string.T2_Ans2),
             new Story(R.string.T3_Story,R.string.T3_Ans1,R.string.T3_Ans2),
             new Story(R.string.T4_End,R.string.T5_End,R.string.T6_End)

     };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState !=null){
            mIndex = savedInstanceState.getInt("mStoryIndex");
        }
        else{
            mIndex = 0;
        }


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:

           buttonTop = (Button)findViewById(R.id.buttonTop);
           buttonBottom = (Button)findViewById(R.id.buttonBottom);
           storyTextView = (TextView)findViewById(R.id.storyTextView);


           story = storyBank[mIndex].getStoryID();
           ans1 = storyBank[mIndex].getAns1();
           ans2 = storyBank[mIndex].getAns2();

           storyTextView.setText(story);
           buttonTop.setText(ans1);
           buttonBottom.setText(ans2);
        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

         buttonTop.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

               updateStory();
             }
         });




        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

         buttonBottom.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 updateStory();
             }
         });


    }
    private  void updateStory(){
        mIndex = (mIndex+1)% storyBank.length;

        if(mIndex==0){

            buttonTop.setVisibility(View.GONE);
            buttonBottom.setVisibility(View.GONE);
            storyTextView.setVisibility(View.GONE);

            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Game Over!");
            alert.setCancelable(false);
            alert.setPositiveButton("Close the game!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            alert.show();
        }

        story = storyBank[mIndex].getStoryID();
        ans1 = storyBank[mIndex].getAns1();
        ans2 = storyBank[mIndex].getAns2();

        storyTextView.setText(story);
        buttonTop.setText(ans1);
        buttonBottom.setText(ans2);

    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("mStoryIndex" , mIndex);
    }
}
