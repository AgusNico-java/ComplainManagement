package com.Complain.Management.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Complain {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    private String complainCode;
    private String consumerName;
    private String consumerMail;
    private String productName;
    private Integer productBatch;
    
    private Boolean solved;

    public Complain() {
    }

    public Complain(String complainCode, String consumerName, String consumerMail, String productName, Integer productBatch) {
        this.complainCode = complainCode;
        this.consumerName = consumerName;
        this.consumerMail = consumerMail;
        this.productName = productName;
        this.productBatch = productBatch;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getSolved() {
        return solved;
    }

    public void setSolved(Boolean solved) {
        this.solved = solved;
    }
    
    
    
    public String getComplainCode() {
        return complainCode;
    }

    public void setComplainCode(String complainCode) {
        this.complainCode = complainCode;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getConsumerMail() {
        return consumerMail;
    }

    public void setConsumerMail(String consumerMail) {
        this.consumerMail = consumerMail;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductBatch() {
        return productBatch;
    }

    public void setProductBatch(Integer productBatch) {
        this.productBatch = productBatch;
    }
}
