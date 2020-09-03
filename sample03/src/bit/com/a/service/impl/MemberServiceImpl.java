package bit.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.MemberDao;
import bit.com.a.dto.MemberDto;
import bit.com.a.service.MemberService;

@Service	//controller와 Dao 중간에 위치하여, DB에서 꺼내 온 data를 가공한다 
public class MemberServiceImpl implements MemberService {
	
	@Autowired				//ioc 
	MemberDao memberDao;	//동일 : MemberDao memberDao = new MemberDaoImpl();
	
	@Override
	public List<MemberDto> allMember() {
		return memberDao.allMember();
	}
	

	
	
}
