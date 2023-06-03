package dao;

import model.DienThoaiCoDinh;
import model.DienThoaiDiDong;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DienThoaiDiDongDAO {
    public static void save(DienThoaiDiDong dienThoai){
        try (Connection connection = ConnectSQL.getGetConnect()) {
            String sql = "INSERT INTO DienThoaiDiDong (ma, ten, hang, gia, thoiGianBaoHanh, dungLuong) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, dienThoai.getMa());
            statement.setString(2, dienThoai.getTen());
            statement.setString(3, dienThoai.getHang());
            statement.setString(4, dienThoai.getGia());
            statement.setString(5, dienThoai.getThoiGianBaoHanh());
            statement.setString(6, dienThoai.getDungLuong());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static double tinhTrungBinhGiaDienThoaiDiDongTheoHang(String hang) {
        String sql = "SELECT AVG(CONVERT(decimal(18,2), gia)) AS TrungBinhGia FROM DienThoaiDiDong WHERE hang = ?";
        double trungBinhGia = 0.0;

        try (Connection connection = ConnectSQL.getGetConnect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, hang);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    trungBinhGia = resultSet.getDouble("TrungBinhGia");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trungBinhGia;
    }
}
