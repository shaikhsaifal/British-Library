package com.britishlibrary.British.Library.controller;

import com.britishlibrary.British.Library.entity.BookEntry;
import com.britishlibrary.British.Library.entity.User;
import com.britishlibrary.British.Library.service.BookEntryService;
import com.britishlibrary.British.Library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookEntryController {
    @Autowired
    private BookEntryService bookEntryService;
    @Autowired
    private UserService userService;

    private String getLoggedInUsername(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @GetMapping
    public List<BookEntry> getAllEntriesByUsername() {
        User user = userService.findbyUsername(getLoggedInUsername());
        if (user == null) throw new RuntimeException("User not found!");
        return user.getBookEntries();
    }

    @PostMapping
    public ResponseEntity<?> createEntry(@RequestBody BookEntry bookEntry){
        try {
            bookEntryService.saveEntry(bookEntry,getLoggedInUsername());
            return new ResponseEntity<>(bookEntry,HttpStatus.CREATED);
        } catch (Exception e){
             new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    @DeleteMapping("id/{myId}")
    public ResponseEntity<?> deleteBookEntryById(@PathVariable String myId){
        boolean removed = bookEntryService.deleteEntry(myId, getLoggedInUsername());
        return removed ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
