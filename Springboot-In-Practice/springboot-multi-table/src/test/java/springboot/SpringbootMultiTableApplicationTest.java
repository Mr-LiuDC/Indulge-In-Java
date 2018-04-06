package springboot;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * SpringbootMultiTableApplicationTests
 * 
 * @author LiuDeCai
 * @date 2018/04/06
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMultiTableApplicationTest {

	@Autowired
	private WebApplicationContext context;
	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		// 构造MockMvc
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void testLazyLoad() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/api/comment").accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.page.content.length()").value(3))
				.andExpect(jsonPath("$.page.content[1].content").value("四海为家"));
	}

}
