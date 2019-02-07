package com.comp1601.truefalsequiz;
//class to handle question string processing
public class Question {
        private String mQuestion;
        private String mAnswer;
//constructor
        public Question(String aQuestionAnswerString){
            int index = aQuestionAnswerString.indexOf("[");
            mQuestion = aQuestionAnswerString.substring(0,index);//assign string before "["
            mAnswer = aQuestionAnswerString.substring(index+1,aQuestionAnswerString.length()-1);  //the rest

        }
        public String getQuestion(){
            return mQuestion;
        }
        public String getAnswer(){
            return mAnswer;
        }
}
