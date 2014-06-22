package com.cleverpost.admin.common.helpers;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.faces.context.FacesContext;

public class IOHelper {

	public static void delImg(String classname, String filename) {
		File imgFile = new File(new File(getImgDir(), classname), filename);
		imgFile.delete();
	}

	public static void writeImg(String classname, String toFilename,
			String filefile) throws IOException {
		writeImg(classname, toFilename, new File(toFilename));
	}

	public static void writeImg(String classname, String toFilename, File file)
			throws IOException {
		ByteArrayOutputStream os = null;
		os = getOutputStream(file);
		writeImg(classname, toFilename, os);
	}

	public static void writeImg(String classname, String toFilename,
			ByteArrayOutputStream os) throws IOException {
		try {
			writeImg(classname, toFilename, os.toByteArray());
		} finally {
			closeStream(os);
		}
	}

	public static void writeImg(String classname, String toFilename, byte[] data)
			throws IOException {
		File file = new File(getImgDir(), classname);
		if (!file.exists()) {
			file.mkdir();
		}
		writeFileToDir(file.getPath(), toFilename, data);
	}

	public static void writeFileToTempDir(String toFilename, byte[] data)
			throws IOException {
		writeFileToDir(getTempDir(), toFilename, data);
	}

	public static void writeFileToDir(String toDirname, String toFilename,
			byte[] data) throws IOException {
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(new File(toDirname, toFilename));
			out.write(data);
		} finally {
			out.close();
		}
	}

	public static String getDir(String dirname) {
		File file = new File(getBaseDir(), dirname);
		file.mkdir();
		return file.getPath();
	}

	public static String getTempDir() {
		return getDir("tmp");
	}

	public static String getImgDir() {
		return getDir("img");
	}

	public static String getBaseDir() {
		return new File(
				((javax.servlet.ServletContext) FacesContext
						.getCurrentInstance().getExternalContext().getContext())
						.getRealPath("index.jsp")).getParent();
	}

	public static String getLogsDir() {
		return new File(
				new File(new File(getBaseDir()).getParent()).getParent(),
				"logs").getPath();
	}

	public static byte[] loadFile(String filepath) throws FileNotFoundException {
		return loadFile(new File(filepath));
	}

	public static byte[] loadFile(File file) throws FileNotFoundException {
		ByteArrayOutputStream out = null;
		try {
			out = getOutputStream(file);
			return out.toByteArray();
		} finally {
			closeStream(out);
		}
	}

	public static ByteArrayOutputStream getOutputStream(String filepath)
			throws FileNotFoundException {
		return getOutputStream(new File(filepath));
	}

	public static byte[] getBytes(String filepath) throws FileNotFoundException {
		return getBytes(new File(filepath));
	}

	public static byte[] getBytes(File file) throws FileNotFoundException {
		return getBytes(new FileInputStream(file));
	}

	public static byte[] getBytes(InputStream inputStream)
			throws FileNotFoundException {
		ByteArrayOutputStream os = null;
		try {
			os = getOutputStream(inputStream);
			return os.toByteArray();
		} finally {
			closeStream(os);
		}
	}

	public static ByteArrayOutputStream getOutputStream(File file)
			throws FileNotFoundException {
		return getOutputStream(new FileInputStream(file));
	}

	public static ByteArrayOutputStream getOutputStream(InputStream inputStream) {
		BufferedInputStream in = null;
		ByteArrayOutputStream out = null;

		int val = -1;
		try {
			in = new BufferedInputStream(inputStream);
			out = new ByteArrayOutputStream();
			while ((val = in.read()) != -1) {
				out.write(val);
			}
			return out;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			closeStream(in);
		}
	}

	public static String getExtension(String filename) {
		int index = filename.lastIndexOf(".");
		return filename.substring(index);
	}

	public static String getUniqueName() {
		return UUID.randomUUID().toString();
	}

	public static void copy(String toFilePath, InputStream fromInputStream) {
		copy(new File(toFilePath), fromInputStream);
	}

	public static void copy(File toFile, InputStream fromInputStream) {
		OutputStream out;
		try {
			out = new FileOutputStream(toFile);
			copy(out, fromInputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void copyAndClose(OutputStream toStream,
			InputStream fromStream) {
		OutputStream outputStream = copy(toStream, fromStream);
		closeStream(outputStream);
	}

	public static OutputStream copy(OutputStream toStream,
			InputStream fromStream) {
		try {
			int read = 0;
			byte[] bytes = new byte[1024];
			while ((read = fromStream.read(bytes)) != -1) {
				toStream.write(bytes, 0, read);
			}
			fromStream.close();
			toStream.flush();
			return toStream;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		} finally {
			closeStream(fromStream);
		}
	}

	public static void delete(String filepath) {
		File file = new File(filepath);
		if (file.exists()) {
			file.delete();
		}
	}

	private static void closeStream(Closeable stream) {
		try {
			stream.close();
			stream = null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
