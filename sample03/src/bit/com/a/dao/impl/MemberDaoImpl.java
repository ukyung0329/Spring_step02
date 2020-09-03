package bit.com.a.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.MemberDao;
import bit.com.a.dto.MemberDto;

@Repository	//저장소(창고에가서 꺼내옴) 
public class MemberDaoImpl implements MemberDao {

	@Autowired
	SqlSession sqlSession;	//	SqlSession sqlSession = new SqlSessiontemplate(); 알아서 상속된 클래스를 찾아
	
	String namespace = "Member.";
	
	@Override
	public List<MemberDto> allMember() {
		List<MemberDto> list = sqlSession.selectList(namespace+"allMember");
		return list;
	}



	


	
}
