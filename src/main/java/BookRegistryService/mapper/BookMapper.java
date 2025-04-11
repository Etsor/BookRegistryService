package BookRegistryService.mapper;

import BookRegistryService.DTO.BookDTO;
import BookRegistryService.entity.Book;

public class BookMapper {
    public static BookDTO toDTO(Book book) {
        BookDTO DTO = new BookDTO();
        
        DTO.setIsbn(book.isbn);
        DTO.setTitle(book.title);
        DTO.setAuthors(book.authors);
        DTO.setGenre(book.genre);
        DTO.setPublisher(book.publisher);
        DTO.setPages(book.pages);
        DTO.setYearOfPublication(book.yearOfPublication);
        DTO.setDateAdded(book.dateAdded);
        
        return DTO;
    }
}