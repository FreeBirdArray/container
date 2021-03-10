package com.ghost.commons.bean;

/**
 * @Company 北京卡尔卡拉科技股份有限公司
 * @Author NorthernGhost
 * @Description
 * @Date 2021/2/20 14:58
 * @Version 1.0
 */
public class SuperUser extends User {

    private String address;

    public SuperUser() {

    }

    public SuperUser(String address) {
        this.address = address;
    }

    public SuperUser(int id, String name, String address) {
        super(id, name);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
