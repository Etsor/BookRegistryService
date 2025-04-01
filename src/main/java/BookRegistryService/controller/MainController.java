package BookRegistryService.controller;

import BookRegistryService.repository.BookRepo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import BookRegistryService.entity.Book;

import java.util.Date;
import java.util.List;
import java.util.Comparator;

@Tag(name = "main_methods")
@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController {
	private final BookRepo bookRepo;
	private final ObjectMapper mapper = new ObjectMapper();

	@Operation(
			summary = """
                    Возвращает информацию о всех книгах во внутреннем
                    хранилище (с возможностью указания сортировки по названию книги или
                    издательству(title/publisher), а также информацию о всех книгах, данные о которых поступили
                    позже указанной даты (формат даты - yyyy-MM-dd)).
                    """
	)
	@GetMapping("api/all")
	public String allBooks(@RequestParam(value = "afterDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
						   @RequestParam(value = "sortBy", required = false) String sortBy) throws JsonProcessingException {

		List<Book> books;

		if (date != null) {
			books = bookRepo.findByDateAddedAfter(date);
		} else {
			books = bookRepo.findAll();
		}

		if (sortBy != null) {
			switch (sortBy) {
				case "title":
					books.sort(Comparator.comparing(book -> book.title, String.CASE_INSENSITIVE_ORDER));
					break;
				case "publisher":
					books.sort(Comparator.comparing(book -> book.publisher, String.CASE_INSENSITIVE_ORDER));
					break;
				default:
					log.warn("Unknown sortBy parameter: {}", sortBy);
			}
		}
		return mapper.writeValueAsString(books);
	}

	@Operation(
			summary = "Возвращает информацию о книге во внутреннем хранилище по ISBN"
	)
	@GetMapping("/api")
	public ResponseEntity<String> getBookByIsbn(@RequestParam String isbn) throws JsonProcessingException {
		Book book = bookRepo.findByIsbn(isbn);
		if (book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
		}
		return ResponseEntity.ok(mapper.writeValueAsString(book));
	}
}