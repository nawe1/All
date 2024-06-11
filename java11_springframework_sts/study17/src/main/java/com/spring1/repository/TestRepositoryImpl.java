package com.spring1.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring1.domain.Test;

@Repository
public class TestRepositoryImpl implements TestRepository {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<Test> getTestList() {
        return sqlSession.selectList("test.getTestList");
    }

    @Override
    public Test getTest(int num) {  return sqlSession.selectOne("test.getTest", num);  }

    @Override
    public void insert(Test test) { sqlSession.insert("test.insert", test); }

    @Override
    public void update(Test test) { sqlSession.update("test.update", test); }

    @Override
    public void delete(int num) { sqlSession.delete("test.delete", num); }
}
