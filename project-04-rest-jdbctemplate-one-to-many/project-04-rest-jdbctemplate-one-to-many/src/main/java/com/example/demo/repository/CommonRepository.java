package com.example.demo.repository;

import java.util.List;

public interface CommonRepository<T> {
	
	T save(T t);
	T findById(int id);
	List<T> findAll();
	T update(int id, T t);
	void delete(int id);	

}
