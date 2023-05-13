package com.ru.min.sportquiz.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class QuestionPool {

    private List<Question> questions = new ArrayList<>(List.of(
            new Question(Level.EASY, "1Сколько пальцев у человека на руке?", "2", "3", "4", "5", "5"),
            new Question(Level.EASY, "2Где заходит солнце?", "Восток", "Запад", "Север", "Юг", "Запад"),
            new Question(Level.EASY, "3Сколько пальцев у человека на руке?", "2", "3", "4", "5", "5"),
            new Question(Level.EASY, "4Сколько пальцев у человека на руке?", "2", "3", "4", "5", "5"),
            new Question(Level.EASY, "5Сколько пальцев у человека на руке?", "2", "3", "4", "5", "5"),
            new Question(Level.MEDIUM, "6Сколько пальцев у человека на руке?", "6", "3", "4", "5", "6"),
            new Question(Level.MEDIUM, "7Сколько пальцев у человека на руке?", "6", "3", "4", "5", "6"),
            new Question(Level.MEDIUM, "8Сколько пальцев у человека на руке?", "6", "3", "4", "5", "6"),
            new Question(Level.MEDIUM, "9Сколько пальцев у человека на руке?", "6", "3", "4", "5", "6"),
            new Question(Level.MEDIUM, "10Сколько пальцев у человека на руке?", "6", "3", "4", "5", "6"),
            new Question(Level.HARD, "11Сколько пальцев у человека на руке?", "7", "3", "4", "5", "7"),
            new Question(Level.HARD, "12Сколько пальцев у человека на руке?", "7", "3", "4", "5", "7"),
            new Question(Level.HARD, "13Сколько пальцев у человека на руке?", "7", "3", "4", "5", "7"),
            new Question(Level.HARD, "14Сколько пальцев у человека на руке?", "7", "3", "4", "5", "7"),
            new Question(Level.HARD, "15Сколько пальцев у человека на руке?", "7", "3", "4", "5", "7")
    ));

    public QuestionPool() {
        this.questions = questions;
    }


    public Question getQuestion(Level level){
        List<Question> filteredQuestions = questions.stream()
                .filter(x -> x.getLevel().equals(level))
                .filter(x -> x.getStatus().equals(Status.NOT_SHOWED))
                .collect(Collectors.toList());

        if (!filteredQuestions.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(filteredQuestions.size());
            Question question = filteredQuestions.get(randomIndex);
            question.setStatus(Status.SHOWED);
            filteredQuestions.add(question);
            //questions.add(question);
            return question;
        } else {
            throw new IllegalArgumentException("Вопросы закончились!");
        }
    }

    public boolean checkCorrectAnswer(Question question, String answer){
        return question.getAnswer().equals(answer);
    }
}
