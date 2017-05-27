CREATE TABLE appointment
(
    book_id BIGINT(20) NOT NULL COMMENT '图书ID',
    student_id BIGINT(20) NOT NULL COMMENT '学号',
    appoint_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '预约时间',
    CONSTRAINT `PRIMARY` PRIMARY KEY (book_id, student_id)
);
CREATE INDEX idx_appoint_time ON appointment (appoint_time);
CREATE TABLE book
(
    book_id BIGINT(20) PRIMARY KEY NOT NULL COMMENT '图书ID' AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL COMMENT '图书名称',
    number INT(11) NOT NULL COMMENT '馆藏数量'
);
CREATE TABLE menu
(
    guid VARCHAR(32) PRIMARY KEY NOT NULL,
    menu_name VARCHAR(100) NOT NULL,
    action_guid VARCHAR(32),
    parent_guid VARCHAR(32),
    menu_index INT(11),
    icon_class VARCHAR(50)
);
CREATE UNIQUE INDEX Menu_guid_uindex ON menu (guid);
CREATE TABLE users
(
    guid VARCHAR(32) NOT NULL COMMENT '物理主键',
    username VARCHAR(100) COMMENT '用户名',
    password VARCHAR(20) COMMENT '密码',
    enabled INT(11) COMMENT '用户是否有效0：无效 1：有效'
);
CREATE TABLE roles
(
    guid VARCHAR(32) NOT NULL COMMENT '物理主键',
    role VARCHAR(100) COMMENT '角色',
    description VARCHAR(150) COMMENT '角色描述',
    available INT(11) COMMENT '角色是否有效0:无效 1：有效'
);
CREATE TABLE permissions
(
    guid VARCHAR(32) NOT NULL COMMENT '物理主键',
    permission VARCHAR(50) COMMENT '权限名称',
    description VARCHAR(150) COMMENT '权限描述',
    avaliable INT(11) COMMENT '权限模块是否有效0:无效 1：有效'
);
CREATE TABLE resources
(
    guid VARCHAR(32) PRIMARY KEY NOT NULL COMMENT '物理主键',
    resource VARCHAR(300) COMMENT '资源名称',
    description VARCHAR(150) COMMENT '资源描述',
    avaliable INT(11) COMMENT '资源是否有效0：无效 1：有效'
);
CREATE UNIQUE INDEX resources_guid_uindex ON resources (guid);
CREATE TABLE users_roles
(
    user_guid VARCHAR(32) NOT NULL COMMENT '用户表物理主键',
    role_guid VARCHAR(32) NOT NULL COMMENT '角色表物理主键',
    CONSTRAINT `PRIMARY` PRIMARY KEY (user_guid, role_guid)
);
CREATE TABLE roles_permissions
(
    role_guid VARCHAR(32) NOT NULL COMMENT '角色表物理主键',
    permission_guid VARCHAR(32) NOT NULL COMMENT '权限表物理主键',
    CONSTRAINT `PRIMARY` PRIMARY KEY (role_guid, permission_guid)
);
CREATE TABLE permissions_resources
(
    permission_guid VARCHAR(32) NOT NULL COMMENT '权限表物理主键',
    resource_guid VARCHAR(32) NOT NULL COMMENT '资源表物理主键',
    CONSTRAINT `PRIMARY` PRIMARY KEY (permission_guid, resource_guid)
);