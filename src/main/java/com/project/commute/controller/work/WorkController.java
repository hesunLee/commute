package com.project.commute.controller.work;

import com.project.commute.dto.work.request.CreateWorkHistoryRequest;
import com.project.commute.dto.work.request.UpdateWorkHistoryRequest;
import com.project.commute.service.work.WorkService;
import org.hibernate.sql.Update;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class WorkController {

    private final WorkService workService;

    public WorkController(WorkService workService) {
        this.workService = workService;
    }

    @PostMapping("/work")
    public void saveWorkHistory(@RequestBody CreateWorkHistoryRequest request) {
        workService.saveWorkHistory(request);
    }

    @PutMapping("/work")
    public void updateWorkHistory(@RequestBody UpdateWorkHistoryRequest request) {
        workService.updateWorkHistory(request);
    }

    @GetMapping("/work")
    public void getWorkHistory(@RequestParam long memberId) {

    }
}
