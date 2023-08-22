package com.example.buspass_v1.entity;

public class UserPass {
    private long passId;
    private String source;
    private String destination;
    private  String issueDate;

    public UserPass() {
    }

    public UserPass(long passId, String source, String destination, String issueDate) {
        this.passId = passId;
        this.source = source;
        this.destination = destination;
        this.issueDate = issueDate;
    }

    public long getPassId() {
        return passId;
    }

    public void setPassId(long passId) {
        this.passId = passId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    @Override
    public String toString() {
        return "UserPass{" +
                "passId=" + passId +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", issueDate='" + issueDate + '\'' +
                '}';
    }
}
