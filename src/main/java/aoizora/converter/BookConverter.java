package aoizora.converter;

import aoizora.domain.book.Book;
import aoizora.model.book.BookDTO;
import org.springframework.stereotype.Component;

@Component
public class BookConverter implements Converter<Book, BookDTO>
{
    private final AuthorConverter authorConverter;

    public BookConverter(AuthorConverter authorConverter)
    {
        this.authorConverter = authorConverter;
    }

    @Override
    public BookDTO convert(Book source) {
        var target = new BookDTO();

        target.setTitle(source.getTitle());
        target.setIsbn(source.getIsbn());
        target.setAuthors(authorConverter.convert(source.getAuthors()));

        return target;
    }
}
