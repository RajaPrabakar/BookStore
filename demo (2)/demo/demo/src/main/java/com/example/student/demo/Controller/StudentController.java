package com.example.student.demo.Controller;

import com.example.student.demo.DTO.StudentRequestDTO;
import com.example.student.demo.DTO.StudentResponseDTO;
import com.example.student.demo.Model.Student;
import com.example.student.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController
{
    @Autowired
    StudentService studentService;

    @GetMapping(value ="/students")
    public ResponseEntity<Object> getStudent()
    {
        List<StudentResponseDTO> studentResponseDTO = studentService.getStudents();
        return  ResponseEntity.ok(studentResponseDTO);

    }

    @GetMapping(value = "/students/{id}")
    public ResponseEntity<Object> getOneStudent(@PathVariable("id") int id)
    {

        StudentResponseDTO studentResponseDTO = studentService.getSingleStudent(id);
        return ResponseEntity.ok(studentResponseDTO);
    }

    @PostMapping(value ="/students")
    public ResponseEntity<Object> createStudent(@RequestBody StudentRequestDTO studentRequestDTO)
    {
        StudentResponseDTO studentResponseDTO = studentService.postStudents(studentRequestDTO);
        return ResponseEntity.accepted().body(studentResponseDTO) ;

    }

    @PutMapping(value ="/students/{id}")
    public ResponseEntity<Object> putStudent(@PathVariable ("id") int id,@RequestBody StudentRequestDTO studentRequestDTO)
    {
        StudentResponseDTO studentResponseDTO = studentService.putStudents(studentRequestDTO,id);
            return ResponseEntity.accepted().body(studentResponseDTO);
    }



    @DeleteMapping(value = "/students/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable ("id") int id)
    {
     Object obj = studentService.deleteStudents(id);
     return ResponseEntity.ok(obj);
    }

}
