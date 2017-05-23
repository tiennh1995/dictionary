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
public class Country extends Type {

    private int id;
    private int idType;
    private String ten;
    private String anh;
    private String quocCa;
    private String danSo;
    private String dienTich;
    private String thuDo;
    private String lichSu;

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

    public String getQuocCa() {
        return quocCa;
    }

    public void setQuocCa(String quocCa) {
        this.quocCa = quocCa;
    }

    public String getDanSo() {
        return danSo;
    }

    public void setDanSo(String danSo) {
        this.danSo = danSo;
    }

    public String getDienTich() {
        return dienTich;
    }

    public void setDienTich(String dienTich) {
        this.dienTich = dienTich;
    }

    public String getThuDo() {
        return thuDo;
    }

    public void setThuDo(String thuDo) {
        this.thuDo = thuDo;
    }

    public String getLichSu() {
        return lichSu;
    }

    public void setLichSu(String lichSu) {
        this.lichSu = lichSu;
    }

    public Country(int id, int idType, String ten, String anh, String quocCa, String danSo, String dienTich, String thuDo, String lichSu) {
        this.id = id;
        this.idType = idType;
        this.ten = ten;
        this.anh = anh;
        this.quocCa = quocCa;
        this.danSo = danSo;
        this.dienTich = dienTich;
        this.thuDo = thuDo;
        this.lichSu = lichSu;
    }

    public Country() {
    }
}
