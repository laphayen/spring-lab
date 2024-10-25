package com.ssafy.edu.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.edu.dto.FileInfoDto;

public interface FileRepository {
	public void fileInsert(FileInfoDto dto) throws Exception;
	public List<FileInfoDto> fileSelectAll() throws Exception;
	public FileInfoDto fileSelect(String saveFile) throws Exception;
}
