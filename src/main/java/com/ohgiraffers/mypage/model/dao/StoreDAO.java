package com.ohgiraffers.mypage.model.dao;

import com.ohgiraffers.mypage.model.dto.ProductDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;

import static com.ohgiraffers.mypage.common.JDBCTemplate.close;


public class StoreDAO {

    private Properties prop = new Properties();
    private String query;


    public StoreDAO() {
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mypage/mapper/product-query.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




    public int selectLastProductCode(Connection con) {

        Statement stmt = null;
        ResultSet rset = null;

        int maxproduct_code = 0;

        String query = prop.getProperty("selectLastProductCode");


        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            if (rset.next()) {
                maxproduct_code = rset.getInt("MAX(A.PRODUCT_CODE)");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(stmt);
        }

        return maxproduct_code;
    }



    public List<Map<Integer, String>> selectAllProduct(Connection con) {

        Statement stmt = null;
        ResultSet rset = null;

        List<Map<Integer, String>> productList = null;

        String query = prop.getProperty("selectAllProductList");

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            productList = new ArrayList<>();

            while (rset.next()){
                Map<Integer, String> product = new HashMap<>();
                product.put(rset.getInt("PRODUCT_CODE"), rset.getString("PRODUCT_NAME"));


                productList.add(product);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(stmt);
        }

        return productList;

    }

    public int insertNewProduct(ProductDTO newProduct, Connection con) {

        PreparedStatement pstmt = null;

        int result = 0;

        String query = prop.getProperty("insertProduct");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1,newProduct.getProductCode());
            pstmt.setString(2,newProduct.getProductType());
            pstmt.setString(3,newProduct.getProductName());
            pstmt.setInt(4,newProduct.getStoreCode());
            pstmt.setInt(5,newProduct.getCategoryCode());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        return result;
    }

    public int deleteProduct(int productCode, Connection con) {
        PreparedStatement pstmt = null;
        int result = 0;
        String query = prop.getProperty("deleteProduct");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, productCode);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        return result;
    }


    public int updateProduct(ProductDTO product, Connection con) {
        PreparedStatement pstmt = null;
        int result = 0;
        String query = prop.getProperty("updateProduct");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, product.getProductType());
            pstmt.setString(2, product.getProductName());
            pstmt.setInt(3, product.getCategoryCode());
            pstmt.setInt(4, product.getProductCode());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }

        return result;
    }

    public ProductDTO selectOneProduct(Connection con, int productCode) {

        PreparedStatement pstmt = null;
        ResultSet rset = null;
        ProductDTO product = null;

        String query = prop.getProperty("selectOneProduct");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, productCode);
            rset = pstmt.executeQuery();

            if (rset.next()) {
                product = new ProductDTO(
                        rset.getInt("PRODUCT_CODE"),
                        rset.getString("PRODUCT_TYPE"),
                        rset.getString("PRODUCT_NAME"),
                        rset.getInt("STORE_CODE"),
                        rset.getInt("CATEGORY_CODE")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
        }

        return product;
    }





}
