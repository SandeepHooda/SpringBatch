package sandeep.SpringBatch.config;

import javax.sql.DataSource;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sandeep.SpringBatch.vo.Employee;

@Configuration
public class Context {
	
	@Bean
	public  JdbcBatchItemWriter<Employee> empWriter(final DataSource dataSource) {
		
		return new JdbcBatchItemWriterBuilder<Employee>()
        .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
        .sql("INSERT INTO Employee (NAME, EMAIL_ADDRESS, PURCHASED_PACKAGE) VALUES (:name, :emailAddress, :purchasedPackage)")
        .dataSource(dataSource)
        .build();
		
	}

}
