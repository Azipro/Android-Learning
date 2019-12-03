package com.example.eig;

class MessageInfo {
    private String address;
    private long date;
    private int type;
    private String body;
    private int id;

    public MessageInfo(String address, long date, int type, String body){
        this.address = address;
        this.date = date;
        this.type = type;
        this.body = body;
    }

    public MessageInfo(String address, long date, int type, String body, int id){
        this.address = address;
        this.date = date;
        this.type = type;
        this.body = body;
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
