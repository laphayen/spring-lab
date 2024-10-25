package com.ssafy.edu.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.edu.dto.FileInfoDto;
@Repository("FileRepositoryImpl")
public class FileRepositoryImpl implements FileRepository {
	@Autowired
	private DataSource ds;

	@Override
	public void fileInsert(FileInfoDto dto) throws SQLException {
		Connection conn = ds.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(
				"insert into files(savefile, originalfile,savefolder) values (?,?,?)");
		pstmt.setString(1, dto.getSaveFile());
		pstmt.setString(2, dto.getOriginalFile());
		pstmt.setString(3, dto.getSaveFolder());
		pstmt.executeUpdate();
		conn.close();
	}

	@Override
	public List<FileInfoDto> fileSelectAll() throws Exception {
		Connection conn = ds.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(
				"select savefile, originalfile,savefolder from  files");
		
		ResultSet rs = pstmt.executeQuery();
		List<FileInfoDto> list = new ArrayList<>();
		while(rs.next()) {
			FileInfoDto d = new FileInfoDto(
					rs.getString("savefolder"),
					rs.getString("originalfile"),
					rs.getString("savefile")
					);
			list.add(d);
		}
		conn.close();
		return list;
	}

	@Override
	public FileInfoDto fileSelect(String saveFile) throws Exception {
		Connection conn = ds.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(
				"select savefile, originalfile,savefolder "
				+ " from  files where savefile = ? ");
		//System.out.println(saveFile+" : 11111111111");
		pstmt.setString(1, saveFile);
		ResultSet rs = pstmt.executeQuery();
		
		FileInfoDto d = null;
		if(rs.next()) {
			 d = new FileInfoDto(
					 rs.getString("savefolder"),
					 rs.getString("originalfile"),
					 rs.getString("savefile")
					
					);
			
		}
		System.out.println(d);
		conn.close();
		return d;
	}
	
}
