package edu.spring.ex02.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex02.domain.MemberVO;

//@Component  // 스프링에서 Component 빈으로 관리
@Repository // 스프링에서 DAO Component 빈으로 관리하겠다라고 선언 하는 것이다.
// 이클래스를 스프링 프레임워크에서 빈으로 관리한다.
// 빈으로 관리할 수 있는 이유는 roo-context.xml에서 패키지를 스캔하겠다고 선언했기 때문
public class MemberDAOImpl implements MemberDAO {
	
	private static final String NAMESPACE = "edu.spring.ex02.MemberMapper";
	
	// DB insert/update/delete/select 동작들은
	// SqlSession 객체를 사용해서 이루어지게 됨
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(MemberVO vo) {
		int result = sqlSession.insert(NAMESPACE + ".member-insert", vo);
		return result;
	} // end insert()
	
	@Override
	public List<MemberVO> select() {
		List<MemberVO> list =
			sqlSession.selectList(NAMESPACE + ".member-select-all");
		return list;
	}
	@Override
	public MemberVO select(String userid) {
		MemberVO vo = sqlSession.selectOne(
				NAMESPACE + ".select-by-userid", userid);
		
		return vo;
	}

	@Override
	public int update(MemberVO vo) {
		int result = sqlSession.update(NAMESPACE + ".update", vo);

		return result;
	}
	
	@Override
	public int delete(String userid) {
		int result = sqlSession.delete(NAMESPACE + ".delete", userid);
		return result;
	}
	
	@Override
	public int update(String id, String mail) {
		Map<String, String> args = new HashMap<>();
		args.put("userid", id);
		args.put("email", mail);
		
		int result = sqlSession.update(
				NAMESPACE + ".update-email", args);
		
		return result;
	}
	


} // end class MemverDAOImpl
