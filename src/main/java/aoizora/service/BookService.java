package aoizora.service;

import aoizora.domain.book.Book;
import aoizora.filter.BookFilter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService
{
    private final JdbcTemplate jdbc;

    public BookService(JdbcTemplate jdbc)
    {
        this.jdbc = jdbc;
    }

    public List<Book> getByFilter(BookFilter filter)
    {
        var sql = "select id, title, isbn from book where " + getWhereClause(filter);

        // TODO
        return jdbc.query(sql, (rs, row) -> {
            var book = new Book();

            book.setId(rs.getLong("id"));
            book.setTitle(rs.getString("title"));
            book.setIsbn(rs.getLong("isbn"));

            return book;
        });
    }

    private String getWhereClause(BookFilter filter)
    {
        var where = "";

        if (filter.getTitle() != null)
        {
            where += String.format("title = %s ", filter.getTitle());
        }

        return where;
    }
}
