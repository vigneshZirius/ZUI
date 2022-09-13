package com.zstyles.application.theme;

public class ThemeModal {
    
    private String seaterId;
    private String seaterNo;


    public ThemeModal(String seaterId, String seaterNo) {
        this.seaterId = seaterId;
        this.seaterNo = seaterNo;
    }
    
    public String getSeaterId() {
        return this.seaterId;
    }

    public void setSeaterId(String seaterId) {
        this.seaterId = seaterId;
    }

    public String getSeaterNo() {
        return this.seaterNo;
    }

    public void setSeaterNo(String seaterNo) {
       this.seaterNo = seaterNo;
    }


    @Override
    public String toString() {
        return "{" +
            "--lumo-base-color:'" + getSeaterId() + "'" +
            ",--lumo-primary-color:'" + getSeaterNo() + "'" + "}";
    }
    
}