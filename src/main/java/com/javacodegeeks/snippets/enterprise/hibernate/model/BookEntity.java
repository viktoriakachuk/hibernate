package com.javacodegeeks.snippets.enterprise.hibernate.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "book", schema = "ibatestdb")
public class BookEntity {
    private int id;
    private String title;
    private String author;

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }


    private Collection<CardEntity> cardsById;

    public BookEntity() {
    }

    public BookEntity(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public BookEntity(int id, String title, String author, Collection<CardEntity> cardsById) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.cardsById = cardsById;
    }

    public BookEntity(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 20)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "author", nullable = true, length = 50)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookEntity that = (BookEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "bookByBookId")
    public Collection<CardEntity> getCardsById() {
        return cardsById;
    }

    public void setCardsById(Collection<CardEntity> cardsById) {
        this.cardsById = cardsById;
    }
}
