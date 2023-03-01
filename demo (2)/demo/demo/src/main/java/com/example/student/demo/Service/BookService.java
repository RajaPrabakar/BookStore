package com.example.student.demo.Service;

import com.example.student.demo.DTO.BookRequestDTO;
import com.example.student.demo.DTO.BookResponseDTO;
import com.example.student.demo.Model.Book;
import com.example.student.demo.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService
{
  @Autowired
    private BookRepository bookRepository;

  public BookResponseDTO postBook(BookRequestDTO bookRequestDTO)
  {
      Book book= new Book();
      book.setId(bookRequestDTO.getId());
      book.setBookName(bookRequestDTO.getBookName());
      book.setAuthorName(bookRequestDTO.getAuthorName());
      Book b = bookRepository.save(book);
      BookResponseDTO bookResponseDTO = new BookResponseDTO();
      bookResponseDTO.setId(b.getId());
      bookResponseDTO.setBookName(b.getBookName());
      bookResponseDTO.setAuthorName(b.getAuthorName());
      return bookResponseDTO;
   }

   public List<BookResponseDTO> getBooks()
   {

       List<Book> bookList =bookRepository.findAll();
       List<BookResponseDTO> bookResponseDTOList = new ArrayList<>();
       for(Book book:bookList)
       {
           BookResponseDTO bookResponseDTO= new BookResponseDTO();
           bookResponseDTO.setId(book.getId());
           bookResponseDTO.setBookName(book.getBookName());
           bookResponseDTO.setAuthorName(book.getAuthorName());
           bookResponseDTOList.add(bookResponseDTO);
       }
       return bookResponseDTOList;
   }

   public BookResponseDTO getSingleBooks(int id)
   {
       Book book =bookRepository.findById(id).orElse(null);
       BookResponseDTO bookResponseDTO = new BookResponseDTO();
       bookResponseDTO.setId(book.getId());
       bookResponseDTO.setBookName(book.getBookName());
       bookResponseDTO.setAuthorName(book.getAuthorName());
       return bookResponseDTO;
   }


   public BookResponseDTO putBook(BookRequestDTO bookRequestDTO,int id)
   {
       Book b = bookRepository.findById(id).orElse(null);
       b.setBookName(bookRequestDTO.getBookName());
       Book book = bookRepository.save(b);
       BookResponseDTO bookResponseDTO = new BookResponseDTO();
       bookResponseDTO.setId(book.getId());
       bookResponseDTO.setBookName(book.getBookName());
       bookResponseDTO.setAuthorName(book.getAuthorName());
       return bookResponseDTO;

   }

   public Object deleteBooks(int id)
   {
       Book book = bookRepository.findById(id).orElse(null);
       bookRepository.delete(book);
       return null;
   }
}
