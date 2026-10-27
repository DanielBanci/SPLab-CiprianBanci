package com.example.crc;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class CommandExecutor {
    private final ExecutorService threadPool = Executors.newFixedThreadPool(4);
    private final Map<String, AsyncTaskStatus> taskStatusMap = new HashMap<>();

    public static class AsyncTaskStatus{
        private final String status;
        private final Object result;

        public AsyncTaskStatus(String status, Object result) {
            this.status = status;
            this.result = result;
        }

        public String getStatus() {
            return status;
        }

        public Object getResult() {
            return result;
        }
    }

    // sync
    public <T> T execute(Command<T> command){
        return command.execute();
    }

    // async
    public <T> String executeAsync(Command<T> command){
        String taskId = UUID.randomUUID().toString();
        taskStatusMap.put(taskId, new AsyncTaskStatus("Pending", null));

        threadPool.submit(() -> {
            try {
                T result = command.execute();
                taskStatusMap.put(taskId, new AsyncTaskStatus("Completed", result));
            } catch (Exception e) {
                taskStatusMap.put(taskId, new AsyncTaskStatus("Failed", e.getMessage()));
            }
        });

        return taskId;
    }

    public AsyncTaskStatus getTaskStatus(String taskId){
        return taskStatusMap.get(taskId);
    }
}
