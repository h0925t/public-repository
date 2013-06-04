package org.himopie.gae.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class SampleTest extends AppEngineTestCase {

    private Sample model = new Sample();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
