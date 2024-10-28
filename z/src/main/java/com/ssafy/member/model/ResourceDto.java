package com.ssafy.member.model;

public class ResourceDto {

    private int resourceId;       // 자원 ID
    private String resourceName;   // 자원 이름

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    @Override
    public String toString() {
        return "ResourceDto [resourceId=" + resourceId + ", resourceName=" + resourceName + "]";
    }
}
