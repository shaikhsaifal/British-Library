//package com.britishlibrary.British.Library.controller;
//
//import com.britishlibrary.British.Library.entity.BookEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/books")
//public class BookEntryController {
//    private Map<Long,BookEntry>BookEntries =new HashMap<>();
//    private long nextId =1;
//
//    @GetMapping
//    public List<BookEntry> getAll(){
//        return new ArrayList<>(BookEntries.values());
//    }
//    //inseting a value
//    @PostMapping
//    public BookEntry insertBook(@RequestBody BookEntry book){
//        book.setId(nextId++);
//        BookEntries.put(book.getId(), book);
//        return book;
//    }
//    //get with the id
//    @GetMapping("id/{id}")
//    public BookEntry getBookById(@PathVariable long id){
//        return BookEntries.get(id);
//    }
//    //delte
//    @DeleteMapping("id/{id}")
//    public BookEntry deleteById(@PathVariable long id){
//        return BookEntries.remove(id);
//    }
//    //update
//    @PutMapping("id/{id}")
//    public BookEntry updateId(@PathVariable long id, @RequestBody BookEntry book){
//        BookEntries.put(id,book);
//        return book;
//    }
//
//}
