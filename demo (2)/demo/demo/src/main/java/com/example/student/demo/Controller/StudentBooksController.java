package com.example.student.demo.Controller;

import com.example.student.demo.DTO.StudentBooksRequestDTO;
import com.example.student.demo.DTO.StudentBooksResponseDTO;
import com.example.student.demo.DTO.StudentsBooksResponseNewDTO;
import com.example.student.demo.Model.StudentBooks;
import com.example.student.demo.Repository.StudentBooksRepository;
import com.example.student.demo.Service.StudentBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentBooksController
{
    @Autowired
    StudentBooksService studentBooksService;


    @PostMapping(value = "/create-student-book")
    public ResponseEntity<Object> createStudentBooks(@RequestBody StudentBooksRequestDTO studentBooksRequestDTO)
    {
        Object obj= studentBooksService.postStudentBooks(studentBooksRequestDTO);
        return ResponseEntity.ok(obj);

    }

    @GetMapping(value = "/studentBooks")
    public ResponseEntity<Object> getStudentBook()
    {
        List<StudentBooks> studentBooks= studentBooksService.getStudentBook();
        return ResponseEntity.ok(studentBooks);
    }

    @PostMapping(value ="/getSpecificStudentBooks/{id}")
    public ResponseEntity<Object> getOneStudentBooks(@PathVariable int id)
    {
        List<StudentBooksResponseDTO> studentBooks= studentBooksService.getSingleSingleBook(id);
     return ResponseEntity.ok(studentBooks);
    }
    @PutMapping(value = "/studentBooks/{id}")
    public ResponseEntity<Object> updateStudentBook(@RequestBody StudentBooksRequestDTO studentBooksRequestDTO,@PathVariable int id)
    {
        StudentBooksResponseDTO studentBooksResponseDTO= studentBooksService.putStudentBook(studentBooksRequestDTO,id);
        return ResponseEntity.ok(studentBooksResponseDTO);
    }

    @DeleteMapping(value = "/studentBooks/{id}")
    public ResponseEntity<Object> deleteStudentBook(@PathVariable int id)
    {
        Object obj = studentBooksService.deleteStudentBooks(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping(value = "/getting_studentsBooks/")
    public ResponseEntity<Object> putStudentsBooks(@RequestBody StudentBooksRequestDTO studentBooksRequestDTO)
    {
        List<StudentsBooksResponseNewDTO> studentBooksResponseDTOS=studentBooksService.getStudentsBooks(studentBooksRequestDTO);
        return ResponseEntity.ok(studentBooksResponseDTOS);

    }


}
