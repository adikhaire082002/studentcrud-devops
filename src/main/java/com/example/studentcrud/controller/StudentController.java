package com.example.studentcrud.controller;

import com.example.studentcrud.entity.Student;
import com.example.studentcrud.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/createStudent")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student savedStudent = studentService.save(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping("/allStudent")
    public ResponseEntity<List<Student>> getAllStudent() {
        return ResponseEntity.ok(studentService.getAll());
    }

    @GetMapping("/getStudent/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getById(id));
    }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable Long id,
            @RequestBody Student student) {
        return ResponseEntity.ok(studentService.update(id, student));
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.ok("Student deleted successfully");
    }
}