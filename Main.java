package com.Book;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	
        Library library = new Library();
        
        try (Scanner scanner = new Scanner(System.in)) {
        	
			while (true) {
			    System.out.println("1. Add book");
			    System.out.println("2. Add user");
			    System.out.println("3. issue book");
			    System.out.println("4. Return book");
			    System.out.println("5. Print books");
			    System.out.println("6. exit");
			    System.out.println(" ");

			    System.out.print("Enter your choice: ");
			    int choice = scanner.nextInt();
			    scanner.nextLine(); // Consume newline left-over

			    switch (choice) {
			    
			        case 1:
			            System.out.print("Enter book title: ");
			            String title = scanner.nextLine();
			            
			            System.out.print("Enter book author: ");
			            String author = scanner.nextLine();
			            
			            library.addBook(new Book(title, author));
			            
			            break;
			            
			        case 2:
			        	
			            System.out.print("Enter user name: ");
			            String name = scanner.nextLine();
			            
			            System.out.print("Enter user ID: ");
			            String id = scanner.nextLine();
			            
			            library.addUser(new User(name, id));
			            
			            break;
			            
			        case 3:
			        	
			            System.out.print("Enter book title: ");
			            title = scanner.nextLine();
			            
			            System.out.print("Enter user ID: ");
			            id = scanner.nextLine();
			            
			            library.borrowBook(title, id);
			            
			            break;
			            
			        case 4:
			        	
			            System.out.print("Enter book title: ");
			            title = scanner.nextLine();
			            
			            library.returnBook(title);
			            break;
			            
			        case 5 :
			        	System.out.println(library.printBooks()); 
			        	break;
			        	
			        case 6 :
			        	System.exit(1);
			        	break;
			        	
			        	default : 
			        		System.out.println("Invalid input.......");
			        		
			            
}
			}
		}
    }
}
        