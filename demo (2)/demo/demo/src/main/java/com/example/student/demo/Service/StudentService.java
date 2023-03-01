package com.example.student.demo.Service;


import com.example.student.demo.DTO.StudentRequestDTO;
import com.example.student.demo.DTO.StudentResponseDTO;
import com.example.student.demo.Model.Student;
import com.example.student.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService
{
    @Autowired
    StudentRepository studentRepository;

   public StudentResponseDTO postStudents(StudentRequestDTO studentRequestDTO)
   {
       Student student = new Student();
       student.setStudentName(studentRequestDTO.getName());
       student.setId(studentRequestDTO.getId());
       Student s = studentRepository.save(student);
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        studentResponseDTO.setName(s.getStudentName());
        studentResponseDTO.setId(s.getId());
        return studentResponseDTO ;
   }
   public List<StudentResponseDTO> getStudents()
   {
       List<StudentResponseDTO> studentResponseList = new ArrayList<>();
       List<Student> student =studentRepository.findAll();
       for(Student s :student) {
           StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
           studentResponseDTO.setName(s.getStudentName());
           studentResponseDTO.setId(s.getId());
           studentResponseList.add(studentResponseDTO);
       }
       return studentResponseList;

   }
   public StudentResponseDTO getSingleStudent(int id)
   {
       Student student= studentRepository.findById(id).orElse(null);
       StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
       studentResponseDTO.setId(student.getId());
       studentResponseDTO.setName(student.getStudentName());
       return studentResponseDTO;
   }
   public StudentResponseDTO putStudents(StudentRequestDTO studentRequestDTO, int id)
   {
       Student s=studentRepository.findById(id).orElse(null);
       s.setStudentName(studentRequestDTO.getName());
       Student student= studentRepository.save(s);
       StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
       studentResponseDTO.setName(student.getStudentName());
       studentResponseDTO.setId(student.getId());

       return studentResponseDTO;
   }
  public Object deleteStudents(int id)
  {
      Student student=studentRepository.findById(id).orElse(null);
      studentRepository.delete(student);
      return null;
  }
}
