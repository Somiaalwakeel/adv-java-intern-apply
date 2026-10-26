package com.pioneers.jpa.controllers;

import com.pioneers.jpa.services.RollbackService;
import liquibase.exception.LiquibaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequiredArgsConstructor
@RequestMapping("liquibase")
public class RollbackController {

    private final RollbackService rollbackService;

    @PostMapping("rollback")
    public void rollback(@RequestParam final int steps) throws SQLException, LiquibaseException {
        rollbackService.rollback(steps);
    }
}
