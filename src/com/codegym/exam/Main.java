package com.codegym.exam;

import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        int choice;
        Product product = new Product();

        do {
            System.out.println("--- CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM ---");
            System.out.println("Chọn chức năng theo số (để tiếp tục)");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Tìm sản phẩm có giá đắt nhất");
            System.out.println("7. Đọc từ file");
            System.out.println("8. Ghi vào file");
            System.out.println("9. Thoát chương trình");
            System.out.println("Chọn chức năng: ");

             choice = scanner.nextInt();

             if (choice != 9) {
                 if (choice == 1) {
                     if (products.size()<1) {
                         System.out.println("Không có sản phẩm ");
                     }
                     System.out.println("Danh sách các sản phẩm: ");
                     for (Product item : products) {
                         System.out.println(item);
                     }
                 } else if (choice == 2) {
                     System.out.println("Mời bạn nhập mã sản phẩm: ");
                     Long id = scanner.nextLong();
                     if (id instanceof Long) {
                         product.setId(id);
                         System.out.println("Bạn đã nhập đúng id");
                     }
                     System.out.println("Mời bạn nhập tên sản phẩm: ");
                     scanner.nextLine();
                     String name = scanner.nextLine();
                     product.setName(name);
                     System.out.println("Mời bạn nhập mô tả sản phẩm: ");
                     String description = scanner.nextLine();
                     product.setDescription(description);
                     System.out.println("Mời bạn nhập giá sản phẩm: ");
                     Double price = scanner.nextDouble();
                     product.setPrice(price);
                     System.out.println("Mời bạn chọn danh mục sản phẩm (1 là điện thoại; 2 là máy tính): ");
                     int idCategory = scanner.nextInt();
                     if (idCategory == 1) {
                         product.setCategory(ECategory.PHONE);
                     } else if (idCategory == 2) {
                         product.setCategory(ECategory.LAPTOP);
                     }
                     System.out.println("Mời bạn nhập số lượng sản phẩm: ");
                     Integer quantity = scanner.nextInt();
                     product.setQuantity(quantity);
                     products.add(product);
                     System.out.println(product);
                 } else if (choice == 3) {
                     System.out.println("Mời bạn nhập mã sản phẩm cần sửa: ");
                     Long idFind = scanner.nextLong();
                     do {
                         for (Product item : products) {
                             if (item.getId() == idFind) {
                                 System.out.println("Mời bạn nhập mã sản phẩm: ");
                                 Long id = scanner.nextLong();
                                 if (id instanceof Long) {
                                     product.setId(id);
                                     System.out.println("Bạn đã nhập đúng id");
                                 }
                                 System.out.println("Mời bạn nhập tên sản phẩm: ");
                                 scanner.nextLine();
                                 String name = scanner.nextLine();
                                 item.setName(name);
                                 System.out.println("Mời bạn nhập mô tả sản phẩm: ");
                                 String description = scanner.nextLine();
                                 item.setDescription(description);
                                 System.out.println("Mời bạn nhập giá sản phẩm: ");
                                 Double price = scanner.nextDouble();
                                 item.setPrice(price);
                                 System.out.println("Mời bạn chọn danh mục sản phẩm (1 là điện thoại; 2 là máy tính): ");
                                 int idCategory = scanner.nextInt();
                                 if (idCategory == 1) {
                                     item.setCategory(ECategory.PHONE);
                                 } else if (idCategory == 2) {
                                     item.setCategory(ECategory.LAPTOP);
                                 }
                                 System.out.println("Mời bạn nhập số lượng sản phẩm: ");
                                 Integer quantity = scanner.nextInt();
                                 item.setQuantity(quantity);
                                 return;
                             } else {
                                 System.out.println("Không tìm được sản phẩm với mã sản phẩm trên");
                                 System.out.println("Mời bạn nhập lại mã sản phẩm");
                                 idFind = scanner.nextLong();
                             }
                         }

                     }
                     while (idFind instanceof Long);
                 } else if (choice == 4) {
                     System.out.println("Mời bạn nhập mã sản phẩm muốn xóa: ");
                     Integer idFind = scanner.nextInt();
                     do {
                         for (Product item : products) {
                             if (item.getId() == idFind) {
                                 System.out.println("Chọn Y để xóa sản phẩm");
                                 String choiceRemoveProduct = scanner.nextLine();
                                 if (choiceRemoveProduct.equals("Y")){
                                     products.remove(item);
                                 } else {
                                     return;
                                 }

                             }else {
                                 System.out.println("Không tìm được sản phẩm với mã sản phẩm trên");
                                 System.out.println("Mời bạn nhập lại mã sản phẩm");
                                 idFind = scanner.nextInt();
                             }
                         }


                     }
                     while (idFind instanceof Integer);
                 } else if (choice == 5) {
                     System.out.println("Chọn 1 để sắp xếp theo chiều tăng dần, 2 theo chiều giảm dần, 3 để quay lại menu");
                     Integer choiceSort = scanner.nextInt();
                     List<Product> cloneProducts = new ArrayList<>(products);
                     if (choiceSort == 1 ) {
                         if (cloneProducts.size()>0){
                             cloneProducts.sort(Comparator.comparing(Product::getPrice));
                             for (Product item : cloneProducts) {
                                 System.out.println(item);
                             }
                         } 
                     } else if (choiceSort == 2) {
                         if (cloneProducts.size()>0){
                             cloneProducts.sort(Comparator.comparing(Product::getPrice, Comparator.reverseOrder()));
                             for (Product item : cloneProducts) {
                                 System.out.println(item);
                             }
                         }
                        
                     } else if (choiceSort == 3) {
                         return;
                     }

                 } else if (choice == 6) {
                     List<Product> cloneProducts = new ArrayList<>(products);
                     if (cloneProducts.size()>0){
                         cloneProducts.sort(Comparator.comparing(Product::getPrice));
                         System.out.println("Sản phẩm có giá đắt nhất: ");
                         System.out.println(cloneProducts.get(cloneProducts.size()-1));
                     }
                 }
             }

        } while (choice > 0 && choice <9);
    }
}
