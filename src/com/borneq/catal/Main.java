package com.borneq.catal;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		scan(new File("c:\\temp"));
	}

	private static void scan(File aStartingDir)
	{
		File[] filesAndDirs = aStartingDir.listFiles();
		String name = filesAndDirs[0].getName();
		List<File> fileList = new ArrayList<File>();
		List<File> dirList = new ArrayList<File>();
		for(File file : filesAndDirs) {
			if (file.isDirectory())
				dirList.add(file);
			else
				fileList.add(file);		
		}
	}
}
