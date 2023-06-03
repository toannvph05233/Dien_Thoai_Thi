package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DienThoaiDao {
    public static List<String> getAllBrands() {
        List<String> brands = new ArrayList<>();
        String queryCoDinh = "SELECT DISTINCT hang FROM DienThoaiCoDinh";
        String queryDiDong = "SELECT DISTINCT hang FROM DienThoaiDiDong";

        try (Connection connection = ConnectSQL.getGetConnect()) {
            PreparedStatement statementCoDinh = connection.prepareStatement(queryCoDinh);
            ResultSet resultSetCoDinh = statementCoDinh.executeQuery();
            while (resultSetCoDinh.next()) {
                String brand = resultSetCoDinh.getString("hang");
                brands.add(brand);
            }

            PreparedStatement statementDiDong = connection.prepareStatement(queryDiDong);
            ResultSet resultSetDiDong = statementDiDong.executeQuery();
            while (resultSetDiDong.next()) {
                String brand = resultSetDiDong.getString("hang");
                if (!brands.contains(brand)) {
                    brands.add(brand);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return brands;
    }
}
