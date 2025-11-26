package com.example.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "order_customer_view")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Immutable
public class OrderCustomerView {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Long orderId;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "customer_name" , length = 100)
    private String customerName;

    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "book_title", length = 100)
    private String title;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "unit_price")
    private Integer unitPrice;

    @Column(name = "total_price")
    private Integer totalPrice;


}
