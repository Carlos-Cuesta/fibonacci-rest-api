package software.actionware.fibonacci;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import java.util.logging.Logger;

import static org.springframework.http.HttpHeaders.ACCEPT_ENCODING;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FibonacciApplicationTests {

	private static final String FIBONACCI_100 = "354224848179261915075";
	private static final Logger LOGGER = Logger.getLogger(FibonacciApplicationTests.class.getName());

	@Autowired
	private MockMvc mockMvc;


	/**
	 * Test of getFibonacciPosition method of class FibonacciController with position = 100
	 * Result must be FIBONACCI_100
	 */
	@Test
	public void testGetFibonacciPosition_100() throws Exception {
		LOGGER.finest("Starting test");
		this.mockMvc.perform(
				get("/fibonacci/100").header(ACCEPT_ENCODING, APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value(HttpStatus.OK.value()))
				.andExpect(jsonPath("$.result").value(FIBONACCI_100));
		LOGGER.finest("Finished test");
	}

	/**
	 * Test of getFibonacciPosition method of class FibonacciController with negative position
	 */
	@Test
	public void testGetFibonacciPosition_Negative() throws Exception {
		LOGGER.finest("Starting test");
		this.mockMvc.perform(
				get("/fibonacci/-1").header(ACCEPT_ENCODING, APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.status").value(HttpStatus.BAD_REQUEST.value()));
		LOGGER.finest("Finished test");
	}

	/**
	 * Test of getFibonacciPosition method of class FibonacciController with invalid position
	 */
	@Test
	public void testGetFibonacciPosition_invalidInteger() throws Exception {
		LOGGER.finest("Starting test");
		this.mockMvc.perform(
				get("/fibonacci/abcd").header(ACCEPT_ENCODING, APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.status").value(HttpStatus.BAD_REQUEST.value()));
		LOGGER.finest("Finished test");
	}

	/**
	 * Test of getFibonacciPosition method of class FibonacciController without path parameter position
	 */
	@Test
	public void testGetFibonacciPosition_invalidPath() throws Exception {
		LOGGER.finest("Starting test");
		this.mockMvc.perform(
				get("/fibonacci/").header(ACCEPT_ENCODING, APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isNotFound())
				.andExpect(jsonPath("$.status").value(HttpStatus.NOT_FOUND.value()));
		LOGGER.finest("Finished test");
	}


}
