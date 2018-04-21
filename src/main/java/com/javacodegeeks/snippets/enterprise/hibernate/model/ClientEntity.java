package com.javacodegeeks.snippets.enterprise.hibernate.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "client", schema = "ibatestdb")
public class ClientEntity {
    private int id;
    private String name;
    private int age;

    @Override
    public String toString() {
        return "ClientEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public ClientEntity() {
    }

    public ClientEntity(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public ClientEntity(int id, String name, int age, Collection<CardEntity> cardsById) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.cardsById = cardsById;
    }

    public ClientEntity(String name, int age) {
        this.name = name;
        this.age = age;
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
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "age", nullable = false)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientEntity that = (ClientEntity) o;

        if (id != that.id) return false;
        if (age != that.age) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }

    private Collection<CardEntity> cardsById;
    @OneToMany(mappedBy = "clientByClientId")
    public Collection<CardEntity> getCardsById() {
        return cardsById;
    }
    public void setCardsById(Collection<CardEntity> cardsById) {
        this.cardsById = cardsById;
    }
}
