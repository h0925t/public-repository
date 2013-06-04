package org.himopie.gae.service;

import java.util.List;

import org.slim3.datastore.Datastore;
import org.himopie.gae.model.Slim3Model;
import org.himopie.gae.meta.Slim3ModelMeta;

import com.google.appengine.api.datastore.Key;

public class Slim3Service {

	private Slim3Service() {
	}

	public static Slim3Model newAndPut(String prop1) {
		Slim3Model model = new Slim3Model();
		model.setProp1(prop1);
		Key key = Datastore.put(model);
		model.setKey(key);
		return model;
	}

	public static List<Slim3Model> queryAll() {
		return Datastore.query(Slim3ModelMeta.get()).asList();
	}
}
