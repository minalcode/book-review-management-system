package com.bookreview.book_review_management.Repository;

import com.bookreview.book_review_management.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}