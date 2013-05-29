/**
 * 
 */
package org.himopie.gae.api;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.himopie.gae.exception.GaeAppException;
import org.himopie.gae.model.Result;
import org.himopie.gae.model.ResultStatus;
import org.himopie.gae.service.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Hito
 * 
 */
@Controller
@RequestMapping(value = "/api")
public class API {

	/** Logger */
	private Logger logger = Logger.getLogger(this.getClass().getPackage().getName());

	/** コンバータ */
	@Autowired
	@Qualifier("totsuzenConvertService")
	private ConvertService<String> converter;

	/**
	 * メッセージを返します。
	 * 
	 * @param input 入力値
	 * @return メッセージ
	 */
	@RequestMapping(value = "totuzen", method = { RequestMethod.POST })
	@ResponseBody
	public Result<String> convertedMessage(@RequestParam(required = false, value = "input") final String input) {
		Result<String> result = new Result<>();
		try {
			String output = this.converter.convert(input);
			result.setValue(output);
		} catch (GaeAppException e) {
			this.logger.log(Level.WARNING, e.getMessage(), e);
			result.setStatus(ResultStatus.ERROR);
			return result;
		}
		result.setStatus(ResultStatus.SUCCESS);
		this.logger.info("Result : " + result.getValue()); //$NON-NLS-1$
		return result;
	}
}
