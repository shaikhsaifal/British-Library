package com.britishlibrary.British.Library.service;

import com.britishlibrary.British.Library.entity.BookEntry;
import com.britishlibrary.British.Library.repository.BookEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookEntryService {
   @Autowired
    private BookEntryRepository bookEntryRepository;

    public BookEntry saveEntry(BookEntry myEntry){
        return bookEntryRepository.save(myEntry);
    }


    public List<BookEntry> getAllBooks(){
       return bookEntryRepository.findAll();
   }
    public BookEntry getBookById(String id) {
        return bookEntryRepository.findById(id).orElse(null);
    }
    public void deleteById(String id){
       bookEntryRepository.deleteById(id);
    }


}
