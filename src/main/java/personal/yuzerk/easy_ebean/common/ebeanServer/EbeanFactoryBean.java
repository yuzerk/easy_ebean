package personal.yuzerk.easy_ebean.common.ebeanServer;

import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.MatchingNamingConvention;
import io.ebean.config.ServerConfig;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
//import io.ebean.springsupport.txn.SpringAwareJdbcTransactionManager;

/**
 * Spring factory for creating the EbeanServer singleton.
 */
@Component
public class EbeanFactoryBean implements FactoryBean<EbeanServer> {

  
  @Autowired
  DataSource dataSource;
  
  @Override
  public EbeanServer getObject() throws Exception {

    ServerConfig config = new ServerConfig();
    config.setName("db");
    //config.setCurrentUserProvider(currentUser);

//    // set the spring's datasource and transaction manager.
    config.setDataSource(dataSource);
//    config.setExternalTransactionManager(new SpringAwareJdbcTransactionManager());

    //use the loadFromProperties() will get configeration from ebean.properties file
//    config.loadFromProperties();
    config.setNamingConvention(new MatchingNamingConvention());

    // set true means if eq("paramName", null) then sql ignore this condition
    config.setExpressionEqualsWithNullAsNoop(true);

    // set as default and register so that Model can be
    // used if desired for save() and update() etc
    config.setDefaultServer(true);
    config.setRegister(true);

    return EbeanServerFactory.create(config);
  }

  @Override
  public Class<?> getObjectType() {
    return EbeanServer.class;
  }

  @Override
  public boolean isSingleton() {
    return true;
  }
}
