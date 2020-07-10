package com.kf2y.tcool.service.file;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FilesStorageService {

	public void init();
	public void saveAudio(MultipartFile file);
	public void saveImage(MultipartFile file);
	public Resource loadAudio(String filename);
	public Resource loadImage(String filename);
}
