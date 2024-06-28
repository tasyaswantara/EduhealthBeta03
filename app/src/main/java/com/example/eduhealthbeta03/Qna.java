package com.example.eduhealthbeta03;

public class Qna {
    private String answer;

    private String question;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


    public Qna(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }


}
