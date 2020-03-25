package bandrefilipe.brewer.web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * The @{@linkplain EnableAsync} annotation switches on Spring’s ability to run @{@linkplain Async}
 * methods in a background thread pool. This class also customizes the {@link Executor} by defining
 * a new bean. Here, the method is named {@code taskExecutor}, since this is the specific method
 * name for which Spring searches.
 */
@Slf4j
@EnableAsync
@Configuration
class AsyncConfig {

    private final int corePoolSize;
    private final int maxPoolSize;
    private final int queueCapacity;
    private final String threadNamePrefix;

    @Autowired
    AsyncConfig(final AsyncTaskExecutorProperties properties) {
        super();
        corePoolSize = properties.getCorePoolSize();
        maxPoolSize = properties.getMaxPoolSize();
        queueCapacity = properties.getQueueCapacity();
        threadNamePrefix = properties.getThreadNamePrefix();
    }

    @Bean
    Executor taskExecutor() {
        log.debug("Creating bean taskExecutor with corePoolSize={}, maxPoolSize={}, queueCapacity={}, threadNamePrefix={}",
                corePoolSize, maxPoolSize, queueCapacity, threadNamePrefix);
        final var executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix(threadNamePrefix);
        executor.initialize();
        return executor;
    }
}
