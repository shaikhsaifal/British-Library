package com.britishlibrary.British.Library.service;

import com.britishlibrary.British.Library.entity.BookEntry;
import com.britishlibrary.British.Library.entity.User;
import com.britishlibrary.British.Library.repository.BookEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookEntryService {

    @Autowired
    private BookEntryRepository bookEntryRepository;
    @Autowired
    private UserService userService;

    public BookEntry saveEntry(BookEntry myEntry, String username){
        try {
            User user =userService.findbyUsername(username);
            if (user == null)throw new RuntimeException("User not found!");

            myEntry.setRegdate(LocalDateTime.now());
            BookEntry savedEntry =bookEntryRepository.save(myEntry);

            user.getBookEntries().add(savedEntry);
            userService.saveUser(user);
        } catch (Exception e){
            throw new RuntimeException("Error ",e);
        }
        return myEntry;
    }

    public boolean deleteEntry(String id, String username){
        User user = userService.findbyUsername(username);
        if (user == null) throw new RuntimeException("user not found");

        boolean removed = user.getBookEntries().removeIf(x -> x.getId().equals(id));
        if (removed){
            userService.saveUser(user);
            bookEntryRepository.deleteById(id);
        }
        return removed;
    }

    public List<BookEntry> getAllBooks(){
        return bookEntryRepository.findAll();
    }

    public BookEntry getBookById(String id) {
        return bookEntryRepository.findById(id).orElse(null);
    }

}

