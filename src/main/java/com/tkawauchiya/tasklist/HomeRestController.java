package com.tkawauchiya.tasklist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class HomeRestController {
    record TaskItem(String id, String task, String deadline, boolean done){}

    private List<TaskItem> taskItems = new ArrayList<>();

    @GetMapping("/restadd")
    String addItem(@RequestParam("task") String task,
                   @RequestParam("deadline") String deadline) {
        String id = UUID.randomUUID().toString().substring(0, 8);
        TaskItem item = new TaskItem(id, task, deadline, false);
        taskItems.add(item);

        return "a task added!";
    }


    @RequestMapping(value = "/resthello")
    String hello() {
        return """
                Hello.
                It works!
                The datetime is %s now.""".formatted(LocalDateTime.now());
    }
}
