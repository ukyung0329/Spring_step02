package main;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dto.BbsDto;
import dto.BbsParam;
import dto.MemberDto;

public class mainClass {

	public static void main(String[] args) throws Exception {
		
		//mybatis 설정파일을 읽어들인다 -> 경로
		InputStream is = Resources.getResourceAsStream("mybatis/config.xml");
		
		//SqlSessionFactory 객체를 취득
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		//SqlSession 객체를 취득 (<- 실질적으로 접근 할 객체)
		SqlSession session = factory.openSession();
		
		
		
		
		// 1. insert
		//MemberDto dto = new MemberDto("aaa", "111", "aaa@");
		//MemberDto dto = new MemberDto("bbb", "222", "bbb@");
		//MemberDto dto = new MemberDto("ccc", "333", "ccc@");
		
		
		//MemberMapper의 <insert id="">와 동일 
		
		
		
		/*
		 * int n = session.insert("add",dto); if(n > 0) { session.commit();
		 * System.out.println("추가 성공!"); }else { session.rollback();
		 * System.out.println("추가 실패"); }
		 */
		 
		 
		 
		
		
		
		// 2. delete
		
		//방법1
		  //MemberDto dto = new MemberDto("aaa"); 
		//MemberDto dto = new MemberDto("bbb", null, null);
		//MemberDto dto = new MemberDto("bbb", null, "");
		
			/*
			 * int n2 = session.delete("del", dto); if(n2 > 0) { session.commit();
			 * System.out.println("삭제 성공!"); }else { session.rollback();
			 * System.out.println("삭제 실패"); }
			 */
		 
		
		//방법2
		/*String id = "ccc";
		int n2 = session.delete("remove", id); 
		
		if(n2 > 0) { session.commit();
		System.out.println("삭제 성공!"); 
		}else { session.rollback();
		System.out.println("삭제 실패"); 
		}
		*/
		
		
		// 3. update
		/*
		 * MemberDto dto = new MemberDto("bbb","222"); int n3 = session.update("upd",
		 * dto); if(n3 > 0) { session.commit(); System.out.println("업데이트 성공!"); }else {
		 * session.rollback(); System.out.println("업데이트 실패"); }
		 */
		
		
		
		
		// 4. select -> 들어가는 타입 없
		
		//방법1
		/*
		 * String id = "bbb"; MemberDto dto = session.selectOne("find", id);//값이 하나일 때
		 * System.out.println(dto.toString());
		 */
		
		//방법2
		/*
		 * List<MemberDto> list = session.selectList("allData"); for (MemberDto m :
		 * list) { System.out.println(m.toString()); }
		 */
		
		
		
		
		
		
		/*
		 BBS 검색
		 1. category : 제목, 내용, 작성자 
		 2. keyword : 검색어		
		 */
		/*
		 * BbsParam search = new BbsParam("title", "코로나"); List<BbsDto> slist =
		 * session.selectList("search", search); for (BbsDto bbs : slist) {
		 * System.out.println(bbs.toString()); }
		 */
		
		
		
		
		
	/*
	 * BbsParam search = new BbsParam("title", "내용"); List<BbsDto> slist =
	 * session.selectList("choice", search); for (BbsDto bbs : slist) {
	 * System.out.println(bbs.toString()); }
	 */
	
		
		
	
	
	  BbsParam search = new BbsParam("id", "aaa"); List<BbsDto> slist =
	  session.selectList("choiceSelect", search); for (BbsDto bbs : slist) {
	  System.out.println(bbs.toString()); }
	 
	 
		
	}

}
