package com.Complain.Management.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
public class SupplierComplain {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy ="uuid2")
    private String id;
    
    private String detectorName;
    private String causeOfComplain;
    private String product;
    private String batch;
    private String complainCode;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date bestBeforeDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date complainDate;
    
    private Boolean solved;
    @Temporal(TemporalType.TIMESTAMP)
    private Date solutionDate;
    
}
