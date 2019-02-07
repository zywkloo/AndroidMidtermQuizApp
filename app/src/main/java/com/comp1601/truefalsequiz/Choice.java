package com.comp1601.truefalsequiz;

public class Choice {
        private String mChoice;

        public Choice(String aChoiceString){
            mChoice = aChoiceString;
        }

        public String getChoice(){
            return this.mChoice;
        }
        public void setChoice(String choice) {this.mChoice = choice;};

}
