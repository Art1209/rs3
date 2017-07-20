package rs3.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class HibernateConfigMysql {
    @Bean
    LocalSessionFactoryBean hibernateSessionFactory(DataSource dataSource){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("rs3.persistence.entity");
        sessionFactory.setHibernateProperties(additionalProperties());
        return sessionFactory;
    }

    @Bean
    HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/testdb");
        dataSource.setUsername("user");
        dataSource.setPassword("4251");
        return dataSource;
    }
//todo пропертис не корректны
    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.setProperty("hibernate.hbm2ddl.auto", "update"); // Auto table creation during SessionFactory creates
        return properties;
    }
//    @Bean
//    public DepartmentService getDepService(){
//        return new DepartmentDaoServiceImpl();
//    }
//
//    @Bean
//    public DepartmentDaoInterface getDeartmentDao(){
//        return new DepartmentDao();
//    }
//
//    @Bean
//    public EmployeeService getEmployeeService(){
//        return new EmployeeDaoService();
//    }
//
//    @Bean
//    public EmployeeDaoInterface getEmployeeDao(){
//        return new EmployeeDao();
//    }

}
