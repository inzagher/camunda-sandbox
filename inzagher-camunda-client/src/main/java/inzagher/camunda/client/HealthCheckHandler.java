package inzagher.camunda.client;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ExternalTaskSubscription("HealthCheckRequest")
public class HealthCheckHandler implements ExternalTaskHandler {
    @Override
    public void execute(ExternalTask task, ExternalTaskService service) {
        log.info("Health check succeeded");
        service.complete(task);
    }
}
