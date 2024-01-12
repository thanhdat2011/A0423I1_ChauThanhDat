package com.example.ex1_mail_config.model;

public class Email {
    private String language;
    private int page_size;
    private boolean spams_filter;
    private String signature;

    public Email() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPage_size() {
        return page_size;
    }

    public void setPage_size(int page_size) {
        this.page_size = page_size;
    }

    public boolean isSpams_filter() {
        return spams_filter;
    }

    public void setSpams_filter(boolean spams_filter) {
        this.spams_filter = spams_filter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
