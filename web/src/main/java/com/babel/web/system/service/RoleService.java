package com.babel.web.system.service;

import com.babel.web.system.entity.Role;

import java.util.List;

/**
 * Created by allen on 2017/5/31.
 */
public interface RoleService {
    List<Role> getRoles();

    void add(Role role);

    void delete(String role);

    void update(Role role);
}
