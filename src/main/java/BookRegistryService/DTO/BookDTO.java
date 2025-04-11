package BookRegistryService.DTO;

import java.util.Date;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookDTO {
    String isbn;
    String title;
    String authors;
    String genre;
    String publisher;
    int yearOfPublication;
    int pages;
    Date dateAdded; 
}