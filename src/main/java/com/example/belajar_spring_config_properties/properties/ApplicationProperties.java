package com.example.belajar_spring_config_properties.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("application")
public class ApplicationProperties {

    private String name;
    private Integer version;
    private boolean productionMode;

    public String getName() {
        return this.name;
    }

    public Integer getVersion() {
        return this.version;
    }

    public boolean isProductionMode() {
        return this.productionMode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setProductionMode(Boolean productionMode) {
        this.productionMode = productionMode;
    }
}
