package com.britishlibrary.British.Library.repository;

import com.britishlibrary.British.Library.entity.BookEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookEntryRepository extends MongoRepository<BookEntry,String>{
}
