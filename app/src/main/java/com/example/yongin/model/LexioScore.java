package com.example.yongin.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.ObservableArrayList;

public class LexioScore extends BaseObservable {
    private ObservableArrayList<Integer> scoreList;

    public LexioScore(int size) {
        scoreList = new ObservableArrayList<>();
        for (int i = 0; i < size; i++) {
            scoreList.add(0);
        }
    }

    public ObservableArrayList<Integer> getScoreList() {
        return scoreList;
    }

    public void setScoreList(ObservableArrayList<Integer> scoreList) {
        this.scoreList = scoreList;
    }
}
