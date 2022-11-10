package view;
import model.ManagerHome;
import model.Person;
import model.PersonModel;
import java.util.ArrayList;
import java.util.Scanner;
public class ViewAdmin{
    public ViewAdmin(){
    }
    public void display(Scanner sc , ArrayList<Person> listUser , ArrayList<ManagerHome> listManager){
        System.out.println("Logged in successfully");
        System.out.println("You are logged in as Admin ");
        boolean check = true;
        endPro:while(check){
            System.out.println("\t\t\t\t\t======Permission Of Admin ======");
            boolean flag = true;
            int choose = 0;
            while(flag) {
                try {
                    System.out.println("1.Update users in the Software about < update, remove >");
                    System.out.println("2.Add ManagerHome ... ");
                    System.out.println("3.Log Out ");
                    System.out.println("=>> Your Choose : ");
                    choose = Integer.parseInt(sc.nextLine());
                    flag = false;
                } catch (Exception ex) {
                    System.out.println("You have entered wrong Input data type, please re-enter it");
                }
            }
                switch (choose){
                    case 1:
                        updateUser(sc,listUser);
                        break;
                    case 2:
                        System.out.println("The feature has not been updated, if you want to register as a tenant, go directly to the company to submit your application for approval.");
                        break;
                    case 3:
                        System.out.println("Logging Out..");
                        System.out.println("Thank You For Using Our Service !!! ");
                        break endPro;
                    default:
                        System.out.println("Import Number Olther !!! ");
                        break;
                }
            }
        }
        public void updateUser(Scanner sc, ArrayList<Person> listUser){
            System.out.println("List User now ");
            for (Person user: listUser){
                System.out.println(user.toString());
            }
            boolean flag = true;
            endPro:while(flag){
            System.out.println("Import username That You want Update ");
            String username = sc.nextLine();
            for (int i = 0; i < listUser.size() ; i++){
                if(username.equals(listUser.get(i).getAccount().getUserName())){
                    //
                    fucionUpdate(sc, listUser.get(i), listUser);
                      break endPro;
                }else{
                    if(i < listUser.size()-1)
                        continue;
                    System.out.println("Not Look for username that you entered @@ !! ");
                    System.out.println("...........Back to home screen");
                    flag = false;
                }
            }
            }
        }
        // Phương thức của case 1 : Update
    public void fucionUpdate(Scanner sc, Person user,ArrayList<Person> listUser){
        boolean check = true;
       endPro: while (check){
            int choose = 0;
            boolean flag = true;
            while (flag){
                try{
                    System.out.println("which function do you want to use, please import this : ");
                    System.out.println("1.Update \t\t\t 2.Delete User \t\t\t \t\t\t3.Exit");
                    System.out.println("=>> Your Choose : ");
                    choose = Integer.parseInt(sc.nextLine());
                    flag = false;
                }catch (Exception ex){
                    System.out.println("You have entered wrong Input data type, please re-enter it");
                }
            }
            endPro1:switch (choose){
                case 1:
                   boolean checkEx = true;
                   int cCCD = 0;
                   int number = 0;
                   int choose1 = 0;
                   while(checkEx){
                       try{
                           System.out.println("Do You Want Update for User ? \n 1.CCCD \t\t 2.NumberPhone \t\t 3.Exit ");
                           System.out.println("=>> Your Choose ");
                           choose1 = Integer.parseInt(sc.nextLine());
                           checkEx = false;
                       }catch(Exception ex) {
                           System.out.println("You have entered wrong Input data type, please re-enter it");
                       }
                   }
                   switch (choose1){
                       case 1:
                           boolean checkEx1 = true;
                           while (checkEx1){
                               try{ System.out.println("Import CCCD new ");
                                   cCCD = Integer.parseInt(sc.nextLine());
                                   checkEx1 = false;
                               }catch (Exception ex){
                                   System.out.println("You have entered wrong Input data type, please re-enter it");
                               }
                           }
                           user.setcCCD(cCCD);
                           System.out.println("change CCCD successful !!! ");
                           break;
                       case 2:
                           boolean checkEx2 = true;
                           while (checkEx2){
                               try{ System.out.println("Import CCCD new ");
                                   number = Integer.parseInt(sc.nextLine());
                                   checkEx2 = false;
                               }catch (Exception ex){
                                   System.out.println("You have entered wrong Input data type, please re-enter it");
                               }
                           }
                           user.setNumberPhone(number);
                           System.out.println("change number successful !!! ");
                           break;
                       case 3:
                           System.out.println("...........Back to home screen");
                           break endPro1;
                   }
                    break;
                case 2:
                    listUser.remove(user);
                    System.out.println("Detele User successful");
                    break;
                case 3:
                    break endPro;
                default:
                    break;
            }
        }
    }


    }

