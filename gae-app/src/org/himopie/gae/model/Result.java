/**
 * 
 */
package org.himopie.gae.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Hito
 * 
 * @param <T> 結果の型
 */
public class Result<T> {

	/** 結果のステータス */
	@Getter
	@Setter
	private ResultStatus status;

	/** 結果の値 */
	@Getter
	@Setter
	private T value;

}
