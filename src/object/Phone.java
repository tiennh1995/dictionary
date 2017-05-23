/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

/**
 *
 * @author HEDSPI
 */
public class Phone extends TechnologyProduct {

    private int id;
    private int idType;
    private String ten;
    private String anh;
    private String HDH;

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

    @Override
    public void setAnh(String anh) {
        this.anh = anh;
    }

    
    
    public String getHDH() {
        return HDH;
    }

    public void setHDH(String HDH) {
        this.HDH = HDH;
    }

    public Phone(int id, int idType, String ten, String anh, String NSX, String model, String gia, String HDH) {
        this.id = id;
        this.idType = idType;
        this.ten = ten;
        this.anh = anh;
        this.NSX = NSX;
        this.model = model;
        this.gia = gia;
        this.HDH = HDH;
    }

    public Phone() {
    }

}
