package bit.com.a.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.MemberDao;
import bit.com.a.dto.MemberDto;
import bit.com.a.service.MemberService;

@Service	// controller, dao 중간에 위치.... DB데이터 가공
public class MemberServiceImpl implements MemberService {

	@Autowired				// ioc
	MemberDao memberDao;	// MemberDao memberDao = new MemberDaoImpl();
	
	/*
	@Override
	public List<MemberDto> allMember() {		
		return memberDao.allMember();
	}
	*/

	@Override
	public int getId(MemberDto mem) {		
		return memberDao.getId(mem);		
	}
	
	@Override
	public boolean addmember(MemberDto mem) {		
		return memberDao.addmember(mem);		
	}

	@Override
	public MemberDto login(MemberDto dto) {		
		return memberDao.login(dto);		
	}
	
	
}





