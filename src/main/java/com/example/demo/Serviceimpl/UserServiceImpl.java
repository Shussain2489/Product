package com.example.demo.Serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import com.example.demo.exception.UserNotFoundByIdException;
import com.example.demo.utility.ResponseStructure;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepo;
	private ResponseStructure<User> structure;
	private ResponseStructure<List<User>> structureList;
	

	public UserServiceImpl(UserRepository userRepo, ResponseStructure<User> structure) {
		this.userRepo = userRepo;
		this.structure = structure;
	}

	@Override
	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		
		User user2 = userRepo.save(user);
		
		return ResponseEntity.ok(structure.setStatusCode(HttpStatus.OK.value())
				.setMessage("User Saved Successfully")
				.setData(user2));
		}

}
	

