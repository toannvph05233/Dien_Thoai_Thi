package model;

import io.FileIO;

public class DienThoai {
    private String ma;
    private String ten;
    private String hang;
    private String gia;

    public DienThoai() {
    }

    public DienThoai(String ma, String ten, String hang, String gia) {
        this.ma = ma;
        this.ten = ten;
        this.hang = hang;
        this.gia = gia;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return ma + "," + ten + "," + hang + "," + gia;
    }
}
