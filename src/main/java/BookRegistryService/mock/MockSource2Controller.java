package BookRegistryService.mock;

import BookRegistryService.entity.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/mock/source2")
public class MockSource2Controller {

    @GetMapping
    public List<Book> getBooks() {
        return Arrays.asList(
                new Book("9781405934138", "Mythos: The Greek Myths Retold",
                        "Stephen Fry", "Mythology", "Penguin Books Ltd",
                        2018, 464, new Date()),
                new Book("9781400032716", "The Curious Incident of the Dog in the Night-Time",
                        "Mark Haddon", "Fiction", "Vintage",
                        2003, 226, new Date()),
                new Book("9781405934138", "Mythos: The Greek Myths Retold",
                        "Stephen Fry", "Mythology", "Penguin Books Ltd",
                        2018, 464, new Date())
        );
    }
}
