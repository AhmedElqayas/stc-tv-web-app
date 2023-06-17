package dataProvider;

import com.google.gson.Gson;
import managers.FileReaderManager;
import testDataTypes.Plan;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JsonDataReader {
    private final String plansFilePath = FileReaderManager.getInstance().getConfigFileReader().getTestDataResourcePath() + "Plans.json";
    private List<Plan> plans;

    public JsonDataReader() {
        plans = getPlans();
    }

    private List<Plan> getPlans() {
        Gson gson = new Gson();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(plansFilePath));
            Plan[] subscriptionPlans = gson.fromJson(bufferedReader, Plan[].class);
            return Arrays.asList(subscriptionPlans);
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

    public List<Plan> getSubscriptionPlans() {
        return plans;
    }
}
