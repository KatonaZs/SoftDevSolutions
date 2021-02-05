package com.unideb.mockito;

public class Client {
    private final Server server;
    private ContentFormatter format;

    public Client(final Server service, final ContentFormatter format) {
        this.server = service;
        this.format = format;
    }
    
    public void connectToTheServer() {
        server.connect();
    }

    public String getServerIdentifier() {
        return server.getIdentifier();
    }
    
    public String getServiceContent(final Long id) {
        connectToTheServer();
        String result = server.getContent(id);
        disconnectFromTheServer();
        return result;
    }

    public String getContentFormatted(final Long id) {
        String content = getServiceContent(id);
        return format.format(content);
    }

    public void disconnectFromTheServer() {
        server.release();
    }
}
