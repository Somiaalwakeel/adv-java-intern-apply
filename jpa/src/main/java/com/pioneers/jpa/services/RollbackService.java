package com.pioneers.jpa.services;

import com.pioneers.jpa.repositories.rollback.RollbackDao;
import liquibase.exception.LiquibaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class RollbackService {

    private final RollbackDao rollbackDao;

    public void rollback(final int steps) throws SQLException, LiquibaseException {
        rollbackDao.rollback(steps);
    }
}
