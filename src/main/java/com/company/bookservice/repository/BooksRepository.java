package com.company.bookservice.repository;

import com.company.bookservice.modul.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BooksRepository extends JpaRepository<Books,Integer> {
    Optional<Books> findByBookId(Integer id);


    List<Books> findAll();
}
