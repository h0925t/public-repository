package org.himopie.gae.service;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class SampleServiceTest extends AppEngineTestCase {

    private SampleService service = new SampleService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
