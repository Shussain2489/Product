package com.example.demo.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.Model.User;
import com.example.demo.utility.ResponseStructure;

public interface  UserService {

	public ResponseEntity<ResponseStructure<User>> saveUser(User user);

	
}
