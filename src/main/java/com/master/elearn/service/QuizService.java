package com.master.elearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.master.elearn.entity.Quiz;
import com.master.elearn.repo.QuizRepository;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    public List<Quiz> getQuizzesByCourse(Long courseId) {
        return quizRepository.findByCourseId(courseId);
    }

    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }
}