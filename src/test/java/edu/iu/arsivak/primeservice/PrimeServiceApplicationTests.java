package edu.iu.arsivak.primeservice;

import edu.iu.arsivak.primeservice.service.PrimesServices;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PrimeServiceApplicationTests {

	PrimesServices primesServices = new PrimesServices();

	@Test
	void _14IsNotPrime() {
		int n = 45;
		boolean expected = false;
		boolean actual = primesServices.isPrime(n);
		assertEquals(expected,actual);
	}

}
