package testDataTypes;

import java.util.List;

public class Plan {
    public String country;
    public List<SubscriptionPlan> subscriptionPlans;
    public String planCurrency;


    public class SubscriptionPlan {
        public String title;
        public int price;
    }

}
