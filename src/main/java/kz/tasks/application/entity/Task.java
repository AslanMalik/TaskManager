package kz.tasks.application.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Task {
    private int id;
    private String name;
    private Date deadlineDate;
    private boolean isCompleted;
}
