import model.Book;
import model.Library;
import model.Member;
import service.LibraryService;
import service.MemberService;

import java.util.Scanner;

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryService libraryService = new Library();
        MemberService memberService;
        int choice;

        System.out.println("Welcome to the Library Management System");

        do {
            System.out.println("\nPlease select an option:");
            System.out.println("[1]. Add Book");
            System.out.println("[2]. Add Member");
            System.out.println("[3]. Borrow Book");
            System.out.println("[4]. Return Book");
            System.out.println("[5]. Display All Books");
            System.out.println("[6]. Display All Members");
            System.out.println("[0]. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter Book ID:");
                    long id = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Enter Book Title:");
                    String title = scanner.nextLine();
                    System.out.println("Enter Book Author:");
                    String author = scanner.nextLine();
                    Book book = new Book(id, title, author, true);
                    ((Library) libraryService).addBook(book);
                }
                case 2 -> {
                    System.out.println("Enter Member ID:");
                    long id = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Enter Member Name:");
                    String name = scanner.nextLine();
                    Member member = new Member(id, name);
                    ((Library) libraryService).registerMember(member);
                }
                case 3 -> {
                    System.out.println("Enter Member ID:");
                    long memberId = scanner.nextLong();
                    Member member = ((Library) libraryService).findMemberById(memberId);
                    if (member != null) {
                        System.out.println("Enter Book ID:");
                        long bookId = scanner.nextLong();
                        Book book = ((Library) libraryService).findBookById(bookId);
                        if (book != null) {
                            member.borrowBook(book);
                        }
                    }
                }
                case 4 -> {
                    System.out.println("Enter Member ID:");
                    long memberId = scanner.nextLong();
                    Member member = ((Library) libraryService).findMemberById(memberId);
                    if (member != null) {
                        System.out.println("Enter Book ID:");
                        long bookId = scanner.nextLong();
                        Book book = ((Library) libraryService).findBookById(bookId);
                        if (book != null) {
                            member.returnBook(book);
                        }
                    }
                }
                case 5 -> ((Library) libraryService).displayBooks();
                case 6 -> ((Library) libraryService).displayMembers();
                case 0 -> System.out.println("Exiting the system...");
                default -> System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
