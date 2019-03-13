package com.cts.controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entity.Book;
import com.cts.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired
	BookService bs;

	//@GetMapping("/books")
	
	//public String listAllBooks() {
	@RequestMapping(value = "/books", method = RequestMethod.GET)//, produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Book>> listAllBooks() {
		System.out.println("Entered in  list abook");
		List<Book> lb = bs.listallBooks();
		System.out.println(lb);
		//model.addAttribute("books", lb);
		//return "bookList";
		 return new ResponseEntity<List<Book>> (lb, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
	public ResponseEntity<Book> findBook(@PathVariable("id") int theId) {
		System.out.println("Entered in  find a book");
		Book book=bs.getBook(theId);
		System.out.println(book);
	 return new ResponseEntity<Book> (book, HttpStatus.OK);
		
	}
	
	


	@RequestMapping(value = "/book", method = RequestMethod.POST)
//ublic String saveABook(@ModelAttribute("book") Book theBook)
	public String saveABook(@RequestBody Book theBook)
	{
		System.out.println("Hey Save Book" + theBook);
		bs.saveBook(theBook);
		//return "redirect:/book/list";
		return " BookSaved";	
	}
	
	

	//@GetMapping("/updateForm")
	@RequestMapping(value = "/book", method = RequestMethod.PUT)
	public  ResponseEntity<Book> bookUpdate(@RequestBody Book theBook)
	{
		bs.saveBook(theBook);
		
		 return new ResponseEntity<Book> (theBook, HttpStatus.OK);
		/*
		System.out.println("UPDATE FORM THE ID"+ theId);
		Book  book =bs.getBook(theId);
		theModel.addAttribute("book",book);
		return "addBook";*/
		
	}


	@RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
	public  String bookDelete(@PathVariable("id") int theId)
	{System.out.println(" Book Delete");
		bs.deleteBook(theId);
		 return "Book Deleted";
		/*
		System.out.println("UPDATE FORM THE ID"+ theId);
		Book  book =bs.getBook(theId);
		theModel.addAttribute("book",book);
		return "addBook";*/
		
	}
	
	/*
	@GetMapping("/showForm")
	public String showAddBook(Model model) {

		
		System.out.println("Entered in  list abook");
		Book theBook = new Book();
		
		model.addAttribute("book", theBook);

		return "addBook";
	}
	
	
	@PostMapping("/saveBook")
	public String saveABook(@ModelAttribute("book") Book theBook)
	{
		System.out.println("Hey Save Book" + theBook);
		bs.saveBook(theBook);
		return "redirect:/book/list";
		
		
	}
	
	@GetMapping("/updateForm")
	public  String showFormUpdate(@RequestParam("bookId") int theId,Model theModel)
	{
		System.out.println("UPDATE FORM THE ID"+ theId);
		Book  book =bs.getBook(theId);
		theModel.addAttribute("book",book);
		return "addBook";
		
	}
	
	
	@GetMapping("/deleteForm")
	public String deleteBook(@RequestParam("bookId") int Id)
	{System.out.println("delete book");
		bs.deleteBook(Id);
		return "redirect:/book/list";
	}
	*/
}
