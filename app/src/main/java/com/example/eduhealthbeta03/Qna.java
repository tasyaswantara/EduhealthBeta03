package com.example.eduhealthbeta03;

public class Qna {
    private final String answer;

    private final String question;

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }


    public Qna(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }


}
