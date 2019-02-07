package com.comp1601.truefalsequiz;

public class Transcript {
    private static final Integer FULLMARK = 100;
    private static final Integer TOTALQUESTIONS = 10;
    private String gradeText;
    private Integer countOfRightAnswers;

    public Transcript(Integer countOfRightAnswers){
        this.countOfRightAnswers=countOfRightAnswers;
        String strOfRightAnswers=new Integer((int)(countOfRightAnswers/(float)TOTALQUESTIONS)).toString();
        this.gradeText= strOfRightAnswers+ "/"+ FULLMARK.toString();
    }

    public String getGradeText() {
        return gradeText;
    }


    public String getComment() {
        if (this.countOfRightAnswers >=9) {
            return "A+ Student! Congrats!";
        } else if (8<=this.countOfRightAnswers && this.countOfRightAnswers<9){
            return "B. That's niceA";
        } else if (6<=this.countOfRightAnswers && this.countOfRightAnswers<8){
            return "C. Should work harder.";
        } else {
            return "Fail.Please consider switching your major.";
        }

    }
}
