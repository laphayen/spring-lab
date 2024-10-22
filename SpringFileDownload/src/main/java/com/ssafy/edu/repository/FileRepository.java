package com.ssafy.edu.repository;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.edu.dto.FileInfoDto;

public interface FileRepository {

	
	public void fileInsert(FileInfoDto dto) throws Exception;
	public List<FileInfoDto> fileSelectAll() throws Exception;
	public FileInfoDto fileSelect(String originalFile) throws Exception;

	
}
