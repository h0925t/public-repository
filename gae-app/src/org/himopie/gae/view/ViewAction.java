package org.himopie.gae.view;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Hito
 * 
 */
@Controller
@RequestMapping("/view")
public class ViewAction {

	/** Logger */
	private Logger logger = Logger.getLogger(this.getClass().getPackage().getName());

	/**
	 * /jsp/${name}.jspを取得して表示するためのコントローラー<br />
	 * 実際のファイル名とのマッピングはSpringで行うため、ファイル名をそのまま返すのみ。
	 * 
	 * @param name JSPファイル名
	 * @return JSPファイル名
	 */
	@RequestMapping(method = RequestMethod.GET, value = "{name}")
	public String view(@PathVariable("name") final String name) {
		this.logger.info("JSP name :" + name); //$NON-NLS-1$
		return name;
	}

}
