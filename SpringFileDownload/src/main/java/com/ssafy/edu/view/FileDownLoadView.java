package com.ssafy.edu.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FileDownLoadView extends AbstractView {

	public FileDownLoadView() {
		setContentType("apllication/download; charset=UTF-8");
	}
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("여기까지 호출됨???   🍉🍉🍉🍉🍉🍉🍉🍉🍉");
		
		ServletContext ctx = getServletContext();
		String realPath = ctx.getRealPath("/upload");
		
		Map<String, Object> fileInfo = (Map<String, Object>) model.get("downloadFile"); // 전송받은 모델(파일 정보)
        
		
		System.out.println("그래서 니 정보가 무엇이나? 🥩🥩" + (Map<String, Object>) model.get("downloadFile"));
		
        String saveFolder = (String) fileInfo.get("sfolder");	// 파일 경로
        String originalFile = (String) fileInfo.get("ofile");	// 원본 파일명(화면에 표시될 파일 이름)
        String saveFile = (String) fileInfo.get("sfile");    	// 암호화된 파일명(실제 저장된 파일 이름)
        File file = new File(realPath + File.separator  + saveFolder, saveFile);
		
        if (saveFolder == null || originalFile == null || saveFile == null) {
        	System.out.println("또 널이야?   🍤🍤🍤🍤🍤🍤🍤🍤🍤🍤🍤🍤🍤🍤🍤🍤🍤🍤🍤🍤🍤");
        }
        
        System.out.println(saveFolder + originalFile + saveFile);
        
        response.setContentType(getContentType());
        response.setContentLength((int) file.length());
        
        String header = request.getHeader("User-Agent");
        boolean isIE = header.indexOf("MSIE") > -1 || header.indexOf("Trident") > -1;
        String fileName = null;
        if (isIE) {
        	fileName = URLEncoder.encode(originalFile, "UTF-8").replaceAll("\\+", "%20");
        } else {
            fileName = new String(originalFile.getBytes("UTF-8"), "ISO-8859-1");
        }
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
        response.setHeader("Content-Transfer-Encoding", "binary");
        OutputStream out = response.getOutputStream();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            FileCopyUtils.copy(fis, out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(fis != null) {
                try { 
                    fis.close(); 
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        out.flush();
    }
}