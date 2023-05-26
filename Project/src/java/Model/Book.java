/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author THANG
 */
public class Book implements Serializable{
    private Long id;
    private String title;
    private String author;
    private String category;
    private int sold;

    public Book() {
        
    }
    public Book(Long id, String title, String author, String category, int sold) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.sold = sold;
    }

    public Book(String title, String author, String category, int sold) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.sold = sold;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }
    
}
