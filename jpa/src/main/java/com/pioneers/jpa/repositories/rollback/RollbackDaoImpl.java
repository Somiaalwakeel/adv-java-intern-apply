package com.pioneers.jpa.repositories.rollback;

import liquibase.Contexts;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;

@Repository
@RequiredArgsConstructor
public class RollbackDaoImpl implements RollbackDao {

    private final DataSource dataSource;

    @Override
    public void rollback(final int steps) throws SQLException, LiquibaseException {

        final Database database = DatabaseFactory.getInstance()
                .findCorrectDatabaseImplementation(new JdbcConnection(dataSource.getConnection()));

        final Liquibase liquibase
                = new Liquibase("db/changelog-master.xml", new ClassLoaderResourceAccessor(), database);

        liquibase.rollback(steps - 1, String.valueOf(new Contexts()));
    }
}
