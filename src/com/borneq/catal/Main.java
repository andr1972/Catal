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
		scan(new File("d:\\sample7z"));
		System.out.printf("END");
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
		for(File file : fileList) {
			int cnt = PrintCountOfItems.getCount(file.getPath());
			if (cnt>=0)
				System.out.printf("%s %d\n",file.getPath(), cnt);
		}
		for(File file : dirList)
			scan(file);
	}
}
