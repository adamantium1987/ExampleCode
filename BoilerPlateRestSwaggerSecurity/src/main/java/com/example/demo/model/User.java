package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Schema(description = "Model object")
@Entity
@Table(name="models")
public class User {

    @JsonProperty(value="modelId", required=true)
    @Schema(description = "Unique identifier of the model.",
            example = "1", required = true)
    private Long modelId;

    @JsonProperty(value="fieldOne", required=true)
    @Schema(description = "Field One",
            example = "Lorem Ipsum", required = true)
    @NotBlank
    @Size(min = 0)
    private String fieldOne;

    @JsonProperty(value="FieldTwo", required=true)
    @Schema(description = "Field two",
            example = "Lorem Ipsum Two", required = true)
    @NotBlank
    @Size(min = 0)
    private String fieldTwo;

    @JsonProperty(value="fieldThree", required=true)
    @Schema(description = "Field Three",
            example = "Lorem Ipsum Three", required = true)
    @NotBlank
    @Size(min = 0)
    private double fieldThree;

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public String getFieldOne() {
        return fieldOne;
    }

    public void setFieldOne(String fieldOne) {
        this.fieldOne = fieldOne;
    }

    public String getFieldTwo() {
        return fieldTwo;
    }

    public void setFieldTwo(String fieldTwo) {
        this.fieldTwo = fieldTwo;
    }

    public double getFieldThree() {
        return fieldThree;
    }

    public void setFieldThree(double fieldThree) {
        this.fieldThree = fieldThree;
    }
}
