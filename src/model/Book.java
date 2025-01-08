package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Book {
    private long id;
    private String title;
    private String author;
    private boolean isAvailable;

    public void getDetails() {
        System.out.println(id + " - " + title + " by " + author + " (" +
                (isAvailable ? "Available" : "Borrowed") + ")");
    }
    public void borrowBook(){
        if (isAvailable){
            isAvailable = false;
            System.out.println(title + "has been borrowed");
        }else {
            isAvailable = true;
            System.out.println(title + "is already borrowed");
        }
    }
    public void returnBook(){
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book Returned");
        }else {
            System.out.println("No Book To Return");
        }
    }
}
