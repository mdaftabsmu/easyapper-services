package com.easyapper.emailservices.dto;

public class AmazonDTO {
    private String smtpServerHost;
    private String smtpServerPort;
    private String smtpUserName;
    private String smtpUserPassword;
    private String fromUserEmail;
    private String fromUserFullName;
    private String toEmail;
    private String subject;
    private String body;

    public AmazonDTO() {
    }

    public AmazonDTO(String smtpServerHost, String smtpServerPort, String smtpUserName, String smtpUserPassword, String fromUserEmail, String fromUserFullName, String toEmail, String subject, String body) {
        this.smtpServerHost = smtpServerHost;
        this.smtpServerPort = smtpServerPort;
        this.smtpUserName = smtpUserName;
        this.smtpUserPassword = smtpUserPassword;
        this.fromUserEmail = fromUserEmail;
        this.fromUserFullName = fromUserFullName;
        this.toEmail = toEmail;
        this.subject = subject;
        this.body = body;
    }

    public String getSmtpServerHost() {
        return smtpServerHost;
    }

    public void setSmtpServerHost(String smtpServerHost) {
        this.smtpServerHost = smtpServerHost;
    }

    public String getSmtpServerPort() {
        return smtpServerPort;
    }

    public void setSmtpServerPort(String smtpServerPort) {
        this.smtpServerPort = smtpServerPort;
    }

    public String getSmtpUserName() {
        return smtpUserName;
    }

    public void setSmtpUserName(String smtpUserName) {
        this.smtpUserName = smtpUserName;
    }

    public String getSmtpUserPassword() {
        return smtpUserPassword;
    }

    public void setSmtpUserPassword(String smtpUserPassword) {
        this.smtpUserPassword = smtpUserPassword;
    }

    public String getFromUserEmail() {
        return fromUserEmail;
    }

    public void setFromUserEmail(String fromUserEmail) {
        this.fromUserEmail = fromUserEmail;
    }

    public String getFromUserFullName() {
        return fromUserFullName;
    }

    public void setFromUserFullName(String fromUserFullName) {
        this.fromUserFullName = fromUserFullName;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
