package bandrefilipe.brewer.web.config;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import static java.lang.Math.max;
import static java.util.Optional.ofNullable;

/**
 * Binds custom configuration properties.
 */
@Data
@Configuration
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@ConfigurationProperties(prefix = "app.async.task.executor")
class AsyncTaskExecutorProperties {

    private int corePoolSize;
    private int maxPoolSize;
    private int queueCapacity;
    private String threadNamePrefix;

    /**
     * Property: {@code app.sync.task.executor.corePoolSize}<p>
     * Default: {@code 1}
     */
    public final int getCorePoolSize() {
        return max(corePoolSize, 1);
    }

    /**
     * Property: {@code app.sync.task.executor.maxPoolSize}<p>
     * Default: {@link AsyncTaskExecutorProperties#getCorePoolSize()}
     */
    public final int getMaxPoolSize() {
        return max(maxPoolSize, getCorePoolSize());
    }

    /**
     * Property: {@code app.sync.task.executor.queueCapacity}<p>
     * Default: {@link Integer#MAX_VALUE}
     */
    public final int getQueueCapacity() {
        return queueCapacity != 0
                ? queueCapacity
                : Integer.MAX_VALUE;
    }

    /**
     * Property: {@code app.sync.task.executor.threadNamePrefix}<p>
     * Default: "{@code SimpleAsyncTaskExecutor-}"
     */
    public final String getThreadNamePrefix() {
        return ofNullable(threadNamePrefix)
                .orElse("SimpleAsyncTaskExecutor-");
    }
}
