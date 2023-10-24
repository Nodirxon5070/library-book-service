package com.company.bookservice.modul;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@Builder
@Entity
@Table(name = "books")
public class Books {
    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    private String name;

    @Column(name = "author_id")
    private Integer authorId;
    @Column(name = "language_id")
    private Integer languageId;
    @Column(name = "image_id")
    private Integer imageId;
    @Column(name = "publisher_id")
    private Integer publisherId;

    @Column(name = "order_book_id")
    private Integer orderBookId;

    private Float price;
    private Integer page;
    private Float amount;

    private LocalDateTime published;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id", insertable = false, updatable = false)
    private Author author;


}
