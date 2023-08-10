package com.springboot.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletContext;

@Service
public class FileMangerService {
	@Autowired
	ServletContext app;

	private Path getPath(String folder, String filename) {
		File dir = Paths.get(app.getRealPath("/files/"), folder).toFile();

		if (!dir.exists()) {
			dir.mkdir();
		}

		return Paths.get(dir.getAbsolutePath(), filename);
	}

	public byte[] read(String folder, String filename) {
		Path path = this.getPath(folder, filename);
		try {
			return Files.readAllBytes(path);
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
	}

	public List<String> save(String folder, MultipartFile[] files) {
		List<String> filenames = new ArrayList<String>();
		for (MultipartFile file : files) {
			String name = System.currentTimeMillis() + file.getOriginalFilename();
			System.out.println("name : " + name);
			String filename = Integer.toHexString(name.hashCode()) + name.substring(name.lastIndexOf("."));
			System.out.println("filename : " + filename);
			Path path = this.getPath(folder, filename);
			System.out.println("path : " + path);
			try {
				file.transferTo(path);
				filenames.add(filename);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return filenames;
	}

	public void delete(String folder, String filename) {
		Path path = this.getPath(folder, filename);
		path.toFile().delete();
	}

	public List<String> list(String folder) {
		List<String> filenames = new ArrayList<>();
		File dir = Paths.get(app.getRealPath("/files/"),folder).toFile();
		System.out.println("--- : " + dir);
		if(dir.exists()) {
			File[] files = dir.listFiles();
			for (File file : files) {
				System.out.println(file.getName());
				filenames.add(file.getName());
			}
		}
		
		return filenames;
	}
}
