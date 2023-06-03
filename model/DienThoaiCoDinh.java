package model;

public class DienThoaiCoDinh extends DienThoai {
    private String mau;

    public DienThoaiCoDinh() {
    }

    public DienThoaiCoDinh(String ma, String ten, String hang, String gia, String mau) {
        super(ma, ten, hang, gia);
        this.mau = mau;
    }


    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    @Override
    public String toString() {
        return super.toString() + "," + mau;
    }
}
