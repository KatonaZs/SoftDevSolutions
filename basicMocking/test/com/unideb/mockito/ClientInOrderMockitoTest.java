package com.unideb.mockito;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ClientInOrderMockitoTest {
    private static final String TEST_CONTENT = "testContent";
    private static final String FORMATTED_TEST_CONTENT = "{$testContent}";

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

    @Test
    public void testGetContentFormattedShouldReturnContentProperly() {
        // GIVEN
        Long ident = 12L;
        BDDMockito.given(server.getContent(ident)).willReturn(TEST_CONTENT);
        BDDMockito.given(formatter.format(Mockito.anyString())).willReturn(FORMATTED_TEST_CONTENT);
        // WHEN
        String result = underTest.getContentFormatted(ident);
        // THEN
        InOrder inorder = BDDMockito.inOrder(server, formatter);
        inorder.verify(server).connect();
        inorder.verify(server).getContent(ident);
        inorder.verify(server).release();
        inorder.verify(formatter).format(TEST_CONTENT);
        Assert.assertEquals(FORMATTED_TEST_CONTENT, result);
    }
}
