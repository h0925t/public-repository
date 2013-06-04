package org.himopie.gae.controller.sample;

import java.util.List;

import org.himopie.gae.model.Sample;
import org.himopie.gae.service.SampleService;
import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class IndexController extends Controller {

	private SampleService service = new SampleService();

	@Override
	public Navigation run() throws Exception {
		List<Sample> sampleList = service.getSampleList();
		requestScope("sampleList", sampleList);
		return forward("index.jsp");
	}
}
