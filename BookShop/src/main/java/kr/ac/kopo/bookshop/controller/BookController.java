package kr.ac.kopo.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.bookshop.model.Book;
import kr.ac.kopo.bookshop.pager.Pager;
import kr.ac.kopo.bookshop.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	final String path = "book/";
	
	@Autowired
	BookService bookservice;
	
	@GetMapping("/dummy")
	String dummy() {
		bookservice.dummy();
		return "redirect:list";
	}
	
	@GetMapping("/init")
	String init() {
		bookservice.init();
		return "redirect:list";
	}
	
	@GetMapping("/list")
	String list(Model model, Pager pager) {
		List<Book> list = bookservice.list(pager);
		model.addAttribute("list", list);
		return path + "list";
	}
	
	@GetMapping("/add")
	String add() {
		return path + "add";
	}
	
	@PostMapping("/add")
	String add(Book item) {
		bookservice.add(item);
		return "redirect:list";
	}
	
	@GetMapping("/update/{bookid}")
	String update(@PathVariable Long bookid, Model model) {
		Book item = bookservice.item(bookid);
		model.addAttribute("item", item);
		return path + "update";
	}
	
	@PostMapping("/update/{bookid}")
	String update(@PathVariable Long bookid, Book item, Model model) {
		item.setBookid(bookid);
		bookservice.update(item);
		return "redirect:../list";
	}
	
	@GetMapping("/delete/{bookid}")
	String delete(@PathVariable Long bookid) {
		bookservice.delete(bookid);
		return "redirect:../list";
	}
	
}
