package com.example.student.demo.Repository;

import com.example.student.demo.Model.Book;
import com.example.student.demo.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer>
{
}
