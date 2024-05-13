package aoizora.filter;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class BookFilter
{
    private String title;

    private Long isbn;

    private String authorFirstName;

    private String authorLastName;
}
