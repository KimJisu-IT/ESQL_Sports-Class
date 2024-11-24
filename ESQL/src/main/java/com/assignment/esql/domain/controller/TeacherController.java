package com.assignment.esql.domain.controller;

import com.assignment.esql.domain.entity.Teacher;
import com.assignment.esql.domain.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        List<Teacher> teachers = teacherService.getAllTeachers();
        return ResponseEntity.ok(teachers);
    }

    @PostMapping
    public ResponseEntity<String> addTeacher(@RequestBody Teacher teacher) {
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(201).body("Teacher added successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Teacher teacher) {
        boolean isValid = teacherService.login(teacher.getId());
        if (isValid) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(401).body("Invalid ID, login failed.");
        }
    }
}