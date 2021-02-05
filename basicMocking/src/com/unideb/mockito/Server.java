package com.unideb.mockito;

public interface Server {
    void connect();

    String getIdentifier();

    String getContent(Long ident);

    void release();
}
