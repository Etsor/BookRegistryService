package BookRegistryService.repository;

import BookRegistryService.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
    Book findByIsbn(String isbn);

    List<Book> findByDateAddedAfter(Date date);

    boolean existsByIsbn(String isbn);
}