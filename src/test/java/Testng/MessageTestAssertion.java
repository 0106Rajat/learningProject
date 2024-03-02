package Testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MessageTestAssertion {
      //  String message = "Tutorialspoint";
        String message = "Manisha";
        MessageUtil mu = new MessageUtil(message);

        @Test
        public void testPrintMessage() {
           Assert.assertEquals("Tutorialspoint", mu.printMessage());
        }
     }
