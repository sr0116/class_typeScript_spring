package employee.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class BookResponseDTO {

  private Long id;
  private String bookName;
  private String author;
  private String publisher;
  private Long price;

  private String description;
  private Integer stock;
  private String category;
  private String isbn;

  private LocalDateTime createdAt;
}