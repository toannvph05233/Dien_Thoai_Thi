package dao;

import model.DienThoaiCoDinh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DienThoaiCoDinhDAO {
    public static void save(DienThoaiCoDinh dienThoai){
        try (Connection connection = ConnectSQL.getGetConnect()) {
            String sql = "INSERT INTO DienThoaiCoDinh (ma, ten, hang, gia, mau) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, dienThoai.getMa());
            statement.setString(2, dienThoai.getTen());
            statement.setString(3, dienThoai.getHang());
            statement.setString(4, dienThoai.getGia());
            statement.setString(5, dienThoai.getMau());
           statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static double tinhTrungBinhGiaDienThoaiCoDinhTheoHang(String hang) {
        String sql = "SELECT AVG(CONVERT(decimal(18,2), gia)) AS TrungBinhGia FROM DienThoaiCoDinh WHERE hang = ?";
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
