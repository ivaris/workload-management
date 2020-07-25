package com.wawa;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.spi.JdbiPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;
import javax.swing.tree.RowMapper;
import java.util.List;

@Configuration
public class H2Config {
    private static final Logger log = LoggerFactory.getLogger(H2Config.class);
    private final Environment props;

    @Autowired
    H2Config(Environment props) {
        this.props = props;
    }

    @Bean("dataSource")
    public DataSource dataSource() {
        log.info("connecting to aurora database {}", props.getProperty("h2.db.url"));
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(props.getProperty("h2.db.driver"));
        hikariConfig.setJdbcUrl(props.getProperty("h2.db.url"));
        hikariConfig.setUsername(props.getProperty("h2.db.username"));
        hikariConfig.setPassword(props.getProperty("h2.db.password"));
        hikariConfig.setPoolName("h2.db.workflow-management");
        hikariConfig.setMaximumPoolSize(props.getProperty("h2.db.pool-size", Integer.class));

        return new HikariDataSource(hikariConfig);
    }

    @Bean("jdbi")
    public Jdbi jdbi() {
        Jdbi jdbi = Jdbi.create(dataSource());
        jdbi.installPlugin(new SqlObjectPlugin());
        return jdbi;
    }

}
