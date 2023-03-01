package com.example.student.demo.Controller;

import com.example.student.demo.DTO.BookRequestDTO;
import com.example.student.demo.DTO.BookResponseDTO;
import com.example.student.demo.DTO.StudentResponseDTO;
import com.example.student.demo.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController
{

    @Autowired
    BookService bookService;

    @PostMapping(value = "/books")
    public ResponseEntity<Object> createBook(@RequestBody BookRequestDTO bookRequestDTO)
    {
        BookResponseDTO book = bookService.postBook(bookRequestDTO);
        return ResponseEntity.ok(book);
    }
    @GetMapping(value ="/books")
    public ResponseEntity<Object> getBook()
    {
        List<BookResponseDTO> bookResponseDTO = bookService.getBooks();
        return ResponseEntity.ok(bookResponseDTO);
    }

    @GetMapping(value = "/books/{id}")
    public ResponseEntity<Object> getSingleBook(@PathVariable("id") int id)
    {
        BookResponseDTO bookResponseDTO = bookService.getSingleBooks(id);
        return ResponseEntity.ok(bookResponseDTO);
    }


    @PutMapping(value = "/books/{id}")
    public ResponseEntity<Object> updateBook(@RequestBody BookRequestDTO bookRequestDTO,@PathVariable("id") int id)
    {
        BookResponseDTO bookResponseDTO= bookService.putBook(bookRequestDTO,id);
        return ResponseEntity.ok(bookResponseDTO);
    }

    @DeleteMapping(value ="/books/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable("id") int id)
    {
        Object obj = bookService.deleteBooks(id);
        return ResponseEntity.ok(obj);

    }

}
