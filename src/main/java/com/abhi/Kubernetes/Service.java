package com.abhi.Kubernetes;

import org.springframework.beans.factory.annotation.Value;

import java.awt.print.Book;

@org.springframework.stereotype.Service
public class Service {

    BookUtil bookUtil;

    Service(BookUtil bookUtil) {
        this.bookUtil = bookUtil;
    }

    public String getAllBooks() {
        return bookUtil.toString();
    }
}
