package com.nutgee.www.blog.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nutgee.www.utils.service.FileStorageService;
import com.nutgee.www.utils.vo.UploadFileResponseVO;
import com.nutgee.www.utils.vo.UploadFileVO;

@Controller
public class BlogController {
	@Autowired
	private FileStorageService fileStorageService;

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/post/{id}/uploadFile")
	public UploadFileResponseVO uploadFile(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
		String fileName = fileStorageService.storeFile(file);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/post")
				.path("/downloadFile/").path(fileName).toUriString();

		UploadFileVO uploadFile = new UploadFileVO();
		uploadFile.setFileName(fileName);
		uploadFile.setFileDownloadUri(fileDownloadUri);
		uploadFile.setFileType(file.getContentType());
		uploadFile.setSize(file.getSize());

		/*
		 * Post post = new Post(); post.setId(id);
		 * 
		 * uploadFile.setPost(post);
		 */

		fileStorageService.saveFile(uploadFile);

		return new UploadFileResponseVO(fileName, fileDownloadUri, file.getContentType(), file.getSize());
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/post/{id}/uploadMultipleFiles")
	public List<UploadFileResponseVO> uploadMultipleFiles(@PathVariable Long id,
			@RequestParam("files") MultipartFile[] files) {
		return Arrays.asList(files).stream().map(file -> uploadFile(id, file)).collect(Collectors.toList());
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/post/{id}/files")
	public List<UploadFileResponseVO> downloadFilesInfoInPost(@PathVariable Long id) {

		List<UploadFileVO> uploadFiles = fileStorageService.findAllByFileId(id+"");

		return uploadFiles
				.stream().map(fileInfo -> new UploadFileResponseVO(fileInfo.getFileName(),
						fileInfo.getFileDownloadUri(), fileInfo.getFileType(), fileInfo.getSize()))
				.collect(Collectors.toList());
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/post/downloadFile/{fileName:.+}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
		Resource resource = fileStorageService.loadFileAsResource(fileName);

		String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (IOException ex) {
			System.out.println("Could not determine file type.");
		}

		if (contentType == null) {
			contentType = "application/octet-stream";
		}

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}
}
