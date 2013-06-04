package org.himopie.gae.controller.sample;

import org.himopie.gae.service.SampleService;
import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

public class RegistController extends Controller {

	private SampleService service = new SampleService();

	@Override
	public Navigation run() throws Exception {
		service.regist(new RequestMap(request));
		return redirect(basePath);
	}
}
