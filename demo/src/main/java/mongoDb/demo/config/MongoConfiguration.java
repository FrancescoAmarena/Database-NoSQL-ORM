package mongoDb.demo.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.Collection;
import java.util.Collections;


@Configuration
public class MongoConfiguration extends AbstractMongoClientConfiguration {
    @Override
    protected Collection<String> getMappingBasePackages() {
        return Collections.singleton("co.develhope");
    }

    @Override
    public MongoClient mongoClient() {
        ConnectionString connectionString=new ConnectionString("mongodb+srv://Francesco:<password>@cluster0.uix4oc8.mongodb.net/?retryWrites=true&w=majority");
        MongoClientSettings mongoClientSettings= MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(mongoClientSettings);
    }

    @Override
    protected String getDatabaseName() {
        return "Develhope";

    }
}
