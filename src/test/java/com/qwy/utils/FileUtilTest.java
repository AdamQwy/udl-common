package com.qwy.utils;

import static org.junit.Assert.*;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>
 * Title: FileUtilTest
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: CodeChewer
 * </p>
 * 
 * @author AdamQwy
 * @date 2017年6月19日 上午11:10:58
 */
public class FileUtilTest {

	File[] fileList = null;
	String path = "F:\\iPastryRoom_file";

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("========================");
	}

	@Test
	public final void testGetFileListFile() {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		System.out.println("------------------------");

		File file = new File(path);
		// fileList = FileUtil.getFileList(file);
		// diaplayFileList(fileList);
		recycleDisplayFilelist(file);

	}

	/*
	 * @Test public final void testGetFileListString() {
	 * System.out.println(Thread.currentThread().getStackTrace()[1].
	 * getMethodName()); System.out.println("------------------------");
	 * 
	 * fileList = FileUtil.getFileList(path); diaplayFileList(fileList); }
	 * 
	 * private void diaplayFileList(File[] file) { for (File f : file) {
	 * System.out.println(f.getName()); } }
	 */

	private void recycleDisplayFilelist(File file) {
		recycleDisplayFilelist(file, -1, null, null);
	}

	private void recycleDisplayFilelist(File file, int rootLevel, Boolean isLast, Set<Integer> excludeLevel) {

		StringBuilder sbDisplay = new StringBuilder();

		if (rootLevel > 0) {
			Integer i = 1;
			for (; i <= rootLevel; i++) {
				if (excludeLevel != null && excludeLevel.contains(i)) {
					sbDisplay.append("\t");
				} else {
					sbDisplay.append("┃\t");
				}
			}
		}

		if (rootLevel > -1) {
			if (isLast) {
				sbDisplay.append("┗━━━");
			} else {
				sbDisplay.append("┣━━━");
			}
		}

		if (file.isDirectory()) {
			sbDisplay.append("⊕");
			sbDisplay.append(file.getName());
			System.out.println(sbDisplay.toString());

			File[] filelist = file.listFiles();
			if (filelist.length > 0) {
				for (int i = 0; i < filelist.length - 1; i++) {
					recycleDisplayFilelist(filelist[i], rootLevel + 1, false, excludeLevel);
				}
				File last = filelist[filelist.length - 1];

				if (last.isDirectory()) {
					if (excludeLevel == null) {
						excludeLevel = new HashSet<Integer>();
					}
					excludeLevel.add(rootLevel + 2);
				}
				recycleDisplayFilelist(last, rootLevel + 1, true, excludeLevel);
			}
		} else {
			sbDisplay.append("☉");
			sbDisplay.append(file.getName());
			System.out.println(sbDisplay.toString());
		}
/*		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();*/
	}

}
