package model;

public class DienThoaiDiDong extends DienThoai {

    private String thoiGianBaoHanh;
    private String dungLuong;

    public DienThoaiDiDong() {
    }

    public DienThoaiDiDong(String ma, String ten, String hang, String gia, String thoiGianBaoHanh, String dungLuong) {
        super(ma, ten, hang, gia);
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.dungLuong = dungLuong;
    }


    public String getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public void setThoiGianBaoHanh(String thoiGianBaoHanh) {
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public String getDungLuong() {
        return dungLuong;
    }

    public void setDungLuong(String dungLuong) {
        this.dungLuong = dungLuong;
    }

    @Override
    public String toString() {
        return super.toString() + "," + thoiGianBaoHanh + "," + dungLuong;
    }
}
