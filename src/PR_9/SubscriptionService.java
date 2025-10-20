package PR_9;

import java.util.HashMap;
import java.util.Map;

public class SubscriptionService {
    private Map<String, Boolean> subscription = new HashMap<>();

    public boolean hasSubscription(User user){
        return subscription.getOrDefault(user.getEmail(), false);
    }

    public void activateSubscription(User user){
        subscription.put(user.getEmail(), true);
        System.out.println("Подкписка активирована для пользователя " + user.getUserName());
    }
}
