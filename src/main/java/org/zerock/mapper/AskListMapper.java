package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.AskListVO;
import org.zerock.domain.Criteria;

public interface AskListMapper {
	
	// 페이징 없이 게시물 리스트를 반환
	public List<AskListVO> getList();
	
	// 페이징을 사용하여 게시물 리스트를 반환
	public List<AskListVO> getListWithPaging(Criteria cri);
	
	// 게시물 객체를 받아 insert 한다.
	public int insert(AskListVO askList);
	
	// insert 전에 시퀀스번호를 먼저 받아와서 번호를 미리 알수 있는 insert
	public Integer insertSelectKey(AskListVO askList);
	
	// 게시물 번호를 받아 게시물 객체를 찾아서 리턴한다.
	public AskListVO read(Long ask_list_no);
	
	// 게시물 번호를 받아 게시물을 삭제한다.
	public int delete(Long ask_list_no);
	
	// (수정된)게시물 객체를 받아 게시물을 수정한다.
	public int update(AskListVO askList);
	
	// 게시물 전체의 갯수를 리턴한다.
	public int getTotalCount(Criteria cri);
	
	// (나중에)게시물 번호를 받아 해당 게시물 번호의 파일 리스트를 가져온다
	//public List<???> findByAskListNO(Long ask_list_no);
	
	// 게시물 번호를 받아 비밀글인지 확인한다.
	public boolean checkLock(Long ask_list_no);
	
	// 해당 게시물(비밀글)의 비밀번호를 반환한다.
	public String askPassword(Long ask_list_no);
	
}
