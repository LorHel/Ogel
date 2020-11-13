package com.lorance.test.config;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@SpringJUnitConfig(TestDBConfiguration.class)
@RunWith(SpringRunner.class)
public class DBConfigurationTest {

    @Autowired DataSource dataSource;
    @Test
    public void testDbConfiguration() {
        assertNotNull(dataSource);
    }
}