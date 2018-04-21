package com.javacodegeeks.snippets.enterprise.hibernate.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "card", schema = "ibatestdb")
public class CardEntity {
    private int id;
    private Date date;
    private ClientEntity clientByClientId;
    private BookEntity bookByBookId;

    @Override
    public String toString() {
        return "CardEntity{" +
                "id=" + id +
                ", date=" + date +
                ", clientByClientId=" + clientByClientId +
                ", bookByBookId=" + bookByBookId +
                '}';
    }

    public CardEntity() {
    }

    public CardEntity(int id, Date date) {
        this.id = id;
        this.date = date;
    }

    public CardEntity(Date date) {
        this.date = date;
    }

    public CardEntity(int id, Date date, ClientEntity clientByClientId, BookEntity bookByBookId) {
        this.id = id;
        this.date = date;
        this.clientByClientId = clientByClientId;
        this.bookByBookId = bookByBookId;
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
    @Column(name = "date", nullable = true)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardEntity that = (CardEntity) o;

        if (id != that.id) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    public ClientEntity getClientByClientId() {
        return clientByClientId;
    }

    public void setClientByClientId(ClientEntity clientByClientId) {
        this.clientByClientId = clientByClientId;
    }

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false)
    public BookEntity getBookByBookId() {
        return bookByBookId;
    }

    public void setBookByBookId(BookEntity bookByBookId) {
        this.bookByBookId = bookByBookId;
    }
}
