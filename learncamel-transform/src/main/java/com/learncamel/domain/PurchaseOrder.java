package com.learncamel.domain;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "PurchaseOrder")
@XmlAccessorType(XmlAccessType.FIELD)
public class PurchaseOrder {

    @XmlAttribute(name = "PurchaseOrderNumber")
    private Integer purchaseOrderNumber;

    @XmlElement(name = "DeliveryNotes")
    private String deliveryNotes;
    @XmlElement(name = "Address")
    private List<Address> address;

    @XmlElementWrapper(name = "Items")
    @XmlElement(name = "Item")
    private List<Item> items;

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "purchaseOrderNumber=" + purchaseOrderNumber +
                ", deliveryNotes='" + deliveryNotes + '\'' +
                ", address=" + address +
                ", items=" + items +
                '}';
    }

    public Integer getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(Integer purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public String getDeliveryNotes() {
        return deliveryNotes;
    }

    public void setDeliveryNotes(String deliveryNotes) {
        this.deliveryNotes = deliveryNotes;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
