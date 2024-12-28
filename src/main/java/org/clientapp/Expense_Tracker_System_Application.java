package org.clientapp;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.model.BudgetModel;
import org.model.CategoryModel;
import org.model.ExpenseModel;
import org.model.UserModel;
import org.service.BudgetService;
import org.service.BudgetServiceImpl;
import org.service.CategoryService;
import org.service.CategoryServiceImpl;
import org.service.CurrentUser_Id;
import org.service.ExpenseService;
import org.service.ExpenseServiceImpl;
import org.service.ReportService;
import org.service.ReportServiceImpl;
import org.service.UserService;
import org.service.UserServiceImpl;


public class Expense_Tracker_System_Application {  //main Class 

	 
	
	private static final Logger logger = LogManager.getLogger(Expense_Tracker_System_Application.class);

	

	public static void main(String[] args) {	
		logger.info("Main Method Start");
	
		Scanner sc = new Scanner(System.in);
		
		UserService uservice = new UserServiceImpl();
		ExpenseService eservice = new ExpenseServiceImpl();
		CategoryService cservice = new CategoryServiceImpl();
		BudgetService bservice = new BudgetServiceImpl();
		ReportService rservice = new ReportServiceImpl();
		System.out.println("======= WELCOME TO EXPENSE TRACKER SYSTEM =======");
		System.out.println("Do you have account? ");
		String yes = sc.nextLine();
		
		if (yes.equalsIgnoreCase("no")) {
			System.out.println("Enete User Name");
			String userName = sc.nextLine();

			System.out.println("Enter Password:");
			String passWord = sc.nextLine();
			System.out.println("Enter Email:");
			String email = sc.nextLine();

			System.out.println("Enter Phone Number:");
			String p_number = sc.nextLine();

			System.out.println("Enter Address");
			String address = sc.nextLine();

			System.out.println(uservice.isAddNewUser(new UserModel(0, userName, passWord, email, p_number, address))
					? "User added successfully......"
					: "User NOT added successfully......");

		}

		System.out.println("Now you can login.............");
		System.out.println("Enter UserName");

		String userName = sc.nextLine();

		System.out.println("Enter PassWord");
		String passWord = sc.nextLine();
		boolean b = uservice.UserLoginByNamePassWard(userName, passWord);
		if (b) {
			System.out.println("Login successfully.....");
			int userId = uservice.getUserIdByUserName(userName);
			CurrentUser_Id.setUser_Id(userId);
			 float Total_Expense = eservice.getTotalExpensesByUserId(userId);

			System.out.println("Logged-in User ID: " + userId);
			do {
				System.out.println("-------------------------------------------");
				System.out.println("1:Insert into UserMaster");
				System.out.println("2:Get All User");
				System.out.println("3:Delete User By User_Id");
				System.out.println("4:Update User By UserName");
//				System.out.println("________________________________________");
				System.out.println("5:Add New Category");
				System.out.println("6:Show All Category");
//				System.out.println("________________________________________");
				System.out.println("7:Add New Expenses");
				System.out.println("8:Show All Expenses");
//				System.out.println("________________________________________");
				System.out.println("9:Add Budget");
				System.out.println("10:Show All Budgets");
				System.out.println("11:Delete Budgets By Budget_id");
				System.out.println("12:Update Budgets Amount");
//				System.out.println("________________________________________");
				System.out.println("13:Show All Report");
				System.out.println("0:Exit from Application \n");
				System.out.println("Enter The Key for Search ");
				int key = sc.nextInt();
				System.out.println("=========================================");
				switch (key) {
				case 1:
					System.out.println("Enete User Name");
					sc.nextLine();
					userName = sc.nextLine();

					System.out.println("Enter Password:");
					passWord = sc.nextLine();
					System.out.println("Enter Email:");
					String email = sc.nextLine();

					System.out.println("Enter Phone Number:");
					String p_number = sc.nextLine();

					System.out.println("Enter Address");
					String address = sc.nextLine();

					System.out.println(
							uservice.isAddNewUser(new UserModel(0, userName, passWord, email, p_number, address))
									? "User added successfully......."
									: "User NOT added successfully......");

					break;

				case 2:
					Optional<List<UserModel>> o = uservice.getAllUser();
					if (o.isPresent()) {
						List<UserModel> list = o.get();
						list.forEach((u) -> System.out
								.println(u.getUser_id() + "\t" + u.getUserName() + "\t\t" + u.getPassWord() + "\t\t"
										+ u.getEmail() + "\t\t\t" + u.getP_number() + "\t\t" + u.getAddress()));
					} else {
						System.out.println("There is NO data Present................");
					}
					System.out.println("------------------------------------------------------");

					break;
				case 3:
					System.out.println("Login in User ");
					System.out.println("Enter User_Id ");
					int user_id = sc.nextInt();
					b = uservice.deleteUserById(user_id);
					if (b) {
						System.out.println("User delete SuccessFully.............");
					} else {
						System.out.println("Some Problem Is there..............");
					}
					break;
				case 4:
					System.out.println("Enete User Name");
					sc.nextLine();
					userName = sc.nextLine();

					System.out.println("Enter Password:");
					passWord = sc.nextLine();
					System.out.println("Enter Email:");
					email = sc.nextLine();

					System.out.println("Enter Phone Number:");
					p_number = sc.nextLine();

					System.out.println("Enter Address");
					address = sc.nextLine();
					System.out.println(
							uservice.updateUserByName(new UserModel(0, userName, passWord, email, p_number, address))
									? "Data Updated........."
									: "Some Problem.............");
					break;
				case 5:
					System.out.println("Enter Category_Name");
					sc.nextLine();
					String category_name = sc.nextLine();

					System.out.println("Enter Description ");
					String description = sc.nextLine();

					b = cservice.AddNewCategory(new CategoryModel(0, category_name, description));
					if (b) {
						System.out.println("Data Savesuccessfully.......");
					} else {
						System.out.println("Some Problem is there............");
					}

					break;
				case 6:
					List<CategoryModel> list = cservice.AllCatrgory();
					if (list != null) {
						list.forEach((v) -> System.out.println(v.getCategory_id() + "\t" + v.getCategory_name() + "\t\t" + v.getDiscrption()));
					} else {
						System.out.println("Some Problem Is there..........");
					}

					break;
				case 7:
					System.out.println("Enter Amount");
					float amount = sc.nextFloat();
					sc.nextLine();

					System.out.println("Enter Description ");
					description = sc.nextLine();

					System.out.println("Enter date (YYYY-MM-DD)");
					String date = sc.nextLine();                    

					System.out.println("Enter category_Id");
					int category_id = sc.nextInt();

					System.out.println(				//A new instance of the ExpenseModel class 
							eservice.AddNewExpenses(new ExpenseModel(0,userId, amount, description, date, category_id))
									? "Data Updated............." 				
									: "Some Problem............");

					break;

				case 8:
					List<ExpenseModel> clist = eservice.showAllExpenses();
					if (clist != null) {
						clist.forEach((v1) -> System.out
								.println(v1.getExpense_id() + "\t" + v1.getUser_id() + "\t" + v1.getCategory_id() + "\t"
										+ v1.getAmount() + "\t\t" + v1.getDescription() + "\t\t\t" + v1.getDate()));
					} else {
						System.out.println("Some Problem.............");
					}

					break;
				case 9:
					System.out.println("Enter UserAmount");
					 amount = sc.nextFloat();
					System.out.println(bservice.isAddNewBudget(new BudgetModel(0, userId, amount)) ? "Data Updated"
							: "Some Problem");
					break;
				case 10:
					List<BudgetModel> blist = bservice.showAllBudget();
					if (blist != null) {
						blist.forEach((v1) -> System.out
								.println(v1.getBudget_id() + "\t" + v1.getUser_id() + "\t" + v1.getBudget_amount()));
					} else {
						System.out.println("Some Problem...........");
					}
					break;
					
				case 11:
					System.out.println("Enter Budget_id");
					int budget_id = sc.nextInt();
					b = bservice.IsDeleteByBudget_id(budget_id);
					if (b) {
						System.out.println("Data Delete...........");
					} else {
						System.out.println("Some Problem............");
					}

					break;
				case 12:
					System.out.println("Enter Amount ");
					amount=sc.nextFloat();
					b=bservice.updateNewBudget(userId, amount);
					if(b) {
					System.out.println("Data Updated.........");
					}else {
						System.out.println("Some Problem Is there..............");
					}
					
					break;
				case 13:

					System.out.println("1:User Expense Of Day");
					System.out.println("2:User Expense Of Month");
					System.out.println("3:User Expense Of Year");
					System.out.println("4:User Amount and Description");
					System.out.println("5:Exist From Application");

					System.out.println("Enter Key For Search");
					int Report = sc.nextInt();
					switch (Report) {
					case 1:
						System.out.println("Enter Date in Format (YYYY-MM-DD)");
						sc.nextLine();
						String day = sc.nextLine();
						 rservice.getReportOfOneDay(day, userId);
//						System.out.println(day + ":" + value);

						break;
					case 2:
						System.out.println("Enter Starting Date of Month (YYYY-MM-DD)");
//						System.out.println("Enter Month Startig Data for chack expense");
						sc.nextLine();
						String from = sc.nextLine();
						System.out.println("Enter Ending  Date of Month (YYYY-MM-DD)");
						String end = sc.nextLine();
						rservice.getReportOfMonth(from, end, userId);
//						System.out.println(from + " To " + end + ":" + value);
						break;
					case 3:
//						System.out.println("Enter Date Of Year");
						System.out.println("Enter  Year  (YYYY)");
						sc.nextLine();
						int year=sc.nextInt();
						from = year+"-01-01";
						end = year+"-12-31";
						 rservice.getReportOfYear(from, end, userId);
//						System.out.println(from + " To " + end + ":" + value);
						break;
					case 4:
						System.out.println("-----------------------------");
						rservice.getAmountDiscriptionOfUser(userId);
						
						break;
					case 5:
						System.exit(0);
						break;

					default:
						System.out.println("Wrong Choise.......");
						break;
					}

					break;

				case 0:
					System.exit(0);
					break;

				default:
					System.out.println("Wrong Choise..........");
					break;
				}

			} while (true);

		} else {
			System.err.println("User Not Found............");
		}
		
		logger.info("Main method end...");
		

		
	}

}
