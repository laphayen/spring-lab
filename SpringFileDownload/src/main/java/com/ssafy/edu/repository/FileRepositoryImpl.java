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
					rs.getString("savefile"),
					rs.getString("originalfile"),
					rs.getString("savefolder"));
			list.add(d);
		}
		conn.close();
		return list;
	}

	@Override
	public FileInfoDto fileSelect(String originalFile) throws Exception {
	    Connection conn = ds.getConnection();
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    FileInfoDto fileInfo = null;

	    try {
	        // SQL query to select the file based on the original file name
	        String sql = "SELECT savefile, originalfile, savefolder FROM files WHERE originalfile = ?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, originalFile);
	        
	        rs = pstmt.executeQuery();

	        // If a record is found, create a new FileInfoDto object and populate it
	        if (rs.next()) {
	            fileInfo = new FileInfoDto(
	                rs.getString("savefile"),
	                rs.getString("originalfile"),
	                rs.getString("savefolder")
	            );
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new Exception("Error retrieving file information");
	    } finally {
	        if (rs != null) rs.close();
	        if (pstmt != null) pstmt.close();
	        conn.close();
	    }

	    return fileInfo;
	}
	
}
