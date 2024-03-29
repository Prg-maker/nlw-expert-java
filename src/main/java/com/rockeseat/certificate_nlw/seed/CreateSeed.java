package com.rockeseat.certificate_nlw.seed;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class CreateSeed {
    private final JdbcTemplate jdbcTemplate;
    
    CreateSeed(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5434/pg_nlw");

        dataSource.setUsername("admin");
        dataSource.setPassword("admin");
        
        CreateSeed createSeed = new CreateSeed(dataSource);
        createSeed.run(args);
    }

    private void run (String... args){
        executeSqlFile("src/main/resources/create.sql");
    }

    private void executeSqlFile(String filePath){
        try{
            String sqlScript = new String(Files.readAllBytes(Paths.get(filePath)));
            jdbcTemplate.execute(sqlScript);

            System.out.println("Seed has by created");
        }catch(IOException e){
            System.err.println("Error ao executar o arquivo" + e.getMessage());
        }
    }

    
}
