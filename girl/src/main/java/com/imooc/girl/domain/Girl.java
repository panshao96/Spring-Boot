package com.imooc.girl.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.sun.javafx.beans.IDProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Girl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cupSize;
    @Min(value = 18, message = "未成年人禁止入内")
    private Integer age;
    private Double money;
}
