package com.babel.web.system.entity;

import com.babel.platform.utils.GuidGenerator;

/**
 * Created by lenovo on 2017/7/14.
 */
public class Role {
    private String guid;
    private String role;
    private String description;
    private int available;

    public Role(String role, String description) {
        this.guid = GuidGenerator.newGuid();
        this.role = role;
        this.description = description;
        this.available = 1;
    }

    public Role(String guid, String role, String description) {
        this.guid = guid;
        this.role = role;
        this.description = description;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Role{" +
                "guid='" + guid + '\'' +
                ", role='" + role + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
