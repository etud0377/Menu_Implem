
/*
   Name: Etu Das
   Date: 06/19/2021
   Course/Section: IT 206-B01
   Assignment: Programming Assignment 2
  
   Description:
   
   This program shows a five menues to choose from. Each menue had its own purpose. First, the user may press 1 and select to create a new show.
   This will allow the user to enter showID, cityName, and ticketCost. The user can't create more than 12 shows. Then, the user may press 2 and 
   select remove show. This will remove the show the user created before. The third option will sell a tick based on the shows available. The user
   will be prompted to choose from general or vip. The fourth option will display informtaion about the shows that are available. The fifth option
   displays a summary report of the total cost, counter for each ticket, and the information about the show.  
   
   After the customer input all the valid information, the program will ask the user if they want to continue. The program will end
   if the user decides to not continue.   
  */
import javax.swing.JOptionPane;
public class ShowImplemen {
   public static void main (String[] args){
   //initializing important inputs and variables
        Show[] showList = new Show[12];
        int showCounter = 0;
        String userInput = "";
        String showID = "";
        String cityName = "";
        double ticketCost = 0.0;
        do{
            int op = menu();
   //doing a switch for the menue inside a do while
            switch (op) {
            //creating a show
                case 1:
               
                    showID = getshowID();
                    cityName = getCityName();
                    ticketCost = getTicketCost();
                    Show show1 = new Show( showID, cityName, ticketCost);
                    showCounter++;
                    if(!(showCounter == 12)) {
                     
                        showList = addArr(showList, show1);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "ERROR! Show full!");
                    }
                     
                    break;
                
                case 2:
                //removing a show
                    if (showCounter == 0){
                        JOptionPane.showMessageDialog(null, "ERROR! No shows are available to remove!");
                        break;
                    }
                    showList = delShow(showList);
                    showCounter--;
                    break;
                
                case 3: 
                    //selling a ticket
                    if (showCounter == 0){
                        JOptionPane.showMessageDialog(null, "ERROR! No shows are available to buy tickets for!");
                        break;
                    }
                    String out = "All shows\n";
                    for (int i = 0; i < showList.length; ++i){
                        if (showList[i] == null){
                            out += i+" : Empty\n";
                        }else{
                            out += i+" : " + showList[i]+"\n";
                        }
                    }
     
                    JOptionPane.showMessageDialog(null, out);
                    

                    int tickOps = 0;
                    do{
                        tickOps = Integer.parseInt(JOptionPane.showInputDialog(null, "Which show would you like to buy a ticket for? "));
                        if(showList[tickOps] == null){
                          JOptionPane.showMessageDialog(null, "Not Available!");
                        }
                    } while (showList[tickOps] == null);
                    String takeInput = JOptionPane.showInputDialog(null,"Are you buying GENERAL or VIP ticket?");
                    if (takeInput.equalsIgnoreCase("GENERAL")) {
                        showList[tickOps].ticketSales(false);
                         
                    }
                    if (takeInput.equalsIgnoreCase("VIP")){
                        showList[tickOps].ticketSales(true);
                    }

                    break;
                
                case 4:
                //Displays information about the show
                    String o = "All shows\n";
                    for (int i = 0; i < showList.length; ++i){
                        if (showList[i] == null){
                            o += i+" : Empty\n";
                        }else{
                            o += i+" : " + showList[i]+"\n";
                        }
                    }
     
                    JOptionPane.showMessageDialog(null, o);
                    break;
                    
                case 5:
                //displays final summary report 
                    String costOut = "";
                    double finalCost= 0.0;

                    for (Show i : showList) {
                        if( i != null) {
                            finalCost += i.calculateCost();
                        }
                   }
                   JOptionPane.showMessageDialog(null, "SUMMARY REPORT\nCurrent number of shows: " + showCounter + "\nTotal ticket sales: " + finalCost);
                   break;
                default :
                    JOptionPane.showMessageDialog(null,"ERROR! Enter value 1-5");
 
                }

            userInput = JOptionPane.showInputDialog(null, "Would you like to continue? (Y for yes, N for no) ");

            }while(!userInput.equalsIgnoreCase("n"));
  }
     
     //method for menue/ validating
     public static int menu(){
      int option = 0;
      do{
         option = Integer.parseInt(JOptionPane.showInputDialog(null, "\tSHOWLIST MENU\n\n1. Create Show\n2. Remove Show\n3. Sell a Ticket\n4. Display Shows\n5. Display Summary Report\n"));

         if (option < 1 || option > 5) {JOptionPane.showMessageDialog(null, "Incorrect number, try again");}
      } while (option < 1 || option > 5);

      return option;
   }

   //method for deleting array
     public static Show[] delShow(Show[] arr){

      String o = "All shows\n";
      for (int i = 0; i < arr.length; ++i){
            o += i+": " + arr[i];
         }
         
      JOptionPane.showMessageDialog(null, o);

      int deleteOption = Integer.parseInt(JOptionPane.showInputDialog(null, "Which show would you like to delete: "));

      arr[deleteOption] = null;

      return arr;
      }
      //adding / creating array method

      public static Show[] addArr(Show[] showList, Show addEle){
         Show[] show3 = new Show[showList.length];
         boolean addCC = false;
         for (int i = 0; i < showList.length; ++i){
            show3[i] = showList[i];
         if (showList[i] == null && addCC == false){
            show3[i] = addEle;
            addCC = true;
         }
      }
      
      return show3;
      
   }
   
//validating showID
     public static String getshowID() {
        String showID;
        do {
            try {
                showID = JOptionPane.showInputDialog(null,"Please Enter Your Show ID: ");
            }
            catch (IllegalArgumentException e) {
                showID = "";
            }
            if (showID.length()!=6){
            JOptionPane.showMessageDialog(null, "ID is not valid");                
            }
        }while (showID.length()!=6);
        return showID;
   }
   //validating cityName
   public static String getCityName() {
        String cityName;
        do {
            try {
                cityName = JOptionPane.showInputDialog(null,"Please Enter Your City Name: ");
            }
            catch (IllegalArgumentException e) {
                cityName = "";
            }
            if (cityName.equals("") || cityName == null) {
              JOptionPane.showMessageDialog(null,"Please enter a valid statement");               
            }
        }while (cityName.equals("") || cityName == null);
        return cityName;
   }
   //validating ticketCost
   public static double getTicketCost() {
        double ticketCost = 0.0;
        do {
            try {
                ticketCost = Double.parseDouble(JOptionPane.showInputDialog(null, "Please Enter Ticket Cost: "));
            }
            catch (IllegalArgumentException e) {
                ticketCost = -1 ;
                }
                if (ticketCost < 1){
                    JOptionPane.showMessageDialog(null, "Try Again");
               }
         }
        while (ticketCost < 1);
            return ticketCost;
        }

}

      
   
        
      

               