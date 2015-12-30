import java.io.IOException;
import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.util.Random;

class GenerateRandomNumbers{
     String s1;
     Integer i;
public void random1()
{
    Random aRandom = new Random();
   
        i = aRandom.nextInt(0xf423f);
    
   
    //i=aRandom.nextInt(999999);
   // aRandom.next
    //System.out.println(i);
   s1=i.toString();
   if(s1.length()<6)
   {
          random1();
   }
  
}   
    public static void main(String[] args) throws IOException,InterruptedException{
           

    //System.out.println(aRandom.nextDouble());
    //System.out.println(aRandom.nextBoolean());
    }
}