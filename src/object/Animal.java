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
public class Animal extends Type {

    private int id;
    private int idType;
    private String ten;
    private String anh;
    private String loai;
    private String trongLuong;
    private String thucAn;
    private String dacTinh;

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

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getTrongLuong() {
        return trongLuong;
    }

    public void setTrongLuong(String trongLuong) {
        this.trongLuong = trongLuong;
    }

    public String getThucAn() {
        return thucAn;
    }

    public void setThucAn(String thucAn) {
        this.thucAn = thucAn;
    }

    public String getDacTinh() {
        return dacTinh;
    }

    public void setDacTinh(String dacTinh) {
        this.dacTinh = dacTinh;
    }

    public Animal(int id, int idType, String ten, String anh, String loai, String trongLuong, String thucAn, String dacTinh) {
        this.id = id;
        this.idType = idType;
        this.ten = ten;
        this.anh = anh;
        this.loai = loai;
        this.trongLuong = trongLuong;
        this.thucAn = thucAn;
        this.dacTinh = dacTinh;
    }

    public Animal() {
    }

}
