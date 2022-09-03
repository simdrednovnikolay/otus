package ru.otus.micro.dao;

import au.com.bytecode.opencsv.CSVReader;
import ru.otus.micro.domain.AnswerDto;
import ru.otus.micro.domain.QuestionDto;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class QuestionDaoImpl implements QuestionDao {
    @Override
    public QuestionDto getQuestion(int question) throws IOException {
        try (CSVReader reader = new CSVReader(new FileReader("src/main/resources/Questions.csv")
                , ';', '"', question)) {

            return QuestionDto.builder()
                    .question(Arrays.toString(reader.readNext()))
                    .build();
        } catch (IOException ex) {
            throw new FileNotFoundException("File is not found");
        }
    }

    @Override
    public AnswerDto checkResult(int question, int answer) throws IOException {

        try (CSVReader reader = new CSVReader(new FileReader("src/main/resources/Answers.csv")
                , ';', '"', question)) {

            return AnswerDto.builder()
                    .answer(Integer.parseInt(reader.readNext()[0]))
                    .build();

        } catch (IOException ex) {
            throw new FileNotFoundException("File is not found");
        }
    }

    @Override
    public String analyseAnswer(AnswerDto trueAnswer, int userAnswer) {
        return trueAnswer.getAnswer() == userAnswer ? "Great\n" :"Incorrect answer\n";
    }
}