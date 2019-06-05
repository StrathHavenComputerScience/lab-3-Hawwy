public class Lab3
{
  public static void testLightCandles1()
  {
    Robot.load("candles1.txt");
    Robot.setDelay(0.05);
    lightCandles();
  }
  
  public static void testLightCandles2()
  {
    Robot.load("candles2.txt");
    Robot.setDelay(0.05);
    lightCandles();
  }
    
  public static void lightCandles()
  {
      checkCandles();
      checkCandles();
      checkCandles();
      checkCandles();
      checkCandles();
      checkCandles();
      checkCandles();
      checkCandles();
      checkCandles();
      checkCandles();
  }
  //precondition: The candles are not lit.
  //postcondition: The candles are lit.
  public static void checkCandles()
  {
      lightCandle();
      moveNextCandle();
    }
  //precondition: One candle is not lit in front of the Robot.
  //postcondition: That candle is lit and the Robot has moved in front of it. 
  public static void turnRight()
  {
      Robot.turnLeft();
      Robot.turnLeft();
      Robot.turnLeft();
    }
  //precondition: The Robot is facing forward.
  //postcondition: The Robot is facing right.
  public static void lightCandle()
  {
      if(Robot.frontIsClear())
        {moveDark();
        }
      else
      {
          Robot.turnLeft();
          Robot.move();
          turnRight();
          if(Robot.frontIsClear())
          {moveDark();
            }
          else
          {Robot.turnLeft();
          Robot.move();
          turnRight();
          moveDark();
        }
        }
    }
  //precondition: One candle is not lit. 
  //postcondition: That candle is now lit. 
  public static void moveNextCandle()
  {
      if(Robot.onDark())
      {
          Robot.move();
          if (Robot.frontIsClear())
          {
              turnRight();
              Robot.move();
              Robot.turnLeft();
              
            }
            else
           { 
                Robot.turnLeft();
                Robot.move();
                turnRight();
            
            }
        }
    }
  //precondition: The Robot is at one candle.
  //postcondition: the Robot moves to the next candle.
  public static void moveDark()
  {
      Robot.move();
      if(Robot.onDark())
      {
        }
      else
      { Robot.makeDark();   
        }
      
  }
  //precondition: The Robot is in front of a block. 
  //postcondition: The Robot is on a dark block. 
  
  //Run this method to test completeRoom on map room1.txt
  public static void testCompleteRoom1()
  {
     Robot.load("room1.txt");
     Robot.setDelay(0.05);
     completeRoom();
  }
  
  //Run this method to test completeRoom on map room2.txt
  public static void testCompleteRoom2()
  {
    Robot.load("room2.txt");
    Robot.setDelay(0.05);
    completeRoom();
  }
  
  //Complete this method.  You will need to write additional helper methods.
  public static void completeRoom()
  {
    checkWholeWall();
    checkWholeWall();
    checkWholeWall();
    checkWholeWall();
  
  }
  //precondition: The sides of the walls are not dark.
  //postcondition: The sides of the walls are dark. 
  public static void checkWholeWall()
  {
      checkWalls();
      Robot.move();
      checkWalls();
      Robot.move();
      checkWalls();
      Robot.move();
      checkWalls();
      Robot.move();
      checkWalls();
      turnRight();
    }
  //precondition: A side is not fully dark.
  //postcondition: A side is completly dark.
  public static void checkWalls()
  {
    Robot.turnLeft();
      if (Robot.frontIsClear())
    {
        checkBlock();
    }
    else
    {
        turnRight();
    }
      }
  //precondition: One block of the wall next to the Robot might be Light. 
  //postcondition: One block of the wall will definitly be Dark. 
  public static void checkBlock()
  {
    Robot.move();
    if (Robot.onDark())
    {
        turnAround();
        Robot.move();
        Robot.turnLeft();
    }
    else 
    {
        Robot.makeDark();
        turnAround();
        Robot.move();
        Robot.turnLeft();
    }
   }
  //precondition: The block the Robot is on might be Light.
  //postcondition: The block that the Robot was on is definitly Dark.
  public static void turnAround()
  {
    Robot.turnLeft();
    Robot.turnLeft();
  }
  //precondition: The Robot looking forward.
  //postcondition: The Robot is looking behind.
  
  //Run this method to test swapAll on map swap1.txt
  public static void testSwapAll1()
  {
    Robot.load("swap1.txt");
    Robot.setDelay(0.05);
    swapAll();
  }
  
  //Run this method to test swapAll on map swap2.txt
  public static void testSwapAll2()
  {
    Robot.load("swap2.txt");
    Robot.setDelay(0.05);
    swapAll();
  }

  //Complete this method.  You will need to write additional helper methods.
  public static void swapAll()
  {
    checkAndUp();
    checkAndUp();
    checkAndUp();
    checkAndUp();
    checkAndUp();
    checkAndUp();
    checkAndUp();
    checkAndUp();
    checkAndUp();
    checkSquare();
  }
  //precondition: The two sides didn't swap Light and Dark blocks.
  //postcondition: The two sides swap Light and Dark blocks. 
  public static void checkAndUp()
  {
    checkSquare();
    moveUp();
  }
  //precondition: One row has not swapped. 
  //postcondition: One row is swapped and the Robot moves up one row. 
  public static void moveUp()
  {
    turnAround();
    Robot.move();
    Robot.turnLeft();
    Robot.move();
  }
  //precondition: Robot is on one row. 
  //postcondition: Robot moves up one row. 
  public static void checkSquare()
  {
    turnRight();
    Robot.move();
    if (Robot.onDark())
    {
        aroundMove2();
        checkSquare1();
        checkMakeDark();
    }
    else
    {
       aroundMove2();
       checkSquare1();
       checkMakeLight();
   }
  }
  //precondition: Robot reads one block. 
  //postcondition: Robot takes that block color and moves it to the other side. 
  public static void aroundMove2()
  {
    turnAround();
    Robot.move();
    Robot.move();
  }
  //precondition: Robot is facing forward. 
  //postcondition: Robot is facing back and moves two blocks back. 
  public static void checkSquare1()
  {
    if (Robot.onDark())
        {
            aroundMove2();
            checkMakeDark();
            aroundMove2();
        }
        else
        {
            aroundMove2();
            checkMakeLight();
            aroundMove2();
        }
  }
  //precondition: Robot is on a block. 
  //postcondition: Robot transfers the block color to the block on the other side. 
  public static void checkMakeDark()
  {
    if (Robot.onDark())
            {
            }
            else
            {
                Robot.makeDark();
            }
  }
  //precondition: Robot is on a block that might be Light.
  //postcondition: Robot is on a block that is definitly Dark. 
  public static void checkMakeLight()
  {
    if (Robot.onDark())
            {
                Robot.makeLight();
            }
  }   
  //precondition: Robot is on a block that might be Dark.
  //postcondition: Robot is definitly on a Light block. 
  //Don't run these. I will!
  public static void testLightCandles3()
  {
    Robot.load("candles3.txt");
    Robot.setDelay(0.05);
    lightCandles();
  }
  
  public static void testLightCandles4()
  {
    Robot.load("candles4.txt");
    Robot.setDelay(0.05);
    lightCandles();
  }
  public static void testCompleteRoom3()
  {
     Robot.load("room3.txt");
     Robot.setDelay(0.05);
     completeRoom();
  }
  
  public static void testCompleteRoom4()
  {
    Robot.load("room4.txt");
    Robot.setDelay(0.05);
    completeRoom();
  }
  
  public static void testSwapAll3()
  {
    Robot.load("swap3.txt");
    Robot.setDelay(0.05);
    swapAll();
  }
  
  //Run this method to test swapAll on map swap2.txt
  public static void testSwapAll4()
  {
    Robot.load("swap4.txt");
    Robot.setDelay(0.05);
    swapAll();
  }
}
public class Lab3
{
  public static void testLightCandles1()
  {
    Robot.load("candles1.txt");
    Robot.setDelay(0.05);
    lightCandles();
  }
  
  public static void testLightCandles2()
  {
    Robot.load("candles2.txt");
    Robot.setDelay(0.05);
    lightCandles();
  }
    
  public static void lightCandles()
  {
      checkCandles();
      checkCandles();
      checkCandles();
      checkCandles();
      checkCandles();
      checkCandles();
      checkCandles();
      checkCandles();
      checkCandles();
      checkCandles();
  }
  //precondition: The candles are not lit.
  //postcondition: The candles are lit.
  public static void checkCandles()
  {
      lightCandle();
      moveNextCandle();
    }
  //precondition: One candle is not lit in front of the Robot.
  //postcondition: That candle is lit and the Robot has moved in front of it. 
  public static void turnRight()
  {
      Robot.turnLeft();
      Robot.turnLeft();
      Robot.turnLeft();
    }
  //precondition: The Robot is facing forward.
  //postcondition: The Robot is facing right.
  public static void lightCandle()
  {
      if(Robot.frontIsClear())
        {moveDark();
        }
      else
      {
          Robot.turnLeft();
          Robot.move();
          turnRight();
          if(Robot.frontIsClear())
          {moveDark();
            }
          else
          {Robot.turnLeft();
          Robot.move();
          turnRight();
          moveDark();
        }
        }
    }
  //precondition: One candle is not lit. 
  //postcondition: That candle is now lit. 
  public static void moveNextCandle()
  {
      if(Robot.onDark())
      {
          Robot.move();
          if (Robot.frontIsClear())
          {
              turnRight();
              Robot.move();
              Robot.turnLeft();
              
            }
            else
           { 
                Robot.turnLeft();
                Robot.move();
                turnRight();
            
            }
        }
    }
  //precondition: The Robot is at one candle.
  //postcondition: the Robot moves to the next candle.
  public static void moveDark()
  {
      Robot.move();
      if(Robot.onDark())
      {
        }
      else
      { Robot.makeDark();   
        }
      
  }
  //precondition: The Robot is in front of a block. 
  //postcondition: The Robot is on a dark block. 
  
  //Run this method to test completeRoom on map room1.txt
  public static void testCompleteRoom1()
  {
     Robot.load("room1.txt");
     Robot.setDelay(0.05);
     completeRoom();
  }
  
  //Run this method to test completeRoom on map room2.txt
  public static void testCompleteRoom2()
  {
    Robot.load("room2.txt");
    Robot.setDelay(0.05);
    completeRoom();
  }
  
  //Complete this method.  You will need to write additional helper methods.
  public static void completeRoom()
  {
    checkWholeWall();
    checkWholeWall();
    checkWholeWall();
    checkWholeWall();
  
  }
  //precondition: The sides of the walls are not dark.
  //postcondition: The sides of the walls are dark. 
  public static void checkWholeWall()
  {
      checkWalls();
      Robot.move();
      checkWalls();
      Robot.move();
      checkWalls();
      Robot.move();
      checkWalls();
      Robot.move();
      checkWalls();
      turnRight();
    }
  //precondition: A side is not fully dark.
  //postcondition: A side is completly dark.
  public static void checkWalls()
  {
    Robot.turnLeft();
      if (Robot.frontIsClear())
    {
        checkBlock();
    }
    else
    {
        turnRight();
    }
      }
  //precondition: One block of the wall next to the Robot might be Light. 
  //postcondition: One block of the wall will definitly be Dark. 
  public static void checkBlock()
  {
    Robot.move();
    if (Robot.onDark())
    {
        turnAround();
        Robot.move();
        Robot.turnLeft();
    }
    else 
    {
        Robot.makeDark();
        turnAround();
        Robot.move();
        Robot.turnLeft();
    }
   }
  //precondition: The block the Robot is on might be Light.
  //postcondition: The block that the Robot was on is definitly Dark.
  public static void turnAround()
  {
    Robot.turnLeft();
    Robot.turnLeft();
  }
  //precondition: The Robot looking forward.
  //postcondition: The Robot is looking behind.
  
  //Run this method to test swapAll on map swap1.txt
  public static void testSwapAll1()
  {
    Robot.load("swap1.txt");
    Robot.setDelay(0.05);
    swapAll();
  }
  
  //Run this method to test swapAll on map swap2.txt
  public static void testSwapAll2()
  {
    Robot.load("swap2.txt");
    Robot.setDelay(0.05);
    swapAll();
  }

  //Complete this method.  You will need to write additional helper methods.
  public static void swapAll()
  {
    checkAndUp();
    checkAndUp();
    checkAndUp();
    checkAndUp();
    checkAndUp();
    checkAndUp();
    checkAndUp();
    checkAndUp();
    checkAndUp();
    checkSquare();
  }
  //precondition: The two sides didn't swap Light and Dark blocks.
  //postcondition: The two sides swap Light and Dark blocks. 
  public static void checkAndUp()
  {
    checkSquare();
    moveUp();
  }
  //precondition: One row has not swapped. 
  //postcondition: One row is swapped and the Robot moves up one row. 
  public static void moveUp()
  {
    turnAround();
    Robot.move();
    Robot.turnLeft();
    Robot.move();
  }
  //precondition: Robot is on one row. 
  //postcondition: Robot moves up one row. 
  public static void checkSquare()
  {
    turnRight();
    Robot.move();
    if (Robot.onDark())
    {
        aroundMove2();
        checkSquare1();
        checkMakeDark();
    }
    else
    {
       aroundMove2();
       checkSquare1();
       checkMakeLight();
   }
  }
  //precondition: Robot reads one block. 
  //postcondition: Robot takes that block color and moves it to the other side. 
  public static void aroundMove2()
  {
    turnAround();
    Robot.move();
    Robot.move();
  }
  //precondition: Robot is facing forward. 
  //postcondition: Robot is facing back and moves two blocks back. 
  public static void checkSquare1()
  {
    if (Robot.onDark())
        {
            aroundMove2();
            checkMakeDark();
            aroundMove2();
        }
        else
        {
            aroundMove2();
            checkMakeLight();
            aroundMove2();
        }
  }
  //precondition: Robot is on a block. 
  //postcondition: Robot transfers the block color to the block on the other side. 
  public static void checkMakeDark()
  {
    if (Robot.onDark())
            {
            }
            else
            {
                Robot.makeDark();
            }
  }
  //precondition: Robot is on a block that might be Light.
  //postcondition: Robot is on a block that is definitly Dark. 
  public static void checkMakeLight()
  {
    if (Robot.onDark())
            {
                Robot.makeLight();
            }
  }   
  //precondition: Robot is on a block that might be Dark.
  //postcondition: Robot is definitly on a Light block. 
  //Don't run these. I will!
  public static void testLightCandles3()
  {
    Robot.load("candles3.txt");
    Robot.setDelay(0.05);
    lightCandles();
  }
  
  public static void testLightCandles4()
  {
    Robot.load("candles4.txt");
    Robot.setDelay(0.05);
    lightCandles();
  }
  public static void testCompleteRoom3()
  {
     Robot.load("room3.txt");
     Robot.setDelay(0.05);
     completeRoom();
  }
  
  public static void testCompleteRoom4()
  {
    Robot.load("room4.txt");
    Robot.setDelay(0.05);
    completeRoom();
  }
  
  public static void testSwapAll3()
  {
    Robot.load("swap3.txt");
    Robot.setDelay(0.05);
    swapAll();
  }
  
  //Run this method to test swapAll on map swap2.txt
  public static void testSwapAll4()
  {
    Robot.load("swap4.txt");
    Robot.setDelay(0.05);
    swapAll();
  }
}
