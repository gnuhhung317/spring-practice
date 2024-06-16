package org.example.assignment1.datasource;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PostgreSQLDataSource implements DataSource{
    @Override
    public String[] getEmails() {
        return new String[]{"duahau@gmail.com","phidao@gmail.com","backkhoa@gmail.com"};
    }
}
