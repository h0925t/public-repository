/**
 * 
 */
package org.himopie.gae.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;
import org.himopie.gae.exception.GaeAppException;
import org.himopie.gae.service.ConvertService;
import org.springframework.stereotype.Service;

/**
 * @author Hito
 * 
 */
@Service("totsuzenConvertService")
public class TotsuzenDeathConvertService implements ConvertService<String> {
	/** Logger */
	private Logger logger = Logger.getLogger(this.getClass().getPackage().getName());

	@Override
	public String convert(final String input) throws GaeAppException {
		this.logger.info("INPUT : " + input); //$NON-NLS-1$
		if (StringUtils.isEmpty(input)) {
			throw new GaeAppException(new IllegalArgumentException("Input String is Empty !")); //$NON-NLS-1$
		}
		List<String> middlePart = createMiddlePart(input);
		int max = getMaxLength(middlePart.toArray(new String[0]));
		String topPart = createTopLine(max);
		String bottomPart = createBottomLine(max);

		String result = topPart + "\n" + StringUtils.join(middlePart, "\n") + "\n" + bottomPart + "\n"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		this.logger.info("OUTPUT : " + result); //$NON-NLS-1$
		return result;
	}

	/**
	 * 配列の中の文字列で最長の長さを返す（SJIS）
	 * 
	 * @param lines 文字列配列
	 * @return 最長の長さ
	 */
	private int getMaxLength(final String[] lines) {
		int max = 0;
		for (String line : lines) {
			try {
				int length = line.getBytes("Shift_JIS").length; //$NON-NLS-1$
				if (length > max) {
					max = length;
				}
			} catch (UnsupportedEncodingException e) {
				this.logger.warning("不正な文字列：" + line); //$NON-NLS-1$
			}
		}
		return max;
	}

	/**
	 * 中間部分の文字列を生成する
	 * 
	 * @param input 入力値
	 * @return 生成文字列
	 */
	private List<String> createMiddlePart(final String input) {
		List<String> outputLines = new ArrayList<>();
		String[] lines = input.split("\n"); //$NON-NLS-1$
		int max = getMaxLength(lines);

		for (String line : lines) {
			String convertedLine = line;
			try {
				while (max > convertedLine.getBytes("Shift_JIS").length) { //$NON-NLS-1$
					convertedLine += "　"; //$NON-NLS-1$
				}
				convertedLine = "＞ " + convertedLine + " ＜"; //$NON-NLS-1$ //$NON-NLS-2$
				outputLines.add(convertedLine);
			} catch (UnsupportedEncodingException e) {
				this.logger.warning("不正な文字列：" + line); //$NON-NLS-1$
			}
		}
		return outputLines;
	}

	/**
	 * 上につく行を生成する
	 * 
	 * @param max 本文部分の最大行
	 * @return 行データ
	 */
	private static String createTopLine(final int max) {
		String ret = "＿"; //$NON-NLS-1$
		for (int i = 0; i < (max * 0.5) - 3; i++) {
			ret += "人"; //$NON-NLS-1$
		}
		ret += "＿"; //$NON-NLS-1$
		return ret;
	}

	/**
	 * 下につく行を生成する
	 * 
	 * @param max 本文部分の最大行
	 * @return 行データ
	 */
	private static String createBottomLine(final int max) {
		String ret = "￣"; //$NON-NLS-1$
		for (int i = 0; i < (max * 0.4) - 3; i++) {
			ret += "Y^"; //$NON-NLS-1$
		}
		ret += "Y￣"; //$NON-NLS-1$
		return ret;
	}
}
