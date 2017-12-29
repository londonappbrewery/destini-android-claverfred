package com.londonappbrewery.destini;

/**
 * Created by FRED on 21-Dec-17.
 */

public class Story {

    private  int mStoryID;
    private int mAns1;
    private int mAns2;

    public Story(int storyResourceID,int answer1ResourceID,int answer2ResourceID){

        mStoryID = storyResourceID;
        mAns1 = answer1ResourceID;
        mAns2 = answer2ResourceID;
            }

    public int getStoryID() {
        return mStoryID;
    }

    public void setStoryID(int storyID) {
        mStoryID = storyID;
    }

    public int getAns1() {
        return mAns1;
    }

    public void setAns1(int ans1) {
        mAns1 = ans1;
    }

    public int getAns2() {
        return mAns2;
    }

    public void setAns2(int ans2) {
        mAns2 = ans2;
    }
}
