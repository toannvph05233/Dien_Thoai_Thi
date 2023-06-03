package service;

import dao.DienThoaiCoDinhDAO;
import dao.DienThoaiDao;
import dao.DienThoaiDiDongDAO;
import io.FileIO;
import model.DienThoai;
import model.DienThoaiCoDinh;
import model.DienThoaiDiDong;

import java.util.List;

public class DienThoaiService {
    private List<DienThoai> dienThoais;
    private final String PATH_DS = "/Users/johntoan98gmail.com/Desktop/DienThoai/src/data/ds.txt";
    private final String PATH_KQ = "/Users/johntoan98gmail.com/Desktop/DienThoai/src/data/ketqua.txt";

    public DienThoaiService() {
        dienThoais = FileIO.read(PATH_DS);
    }

    public void docDS(){
        dienThoais = FileIO.read(PATH_DS);
        FileIO.write(dienThoais,PATH_KQ);
    }

    public void luuCSDL(){
        for (DienThoai dt:dienThoais) {
//            instanceof kiểm tra kiểu dữ liệu của dt
            if (dt instanceof DienThoaiCoDinh){
                DienThoaiCoDinhDAO.save((DienThoaiCoDinh) dt);
            }
        }
        for (DienThoai dt:dienThoais) {
            if (dt instanceof DienThoaiDiDong){
                DienThoaiDiDongDAO.save((DienThoaiDiDong) dt);

            }
        }
    }

    public void thongKe(){
        List<String> listHang = DienThoaiDao.getAllBrands();
        for (String h:listHang) {
            System.out.println("Hãng " + h + " Có giá trung bình của DTCD = "
                    + DienThoaiCoDinhDAO.tinhTrungBinhGiaDienThoaiCoDinhTheoHang(h) +
                    " của DTDD = " + DienThoaiDiDongDAO.tinhTrungBinhGiaDienThoaiDiDongTheoHang(h));
        }
    }


    public void hienThiDienThoai(){
        System.out.println("------ Danh sách điện thoại cố định là :");
        for (DienThoai dt:dienThoais) {
//            instanceof kiểm tra kiểu dữ liệu của dt
            if (dt instanceof DienThoaiCoDinh){
                System.out.println(dt);
            }
        }

        System.out.println("------ Danh sách điện thoại di động là :");
        for (DienThoai dt:dienThoais) {
            if (dt instanceof DienThoaiDiDong){
                System.out.println(dt);
            }
        }
    }
}