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
public class Motorbike extends Transport {

    private int id;
    private int idType;
    private String ten;
    private String anh;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getIdType() {
        return idType;
    }

 

    @Override
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Override
    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public Motorbike(int id, int idType, String ten, String anh, String hang, String gia) {
        this.id = id;
        this.idType = idType;
        this.ten = ten;
        this.anh = anh;
        this.hang = hang;
        this.gia = gia;

    }

    public Motorbike() {
    }
}
