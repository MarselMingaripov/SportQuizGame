package com.ru.min.sportquiz.question;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class QuestionPool {

    private List<Question> questions = new ArrayList<>(List.of(
            new Question(Level.EASY, "Сколько пальцев у человека на руке?", "2", "3", "4", "5", "5"),
            new Question(Level.EASY, "Где заходит солнце?", "Восток", "Запад", "Север", "Юг", "Запад"),
            new Question(Level.EASY, "Сколько пальцев у человека на руке?", "2", "3", "4", "5", "5"),
            new Question(Level.EASY, "Сколько пальцев у человека на руке?", "2", "3", "4", "5", "5"),
            new Question(Level.EASY, "Сколько пальцев у человека на руке?", "2", "3", "4", "5", "5"),
            new Question(Level.MEDIUM, "Сколько пальцев у человека на руке?", "6", "3", "4", "5", "6"),
            new Question(Level.MEDIUM, "Сколько пальцев у человека на руке?", "6", "3", "4", "5", "5"),
            new Question(Level.MEDIUM, "Сколько пальцев у человека на руке?", "6", "3", "4", "5", "5"),
            new Question(Level.MEDIUM, "Сколько пальцев у человека на руке?", "6", "3", "4", "5", "5"),
            new Question(Level.MEDIUM, "Сколько пальцев у человека на руке?", "6", "3", "4", "5", "5"),
            new Question(Level.HARD, "Сколько пальцев у человека на руке?", "7", "3", "4", "5", "5"),
            new Question(Level.HARD, "Сколько пальцев у человека на руке?", "7", "3", "4", "5", "5"),
            new Question(Level.HARD, "Сколько пальцев у человека на руке?", "7", "3", "4", "5", "5"),
            new Question(Level.HARD, "Сколько пальцев у человека на руке?", "7", "3", "4", "5", "5"),
            new Question(Level.HARD, "Сколько пальцев у человека на руке?", "7", "3", "4", "5", "5")
    ));

    public Question getQuestion(Level level){
        List<Question> filteredQuestions = questions.stream()
                .filter(x -> x.getLevel().equals(level))
                .filter(x -> x.getStatus().equals(Status.NOT_SHOWED))
                .collect(Collectors.toList());
        if (!filteredQuestions.isEmpty()) {
            double randomIndex = 1 + Math.random() * filteredQuestions.size();
            Question question = questions.get((int)randomIndex);
            question.setStatus(Status.SHOWED);
            return question;
        } else {
            throw new IllegalArgumentException("Вопросы закончились!");
        }
    }

    public void restartQuestions(){
        questions.stream().forEach(x -> x.setStatus(Status.NOT_SHOWED));
    }
}
