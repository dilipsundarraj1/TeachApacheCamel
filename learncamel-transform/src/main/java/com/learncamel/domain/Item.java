package com.learncamel.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigInteger;
import java.time.LocalDate;

@XmlRootElement(name = "Item")
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {

    @XmlElement(name = "ProductName")
    private String productName;
    @XmlElement(name = "Quantity")
    private Integer quantity;
    @XmlElement(name = "USPrice")
    private BigInteger usPrice;
    @XmlElement(name = "ShipDate")
    private String shipDate;
    @XmlElement(name = "Comment")
    private String comment;

    @Override
    public String toString() {
        return "Item{" +
                "productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", usPrice=" + usPrice +
                ", shipDate=" + shipDate +
                ", comment='" + comment + '\'' +
                '}';
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigInteger getUsPrice() {
        return usPrice;
    }

    public void setUsPrice(BigInteger usPrice) {
        this.usPrice = usPrice;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

