package com.kf2y.tcool.service.file;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FilesStorageServiceImpl implements FilesStorageService {
	
	private final Path audiosDirectory = Paths.get("src/main/resources/audios");
	private final Path imagesDirectory = Paths.get("src/main/resources/images");

	@Override
	public void init() {
		try {
			Files.createDirectories(audiosDirectory);
			Files.createDirectories(imagesDirectory);
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize folders!");
		}

	}

	@Override
	public void saveAudio(MultipartFile file) {
		try {
			Files.copy(file.getInputStream(), this.audiosDirectory.resolve(file.getOriginalFilename()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Could not store the file. Error: "+ e.getMessage());
		}
	}

	@Override
	public void saveImage(MultipartFile file) {
		// TODO Auto-generated method stub

	}

	@Override
	public Resource loadAudio(String filename) {
		try {
			Path file = audiosDirectory.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if(resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("Cold not read the file!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("Error: "+ e.getMessage());
		}
	}

	@Override
	public Resource loadImage(String filename) {
		// TODO Auto-generated method stub
		return null;
	}

}
