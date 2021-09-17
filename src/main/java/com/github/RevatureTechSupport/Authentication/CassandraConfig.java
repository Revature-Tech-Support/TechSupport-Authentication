package com.github.RevatureTechSupport.Authentication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;

import java.util.List;

@EnableReactiveCassandraRepositories
@Configuration
@PropertySource("classpath:application.properties")
public class CassandraConfig extends AbstractReactiveCassandraConfiguration {

  @Value("${cassandra.contactpoint}")
  private String contactPoint;

  @Value("${cassandra.keyspace}")
  private String keyspace;

  @Override
  protected String getKeyspaceName() {
    return keyspace;
  }

  public String[] getEntityBasePackage() {
    return new String[] {"com.github.TechSupport.Authentication.domain"};
  }

  @Override
  protected String getContactPoints() {
    return contactPoint;
  }

  @Override
  public SchemaAction getSchemaAction() {
    return SchemaAction.CREATE_IF_NOT_EXISTS;
  }

  @Override
  protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
    CreateKeyspaceSpecification specification =
        CreateKeyspaceSpecification.createKeyspace(keyspace)
            .ifNotExists()
            .with(KeyspaceOption.DURABLE_WRITES, true);
    return List.of(specification);
  }
}
