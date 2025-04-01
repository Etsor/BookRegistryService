package BookRegistryService.service;

import BookRegistryService.entity.Book;
import BookRegistryService.repository.BookRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookSyncService {

    private final BookRepo bookRepo;

    private final RestTemplate restTemplate = new RestTemplate();

    private static final String SOURCE_1_URL = "http://localhost:8080/mock/source1";
    private static final String SOURCE_2_URL = "http://localhost:8080/mock/source2";

    @Scheduled(fixedRate = 60000)  // Синхронизация с источниками каждую минуту
    public void syncBooks() {
        log.info("Starting book synchronization...");

        List<Book> source1Books = fetchBooksFromSource(SOURCE_1_URL);
        List<Book> source2Books = fetchBooksFromSource(SOURCE_2_URL);

        Set<Book> uniqueBooks = new HashSet<>();
        uniqueBooks.addAll(source1Books);
        uniqueBooks.addAll(source2Books);

        for (Book book : uniqueBooks) {
            if (!bookRepo.existsByIsbn(book.getIsbn())) {
                bookRepo.save(book);
            }
        }

        log.info("Book synchronization completed. Added {} new books.", uniqueBooks.size());
    }

    private List<Book> fetchBooksFromSource(String url) {
        try {
            ResponseEntity<Book[]> response = restTemplate.getForEntity(url, Book[].class);

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                log.info("Uploaded {} books from {}", response.getBody().length, url);
                return List.of(response.getBody());
            } else {
                log.warn("Failed to get data from {}", url);
                return List.of();
            }
        } catch (Exception err) {
            log.error("Failed to fetch books from {}: {}", url, err.getMessage());
            return List.of();
        }
    }
}