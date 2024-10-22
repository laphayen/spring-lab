package com.ssafy.edu.controller;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.edu.dto.FileInfoDto;
import com.ssafy.edu.repository.FileRepository;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("/file")
public class FileController {
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private FileRepository frepo;

	@PostMapping("/fileupload")
	public String fileUpload(@RequestParam("upfile") MultipartFile[] files) throws Exception {
		System.out.println("file✔✔✔✔✔✔✔✔✔✔");
		add(files);
		return "redirect:/file/list";
	}

	@GetMapping("/list")
	public ModelAndView list(ModelAndView mv) throws Exception {
		List<FileInfoDto> list = frepo.fileSelectAll();
		mv.addObject("list", list);
		mv.setViewName("index");

		return mv;
	}


	@GetMapping("/download")
	public ModelAndView downloadFile(@RequestParam("originalFile") String originalFile) throws Exception {
	    
		System.out.println("(●'◡'●)(●'◡'●)");
		
	    FileInfoDto file = frepo.fileSelect(originalFile);  // 실제 파일 정보를 가져옴
	    Map<String, Object> fileInfo = new HashMap<>();
	    fileInfo.put("sfolder", file.getSaveFolder());  // 파일이 저장된 폴더 정보
	    fileInfo.put("ofile", file.getOriginalFile());  // 원본 파일명
	    fileInfo.put("sfile", file.getSaveFile());      // 실제 저장된 파일명
	    
	    System.out.println("그래서 파일 정보 잘 찍힘???? 🍦🍦🍦🍦🍦  " + fileInfo);

	    return new ModelAndView("fileDownLoadView", "downloadFile", fileInfo);
	}


	private void add(MultipartFile[] files) throws Exception {
//		FileUpload 관련 설정.
		// logger.debug("MultipartFile.isEmpty : {}", files[0].isEmpty());
		if (!files[0].isEmpty()) {
			String realPath = servletContext.getRealPath("/upload");
//			String realPath = servletContext.getRealPath("/resources/img");
			String today = new SimpleDateFormat("yyMMdd").format(new Date());
			String saveFolder = realPath + File.separator + today;
			// logger.debug("저장 폴더 : {}", saveFolder);
			File folder = new File(saveFolder);
			if (!folder.exists())
				folder.mkdirs();

			List<FileInfoDto> fileInfos = new ArrayList<FileInfoDto>();
			for (MultipartFile mfile : files) {
				FileInfoDto fileInfoDto = new FileInfoDto();
				String originalFileName = mfile.getOriginalFilename();
				if (!originalFileName.isEmpty()) {
					String saveFileName = UUID.randomUUID().toString()
							+ originalFileName.substring(originalFileName.lastIndexOf('.'));
					fileInfoDto.setSaveFolder(today);
					fileInfoDto.setOriginalFile(originalFileName);
					fileInfoDto.setSaveFile(saveFileName);
					// logger.debug("원본 파일 이름 : {}, 실제 저장 파일 이름 : {}", mfile.getOriginalFilename(),
					// saveFileName);
					mfile.transferTo(new File(folder, saveFileName));
				}
				fileInfos.add(fileInfoDto);
			}
			for (FileInfoDto fileInfoDto : fileInfos) {
				frepo.fileInsert(fileInfoDto);
			}
		}
	}

}
