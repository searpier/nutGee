package com.nutgee.www.board.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.nutgee.www.board.service.BoardService;
import com.nutgee.www.board.vo.BoardVO;
import com.nutgee.www.utils.service.FileStorageService;
import com.nutgee.www.utils.vo.SmarteditorVO;
import com.nutgee.www.utils.vo.UploadFileResponseVO;
import com.nutgee.www.utils.vo.UploadFileVO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService bService;

	@Autowired
	private FileStorageService fileStorageService;
	
	@Value("${site-file.upload-dir}")
	private String uploadDir;
	
	@Value("${site-file.upload-path}")
	private String realPath;

	@PostMapping(value = { "/uploadPic" })
	@ResponseBody
	public String TestUploadUtil(@RequestParam("filedata") MultipartFile filedata)
			throws IOException {
		
		String result = realPath;
		Path uploadPath = Paths.get(uploadDir);
		// ???????????? ??????????????? ????????? ???????????? ???????????? ??????
		if (!Files.isDirectory(uploadPath)) {
			Files.createDirectories(uploadPath);
		}

		MultipartFile mFile = filedata;
		UUID tempFileName = UUID.randomUUID();
		String originalFileName = mFile.getOriginalFilename(); // ?????? ?????????
		String fileExt = FilenameUtils.getExtension(originalFileName);

		if (originalFileName.toLowerCase().endsWith(".tar.bz2")) {
			fileExt = "tar.bz2";
		} else if (originalFileName.toLowerCase().endsWith(".tar.gz")) {
			fileExt = "tar.gz";
		}
		// ??????????????? ???????????? ???????????? ????????????.
		String logicalFileName = tempFileName.toString() + "." + fileExt;

		byte[] fileBytes = mFile.getBytes(); // ????????? ???????????? ????????????.
		Path filePath = uploadPath.resolve(logicalFileName);
		Files.write(filePath, fileBytes); // ?????? ??????
		
		return "<img src='"+result+logicalFileName+"'>";
	}

	@RequestMapping("/regBoard")
	public String regBoard( BoardVO bvo, HttpSession session) throws Exception {
		
		if(session.getAttribute("id")!=null) {
			bvo.setId((String)session.getAttribute("id"));
		}else {
			return "redirect:/customer/login";
		}
		bService.insertBoard(bvo);
		return "redirect:/blogList";
	}
}
