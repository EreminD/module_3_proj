package ru.inno.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.inno.utils.StringUtils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringUtilTest {
    private StringUtils utils;

    @BeforeEach
    public void setUp(){
        utils = new StringUtils();
    }

    @Test
    public void emailContainsAt(){
        assertTrue(utils.isEmail("test@mail.ru"));
    }

    @Test
    public void emailDoesNotContainAt(){
        assertFalse(utils.isEmail("testmail.ru"));
    }

    @Test
    public void shouldContainDomain(){
        assertFalse(utils.isEmail("test@mailru"));
    }

    @Test
    public void shouldContainTextBeforeAt(){
        assertFalse(utils.isEmail("@mail.ru"));
    }

    @Test
    public void emailIfContainsLettersDigitsAtDomain(){
        assertTrue(utils.isEmail("test123456@mail565432.com"));
    }

    @Test
    public void final1Check(){
        assertTrue(utils.isEmail("sergey.tarasov@mail.ru"));
    }

    @Test
    public void final2Check(){
        assertFalse(utils.isEmail("oxana@mail.ru@mail.ru"));
    }

    @Test
    public void final3Check(){
        assertFalse(utils.isEmail("oxana emelina@mail.ru"));
    }
}
