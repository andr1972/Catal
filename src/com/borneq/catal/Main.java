package com.borneq.catal;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.borneq.usesevenzipjbind.PrintCountOfItems;

import net.sf.sevenzipjbinding.SevenZip;
import net.sf.sevenzipjbinding.SevenZipNativeInitializationException;

public class Main {
    public static void main(String[] args) {
		try 
		{
            SevenZip.initSevenZipFromPlatformJAR();
            System.out.println("7-Zip-JBinding library was initialized");
        } catch (SevenZipNativeInitializationException e) {
            e.printStackTrace();
        }
		PrintCountOfItems.printCount("d:\\sample7z\\do7z\\7z\\7zsfx.exe");
		scan(new File("d:\\sample7z"));
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
			System.out.printf("%s\n",file.getPath());
		for(File file : dirList)
			scan(file);
	}
}
