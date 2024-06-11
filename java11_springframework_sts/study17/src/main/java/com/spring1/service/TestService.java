package com.spring1.service;

import java.util.List;

import com.spring1.domain.Test;

public interface TestService {
    public List<Test> getTestList();
    public List<Test> getTestList2();
    public List<Test> getTestList3();
    public Test getTest(int num);
    public Test getTest2(int num);
    public Test getTest3(int num);
    public void insert(Test test);
    public void insert2(Test test);
    public void insert3(Test test);
    public void update(Test test);
    public void update2(Test test);
    public void update3(Test test);
    public void delete(int num);
    public void delete2(int num);
    public void delete3(int num);
}
