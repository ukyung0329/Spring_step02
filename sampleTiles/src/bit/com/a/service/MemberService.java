package bit.com.a.service;

import bit.com.a.dto.MemberDto;

public interface MemberService {

	//List<MemberDto> allMember();
	
	int getId(MemberDto mem);
	boolean addmember(MemberDto mem);
	
	MemberDto login(MemberDto dto);
}
