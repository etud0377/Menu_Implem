public class Show {
   private String showID;
   private String cityName;
   private double ticketCost;
   private int genCounter = 0;
   private int vipCounter = 0;
   public static final int MAX_SHOWS = 12;   
   public static final int GEN_SEAT = 500;
   public static final int VIP_SEAT = 100;
   
   

   public Show(String showID, String cityName,double ticketCost) {
   
      if (showID.length()!=6) {
         throw new IllegalArgumentException("ID is not valid");
      }
      this.showID = showID;
      
     if (cityName.equals("") || cityName == null) {
         throw new IllegalArgumentException("Please enter a valid number");
      } 
      this.cityName = cityName;
      
      if (ticketCost < 1 ) {
        throw new IllegalArgumentException("Enter valid cost!");
      }
      this.ticketCost = ticketCost;

   }

   public String getShowID() {return this.showID;}
   public String getCityName() {return this.cityName;}
   public double getTicketCost() {return this.ticketCost;}
   public int getGenCounter() {return this.genCounter;}
   public int getVipCounter() {return this.vipCounter;}
   
   
   public void setShowID(String showID){
      if (showID.length()!=6) {
         throw new IllegalArgumentException("ID is not valid");
      }
      int x = 0;   
      while(x < showID.length() ) {
         if (!Character.isUpperCase(showID.charAt(x)) && x < 2){
            throw new IllegalArgumentException("Must be upper case letters");
         }  
         if (!Character.isDigit(showID.charAt(x)) && x > 1) {
            throw new IllegalArgumentException("Must be four digits");
         }
         else {
            x++;
         }  
     }
   }
   public void setCityName(String cityName){
      for (char i : cityName.toCharArray()) {
         if (Character.isDigit(i)){
            throw new IllegalArgumentException("Please enter a valid statement");
      }
      if (cityName.equals("") || cityName == null) {
         throw new IllegalArgumentException("Please enter a valid statement");
      } 
      this.cityName = cityName;
      }
   }
    
    public void setTicketCost (double ticketCost  ){
      if (ticketCost < 1) {
        throw new IllegalArgumentException("Enter valid cost!");
      }
      this.ticketCost = ticketCost;  
        
   }
   
   public void ticketSales(boolean checkCounter){


       if (checkCounter == false) { 
         if(this.genCounter >= 500)
            throw new IllegalArgumentException("Seats are all filled");
         this.genCounter++;
      }
      if (checkCounter == true) {
         if (this.vipCounter >= 100)
            throw new IllegalArgumentException("Seats are all filled");
         this.vipCounter++;

      }     

    }
 
    public double calculateCost() {
      return (this.ticketCost * this.genCounter) + ((this.ticketCost + 150) * this.vipCounter);
      }
      
     
   public String toString() {
         return " Your show ID is: " + this.getShowID() + "\nYour city name is:  " + this.getCityName() + "\nYour ticket cost: " + this.getTicketCost() + "\nTotal General Ticket: " + this.genCounter +  "\nTotal VIP Ticket: " + this.vipCounter + "\nYour total cost: " + this.calculateCost();
         
   }

}
   
   
   