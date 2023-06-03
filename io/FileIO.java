package io;

import model.DienThoai;
import model.DienThoaiCoDinh;
import model.DienThoaiDiDong;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class FileIO {

    public static void write(List<DienThoai> rows, String PATH) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PATH))) {
            for (DienThoai obj : rows) {
                bw.write(obj.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<DienThoai> read(String path) {
        List<DienThoai> dienThoais = new ArrayList<>();
        try (BufferedReader bir = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bir.readLine()) != null) {
                String[] arr = line.split(",");
                DienThoai dienThoai = getDienThoai(arr);
                if (dienThoai!= null){
                    dienThoais.add(dienThoai);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dienThoais;
    }

    public static boolean kiemTraMaDienThoaiCD(String ma) {
        Pattern pattern = Pattern.compile("^DTCD[0-9]{2}$");
        if (pattern.matcher(ma).matches()) {
            return true;
        }
        return false;
    }
    public static boolean kiemTraMaDienThoaiDD(String ma) {
        Pattern pattern = Pattern.compile("^DTDD[0-9]{2}$");
        if (pattern.matcher(ma).matches()) {
            return true;
        }
        return false;
    }

    public static DienThoai getDienThoai(String[] arr) {
        if (arr.length == 5 && kiemTraMaDienThoaiCD(arr[0])) {
            System.out.println("Điện thoại cố đinh :" + Arrays.toString(arr));
            return new DienThoaiCoDinh(arr[0], arr[1], arr[2], arr[3], arr[4]);
        } else if (arr.length == 6 && kiemTraMaDienThoaiDD(arr[0])) {
            System.out.println("Điện thoại di động :" + Arrays.toString(arr));
            return new DienThoaiDiDong(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]);
        }
        return null;
    }
}
