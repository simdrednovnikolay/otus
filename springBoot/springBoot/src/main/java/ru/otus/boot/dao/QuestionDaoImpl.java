package ru.otus.boot.dao;

import au.com.bytecode.opencsv.CSVReader;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import ru.otus.boot.config.CsvConfig;
import ru.otus.boot.domain.AnswerDto;
import ru.otus.boot.domain.QuestionDto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


@Service
@RequiredArgsConstructor
public class QuestionDaoImpl implements QuestionDao {
    private final CsvConfig csvConfig;

    @Override
    public QuestionDto getQuestion(int question) throws IOException {
        File file = new ClassPathResource(csvConfig.getQuestionFile()).getFile();
        try (CSVReader reader = new CSVReader(new FileReader(file)
                , ';', '"', question)) {

            return QuestionDto.builder()
                    .question(String.valueOf(Arrays.toString(reader.readNext()).charAt(1)))
                    .build();
        } catch (IOException ex) {
            throw new FileNotFoundException("File is not found");
        }
    }

    @Override
    public AnswerDto checkResult(int question, int answer) throws IOException {
        File file = new ClassPathResource(csvConfig.getAnswerFile()).getFile();
        try (CSVReader reader = new CSVReader(new FileReader(file)
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
        return trueAnswer.getAnswer() == userAnswer ? "message.correct" : "message.incorrect";
    }
}