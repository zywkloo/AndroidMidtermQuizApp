package com.comp1601.truefalsequiz;
// new class to handle grade calculation and string parse
public class Transcript {
    private static final Integer FULLMARK = 100;
    private static final Integer TOTALQUESTIONS = 10;
    private String gradeText;
    private Integer countOfRightAnswers;
    //constructor
    public Transcript(Integer countOfRightAnswers){
        this.countOfRightAnswers=countOfRightAnswers;
        Integer strOfRightAnswers = new Integer(countOfRightAnswers*TOTALQUESTIONS);
        this.gradeText= strOfRightAnswers.toString()+ "/"+ FULLMARK.toString();
    }
    //getter
    public String getGradeText() {
        return gradeText;
    }


    //get comment
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
