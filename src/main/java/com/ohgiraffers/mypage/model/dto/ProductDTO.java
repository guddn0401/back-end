package com.ohgiraffers.mypage.model.dto;

public class ProductDTO {

    private int productCode;
    private String productType;
    private String productName;
    private int storeCode;
    private int categoryCode;

    public ProductDTO() {}

    public ProductDTO(int productCode, String productType, String productName, int storeCode, int categoryCode) {
        this.productCode = productCode;
        this.productType = productType;
        this.productName = productName;
        this.storeCode = storeCode;
        this.categoryCode = categoryCode;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(int storeCode) {
        this.storeCode = storeCode;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }


    @Override
    public String toString() {
        return "ProductDTO{" +
                "productCode=" + productCode +
                ", productType='" + productType + '\'' +
                ", productName='" + productName + '\'' +
                ", storeCode=" + storeCode +
                ", categoryCode=" + categoryCode +
                '}';
    }
}
