package org.himopie.gae.controller.sample;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.slim3.tester.ControllerTestCase;

public class RegistControllerTest extends ControllerTestCase {

	@Test
	public void run() throws Exception {
		tester.start("/sample/regist");
		RegistController controller = tester.getController();
		assertThat(controller, is(notNullValue()));
		assertThat(tester.isRedirect(), is(true));
		assertThat(tester.getDestinationPath(), is("/sample/"));
	}
}
