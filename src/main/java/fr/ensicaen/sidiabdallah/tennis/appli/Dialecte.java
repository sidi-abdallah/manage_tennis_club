package fr.ensicaen.sidiabdallah.tennis.appli;

import org.hibernate.dialect.PostgreSQL9Dialect;
import org.hibernate.engine.jdbc.env.spi.NameQualifierSupport;

public class Dialecte extends PostgreSQL9Dialect {
    @Override
    public String getTableTypeString() {
        return super.getTableTypeString() + " DEFAULT CHARSET=utf8";
    }

    @Override
    public NameQualifierSupport getNameQualifierSupport() {
        return NameQualifierSupport.NONE;
    }
}
