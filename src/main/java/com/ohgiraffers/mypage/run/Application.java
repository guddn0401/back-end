package com.ohgiraffers.mypage.run;

import com.ohgiraffers.mypage.model.dao.StoreDAO;
import com.ohgiraffers.mypage.model.dto.ProductDTO;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.ohgiraffers.mypage.common.JDBCTemplate.getConnection;

public class Application {

    public static void main(String[] args) {

        Connection con = getConnection();
        StoreDAO registDAO = new StoreDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("1. 전체 메뉴 조회");
            System.out.println("2. 신규 메뉴 추가");
            System.out.println("3. 메뉴 삭제");
            System.out.println("4. 메뉴 수정");
            System.out.println("5. 메뉴 상세 조회");
            System.out.println("6. 나가기");
            System.out.print("조회하실 메뉴를 선택하세요 : ");

            int num = sc.nextInt();
            sc.nextLine();

            switch (num) {

                // 전체 메뉴 조회
                case 1:
                    List<Map<Integer, String>> productList = registDAO.selectAllProduct(con);
                    for (Map<Integer, String> product : productList) {
                        System.out.println("product = " + product);
                    }
                    break;

                // 신규 메뉴 등록
                case 2:
                    System.out.print("등록할 메뉴의 코드를 입력하세요 : ");
                    int productCode = sc.nextInt();
                    sc.nextLine();

                    System.out.print("등록할 메뉴의 타입을 입력하세요 : ");
                    String productType = sc.nextLine();

                    System.out.print("등록할 메뉴의 이름을 입력하세요 : ");
                    String productName = sc.nextLine();

                    System.out.print("등록할 메뉴의 매장코드를 입력하세요 : ");
                    int storeCode = sc.nextInt();


                    int categoryCode;
                    switch (productName) {
                        case "과자":
                            categoryCode = 1;
                            break;
                        case "아이스크림":
                            categoryCode = 2;
                            break;
                        case "음료":
                            categoryCode = 3;
                            break;
                        default:
                            System.out.print("등록할 메뉴의 카테고리 코드를 직접 입력하세요 : ");
                            categoryCode = sc.nextInt();
                    }

                    ProductDTO newProduct = new ProductDTO(productCode, productType, productName, storeCode, categoryCode);
                    int insertResult = registDAO.insertNewProduct(newProduct, con);

                    if (insertResult > 0) {
                        System.out.println("메뉴 등록 성공!");
                    } else {
                        System.out.println("메뉴 등록 실패!");
                    }
                    break;

                // 메뉴 삭제
                case 3:
                    System.out.print("삭제할 메뉴의 코드를 입력하세요: ");
                    int delProductCode = sc.nextInt();

                    int delResult = registDAO.deleteProduct(delProductCode, con);
                    if (delResult > 0) {
                        System.out.println("메뉴 삭제 성공!");
                    } else {
                        System.out.println("메뉴 삭제 실패!");
                    }
                    break;

                // 메뉴 수정
                case 4:
                    System.out.print("수정할 메뉴 코드 입력: ");
                    int updateCode = sc.nextInt();
                    sc.nextLine();

                    System.out.print("새로운 메뉴 타입 입력: ");
                    String updateType = sc.nextLine();

                    System.out.print("새로운 메뉴 이름 입력: ");
                    String updateName = sc.nextLine();

                    System.out.print("새로운 카테고리 코드 입력: ");
                    int updateCategory = sc.nextInt();

                    ProductDTO updateProduct = new ProductDTO(updateCode, updateType, updateName, 0, updateCategory);
                    int updateResult = registDAO.updateProduct(updateProduct, con);

                    if (updateResult > 0) {
                        System.out.println("메뉴 수정 성공!");
                    } else {
                        System.out.println("메뉴 수정 실패!");
                    }
                    break;

                // 단일 메뉴 상세 조회
                case 5:
                    System.out.print("조회할 메뉴 코드 입력: ");
                    int searchCode = sc.nextInt();

                    ProductDTO foundProduct = registDAO.selectOneProduct(con, searchCode);
                    if (foundProduct != null) {
                        System.out.println("==== 상세 메뉴 ====");
                        System.out.println("코드: " + foundProduct.getProductCode());
                        System.out.println("타입: " + foundProduct.getProductType());
                        System.out.println("이름: " + foundProduct.getProductName());
                        System.out.println("매장코드: " + foundProduct.getStoreCode());
                        System.out.println("카테고리코드: " + foundProduct.getCategoryCode());
                    } else {
                        System.out.println("해당 코드의 메뉴가 없습니다.");
                    }
                    break;

                // 종료
                case 6:
                    System.out.println("프로그램 종료.");
                    return;

                default:
                    System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
            }
        }
    }
}
