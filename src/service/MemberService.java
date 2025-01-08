package service;

import model.Book;

public interface MemberService {
    long getId();
    String getName();
    void borrowBook(Book book);
    void returnBook(Book book);
    void getDetails();
}
