package employee.demo.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BookRequestDTO {

  private String bookName;
  private String author;
  private String publisher;
  private Long price;

  private String description;
  private Integer stock;
  private String category;
  private String isbn;
}
