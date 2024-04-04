package jlin2.examples.localtesting;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class EmailValidatorTest {


    @Test
    public void testValidEmail() {
        assertTrue(EmailValidator.Companion.isValidEmail("neha@vaidya.com"));
        assertTrue(EmailValidator.Companion.isValidEmail("22@viranch.co.ca"));
        assertTrue(EmailValidator.Companion.isValidEmail("nehavaidya@viranch.com"));
        assertTrue(EmailValidator.Companion.isValidEmail("n_pandya261091@fanshaweonline.ca"));
    }


}

