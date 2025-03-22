package com.example.belajar_spring_config_properties.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties("application")
public class ApplicationProperties {

    private String name;
    private Integer version;
    private boolean productionMode;
    private DatabaseProperties databaseProperties;
    private List<Role> defaultRoles;
    private Map<String, Role> roles;

    public List<Role> getDefaultRoles() {
        return defaultRoles;
    }

    public void setDefaultRoles(List<Role> defaultRoles) {
        this.defaultRoles = defaultRoles;
    }

    public Map<String, Role> getRoles() {
        return roles;
    }

    public void setRoles(Map<String, Role> roles) {
        this.roles = roles;
    }

    public String getName() {
        return this.name;
    }

    public Integer getVersion() {
        return this.version;
    }

    public boolean isProductionMode() {
        return this.productionMode;
    }

    public DatabaseProperties getDatabase() {
        return databaseProperties;
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

    public void setDatabase(DatabaseProperties databaseProperties) {
        this.databaseProperties = databaseProperties;
    }

    public static class DatabaseProperties {
        private String username;
        private String password;
        private String url;
        private String database;

        private List<String> whitelistTables;
        private Map<String, Integer> maxTablesSize;

        public String getDatabase() {
            return database;
        }

        public void setDatabase(String database) {
            this.database = database;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<String> getWhitelistTables() {
            return whitelistTables;
        }

        public void setWhitelistTables(List<String> whitelistTables) {
            this.whitelistTables = whitelistTables;
        }

        public Map<String, Integer> getMaxTablesSize() {
            return maxTablesSize;
        }

        public void setMaxTablesSize(Map<String, Integer> maxTablesSize) {
            this.maxTablesSize = maxTablesSize;
        }
    }

    public static class Role {
        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
