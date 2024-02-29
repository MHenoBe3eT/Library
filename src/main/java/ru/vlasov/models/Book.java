package ru.vlasov.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Book")
@NoArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    @NotEmpty(message = "title should not be empty")
    @Size(min = 2, max = 100, message = "Title should be between 2 and 100 characters")
    private String title;
    @Column(name = "year")
    @NotNull(message = "year should not be empty")
    @Min(value = 0, message = "Year should be greater than 0")
    private int year;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person owner;

    public Book(String title, Integer year, Person owner) {
        this.title = title;
        this.year = year;
        this.owner = owner;
    }

}
