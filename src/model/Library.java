package model;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Library {
    private List<Book> books;
    private List<Members> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println(book.getTitle() + " has been added to the library.");
    }

    public void registerMember(Members member) {
        members.add(member);
        System.out.println(member.getMemberName() + " has been registered as a member.");
    }

    public Book findBookById(long id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        System.out.println("Book with ID " + id + " not found.");
        return null;
    }

    public Members findMemberById(long id) {
        for (Members member : members) {
            if (member.getMemberId() == id) {
                return member;
            }
        }
        System.out.println("Member with ID " + id + " not found.");
        return null;
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Books in the library:");
            for (Book book : books) {
                book.getDetails();
            }
        }
    }

    public void displayMembers() {
        if (members.isEmpty()) {
            System.out.println("No members in the library.");
        } else {
            System.out.println("Members in the library:");
            for (Members member : members) {
                member.getDetails();
            }
        }
    }
}
