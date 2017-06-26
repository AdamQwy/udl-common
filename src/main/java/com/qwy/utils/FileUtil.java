package com.qwy.utils;

import java.io.File;

/**
 * <p>Title: 文件工具类</p>
 * <p>Description: </p>
 * <p>Company: CodeChewer</p>
 * @author AdamQwy
 * @date 2017年6月19日 上午10:48:33
 */
public class FileUtil {
	public static File[] getFileList(File dictionary) {
		if (dictionary.isDirectory()) {
			return dictionary.listFiles();
		}
		return null;
	}

	public static File[] getFileList(String dictionaryPath) {
		return getFileList(new File(dictionaryPath));
	}
}
