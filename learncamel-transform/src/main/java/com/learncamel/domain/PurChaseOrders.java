package com.learncamel.domain;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "PurchaseOrders")
@XmlAccessorType(XmlAccessType.FIELD)
public class PurChaseOrders {

    @XmlElement(name = "PurchaseOrder")
    private List<PurchaseOrder> purchaseOrders;

    public List<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrders;
    }

    public void setPurchaseOrders(List<PurchaseOrder> purchaseOrders) {
        this.purchaseOrders = purchaseOrders;
    }

    @Override
    public String toString() {
        return "PurChaseOrders{" +
                "purchaseOrders=" + purchaseOrders +
                '}';
    }
}
