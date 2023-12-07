package org.jpa.app.relationalMappings.one_to_many.unidirectional.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.SharedCacheMode;
import jakarta.persistence.ValidationMode;
import jakarta.persistence.spi.ClassTransformer;
import jakarta.persistence.spi.PersistenceUnitInfo;
import jakarta.persistence.spi.PersistenceUnitTransactionType;

import javax.sql.DataSource;
import java.net.URL;
import java.util.List;
import java.util.Properties;

public class CustomPersistenceUnitInfo implements PersistenceUnitInfo {

    private final String persistenceUnitName;
    @Override
    public String getPersistenceUnitName() {
        return persistenceUnitName;
    }

    @Override
    public String getPersistenceProviderClassName() {
        return "org.hibernate.jpa.HibernatePersistenceProvider";
    }

    @Override
    public PersistenceUnitTransactionType getTransactionType() {
        return PersistenceUnitTransactionType.RESOURCE_LOCAL;
    }

    public CustomPersistenceUnitInfo(String persistenceUnitName) {
        this.persistenceUnitName = persistenceUnitName;
    }

    @Override
    public DataSource getJtaDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost/postgres?useSSL=false");
        config.setDriverClassName("org.postgresql.Driver");
        config.setUsername("postgres");
        config.setPassword("root");
        config.setMaximumPoolSize(20);

        HikariDataSource dataSource = new HikariDataSource(config);
        return dataSource;
    }

    @Override
    public DataSource getNonJtaDataSource() {
        return null;
    }

    @Override
    public List<String> getMappingFileNames() {
        return null;
    }

    @Override
    public List<URL> getJarFileUrls() {
        return null;
    }

    @Override
    public URL getPersistenceUnitRootUrl() {
        return null;
    }

    @Override
    public List<String> getManagedClassNames() {
        return List.of("org.jpa.app.relationalMappings.one_to_many.unidirectional.Company", "org.jpa.app.relationalMappings.one_to_many.unidirectional.Department");
    }

    @Override
    public boolean excludeUnlistedClasses() {
        return true;
    }

    @Override
    public SharedCacheMode getSharedCacheMode() {
        return SharedCacheMode.ENABLE_SELECTIVE;
    }

    @Override
    public ValidationMode getValidationMode() {
        return null;
    }

    @Override
    public Properties getProperties() {
        Properties props = new Properties();
        props.setProperty("jakarta.persistence.schema-generation.database.action", "drop-and-create");
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("hibernate.format_sql", "true");
        return props;
    }

    @Override
    public String getPersistenceXMLSchemaVersion() {
        return null;
    }

    @Override
    public ClassLoader getClassLoader() {
        return null;
    }

    @Override
    public void addTransformer(ClassTransformer transformer) {

    }

    @Override
    public ClassLoader getNewTempClassLoader() {
        return null;
    }
}
