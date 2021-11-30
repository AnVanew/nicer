package dbworker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class DbWorker {

    private Connection getConnection(){
        try {
            Class.forName("org.h2.Driver");
            Connection connection = DriverManager.getConnection("jdbc:h2:/home/naicinfa/prog/nicer/db/naicdb",
                                                            "admin", "admin");
            return connection;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public <T> T executeQueryGet(String queryString, ThrowableConsumer<PreparedStatement> consumer, ResultSetConsumer<T> resultSetConsumer) {
        ResultSet resultSet;
        T t = null;
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(queryString);
            consumer.consume(statement);
            resultSet = statement.executeQuery();
            if (resultSet.next()) t = resultSetConsumer.consume(resultSet);
        } catch (Exception e)  {
            throw new RuntimeException(e);
        }
        return t;
    }

    public int executeQueryUpdate(String queryString, ThrowableConsumer<PreparedStatement> consumer) {
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(queryString);
            consumer.consume(statement);
            return statement.executeUpdate();
        } catch (Exception e)  {
            throw new RuntimeException(e);
        }
    }

    @FunctionalInterface
    public interface ThrowableConsumer <T> {
        void consume(T t) throws Exception;
    }

    @FunctionalInterface
    public  interface ResultSetConsumer <T> {
        T consume(ResultSet resultSet) throws Exception;
    }
}
