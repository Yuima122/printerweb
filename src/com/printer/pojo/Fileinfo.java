package com.printer.pojo;

public class Fileinfo {
    private String orderid;

    private String filename;

    private String savename;

    private Integer number;

    private Integer dan;

    private Integer color;

    private Integer rangestart;

    private Integer rangeend;

    private Integer allinone;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getSavename() {
        return savename;
    }

    public void setSavename(String savename) {
        this.savename = savename == null ? null : savename.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getDan() {
        return dan;
    }

    public void setDan(Integer dan) {
        this.dan = dan;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public Integer getRangestart() {
        return rangestart;
    }

    public void setRangestart(Integer rangestart) {
        this.rangestart = rangestart;
    }

    public Integer getRangeend() {
        return rangeend;
    }

    public void setRangeend(Integer rangeend) {
        this.rangeend = rangeend;
    }

    public Integer getAllinone() {
        return allinone;
    }

    public void setAllinone(Integer allinone) {
        this.allinone = allinone;
    }
}