package aoizora.controller;

import aoizora.converter.BookConverter;
import aoizora.filter.BookFilter;
import aoizora.model.book.BookDTO;
import aoizora.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/api/v1/book")
@Controller
public class BookController
{
    private final BookService bookService;

    private final BookConverter bookConverter;

    public BookController(BookService bookService, BookConverter bookConverter)
    {
        this.bookService = bookService;
        this.bookConverter = bookConverter;
    }

    @GetMapping("/getByFilter")
    public ResponseEntity<List<BookDTO>> getByFilter(@RequestParam String title,
                                                     @RequestParam Long isbn,
                                                     @RequestParam String authorFirstName,
                                                     @RequestParam String authorLastName)
    {
        var filter = BookFilter.builder()
                .title(title)
                .isbn(isbn)
                .authorFirstName(authorFirstName)
                .authorLastName(authorLastName)
                .build();

        return ResponseEntity.ok(bookConverter.convert(bookService.getByFilter(filter)));
    }
}
