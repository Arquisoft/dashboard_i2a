package dashboard;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MainControllerTest {

	@LocalServerPort
	private int port;

    @Autowired
	private TestRestTemplate template;

	private URL base;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port);
	}

	@Test
	public void getLanding() throws Exception {
		String userURI = base.toString() + "/user";  
		ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
		assertThat(response.getBody(), containsString("Hola"));
	}
	
	@Test
	public void getUser() throws Exception {
		String userURI = base.toString() + "/user";  
		ResponseEntity<String> response = template.getForEntity(userURI, String.class);
		UserInfo expected = new UserInfo("pepe",0);
	}

}