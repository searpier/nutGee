package com.nutgee.www.utils.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nutgee.www.utils.vo.UploadFileVO;


@Mapper
public interface FileDAO {
	
	public List<UploadFileVO> findAllByFileId(String id);
	public int saveFile(UploadFileVO fvo);

	
}
