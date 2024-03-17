package com.example.fe_module4.model.DTO;

import com.example.fe_module4.model.ProductType;
import jakarta.validation.constraints.*;

public class ProductDTO {

    private Long pId;
    @NotBlank(message = "Product's name must not be empty !!!")
    @Size(min = 5, max = 50, message = "Product's name from 5 to 50 characters !!!")
    private String pName;

    @Min(value = 100000, message = "Price must be > 100.000 !!!")
    private double pPrice;
    private Long pType;

    public ProductDTO() {
    }

    public ProductDTO(String pName, double pPrice, Long pType) {
        this.pName = pName;
        this.pPrice = pPrice;
        this.pType = pType;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public double getpPrice() {
        return pPrice;
    }

    public void setpPrice(double pPrice) {
        this.pPrice = pPrice;
    }

    public Long getpType() {
        return pType;
    }

    public void setpType(Long pType) {
        this.pType = pType;
    }
}
