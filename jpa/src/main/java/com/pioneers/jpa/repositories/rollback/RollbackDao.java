package com.pioneers.jpa.repositories.rollback;

import liquibase.exception.LiquibaseException;

import java.sql.SQLException;

public interface RollbackDao {

    void rollback(int steps) throws SQLException, LiquibaseException;
}
