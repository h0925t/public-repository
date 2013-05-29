/**
 * 
 */
package org.himopie.gae.exception;

/**
 * @author Hito
 * 
 */
public class GaeAppException extends Exception {

	/** SerialVersionUID */
	private static final long serialVersionUID = 5251840175670794621L;

	/**
	 * コンストラクタ
	 * 
	 * @param e 例外
	 */
	public GaeAppException(final Exception e) {
		super(e);
	}

	/**
	 * コンストラクタ
	 * 
	 * @param message メッセージ
	 */
	public GaeAppException(final String message) {
		super(message);
	}

}
