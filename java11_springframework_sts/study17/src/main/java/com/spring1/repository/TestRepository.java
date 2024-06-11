package com.spring1.repository;

import java.util.List;

import com.spring1.domain.Test;

public interface TestRepository {
    public List<Test> getTestList();
    public Test getTest(int num);
    public void insert(Test test);
    public void update(Test test);
    public void delete(int num);
}