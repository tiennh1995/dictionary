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
public class Person extends Type {

    private int id;
    private int idType;
    private String ten;
    private String anh;
    private String ngaySinh;
    private String queQuan;
    private String congViec;

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

    @Override
    public String getAnh() {
        return anh;
    }

    @Override
    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getCongViec() {
        return congViec;
    }

    public void setCongViec(String congViec) {
        this.congViec = congViec;
    }

    public Person(int id, int idType, String ten, String anh, String ngaySinh, String queQuan, String congViec) {
        this.id = id;
        this.idType = idType;
        this.ten = ten;
        this.anh = anh;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
        this.congViec = congViec;
    }

    public Person() {
    }

}
