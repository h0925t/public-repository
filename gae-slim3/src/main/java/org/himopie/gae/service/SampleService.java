package org.himopie.gae.service;

import java.util.List;
import java.util.Map;

import org.himopie.gae.meta.SampleMeta;
import org.himopie.gae.model.Sample;
import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Transaction;

public class SampleService {
	private SampleMeta s = new SampleMeta();

	public Sample regist(final Map<String, Object> input) {
		Sample sample = new Sample();
		BeanUtil.copy(input, sample);
		Transaction tx = Datastore.beginTransaction();
		Datastore.put(sample);
		tx.commit();
		return sample;
	}

	public List<Sample> getSampleList() {
		return Datastore.query(s).sort(s.createdDate.desc).asList();
	}
}
