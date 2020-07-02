package com.wizzstudio.database_homework.service;

import com.wizzstudio.database_homework.entity.ScoreEntity;

public class ScoreService {
    public static boolean isFail(ScoreEntity scoreEntity) {
        var secondScore = scoreEntity.getSecondScore();
        return secondScore != -1 && secondScore < 60;
    }
}
