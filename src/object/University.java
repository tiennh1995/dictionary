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
public class University extends Type {

    private int id;
    private int idType;
    private String ten;
    private String anh;
    private String hieuTruong;
    private String nganh;
    private String lichSu;
    private String soLuongSV;

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

    public String getHieuTruong() {
        return hieuTruong;
    }

    public void setHieuTruong(String hieuTruong) {
        this.hieuTruong = hieuTruong;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    public String getLichSu() {
        return lichSu;
    }

    public void setLichSu(String lichSu) {
        this.lichSu = lichSu;
    }

    public String getSoLuongSV() {
        return soLuongSV;
    }

    public void setSoLuongSV(String soLuongSV) {
        this.soLuongSV = soLuongSV;
    }

    public University(int id, int idType, String ten, String anh, String hieuTruong, String nganh, String lichSu, String soLuongSV) {
        this.id = id;
        this.idType = idType;
        this.ten = ten;
        this.anh = anh;
        this.hieuTruong = hieuTruong;
        this.nganh = nganh;
        this.lichSu = lichSu;
        this.soLuongSV = soLuongSV;
    }

    public University() {
    }

}
