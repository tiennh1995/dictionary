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
public class Company extends Type {

    private int id;
    private int idType;
    private String ten;
    private String anh;
    private String TGD;
    private String gia;
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

    public String getTGD() {
        return TGD;
    }

    public void setTGD(String TGD) {
        this.TGD = TGD;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getLichSu() {
        return lichSu;
    }

    public void setLichSu(String lichSu) {
        this.lichSu = lichSu;
    }

    public Company(int id, int idType, String ten, String anh, String TGD, String gia, String lichSu) {
        this.id = id;
        this.idType = idType;
        this.ten = ten;
        this.anh = anh;
        this.TGD = TGD;
        this.gia = gia;
        this.lichSu = lichSu;

    }

    public Company() {
    }

}
