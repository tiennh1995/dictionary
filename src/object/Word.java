/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

/**
 *
 * @author TIENNH
 */
public class Word {

    private int id;
    private String ten;
    private int idType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public Word() {
    }

    public Word(int id, String ten, int idType) {
        this.id = id;
        this.ten = ten;
        this.idType = idType;
    }

}
