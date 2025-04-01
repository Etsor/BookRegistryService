package BookRegistryService.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 13, unique = true, nullable = false)
	public String isbn;

	@Column(nullable = false)
	public String title;

	@Column(nullable = false)
	public String authors;

	@Column(nullable = true)
	public String genre;

	@Column(nullable = false)
	public String publisher;

	@Column(nullable = false)
	public int yearOfPublication;

	@Column(nullable = false)
	public int pages;

	@Column(nullable = false)
	public Date dateAdded;

	public Book(String isbn, String title, String authors,
    		String genre, String publisher, int yearOfPublication,
    		int pages, Date date_added) {
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
        this.genre = genre;
        this.publisher = publisher;
        this.yearOfPublication = yearOfPublication;
        this.pages = pages;
        this.dateAdded = date_added;
	}

	public Book() {

	}

	@Override
	public String toString() {
		return "Book{" +
				"id=" + id +
				", isbn='" + isbn + '\'' +
				", title='" + title + '\'' +
				", authors='" + authors + '\'' +
				", genre='" + genre + '\'' +
				", publisher='" + publisher + '\'' +
				", year_of_publication=" + yearOfPublication +
				", pages=" + pages +
				", date_added=" + dateAdded +
				'}';
	}
}
