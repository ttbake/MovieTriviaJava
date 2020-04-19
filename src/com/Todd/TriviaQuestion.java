package com.Todd;

public class TriviaQuestion {
    private String question;
    private String firstOption;
    private String secondOption;
    private String thirdOption;
    private String correctAnswer;
    private boolean questionAsked = false;

    public boolean isQuestionAsked() {
        return questionAsked;
    }

    public void setQuestionAsked(boolean questionAsked) {
        this.questionAsked = questionAsked;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getFirstOption() {
        return firstOption;
    }

    public void setFirstOption(String firstOption) {
        this.firstOption = firstOption;
    }

    public String getSecondOption() {
        return secondOption;
    }

    public void setSecondOption(String secondOption) {
        this.secondOption = secondOption;
    }

    public String getThirdOption() {
        return thirdOption;
    }

    public void setThirdOption(String thirdOption) {
        this.thirdOption = thirdOption;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
