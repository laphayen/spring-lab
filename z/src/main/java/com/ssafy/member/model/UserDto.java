package com.ssafy.member.model;

public class UserDto {

    private String id;           // 사용자 ID
    private String name;         // 사용자 이름
    private String password;     // 사용자 비밀번호
    private String email;        // 이메일 (전체 주소)
    private String role;         // 사용자 권한 (USER 또는 ADMIN)

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }



    @Override
    public String toString() {
        return "UserDto [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", role=" + role
                + "]";
    }
}
