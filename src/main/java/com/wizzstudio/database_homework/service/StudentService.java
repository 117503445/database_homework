package com.wizzstudio.database_homework.service;

import com.wizzstudio.database_homework.entity.StudentEntity;
import com.wizzstudio.database_homework.util.MathUtil;

import java.util.Arrays;
import java.util.List;

public class StudentService {
    private static List<Double> getFailSums(StudentEntity studentEntity) {
        var sumBiXiu = 0.0;
        var sumXianXuan = 0.0;
        var sumRenXuan = 0.0;


        var scores = studentEntity.getScoreEntities();

        for (var score : scores) {
            if (ScoreService.isFail(score)) {
                var course = score.getCourseEntity();

                var credit = course.getCredit();

                switch (course.getType()) {
                    case 0:
                        sumBiXiu += credit;
                        break;
                    case 1:
                        sumXianXuan += credit;
                        break;
                    case 2:
                        sumRenXuan += credit;
                        break;
                    default:
                        break;
                }
            }
        }
        return Arrays.asList(sumBiXiu, sumXianXuan, sumRenXuan);
    }

    public static boolean isFiring(StudentEntity studentEntity) {

        var sums = getFailSums(studentEntity);

        var sumBiXiu = sums.get(0);
        var sumXianXuan = sums.get(1);
        var sumRenXuan = sums.get(2);

        var rule = studentEntity.getClassEntity().getRuleEntity();

        boolean b = MathUtil.isBetween(sumBiXiu, rule.getMaxBiXiuFailedCredit() - 2, rule.getMaxBiXiuFailedCredit(), true, false) || MathUtil.isBetween(sumRenXuan, rule.getMaxRenXuanFailedCredit() - 2, rule.getMaxRenXuanFailedCredit(), true, false) || MathUtil.isBetween(sumXianXuan, rule.getMaxXianXuanFailedCredit() - 2, rule.getMaxXianXuanFailedCredit(), true, false);
        return b;
    }

    public static boolean isFired(StudentEntity studentEntity) {
        var sums = getFailSums(studentEntity);

        var sumBiXiu = sums.get(0);
        var sumXianXuan = sums.get(1);
        var sumRenXuan = sums.get(2);

        var rule = studentEntity.getClassEntity().getRuleEntity();

        boolean b = sumBiXiu >= rule.getMaxBiXiuFailedCredit() || sumXianXuan >= rule.getMaxXianXuanFailedCredit() || sumRenXuan >= rule.getMaxRenXuanFailedCredit();
        return b;
    }
}
