package model;

import service.MemberService;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Member implements MemberService {
    private long memberId;
    private String memberName;
    private List<Book> memberBorrowedBooks;

    public Member(long memberId, String memberName) {
        this.memberId = memberId;
        this.memberName = memberName;
        memberBorrowedBooks = new ArrayList<>();
    }

    @Override
    public long getId() {
        return memberId;
    }

    @Override
    public String getName() {
        return memberName;
    }

    @Override
    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            memberBorrowedBooks.add(book);
            book.borrowBook();
            System.out.println(memberName + " borrowed " + book.getTitle());
        } else {
            System.out.println(book.getTitle() + " is not available");
        }
    }

    @Override
    public void returnBook(Book book) {
        if (memberBorrowedBooks.contains(book)) {
            memberBorrowedBooks.remove(book);
            book.returnBook();
            System.out.println(memberName + " returned " + book.getTitle());
        } else {
            System.out.println(memberName + " did not borrow " + book.getTitle());
        }
    }

    @Override
    public void getDetails() {
        System.out.println("Member ID: " + memberId);
        System.out.println("Member Name: " + memberName);
        if (memberBorrowedBooks.isEmpty()) {
            System.out.println("No books borrowed");
        } else {
            System.out.println("Books borrowed:");
            for (Book book : memberBorrowedBooks) {
                System.out.println("- " + book.getTitle() + " by " + book.getAuthor());
            }
        }
    }
}
