package com.itheima.ssm;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @program: heima_ssm_02
 * @description:
 * @author: wangenxian
 * @create: 2019-07-03 10:44
 **/

public class  Product {
    private String productNum; // 编号 唯一
    private String productName; // 名称
    private String cityName; // 出发城市
    private int productPrice; // 产品价格
    private String productDesc; // 产品描述
    private Integer productStatus; // 状态 0 关闭 1 开启

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getProductPrice() {
        return productPrice;
    }


    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }


    @Override
    public String toString() {
        return "Product{" +
                "productNum='" + productNum + '\'' +
                ", productName='" + productName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", productPrice=" + productPrice +
                ", productDesc='" + productDesc + '\'' +
                ", productStatus=" + productStatus +
                '}';
    }
}
