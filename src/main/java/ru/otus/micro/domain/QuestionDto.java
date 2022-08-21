package ru.otus.micro.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuestionDto {

    protected String question;

    @Override
    public String toString() {
        return question.replace("[","").replace("]","");
    }
}
