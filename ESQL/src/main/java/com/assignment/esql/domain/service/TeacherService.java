package com.assignment.esql.domain.service;

import com.assignment.esql.domain.entity.Teacher;
import com.assignment.esql.domain.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public boolean login(int id) {
        return teacherRepository.existsById(id);
    }
}