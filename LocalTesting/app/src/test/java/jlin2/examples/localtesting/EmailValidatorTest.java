package jlin2.examples.localtesting;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EmailValidatorTest {


    @Test
    public void testValidEmail() {
        assertTrue(EmailValidator.Companion.isValidEmail("neha@vaidya.com"));
        assertTrue(EmailValidator.Companion.isValidEmail("22@viranch.co.ca"));
        assertTrue(EmailValidator.Companion.isValidEmail("nehavaidya@viranch.com"));
        assertTrue(EmailValidator.Companion.isValidEmail("n_pandya261091@fanshaweonline.ca"));
        assertTrue(EmailValidator.Companion.isValidEmail("username@domain.com"));
    }

    @Test
    public void testInvalidEmail() {
        assertFalse(EmailValidator.Companion.isValidEmail("88@abc"));
        assertFalse(EmailValidator.Companion.isValidEmail(""));
        assertFalse(EmailValidator.Companion.isValidEmail(null));
        assertFalse(EmailValidator.Companion.isValidEmail("username@abc..com"));
        assertFalse(EmailValidator.Companion.isValidEmail("@fanshawe.com"));
        assertFalse(EmailValidator.Companion.isValidEmail("username123"));
    }
}

