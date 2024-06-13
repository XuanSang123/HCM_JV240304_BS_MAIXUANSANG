package ra.run;

import ra.business.Book;

import java.util.Arrays;
import java.util.Scanner;

public class BookManagement {
    Book[] books = new Book[100];
    Scanner scanner = new Scanner(System.in);
    public static int count = 0;

    public Book inputData() {
        String bookName, author, descriptions;
        double importPrice, exportPrice;
        float interest;
        boolean bookStatus;

        System.out.println("Nhập tên sách:");
        bookName = scanner.nextLine();
        while (bookName.isEmpty()) {
            System.out.println("tên sách không được để trống. vui lòng nhập:");
            bookName = scanner.nextLine();
        }

        System.out.println("Nhập tên tác giả:");
        author = scanner.nextLine();
        while (author.isEmpty()) {
            System.out.println("Không được để trông tên tác giả. vui lòng nhâp :");
            author = scanner.nextLine();
        }

        System.out.println("Mô tả về sách :");
        descriptions = scanner.nextLine();
        while (descriptions.length() < 10) {
            System.out.println("Mổ tả sách không được để trống và có ít nhất 10 ký tự. vui lòng nhập:");
            descriptions = scanner.nextLine();
        }

        System.out.println("Giá nhập sách:");
        importPrice = Double.parseDouble(scanner.nextLine());

        while (importPrice < 0) {
            System.out.println("Giá nhập phải lớn hơn 0:");
            importPrice = Double.parseDouble(scanner.nextLine());
        }

        System.out.println("Giá xuất phải lớn hơn 1.2 giá nhập:");
        exportPrice = Double.parseDouble(scanner.nextLine());
        while (exportPrice < importPrice * 1.2) {
            System.out.println("Đâu vao không hợp lệ. Vui lòng nhập một số:");
            exportPrice = Double.parseDouble(scanner.nextLine());
        }
        interest = (float) (exportPrice - importPrice);

        System.out.println("Nhập trạng thái sách (đúng nếu có, sai nếu không có):");
        String bookStatusInput = scanner.nextLine();
        while (!bookStatusInput.equalsIgnoreCase("true") && !bookStatusInput.equalsIgnoreCase("false")) {
            System.out.println("Vui lòng nhập true or false:");
            bookStatusInput = scanner.nextLine();
        }
        bookStatus = Boolean.parseBoolean(bookStatusInput);
        return new Book(bookName, author, descriptions, importPrice, exportPrice, interest, bookStatus);
    }

    // 1. Add book:
    public void addBook() {
        System.out.println("Nhập số lượng sách muốn thêm:");
        int n = Integer.parseInt(scanner.nextLine());
//

        if (n <= 100) {
            books = new Book[n];
            for (int i = 0; i < n; i++) {
                System.out.println("Nhập thông tin sách " + (i + 1) + ":");
                books[i] = inputData();
            }
        } else System.out.println("vui long nhập số lượng nhỏ hơn 100");
//
    }

    // 2. Display data
    public void displayData() {
        if (books == null) {
            System.out.println("Không có dữ liệu để hiển thị.");
            return;
        }
        for (Book book : books) System.out.println(book);
    }

    // 3. Sử dụng thuật toán sắp xếp để sắp xếp sách đang lưu trữ theo lợi nhuận tăng.
    public void sortBooksByInterest() {
        Arrays.sort(books, (book1, book2) -> Float.compare(book1.getInterest(), book2.getInterest()));
    }

    // 4. Nhập mã sách cần xóa từ bàn phím, thực hiện xóa sách trong danh sách.
    public void deleteBook() {
        System.out.println("Nhập id sách bạn muốn xóa:");
        int bookId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < books.length; i++) {
            if (books[i].getBookId() == bookId) {
                books[i] = null;
                break;
            }
        }
    }

    // 5. Nhập chuỗi tìm kiếm từ bàn phím, thực hiện tìm và in ra những sách có tên hoặc mô tả phù hợp.
    public void searchBook() {
        System.out.println("Nhập từ khóa tìm kiếm:");
        String keyword = scanner.nextLine();
        for (Book book : books) {
            if (book.getBookName().contains(keyword) || book.getDescriptions().contains(keyword))
                System.out.println(book);
        }
    }

    //    6. Nhập vào mã sản phẩm, thay đổi các thông tin sách , chú ý validate dữ liệu như thêm mới.
    public void updateBook() {
        System.out.println("Nhập id sách bạn muốn cập nhật:");
        int bookId = Integer.parseInt(scanner.nextLine());
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                System.out.println("Nhập thông tin mới cho sách:");
                books[bookId] = inputData();
                break;
            }
        }
    }

}
