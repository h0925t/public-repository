/**
 * 
 */
package org.himopie.gae.service;

import org.himopie.gae.exception.GaeAppException;

/**
 * 何かしら変換するサービスのインターフェース
 * 
 * @author Hito
 * @param <T> 型
 * 
 */
public interface ConvertService<T> {

	/**
	 * 変換する
	 * 
	 * @param input 入力
	 * @return 出力
	 * @throws GaeAppException 例外
	 */
	public T convert(final T input) throws GaeAppException;

}
