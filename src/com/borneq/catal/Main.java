package com.borneq.catal;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import illegalargumentexception.console.TextDevice;
import illegalargumentexception.console.TextDevices;

public class Main {
	private static final TextDevice io = TextDevices.defaultTextDevice();
	
	public static void main(String[] args) {
		scan(new File("c:\\temp"));
	}

	private static void scan(File aStartingDir)
	{
		File[] filesAndDirs = aStartingDir.listFiles();
		//String name = filesAndDirs[0].getName();
		List<File> fileList = new ArrayList<File>();
		List<File> dirList = new ArrayList<File>();
		for(File file : filesAndDirs) {
			if (file.isDirectory())
				dirList.add(file);
			else
				fileList.add(file);		
		}
		for(File file : fileList)
			io.printf("%s\n",file.getPath());			 
	}
}
