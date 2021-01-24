package com.tatsam.priority;

import java.util.ArrayList;
import java.util.List;

import com.tatsam.priority.entities.Priority;
import com.tatsam.priority.entities.User;
import com.tatsam.priority.entities.UserPriority;
import com.tatsam.priority.repositories.PriorityRepository;
import com.tatsam.priority.repositories.UserPriorityRepository;
import com.tatsam.priority.repositories.UserRepository;
import com.tatsam.priority.services.UserPriorityService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PriorityApplicationTests {

	@Autowired
	PriorityRepository priorityRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserPriorityRepository userPriorityRepository;

	@Autowired
	UserPriorityService userPriorityService;

	@Test
	public void testCreatePriority() {
		Priority priority = new Priority();
		priority.setCategory("Connection");
	
		priorityRepository.save(priority);
	}

	@Test
	public void testSeedPriority() {
		List<Priority> priorityList = new ArrayList<>();

		Priority relationshipsPriority = new Priority();
		relationshipsPriority.setCategory("Relationships");
		priorityList.add(relationshipsPriority);

		Priority careerPriority = new Priority();
		careerPriority.setCategory("Career");
		priorityList.add(careerPriority);

		Priority wealthPriority = new Priority();
		wealthPriority.setCategory("Wealth");
		priorityList.add(wealthPriority);

		priorityRepository.saveAll(priorityList);
	}

	@Test
	public void testCreateUser() {
		User user = new User();
		user.setUsername("TestUser");
		user.setPhone("1234512345");
		user.setEmail("test@test.com");

		userRepository.save(user);
	}

	@Test
	public void testUpdateUser() {
		User user = userRepository.findById(2l).get();
		user.setEmail("updatedmail@test.com");

		userRepository.save(user);
	}

	@Test
	public void testCreateUserPriority() {
		UserPriority userPriority = new UserPriority();
		userPriority.setUserId(1l);
		userPriority.setPriorityId(2l);
		userPriority.setSatisfactionRating(3);
		userPriority.setPriorityOrder(1);
		userPriorityRepository.save(userPriority);
	}

	@Test
	public void testSaveAll() {
		List<UserPriority> allPriorities = new ArrayList<>();
		allPriorities.add(new UserPriority(1l, 2l, 3, 1));
		allPriorities.add(new UserPriority(1l, 4l, 1, 2));
		allPriorities.add(new UserPriority(1l, 3l, 1, 3));
		allPriorities.add(new UserPriority(1l, 1l, 2, 4));

		userPriorityService.saveAllUserPriorities(allPriorities);
	}
}
