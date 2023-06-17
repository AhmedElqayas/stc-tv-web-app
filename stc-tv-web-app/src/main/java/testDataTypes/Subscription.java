package testDataTypes;

import java.util.List;

public class Subscription {
    public String country;
    public List<SubscriptionPlan> subscriptionPlans;
    public String planCurrency;


    public class SubscriptionPlan {
        public String planTitle;
        public String planPrice;
    }

}
