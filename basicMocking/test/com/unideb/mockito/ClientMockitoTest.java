package com.unideb.mockito;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ClientMockitoTest {

    private static final String TEST_SERVER_NAME = "TestServerName";

    private Client underTest;

    @Mock
    private Server server;
    @Mock
    private ContentFormatter formatter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        underTest = new Client(server, formatter);
    }

    @Test //test-el kezdünk utána a metodus neve, ez után Should és amit csinálnia kell
    public void testConnectShouldConnectToTheServer() {
        // GIVEN in setup
        // WHEN
        underTest.connectToTheServer();
        // THEN
        BDDMockito.verify(server).connect();
    }

    @Test
    public void testGetServerIdenrifierShouldReturnServerIdentifier() {
        // GIVEN
        BDDMockito.given(server.getIdentifier()).willReturn(TEST_SERVER_NAME);
        // WHEN
        String result = underTest.getServerIdentifier();
        // THEN
        BDDMockito.verify(server).getIdentifier();
        Assert.assertEquals(TEST_SERVER_NAME, result);
    }

    @Test(expected = RuntimeException.class)
    public void testGetContentShouldThrowExceptionWhenGetNotValidInput() {
        // GIVEN
        BDDMockito.given(server.getContent(-1L)).willThrow(new RuntimeException());
        // WHEN
        underTest.getServiceContent(-1L);
        // THEN exception thrown
    }

    @Test
    public void testReleaseShouldReleaseService() {
        // GIVEN in setup
        // WHEN
        underTest.disconnectFromTheServer();
        // THEN
        BDDMockito.verify(server).release();
    }
}
