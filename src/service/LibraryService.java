package service;

import model.Book;

public interface LibraryService {
    String getName();
    void borrowBook(Book book);
    void returnBook(Book book);
    void getDetails();
}
