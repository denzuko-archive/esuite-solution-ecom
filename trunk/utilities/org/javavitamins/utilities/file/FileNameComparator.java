package org.javavitamins.utilities.file;

import java.io.File;
import java.util.Comparator;

public class FileNameComparator implements Comparator {

	public FileNameComparator() {
	}

	public int compare(Object obj1, Object obj2) {
		File file1 = (File) obj1;
		File file2 = (File) obj2;
		return file1.getName().compareTo(file2.getName());
	}

}