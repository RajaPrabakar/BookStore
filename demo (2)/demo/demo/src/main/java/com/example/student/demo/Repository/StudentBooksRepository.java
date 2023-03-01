package com.example.student.demo.Repository;

import com.example.student.demo.Model.StudentBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentBooksRepository extends JpaRepository<StudentBooks,Integer>
{
    List<StudentBooks> findByStudent_Id(int id);
    List<StudentBooks> findByStudent_StudentName(String name);
    List<StudentBooks> findByBook_BookName(String name);
    List<StudentBooks> findByBook_AuthorName(String name);
    List<StudentBooks> findByStudent_StudentNameAndBook_BookNameAndBook_AuthorName(String studentName, String bookName, String authorName);
    List<StudentBooks> findByStudent_StudentNameAndBook_BookName(String studentName, String bookName);
    List<StudentBooks> findByBook_BookNameAndBook_AuthorName( String bookName, String authorName);
    List<StudentBooks> findByStudent_StudentNameAndBook_AuthorName(String studentName, String authorName);

}
