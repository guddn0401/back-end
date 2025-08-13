package com.ohgiraffers.mypage.model.dto;

public class StoreDTO {

    private int storeCode;
    private String tel;
    private String storeName;

    public StoreDTO() {}

    public StoreDTO(int storeCode, String tel, String storeName) {
        this.storeCode = storeCode;
        this.tel = tel;
        this.storeName = storeName;
    }

    public int getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(int storeCode) {
        this.storeCode = storeCode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }


    @Override
    public String toString() {
        return "StoreDTO{" +
                "storeCode=" + storeCode +
                ", tel='" + tel + '\'' +
                ", storeName='" + storeName + '\'' +
                '}';
    }
}
