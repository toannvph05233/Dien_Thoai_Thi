import io.FileIO;
import model.DienThoai;
import service.DienThoaiService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DienThoaiService dienThoaiService = new DienThoaiService();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("1. Đọc file ds.txt");
            System.out.println("2. Hiển thị danh sách DT");
            System.out.println("3. Lưu và CSDL");
            System.out.println("4. Thống kê");
            System.out.println("5. Thoát");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    dienThoaiService.docDS();
                    break;
                case 2:
                    dienThoaiService.hienThiDienThoai();
                    break;
                case 3:
                    dienThoaiService.luuCSDL();
                    break;
                case 4:
                    dienThoaiService.thongKe();
                    break;
                case 5:
                    return;
            }
        }
    }
}