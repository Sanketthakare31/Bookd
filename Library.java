package com.Book;
import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Book> books;
    private Map<String, User> users;
    private Map<String, String> borrowedBooks;

    public Library() {
        this.books = new HashMap<>();
        this.users = new HashMap<>();
        this.borrowedBooks = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getTitle(), book);
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void borrowBook(String title, String userId) {
        if (books.containsKey(title) && users.containsKey(userId)) {
            Book book = books.get(title);
            if (book.getAvailability()) {
                book.setAvailability(false);
                borrowedBooks.put(title, userId);
                System.out.println("Book borrowed successfully!");
            } else {
                System.out.println("Book is not available.");
            }
        } else {
            System.out.println("Book or user not found.");
        }
    }

    public void returnBook(String title) {
        if (borrowedBooks.containsKey(title)) {
        	
            Book book = books.get(title);
            
            book.setAvailability(true);
            
            borrowedBooks.remove(title);
            
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Book is not borrowed.");
        }
    }

    public Map<String, String> printBooks() {
    	int count=0;
        for (Book book : books.values()) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Availability: " + book.getAvailability());
           count++;
        }
        if(count==0) {
        	System.out.println("No Record found...");
        }
		return borrowedBooks;
       
    }

    public void printUsers() {
        for (User user : users.values()) {
            System.out.println("Name: " + user.getName() + ", ID: " + user.getId());
        }
    }

    public void printBorrowedBooks() {
        for (Map.Entry<String, String> entry : borrowedBooks.entrySet()) {
            System.out.println("Book: " + entry.getKey() + ", Borrowed by: " + users.get(entry.getValue()).getName());
        }
    }
}

