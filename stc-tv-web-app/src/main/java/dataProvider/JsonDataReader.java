package dataProvider;

import com.google.gson.Gson;
import managers.FileReaderManager;
import testDataTypes.Subscription;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JsonDataReader {
    private final String plansFilePath = FileReaderManager.getInstance().getConfigFileReader().getTestDataResourcePath() + "SubscriptionInfo.json";
    private List<Subscription> subscriptions;

    public JsonDataReader() {
        subscriptions = getPlans();
    }

    private List<Subscription> getPlans() {
        Gson gson = new Gson();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(plansFilePath));
            Subscription[] subscriptionSubscriptions = gson.fromJson(bufferedReader, Subscription[].class);
            return Arrays.asList(subscriptionSubscriptions);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Json file not found at path : " + plansFilePath);
        } finally {
            try {
                if (bufferedReader != null) bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Subscription> getSubscriptionPlans() {
        return subscriptions;
    }
}
