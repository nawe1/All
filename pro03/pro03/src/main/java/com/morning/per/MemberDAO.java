package com.morning.per;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.morning.biz.MemberServiceImpl;
import com.morning.domain.Member;

@Repository
public class MemberDAO implements MemberMapper {

	private static final Logger log = LoggerFactory.getLogger(MemberDAO.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Member> getMemberList() {
		return sqlSession.selectList("member.getMemberList");
	}

    @Override
    public Member getMember(String id) throws IllegalArgumentException {
        log.info("Fetching member with id: {}", id);
        Member member = sqlSession.selectOne("member.getMember", id);
        if (member != null) {
            log.info("Fetched member: {}", member);
        } else {
            log.warn("No member found with id: {}", id);
        }
        return member;
    }

	@Override
	public int memberCount() {		
		return sqlSession.selectOne("member.memberCount");
	}

	@Override
	public void insMember(Member member) {
		sqlSession.insert("member.insMember", member);
	}

	@Override
	public void changePw(Member member) {
		sqlSession.update("member.changePw", member);	
	}

	@Override
	public void changeInfo(Member member) {
		sqlSession.update("member.changeInfo", member);
	}

	@Override
	public void changePoint(Member member) {
		sqlSession.update("member.changePoint", member);	
	}

	@Override
	public void delMember(String id) {
		sqlSession.delete("member.delMember", id);
	}
	
}
