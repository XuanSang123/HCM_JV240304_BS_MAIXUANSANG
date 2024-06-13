import ra.run.BookManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookManagement bookManagement = new BookManagement();
        Scanner scanner = new Scanner(System.in);
        boolean isFlag = true;
        while (isFlag) {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************");
            System.out.println("1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách");
            System.out.println("2. Hiển thị thông tin tất cả sách trong thư viện");
            System.out.println("3. Sắp xếp sách theo lợi nhuận tăng dần");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả");
            System.out.println("6. Thay đổi thông tin sách theo mã sách");
            System.out.println("7. Thoát");
            System.out.print("Chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    bookManagement.addBook();
                    break;
                case 2:
                    bookManagement.displayData();
                    break;
                case 3:
                    bookManagement.sortBooksByInterest();
                    break;
                case 4:
                    bookManagement.deleteBook();
                    break;
                case 5:
                    bookManagement.searchBook();
                    break;
                case 6:
                    bookManagement.updateBook();
                    break;
                case 7:
                    isFlag = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter again.");
                    break;
            }
        }

    }
}
