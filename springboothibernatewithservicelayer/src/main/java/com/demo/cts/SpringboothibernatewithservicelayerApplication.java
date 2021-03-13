package com.demo.cts;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.cts.domain.Book;
import com.demo.cts.service.BookService;

@SpringBootApplication
public class SpringboothibernatewithservicelayerApplication implements CommandLineRunner{
	  @Autowired
	  private BookService bookService;
	  	
	  	
	  	public static void main(String[] args) {
	  		SpringApplication.run(SpringboothibernatewithservicelayerApplication.class, args);
	  		
	  	}

	  	@Override
	  	public void run(String... args) throws Exception {
	  		  Scanner scanner=new Scanner(System.in); 
	  		  int ch=0;
	  		  while(true)
	  		  {
	  			  System.out.println("1) ADD BOOK");
	  			  System.out.println("2 SEARCHING A SPECIFIC BOOK");
	  			  System.out.println("3) DISPLAY BOOKS");
	  			  System.out.println("4) DELETE BOOKS");
	  			  System.out.println("5) UPDATE BOOK");
	  			  System.out.println("6) EXIT");
	  			  System.out.println("Enter your choice ");
	  			  ch=scanner.nextInt();
	  			  switch(ch)
	  			  {
	  			  case 1 :        Book book=new Book();
	  		  		              System.out.println("Enter the tile");
	  		                      String title=scanner.next(); 
	  		                      System.out.println("Enter the author"); 
	  		                      String author=scanner.next(); 
	  		                      System.out.println("Enter the price"); 
	  		                      int price=scanner.nextInt();
	  		                      book.setTitle(title);
	  		                      book.setAuthor(author);
	  		                      book.setPrice(price); 
	  		                      book=bookService.addBook(book);
	  		                      System.out.println("Book added!!!!!!!!!!"+book);
	  		                      break;
	  		 
	  			  case 2 :  	 System.out.println("Searching a specific book"); 
	  			                 System.out.println("Enter the book to be searched");
	  			                 int searchId=scanner.nextInt();
	  			                 Book bookSearched=bookService.getBook(searchId); 
	  			                 if(bookSearched!=null) {
	  		                     System.out.println(bookSearched);
	  		                     }
	  			                 else {
	  		                         System.out.println("Book not found!!!!!!");
	  		                          }
	  		                    
	  			                break;
	  			                
	  			  case 3 :    System.out.println("All the books");
	  	                      List<Book> bookList=bookService.getBooks();
	  		                  for(Book book1 : bookList)
	  		                   {
	  		                	System.out.println(book1.getBookId()+" "+book1.getTitle()+" "+book1.getPrice());
	  		                   }
	  		                   break;
	  		                   
	  			  case 4 : 	  System.out.println("Demo of delete!!!!!");
	  			              System.out.println("Enter the book to be deleted");
	  			              int idToDelete=scanner.nextInt();
	  		 		          Book bookSearchedForDelete=bookService.deleteBook(idToDelete); 
	  		 		      
	  		 		          if(bookSearchedForDelete!=null) {
	  		 		          System.out.println("Book deleted "+bookSearchedForDelete);	 		          
	  		                  
	  		 		          } else {
	  		                      System.out.println("No book with the id entered"); 
	  		                      }
	  		                  break;
	  			  case 5  :    System.out.println("Demo for update");            
	  	  	                   System.out.println("Enter the id for the book to be updated");
	  	                       int idToUpdate=scanner.nextInt();
	  	                       Book bookToBeUpdated=bookService.getBook(idToUpdate); 
  			                  if(bookToBeUpdated!=null) {
  		                           System.out.println(bookToBeUpdated);
  		                           System.out.println("Enter the new price");
  		                           bookToBeUpdated.setPrice(scanner.nextFloat());
	  	                         Book bookUpdated= bookService.updateBook(bookToBeUpdated); 
	  	                         System.out.println("Book update!!!!!"+bookUpdated);
	  	                         }
  			                  else
	  	                       {
	  	      	                 System.out.println("Book not found!!!!!!");
	  	                       }
	  	                       break;
	  			  case 6 : System.exit(0);
	  			  
	  			  } // end of switch
	  	     }  // end of while
	  	} // end of main
	  }  // end of class
