package com.ohgiraffers.mypage.model.dto;

public class WorkerDTO {

    private int workerCode;
    private int storeCode;
    private int salary;
    private String workerName;
    private String workTime;

    public WorkerDTO() {}

    public WorkerDTO(int workerCode, int storeCode, int salary, String workerName, String workTime) {
        this.workerCode = workerCode;
        this.storeCode = storeCode;
        this.salary = salary;
        this.workerName = workerName;
        this.workTime = workTime;
    }


    public int getWorkerCode() {
        return workerCode;
    }

    public void setWorkerCode(int workerCode) {
        this.workerCode = workerCode;
    }

    public int getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(int storeCode) {
        this.storeCode = storeCode;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    @Override
    public String toString() {
        return "WorkerDTO{" +
                "workerCode=" + workerCode +
                ", storeCode=" + storeCode +
                ", salary=" + salary +
                ", workerName='" + workerName + '\'' +
                ", workTime='" + workTime + '\'' +
                '}';
    }
}
