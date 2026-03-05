package kz.tasks.application.controller;

import kz.tasks.application.db.DbManager;
import kz.tasks.application.entity.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskController {
    @GetMapping(value = "/")
    public String getMain(Model model) {
        model.addAttribute("tasks", DbManager.getTasks());
        return "main";
    }

    @PostMapping(value = "/add-task")
    public String setAddTask(Task task) {
        DbManager.addTask(task);
        return "redirect:/";
    }

    @GetMapping(value = "/details/{id}")
    public String getTask(@PathVariable int id, Model m) {
        m.addAttribute("task", DbManager.getTaskById(id));
        return "details";
    }

    @PostMapping(value = "/update")
    public String updateTask(Task task) {
        DbManager.replaceTask(task);
        return "redirect:/";
    }

    @PostMapping(value = "/delete")
    public String deleteTask(@RequestParam int id) {
        DbManager.deleteTask(id);
        return "redirect:/";
    }

}
