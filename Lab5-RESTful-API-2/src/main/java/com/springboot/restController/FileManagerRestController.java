package com.springboot.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.service.FileMangerService;

import jakarta.websocket.server.PathParam;

@RestController
@CrossOrigin(origins = "*")
public class FileManagerRestController {

	@Autowired
	FileMangerService fileService;
	
	@GetMapping("/rest/files/{folder}/{file}")
	private byte[] download(@PathVariable("folder") String folder, @PathVariable("file") String file) {
		return fileService.read(folder, file);
	}
	
	@PostMapping(value = "/rest/files/{folder}")
	private List<String> upload(@PathVariable("folder") String folder, @PathParam("files") MultipartFile[] files){
		return fileService.save(folder, files);
	}
	
	@DeleteMapping("/rest/files/{folder}/{file}")
	private void delete(@PathVariable("folder") String folder, @PathVariable("file") String file) {
		fileService.delete(folder, file);
	}
	
	@GetMapping("/rest/files/{folder}")
	private List<String> list(@PathVariable("folder") String folder) {
		return fileService.list(folder);
	}
}
