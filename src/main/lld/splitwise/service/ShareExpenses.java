package main.lld.splitwise.service;

import main.lld.splitwise.model.OwedUser;
import main.lld.splitwise.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

public class ShareExpenses {
    List<User> users;
    Map<User, Map<User, OwedUser>> expensesmap = new HashMap<>();
    UserService userService;

    public ShareExpenses(List<User> users, UserService userService) {
        this.users = users;
        this.userService = userService;
    }

    public void splitEqualExpenses(String username, double totalAmount, List<User> owedUsers) {
        Optional<User> user = userService.getUser(username);
        int totalSharedUsers = owedUsers.size();
        if (user.isPresent()) {
            double shares = totalAmount / totalSharedUsers;
            Map<User, OwedUser> userSpecificMap;
            if (expensesmap.get(user.get()) != null) {
                userSpecificMap = expensesmap.get(user.get());
            } else {
                userSpecificMap = new HashMap<>();
            }

            for (User owedUser : owedUsers) {
                if (expensesmap.get(owedUser) != null && owedUser != user.get()) {
                    double remaining = expensesmap.get(owedUser).get(user.get()).getBalance() - shares;
                    if (remaining > 0) {
                        expensesmap.get(owedUser).get(user.get()).setBalance(remaining);
                    } else if (remaining < 0) {
                        expensesmap.get(owedUser).remove(user.get());
                        OwedUser owedUser1 = new OwedUser(owedUser, Math.abs(remaining));
                        userSpecificMap.put(owedUser, owedUser1);
                    } else {
                        expensesmap.get(owedUser).remove(user.get());
                    }
                } else {
                    if (userSpecificMap.get(owedUser) != null) {
                        double initialBalance = userSpecificMap.get(owedUser).getBalance();
                        userSpecificMap.get(owedUser).setBalance(initialBalance + shares);
                    } else {
                        OwedUser owedUser1 = new OwedUser(owedUser, shares);
                        userSpecificMap.put(owedUser, owedUser1);
                    }
                }
            }
            expensesmap.put(user.get(), userSpecificMap);
        }
    }
    public void splitEXactExpenses(String username, double totalAmount, List<User> owedUsers,Map<User,Double> owedAmountMap){
        Optional<User> user = userService.getUser(username);
        if (user.isPresent()) {
            Map<User, OwedUser> userSpecificMap;
            if (expensesmap.get(user.get()) != null) {
                userSpecificMap = expensesmap.get(user.get());
            } else {
                userSpecificMap = new HashMap<>();
            }

            for (User owedUser : owedUsers) {
                if (expensesmap.get(owedUser) != null && owedUser != user.get()) {
                    double remaining = expensesmap.get(owedUser).get(user.get()).getBalance() - owedAmountMap.get(owedUser);
                    if (remaining > 0) {
                        expensesmap.get(owedUser).get(user.get()).setBalance(remaining);
                    } else if (remaining < 0) {
                        expensesmap.get(owedUser).remove(user.get());
                        OwedUser owedUser1 = new OwedUser(owedUser, Math.abs(remaining));
                        userSpecificMap.put(owedUser, owedUser1);
                    } else {
                        expensesmap.get(owedUser).remove(user.get());
                    }
                } else {
                    if (userSpecificMap.get(owedUser) != null) {
                        double initialBalance = userSpecificMap.get(owedUser).getBalance();
                        userSpecificMap.get(owedUser).setBalance(initialBalance + owedAmountMap.get(owedUser));
                    } else {
                        OwedUser owedUser1 = new OwedUser(owedUser, owedAmountMap.get(owedUser));
                        userSpecificMap.put(owedUser, owedUser1);
                    }
                }
            }
            expensesmap.put(user.get(), userSpecificMap);
        }
    }
    public void splitPercentExpenses(String username, double totalAmount, List<User> owedUsers,Map<User,Double> owedPercentMap){
        Optional<User> user = userService.getUser(username);
        if (user.isPresent()) {
            Map<User, OwedUser> userSpecificMap;
            if (expensesmap.get(user.get()) != null) {
                userSpecificMap = expensesmap.get(user.get());
            } else {
                userSpecificMap = new HashMap<>();
            }

            for (User owedUser : owedUsers) {
                if (expensesmap.get(owedUser) != null && owedUser != user.get()) {
                    double remaining = expensesmap.get(owedUser).get(user.get()).getBalance() - getPercentageAmount(totalAmount,owedPercentMap.get(owedUser));
                    if (remaining > 0) {
                        expensesmap.get(owedUser).get(user.get()).setBalance(remaining);
                    } else if (remaining < 0) {
                        expensesmap.get(owedUser).remove(user.get());
                        OwedUser owedUser1 = new OwedUser(owedUser, Math.abs(remaining));
                        userSpecificMap.put(owedUser, owedUser1);
                    } else {
                        expensesmap.get(owedUser).remove(user.get());
                    }
                } else {
                    if (userSpecificMap.get(owedUser) != null) {
                        double initialBalance = userSpecificMap.get(owedUser).getBalance();
                        userSpecificMap.get(owedUser).setBalance(initialBalance + getPercentageAmount(totalAmount,owedPercentMap.get(owedUser)));
                    } else {
                        OwedUser owedUser1 = new OwedUser(owedUser, getPercentageAmount(totalAmount,owedPercentMap.get(owedUser)));
                        userSpecificMap.put(owedUser, owedUser1);
                    }
                }
            }
            expensesmap.put(user.get(), userSpecificMap);
        }
    }

    private double getPercentageAmount(double totalAmount, Double percent) {
        return (percent*totalAmount/100);
    }

    public void showExpenses(String username){
        if(username.isEmpty() && expensesmap.size() ==0){
            System.out.println("NO Balance");
            return;
        } else if (username.isEmpty()) {
            showAllUsersData();
            return;
        }
        AtomicBoolean isUserHasData = new AtomicBoolean(false);
        Optional<User> showUser = userService.getUser(username);
        if(showUser.isPresent()){
            //Expenses for you statements
            if(expensesmap.get(showUser.get())!= null){
                Map<User,OwedUser> owedUsers = expensesmap.get(showUser.get());
                for (Map.Entry<User,OwedUser> entry: owedUsers.entrySet()) {
                    isUserHasData.set(true);
                    if(!entry.getKey().getUserName().equals(showUser.get().getUserName())){
                        System.out.println(entry.getKey().getUserName() + " Owes "+showUser.get().getUserName()+ " : "+entry.getValue().getBalance());
                    }
                }
            }

            // I am responsible to pay
            users.forEach(user -> {
                if(expensesmap.get(user) != null && user != showUser.get()){
                    expensesmap.get(user).forEach(((user1, owedUser) -> {
                        if(user1.getUserName().equals(showUser.get().getUserName()) || user1.getUserName().equals(owedUser.getUser().getUserName())){
                            isUserHasData.set(true);
                            System.out.println(owedUser.getUser().getUserName() + " Owes "+user.getUserName()+ " : "+owedUser.getBalance());
                        }
                    }));
                }
            });
            if(!isUserHasData.get()){
                System.out.println("No Balance");
            }
            isUserHasData.set(false);
        }else {
            System.out.println("NO User");
        }
    }

    private void showAllUsersData() {
        users.forEach(user -> {
            if(expensesmap.get(user) != null){
                expensesmap.get(user).forEach(
                        (user1,owedUser)->{
                            if(!owedUser.getUser().getUserName().equals(user.getUserName())){
                                System.out.println(owedUser.getUser().getUserName() + " owes "+user.getUserName() + " : "+owedUser.getBalance());
                            }
                        }
                );
            }
        });
    }
}
