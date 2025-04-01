package BookRegistryService.mock;

import BookRegistryService.entity.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/mock/source1")
public class MockSource1Controller {

    @GetMapping
    public List<Book> getBooks() {
        return Arrays.asList(
                new Book("9780374275631", "Thinking, Fast and Slow", "Daniel Kahneman",
                        "Nonfiction", "Farrar, Straus and Giroux",
                        2011, 499, new Date()),
                new Book("9780399155345", "The Help", "Kathryn Stockett",
                        "Fiction", "G.P. Putnam's Sons",
                        2009, 464, new Date()),
                new Book("9780399155345", "The Help", "Kathryn Stockett",
                        "Fiction", "G.P. Putnam's Sons",
                        2009, 464, new Date())
        );
    }
}
