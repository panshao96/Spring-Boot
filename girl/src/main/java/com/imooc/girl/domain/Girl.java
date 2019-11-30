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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Girl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @NotEmpty(message = "请输入cupSize")
    private String cupSize;

    @NotNull(message = "请输入年龄")
    @Min(value = 18, message = "未成年人禁止入内")
    private Integer age;

    @NotNull(message = "请输入收入")
    private Double incomes;
}
