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
public class Culinary extends Type {

    private int id;
    private int idType;
    private String ten;
    private String anh;
    private String thanhPhan;
    private String diaDiem;
    private String gia;

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

    public String getThanhPhan() {
        return thanhPhan;
    }

    public void setThanhPhan(String thanhPhan) {
        this.thanhPhan = thanhPhan;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public Culinary(int id, int idType, String ten, String anh, String thanhPhan, String diaDiem, String gia) {
        this.id = id;
        this.idType = idType;
        this.ten = ten;
        this.anh = anh;
        this.thanhPhan = thanhPhan;
        this.diaDiem = diaDiem;
        this.gia = gia;

    }

    public Culinary() {
    }

}
