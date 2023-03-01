package com.example.student.demo.DTO;

public class StudentBooksResponseDTO extends StudentsBooksResponseNewDTO {
    private int studentId;
    private int bookId;

    private int id;
    private String studentName;
    private String bookName;
    private String authorName;




    public StudentBooksResponseDTO() {
    }

//    public StudentBooksResponseDTO(int studentId, int id, String bookName, String authorName, int bookId) {
//        this.studentId = studentId;
//        this.id = id;
//        this.bookName = bookName;
//        this.authorName = authorName;
//        this.bookId = bookId;
//    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }




    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }



    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

}
