package com.example.student.demo.Service;

import com.example.student.demo.DTO.StudentBooksRequestDTO;
import com.example.student.demo.DTO.StudentBooksResponseDTO;
import com.example.student.demo.DTO.StudentsBooksResponseNewDTO;
import com.example.student.demo.Model.Book;
import com.example.student.demo.Model.Student;
import com.example.student.demo.Model.StudentBooks;
import com.example.student.demo.Repository.BookRepository;
import com.example.student.demo.Repository.StudentBooksRepository;
import com.example.student.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentBooksService {

    @Autowired
    StudentBooksRepository studentBooksRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    StudentRepository studentRepository;





    public Object postStudentBooks(StudentBooksRequestDTO studentBooksRequestDTO) {
        StudentBooks studentBooks = new StudentBooks();
        Student student = studentRepository.findById(studentBooksRequestDTO.getStudentId()).orElse(null);
        Book book = bookRepository.findById(studentBooksRequestDTO.getBookId()).orElse(null);
        studentBooks.setBook(book);
        studentBooks.setStudent(student);
        studentBooksRepository.save(studentBooks);
        return "Created";
    }

    public List<StudentBooks> getStudentBook() {
        return studentBooksRepository.findAll();
    }

    public List<StudentBooksResponseDTO> getSingleSingleBook(int id) {
        List<StudentBooks> studentBooks = studentBooksRepository.findByStudent_Id(id);
        List<StudentBooksResponseDTO> studentBooksResponseDTOList = new ArrayList<>();
        for (StudentBooks studentBook : studentBooks) {
            StudentBooksResponseDTO studentBooksResponseDTO = new StudentBooksResponseDTO();
            studentBooksResponseDTO.setStudentName(studentBook.getStudent().getStudentName());
            studentBooksResponseDTO.setBookName(studentBook.getBook().getBookName());
            studentBooksResponseDTO.setAuthorName(studentBook.getBook().getAuthorName());
            studentBooksResponseDTO.setStudentId(studentBook.getStudent().getId());
            studentBooksResponseDTO.setId(studentBook.getId());
            studentBooksResponseDTO.setBookId(studentBook.getBook().getId());
            studentBooksResponseDTOList.add(studentBooksResponseDTO);
        }
        return studentBooksResponseDTOList;

    }

    public StudentBooksResponseDTO putStudentBook(StudentBooksRequestDTO studentBooksRequestDTO, int id) {
        Book book = bookRepository.findById(id).orElse(null);
        book.setBookName(studentBooksRequestDTO.getBookName());
        bookRepository.save(book);
        StudentBooksResponseDTO studentBooksResponseDTO = new StudentBooksResponseDTO();
        studentBooksResponseDTO.setBookName(book.getBookName());
        studentBooksResponseDTO.setBookId(book.getId());
        studentBooksResponseDTO.setAuthorName(book.getAuthorName());

        return studentBooksResponseDTO;
    }

    public Object deleteStudentBooks(int id) {
        Book book = bookRepository.findById(id).orElse(null);
        bookRepository.delete(book);
        return "deleted";

    }

    public List<StudentsBooksResponseNewDTO> getStudentsBooks(StudentBooksRequestDTO studentBooksRequestDTO) {

        List<StudentBooks> studentBooks = new ArrayList<>();
        List<StudentsBooksResponseNewDTO> studentsBooksResponseNewDTOS = new ArrayList<>();
        if(studentBooksRequestDTO.getStudentName()!= null && studentBooksRequestDTO.getBookName()!= null && studentBooksRequestDTO.getAuthorName() != null)
        {

            studentBooks = studentBooksRepository.findByStudent_StudentNameAndBook_BookNameAndBook_AuthorName(studentBooksRequestDTO.getStudentName(),studentBooksRequestDTO.getBookName(),studentBooksRequestDTO.getAuthorName());
            for (StudentBooks studentBook : studentBooks) {
                StudentsBooksResponseNewDTO studentsBooksResponseNewDTO = new StudentsBooksResponseNewDTO();
                studentsBooksResponseNewDTO.setStudentName(studentBook.getStudent().getStudentName());
                studentsBooksResponseNewDTO.setBookName(studentBook.getBook().getBookName());
                studentsBooksResponseNewDTO.setAuthorName(studentBook.getBook().getAuthorName());
                studentsBooksResponseNewDTOS.add(studentsBooksResponseNewDTO);
            }
        }
        else if(studentBooksRequestDTO.getStudentName()!= null && studentBooksRequestDTO.getBookName()!= null)
        {

            studentBooks=studentBooksRepository.findByStudent_StudentNameAndBook_BookName(studentBooksRequestDTO.getStudentName(),studentBooksRequestDTO.getBookName());
            for (StudentBooks studentBook : studentBooks) {
                StudentsBooksResponseNewDTO studentsBooksResponseNewDTO = new StudentsBooksResponseNewDTO();
                studentsBooksResponseNewDTO.setStudentName(studentBook.getStudent().getStudentName());
                studentsBooksResponseNewDTO.setBookName(studentBook.getBook().getBookName());
                studentsBooksResponseNewDTO.setAuthorName(studentBook.getBook().getAuthorName());
                studentsBooksResponseNewDTOS.add(studentsBooksResponseNewDTO);
            }
        }
        else if(studentBooksRequestDTO.getBookName()!= null && studentBooksRequestDTO.getAuthorName() != null)
        {
            studentBooks=studentBooksRepository.findByBook_BookNameAndBook_AuthorName(studentBooksRequestDTO.getBookName(),studentBooksRequestDTO.getAuthorName());
            for (StudentBooks studentBook : studentBooks) {
                StudentsBooksResponseNewDTO studentsBooksResponseNewDTO = new StudentsBooksResponseNewDTO();
                studentsBooksResponseNewDTO.setStudentName(studentBook.getStudent().getStudentName());
                studentsBooksResponseNewDTO.setBookName(studentBook.getBook().getBookName());
                studentsBooksResponseNewDTO.setAuthorName(studentBook.getBook().getAuthorName());
                studentsBooksResponseNewDTOS.add(studentsBooksResponseNewDTO);
            }
        }

        else if( studentBooksRequestDTO.getStudentName()!= null && studentBooksRequestDTO.getAuthorName() != null )
        {
            studentBooks = studentBooksRepository.findByStudent_StudentNameAndBook_AuthorName(studentBooksRequestDTO.getStudentName(),studentBooksRequestDTO.getAuthorName());
            for (StudentBooks studentBook : studentBooks) {
                StudentsBooksResponseNewDTO studentsBooksResponseNewDTO = new StudentsBooksResponseNewDTO();
                studentsBooksResponseNewDTO.setStudentName(studentBook.getStudent().getStudentName());
                studentsBooksResponseNewDTO.setBookName(studentBook.getBook().getBookName());
                studentsBooksResponseNewDTO.setAuthorName(studentBook.getBook().getAuthorName());
                studentsBooksResponseNewDTOS.add(studentsBooksResponseNewDTO);
            }
        }
         else if (studentBooksRequestDTO.getStudentName()!= null)
        {
            studentBooks = studentBooksRepository.findByStudent_StudentName(studentBooksRequestDTO.getStudentName());
            for (StudentBooks studentBook : studentBooks)
            {
                StudentsBooksResponseNewDTO studentsBooksResponseNewDTO = new StudentsBooksResponseNewDTO();
                studentsBooksResponseNewDTO.setStudentName(studentBook.getStudent().getStudentName());
                studentsBooksResponseNewDTO.setBookName(studentBook.getBook().getBookName());
                studentsBooksResponseNewDTO.setAuthorName(studentBook.getBook().getAuthorName());
                studentsBooksResponseNewDTOS.add(studentsBooksResponseNewDTO);
            }
        }
        else if(studentBooksRequestDTO.getBookName()!= null)
        {
            studentBooks=studentBooksRepository.findByBook_BookName(studentBooksRequestDTO.getBookName());
            for(StudentBooks studentBook : studentBooks)
            {
                StudentsBooksResponseNewDTO studentsBooksResponseNewDTO = new StudentsBooksResponseNewDTO();
                studentsBooksResponseNewDTO.setStudentName(studentBook.getStudent().getStudentName());
                studentsBooksResponseNewDTO.setBookName(studentBook.getBook().getBookName());
                studentsBooksResponseNewDTO.setAuthorName(studentBook.getBook().getAuthorName());
                studentsBooksResponseNewDTOS.add(studentsBooksResponseNewDTO);
            }
        }
        else if (studentBooksRequestDTO.getAuthorName() != null) {
            studentBooks = studentBooksRepository.findByBook_AuthorName(studentBooksRequestDTO.getAuthorName());
            for (StudentBooks studentBook : studentBooks) {
                StudentsBooksResponseNewDTO studentsBooksResponseNewDTO = new StudentsBooksResponseNewDTO();
                studentsBooksResponseNewDTO.setStudentName(studentBook.getStudent().getStudentName());
                studentsBooksResponseNewDTO.setBookName(studentBook.getBook().getBookName());
                studentsBooksResponseNewDTO.setAuthorName(studentBook.getBook().getAuthorName());
                studentsBooksResponseNewDTOS.add(studentsBooksResponseNewDTO);
            }
        }
        else {
            studentBooks=studentBooksRepository.findAll();
            for (StudentBooks studentBook : studentBooks) {
                StudentsBooksResponseNewDTO studentsBooksResponseNewDTO = new StudentsBooksResponseNewDTO();
                studentsBooksResponseNewDTO.setStudentName(studentBook.getStudent().getStudentName());
                studentsBooksResponseNewDTO.setBookName(studentBook.getBook().getBookName());
                studentsBooksResponseNewDTO.setAuthorName(studentBook.getBook().getAuthorName());
                studentsBooksResponseNewDTOS.add(studentsBooksResponseNewDTO);
            }
        }
        return studentsBooksResponseNewDTOS;
        }



    }







