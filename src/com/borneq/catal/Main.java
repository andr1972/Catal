package com.borneq.catal;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.sf.sevenzipjbinding.SevenZip;
import net.sf.sevenzipjbinding.SevenZipNativeInitializationException;
import illegalargumentexception.console.TextDevice;
import illegalargumentexception.console.TextDevices;

public class Main {
	private static final TextDevice io = TextDevices.defaultTextDevice();
	
	public static void main(String[] args) {
		try 
		{
            SevenZip.initSevenZipFromPlatformJAR();
            System.out.println("7-Zip-JBinding library was initialized");
        } catch (SevenZipNativeInitializationException e) {
            e.printStackTrace();
        }
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
		Collections.sort(dirList);
		Collections.sort(fileList);
		for(File file : fileList)
			io.printf("%s\n",file.getPath());
		for(File file : dirList)
			scan(file);
	}
}
