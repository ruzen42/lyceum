package org.jdev.jvm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.jdev.jvm.config.AsyncSyncConfiguration;
import org.jdev.jvm.config.DatabaseTestcontainer;
import org.jdev.jvm.config.JacksonConfiguration;
import org.jdev.jvm.config.RedisTestContainer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.context.ImportTestcontainers;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(
    classes = {
        LyceumApp.class, JacksonConfiguration.class, AsyncSyncConfiguration.class, org.jdev.jvm.config.JacksonHibernateConfiguration.class,
    }
)
@ImportTestcontainers({ DatabaseTestcontainer.class, RedisTestContainer.class })
public @interface IntegrationTest {}
