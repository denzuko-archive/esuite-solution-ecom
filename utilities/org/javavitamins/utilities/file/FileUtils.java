package org.javavitamins.utilities.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.javavitamins.utilities.StringUtils;

import org.javavitamins.modules.validator.BasicValidator;

public class FileUtils {

	public FileUtils() {
	}

	public static void copyDirectory(String sourceDirName,
			String destinationDirName) {
		copyDirectory(new File(sourceDirName), new File(destinationDirName));
	}

	public static void copyDirectory(File source, File destination) {
		if (source.exists() && source.isDirectory()) {
			if (!destination.exists())
				destination.mkdirs();
			File fileArray[] = source.listFiles();
			for (int i = 0; i < fileArray.length; i++)
				if (fileArray[i].isDirectory())
					copyDirectory(fileArray[i], new File(destination.getPath()
							+ File.separator + fileArray[i].getName()));
				else
					copyFile(fileArray[i], new File(destination.getPath()
							+ File.separator + fileArray[i].getName()));

		}
	}

	public static void copyFile(String source, String destination) {
		copyFile(source, destination, false);
	}

	public static void copyFile(String source, String destination, boolean lazy) {
		copyFile(new File(source), new File(destination), lazy);
	}

	public static void copyFile(File source, File destination) {
		copyFile(source, destination, false);
	}

	public static void copyFile(File source, File destination, boolean lazy) {
		if (!source.exists())
			return;
		if (lazy) {
			String oldContent = null;
			try {
				oldContent = read(source);
			} catch (Exception exception) {
				return;
			}
			String newContent = null;
			try {
				newContent = read(destination);
			} catch (Exception exception1) {
			}
			if (oldContent == null || !oldContent.equals(newContent))
				copyFile(source, destination, false);
		} else {
			if (destination.getParentFile() != null
					&& !destination.getParentFile().exists())
				destination.getParentFile().mkdirs();
			try {
				FileChannel srcChannel = (new FileInputStream(source)) // TODO
						.getChannel();
				FileChannel dstChannel = (new FileOutputStream(destination))
						.getChannel();
				dstChannel.transferFrom(srcChannel, 0L, srcChannel.size());
				srcChannel.close();
				dstChannel.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}

	public static boolean delete(String file) {
		return delete(new File(file));
	}

	public static boolean delete(File file) {
		if (file.exists())
			return file.delete();
		else
			return false;
	}

	public static void deltree(String directory) {
		deltree(new File(directory));
	}

	public static void deltree(File directory) {
		if (directory.exists() && directory.isDirectory()) {
			File fileArray[] = directory.listFiles();
			for (int i = 0; i < fileArray.length; i++)
				if (fileArray[i].isDirectory())
					deltree(fileArray[i]);
				else
					fileArray[i].delete();

			directory.delete();
		}
	}

	public static byte[] getBytes(File file) throws IOException {
		if (file == null || !file.exists()) {
			return null;
		} else {
			FileInputStream in = new FileInputStream(file);
			byte bytes[] = getBytes(((InputStream) (in)));
			in.close();
			return bytes;
		}
	}

	public static byte[] getBytes(InputStream in) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		for (int c = in.read(); c != -1; c = in.read())
			out.write(c);

		out.close();
		return out.toByteArray();
	}

	public static String getPath(String fullFileName) {
		int pos = fullFileName.lastIndexOf("/");
		if (pos == -1)
			pos = fullFileName.lastIndexOf("\\");
		String shortFileName = fullFileName.substring(0, pos);
		if (BasicValidator.isNull(shortFileName))
			return "/";
		else
			return shortFileName;
	}

	public static String getShortFileName(String fullFileName) {
		int pos = fullFileName.lastIndexOf("/");
		if (pos == -1)
			pos = fullFileName.lastIndexOf("\\");
		String shortFileName = fullFileName.substring(pos + 1, fullFileName
				.length());
		return shortFileName;
	}

	public static boolean exists(String fileName) {
		File file = new File(fileName);
		return file.exists();
	}

	public static String[] listDirs(String fileName) throws IOException {
		return listDirs(new File(fileName));
	}

	public static String[] listDirs(File file) throws IOException {
		List dirs = new ArrayList();
		File fileArray[] = file.listFiles();
		for (int i = 0; i < fileArray.length; i++)
			if (fileArray[i].isDirectory())
				dirs.add(fileArray[i].getName());

		return (String[]) dirs.toArray(new String[0]);
	}

	public static String[] listFiles(String fileName) throws IOException {
		if (BasicValidator.isNull(fileName))
			return new String[0];
		else
			return listFiles(new File(fileName));
	}

	public static String[] listFiles(File file) throws IOException {
		List files = new ArrayList();
		File fileArray[] = file.listFiles();
		for (int i = 0; fileArray != null && i < fileArray.length; i++)
			if (fileArray[i].isFile())
				files.add(fileArray[i].getName());

		return (String[]) files.toArray(new String[0]);
	}

	public static void mkdirs(String pathName) {
		File file = new File(pathName);
		file.mkdirs();
	}

	public static boolean move(String sourceFileName, String destinationFileName) {
		return move(new File(sourceFileName), new File(destinationFileName));
	}

	public static boolean move(File source, File destination) {
		if (!source.exists()) {
			return false;
		} else {
			destination.delete();
			return source.renameTo(destination);
		}
	}

	public static String read(String fileName) throws IOException {
		return read(new File(fileName));
	}

	public static String read(File file) throws IOException {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new FileReader(file));
		for (String line = null; (line = br.readLine()) != null;) {
			sb.append(line);
			sb.append('\n');
		}

		br.close();
		return sb.toString().trim();
	}

	public static File[] sortFiles(File files[]) {
		Arrays.sort(files, new FileNameComparator());
		List directoryList = new ArrayList();
		List fileList = new ArrayList();
		for (int i = 0; i < files.length; i++)
			if (files[i].isDirectory())
				directoryList.add(files[i]);
			else
				fileList.add(files[i]);

		directoryList.addAll(fileList);
		return (File[]) directoryList.toArray(new File[0]);
	}

	public static String replaceSeparator(String fileName) {
		return StringUtils.replace(fileName, '\\', "/");
	}

	public static List toList(Reader reader) {
		List list = new ArrayList();
		try {
			BufferedReader br = new BufferedReader(reader);
			for (String line = null; (line = br.readLine()) != null;)
				list.add(line);

			br.close();
		} catch (IOException ioexception) {
		}
		return list;
	}

	public static List toList(String fileName) {
		try {
			return toList(((Reader) (new FileReader(fileName))));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return new ArrayList();
	}

	public static Properties toProperties(FileInputStream fis) {
		Properties props = new Properties();
		try {
			props.load(fis);
		} catch (IOException ioexception) {
		}
		return props;
	}

	public static Properties toProperties(String fileName) {
		try {
			return toProperties(new FileInputStream(fileName));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return new Properties();
	}

	public static void write(String fileName, String s) throws IOException {
		write(new File(fileName), s);
	}

	public static void write(String fileName, String s, boolean lazy)
			throws IOException {
		write(new File(fileName), s, lazy);
	}

	public static void write(String pathName, String fileName, String s)
			throws IOException {
		write(new File(pathName, fileName), s);
	}

	public static void write(String pathName, String fileName, String s,
			boolean lazy) throws IOException {
		write(new File(pathName, fileName), s, lazy);
	}

	public static void write(File file, String s) throws IOException {
		write(file, s, false);
	}

	public static void write(File file, String s, boolean lazy)
			throws IOException {
		if (file.getParent() != null)
			mkdirs(file.getParent());
		if (file.exists()) {
			String content = read(file);
			if (content.equals(s))
				return;
		}
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		bw.flush();
		bw.write(s);
		bw.close();
	}

	public static void write(String fileName, byte byteArray[])
			throws IOException {
		write(new File(fileName), byteArray);
	}

	public static void write(File file, byte byteArray[]) throws IOException {
		if (file.getParent() != null)
			mkdirs(file.getParent());
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(byteArray);
		fos.close();
	}

	public static Properties loadFile(String fileName) {
		FileInputStream fileInputStream = null;
		Properties properties = new Properties();
		try {
			fileInputStream = new FileInputStream(new File(fileName));
			properties.load(fileInputStream);
		} catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
			// logger.fatal("FileNotFoundException for the property file and property file name with fully qaulified path is :"
			// + fileName);
		} catch (IOException ioexception) {
			ioexception.printStackTrace();
			// logger
			// .fatal("IO Exception occured while reading the property file with fully qualified path as : "
			// + fileName);
		}
		return properties;
	}

}