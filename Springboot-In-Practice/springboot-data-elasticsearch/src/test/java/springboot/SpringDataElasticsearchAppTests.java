package springboot;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import springboot.domain.User;
import springboot.repository.UserRepository;

/**
 * @description: 测试ElasticSearch 增删改查
 * @dateTime: Create On 2017-12-03 21:47:12
 * @author: Mr-LiuDC
 * @email: 1911939348@qq.com
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataElasticsearchAppTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private UserRepository userRepository;

	// @Before
	/**
	 * 初始化数据(添加)
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void initData() {
		userRepository.deleteAll();

		userRepository.save(new User("刘德财", new Date("1993/10/10"), new Date(), "世上无难事"));
		userRepository.save(new User("刘小芳", new Date("1995/10/10"), new Date(), "既然选择远方，那只便风雨兼程"));
		userRepository.save(new User("刘一刀", new Date("1985/11/10"), new Date(), "一般一般，世界第三"));
		userRepository.save(new User("唐琴琴", new Date("1995/11/20"), new Date(), "早起的鸟儿有虫吃"));

	}

	/**
	 * 测试ElasticSearch根据条件查询数据
	 */
	@Test
	public void findDistinctUserByNameContainingOrMottoContaining() {
		Pageable pageable = new PageRequest(0, 10);

		String name = "刘";
		String motto = "世";

		Page<User> userPage = userRepository.findDistinctUserByNameContainingOrMottoContaining(name, motto, pageable);
		assertThat(userPage.getTotalElements()).isEqualTo(3);
		for (User user : userPage.getContent()) {
			System.out.println(user.toString());
		}
		System.out.println("---------------");
		Page<User> userPage2 = userRepository.findDistinctUserByNameContainingAndMottoContaining(name, motto, pageable);
		assertThat(userPage2.getTotalElements()).isEqualTo(2);
		for (User user : userPage2.getContent()) {
			System.out.println(user.toString());
		}
	}

	/**
	 * 测试ElasticSearch更新数据
	 */
	@Test
	public void testUpdate() {
		User user = userRepository.findOne("AWAcnK7NFf2hBMG1wH23");
		System.out.println(user);
		user.setMotto("世上无难事,只怕有心人");
		userRepository.save(user);
		System.out.println(userRepository.findOne("AWAcnK7NFf2hBMG1wH23"));
	}

	/**
	 * 测试ElasticSearch删除数据
	 */
	@Test
	public void testDelete() {
		userRepository.delete("AWAcnK7NFf2hBMG1wH23");
	}

	/**
	 * 测试ElasticSearch添加数据
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void saveUsers() {
		User user1 = new User();
		user1.setName("刘德财");
		user1.setBirthday(new Date(1993, 10, 1));
		user1.setCreatTime(new Date());
		user1.setMotto("天生我材必有用");
		userRepository.save(user1);

		User user2 = new User();
		user2.setName("唐琴琴");
		user2.setBirthday(new Date(1995, 10, 1));
		user2.setCreatTime(new Date());
		user2.setMotto("世上无难事");
		userRepository.save(user2);
	}

}
