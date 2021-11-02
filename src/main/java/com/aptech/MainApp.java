package com.aptech;

import com.aptech.mail.MyMail;

public class MainApp {
    public static void main(String[] args) {
        MyMail mail=new MyMail();
        mail.sendMailWithAttachments();
    }
}
