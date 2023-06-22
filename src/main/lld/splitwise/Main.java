package main.lld.splitwise;

import main.lld.splitwise.constant.ExpenseType;
import main.lld.splitwise.constant.Type;
import main.lld.splitwise.model.User;
import main.lld.splitwise.service.ShareExpenses;
import main.lld.splitwise.service.UserService;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Input Sample Users
        User user1 = new User(1, "u1","u1@gmail.com","9890098900");
        User user2 = new User(2, "u2","u2@gmail.com","9999999999");
        User user3 = new User(3, "u3","u3@gmail.com","9898989899");
        User user4 = new User(4, "u4","u4@gmail.com","8976478292");

        List<User> users = new ArrayList<>(Arrays.asList(user1,user2,user3,user4));
        //Adding Expenses

        UserService userService = new UserService(users);
        ShareExpenses shareExpenses = new ShareExpenses(users,userService);

        while (true){
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter Type");
            Type type = Type.of(scan.nextLine());

            switch (type){
                case EXPENSE:
                    System.out.println("Enter Username");
                    String user = scan.nextLine();
                    System.out.println("Enter amountSpend");
                    int amountSpend = scan.nextInt();
                    System.out.println("Enter totalMembers");
                    double totalMembers = scan.nextDouble();
                    List<User> owedUsers = new ArrayList<>();
                    for (int i = 0; i < totalMembers; i++) {
                        System.out.println("Enter owed Username");
                        owedUsers.add(userService.getUser(scan.next()).get());
                    }
                    System.out.println("Enter ExpenseType");
                    ExpenseType expenseType = ExpenseType.of(scan.next());
                    switch (expenseType){
                        case EQUAL:
                            shareExpenses.splitEqualExpenses(user,amountSpend,owedUsers);
                            break;
                        case EXACT:
                            Map<User,Double> owedAmountMap = new HashMap<>();
                            double sum = 0;
                            for (int i = 0; i <totalMembers ; i++) {
                                System.out.println("Enter Amount");
                                double amount = scan.nextDouble();
                                sum+= amount;
                                owedAmountMap.put(owedUsers.get(i),amount);
                            }
                            if(sum != amountSpend){
                                System.out.println("Sum not Matched to actual split amount");
                                break;
                            }
                            shareExpenses.splitEXactExpenses(user,amountSpend,owedUsers,owedAmountMap);
                            break;
                        case PERCENT:
                            Map<User,Double> owedPercentageMap = new HashMap<>();
                            double totalPercent = 0;
                            for (int i = 0; i <totalMembers ; i++) {
                                System.out.println("Enter percent");
                                double percent = scan.nextDouble();
                                totalPercent+=percent;
                                owedPercentageMap.put(owedUsers.get(i),percent);
                            }
                            if(100 != totalPercent){
                                System.out.println("Sum Percetage not Matched to 100");
                                break;
                            }
                            shareExpenses.splitPercentExpenses(user,amountSpend,owedUsers,owedPercentageMap);
                            break;
                    }
                    break;
                case SHOW:
                    System.out.println("Enter username");
                    String username = scan.nextLine();
                    shareExpenses.showExpenses(username);
                    break;
                case QUIT:
                    System.out.println("Quiting");
                    return;
                default:
                    System.out.println("No Expected Argument Found");
                    break;


            }
        }
    }
}
