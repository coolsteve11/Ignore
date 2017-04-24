import java.util.Scanner;
public class uhh {
    static double radius;
    static double numwheels;
    static double numleading;
    static double numtrailing;
    static double finaldrivingpos;
    static double middleoftrailingwheels;
    static double middleofdrivingwheels;
    static double startingpos;
    static double type;
    static Scanner sc = new Scanner(System.in);
    public static void main() {
       createParams();     
       randSetup();
       createLoco();
       StdDraw.show(10);
    }
    public static void createLoco(){
      if (type == 1){  
        
      drawDriving();
       drawLeading();  
       drawTrailing(); 
       drawBoiler(); 
       drawCab(); 
    }
    if (type == 2){
     if (numwheels % 2 != 0){
     System.out.println("the # of driving wheels must be equal for a duplex.");   
        }
     else{
          numwheels ++;
       startingpos = ((0*((radius*2)+.35))-numwheels*2)-radius*2;
        drawDrivingDuplex();
       drawLeading();  
       drawTrailing(); 
       drawBoiler(); 
       drawCab();
        
        }          
    }
    if (type == 3){
        
      drawDriving();
       drawLeading();  
       drawTrailing(); 
       drawCamelBoiler(); 
       drawCamelCab();
    }
    }
    public static void randSetup(){
      finaldrivingpos = 0;
       middleoftrailingwheels = 0;
       middleofdrivingwheels = 0;
        StdDraw.setXscale(-25, +25);
        StdDraw.setYscale(-25, +25);
        StdDraw.clear(StdDraw.WHITE);     
        StdDraw.setPenColor(StdDraw.BLACK); 
       startingpos = ((0*((radius*2)+.35))-numwheels*2)-radius*2;  
    }
    public static void createParams(){
    System.out.println("radius?");
       radius = sc.nextDouble();
       System.out.println("driving wheels?");
       numwheels = sc.nextDouble();
       System.out.println("leading wheels?");
       numleading = sc.nextDouble();
       System.out.println("trailing wheels??");
       numtrailing = sc.nextDouble();
       System.out.println("Type?  1 = standard, 2 = mallet/duplex, 3 = camel");
       type = sc.nextDouble();    
    }
    public static void drawBoiler(){
    middleofdrivingwheels /= numwheels;
    StdDraw.filledRectangle(middleofdrivingwheels+(numleading), radius+4, (radius*numwheels)+numleading, 4);    
        
    }
    public static void drawCamelBoiler(){
    middleofdrivingwheels /= numwheels;
    StdDraw.filledRectangle(middleofdrivingwheels, radius+4, (radius*(numwheels)+(numleading+numtrailing)*(radius/2)), 4);    
        
    }
    public static void drawCab(){
    middleoftrailingwheels /= numtrailing;       
    StdDraw.filledRectangle(middleoftrailingwheels, radius+4, 4, 6);
    }
    public static void drawCamelCab(){      
    StdDraw.filledRectangle(middleofdrivingwheels, radius+4, 4, 6);
    }
    public static void drawDriving(){
      for (int i = 0; i < numwheels; i++) {            
                StdDraw.filledCircle(((i*((radius*2)))-numwheels*2)+.35, 0, radius);    
                finaldrivingpos = (((i*((radius*2)))-numwheels*2)+.35)+radius*2;
                middleofdrivingwheels += ((i*((radius*2)))-numwheels*2)+.35;
        }   
    }
    public static void drawDrivingDuplex(){
     
      for (int i = 0; i < numwheels; i++) {         
          if (i == (int)(numwheels / 2.0)){
        StdDraw.setPenColor(StdDraw.WHITE); 
            StdDraw.filledCircle(((i*((radius*2)))-numwheels*2)+.35, 0, radius);    
                finaldrivingpos = (((i*((radius*2)))-numwheels*2)+.35)+radius*2;
                middleofdrivingwheels += ((i*((radius*2)))-numwheels*2)+.35;
                StdDraw.setPenColor(StdDraw.BLACK); 
           }
          else{  
                StdDraw.filledCircle(((i*((radius*2)))-numwheels*2)+.35, 0, radius);    
                finaldrivingpos = (((i*((radius*2)))-numwheels*2)+.35)+radius*2;
                middleofdrivingwheels += ((i*((radius*2)))-numwheels*2)+.35;
            }
        }   
    }
     public static void drawLeading(){
      for (int i = 0; i < numleading; i++) {            
               StdDraw.filledCircle((finaldrivingpos+(i*((radius))))+.35, -radius/2, radius/2);  
        }
    }
     public static void drawTrailing(){
        for (int i = 0; i < numtrailing; i++) {            
               StdDraw.filledCircle(startingpos-(i*((radius)))-.35, -radius/2, radius/2);
               middleoftrailingwheels += (startingpos-(i*((radius)))-.35);
        }
    }
    }