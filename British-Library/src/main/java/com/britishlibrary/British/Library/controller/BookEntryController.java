package com.britishlibrary.British.Library.controller;

import com.britishlibrary.British.Library.entity.BookEntry;
import com.britishlibrary.British.Library.entity.User;
import com.britishlibrary.British.Library.service.BookEntryService;
import com.britishlibrary.British.Library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    //get all book entries of a user
    @GetMapping("/{userName}")
    public List<BookEntry>getAllEntriesOfUser(@PathVariable String userName){
        User u =userService.findbyUsername(userName);
        if (u != null){
            u.getBookEntries();
        }
        return bookEntryService.getAllBooks();
    }

    @PostMapping("/{userName}")
    public BookEntry insertBook(@RequestBody BookEntry myEntry,@PathVariable String userName){
        // 1️⃣ Set registration date
        myEntry.setRegdate(LocalDateTime.now());

        // 2️⃣ Save the book entry first
        BookEntry savedEntry =bookEntryService.saveEntry(myEntry);
        // 3️⃣ Fetch the user by username
        User user =userService.findbyUsername(userName);
        if (user == null){
            throw new RuntimeException("user not found with username: "+userName);
        }
        // 4️⃣ Add the saved book to the user's list
        user.getBookEntries().add(savedEntry);

        // 5️⃣ Save the updated user
        userService.saveUser(user);
        // 6️⃣ Return the saved book entry
        return savedEntry;
        }

//remaining below are incomplete and remaining to update
//  @GetMapping("/id/{id}")
//     public BookEntry getById(@PathVariable String id){
//        return bookEntryService.getBookById(id);
//    }
//
//    @DeleteMapping("/id/{id}")
//    public boolean deletebook(@PathVariable String id){
//       bookEntryService.deleteById(id);
//        return true;
//    }
//
//    @PutMapping("id/{id}")
//    public BookEntry updateBookEntry(@PathVariable String id,@RequestBody BookEntry updatedEntry){
//        BookEntry existingEntry =bookEntryService.getBookById(id);
//        if (existingEntry== null){
//            throw new RuntimeException("Entry not found with id: "+id);
//        }
//        existingEntry.setTitle(updatedEntry.getTitle());
//        existingEntry.setYear(updatedEntry.getYear());
//        existingEntry.setAuthorName(updatedEntry.getAuthorName());
//        return bookEntryService.saveEntry(existingEntry);
//    }

}
