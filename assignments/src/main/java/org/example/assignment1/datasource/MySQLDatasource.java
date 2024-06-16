package org.example.assignment1.datasource;

import org.springframework.stereotype.Component;

@Component
public class MySQLDatasource implements DataSource{
    @Override
    public String[] getEmails() {
        return new String[]{"duchung@gmail.com","thimai@gmail.com","gangbang@gmail.com"};
    }
}
