package bbl.util.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static bbl.util.ArraysInt.*;

class Arraytests 
{
int [] array= {10,25,30,40,100};
	@Test
	void addNumbertest()
	{
		int [] arrayExpected = {10,25,30,40,100,-2};
		int [] arrayActual=addNumber(array, -2);
		assertArrayEquals(arrayExpected, arrayActual);
	}
	
	@Test
	void insertNumbertest()
	{
		int [] arrayExpectedLast = {10,25,30,40,100,25};
		int [] arrayExpectedFirst={25,10,25,30,40,100};
		int [] arrayExpectedMiddle={10,25,30,25,40,100};
		int [] arrayExpectedOver={10,25,30,40,100,0,0,1};
		int [] arrayActualLast=insertNumber(array,5,25);
		int [] arrayActualFirst=insertNumber(array,0,25);
		int [] arrayActualMiddle=insertNumber(array,3,25);
		int [] arrayActualOver=insertNumber(array,7,1);
		assertArrayEquals(arrayExpectedLast,arrayActualLast);
		assertArrayEquals(arrayExpectedFirst,arrayActualFirst);
		assertArrayEquals(arrayExpectedMiddle,arrayActualMiddle);
		assertArrayEquals(arrayExpectedOver,arrayActualOver);
	}

	@Test
	void removeNumbertest()
	{
		int [] arrayExpectedLast = {10,25,30,40}; 
		int [] arrayExpectedFirst={25,30,40,100};  
		int [] arrayExpectedMiddle={10,25,40,100};    
		int [] arrayActualLast=removeNumber(array,array.length-1);
		int [] arrayActualFirst=removeNumber(array,0);
		int [] arrayActualMiddle=removeNumber(array,2);
		assertArrayEquals(arrayExpectedLast,arrayActualLast);
		assertArrayEquals(arrayExpectedFirst,arrayActualFirst);
		assertArrayEquals(arrayExpectedMiddle,arrayActualMiddle);
	}
	
	@Test
	void InsertSortedtest()
	{
		int [] arrayExpectedLast = {10,25,30,40,100,150};
		int [] arrayExpectedFirst={10,10,25,30,40,100};
		int [] arrayExpectedMiddle={10,25,30,35,40,100};
		int [] arrayActualLast=insertSorted(array,150);
		int [] arrayActualFirst=insertSorted(array,10);
		int [] arrayActualMiddle=insertSorted(array,35);
		assertEquals(5,array.length);
		assertArrayEquals(arrayExpectedLast,arrayActualLast);
		assertArrayEquals(arrayExpectedFirst,arrayActualFirst);
		assertArrayEquals(arrayExpectedMiddle,arrayActualMiddle);
	}
	
	@Test
	void CopyOftest()
	{
		int [] arrayExpectedSameLength={10,25,30,40,100};
		int [] arrayExpectedLessLength={10,25,30};
		int [] arrayExpectedGreaterLength={10,25,30,40,100,0};
		int [] arrayActulaSameLength=Arrays.copyOf(array,array.length);
		int [] arrayActulaLessLength=Arrays.copyOf(array,array.length-2);
		int [] arrayActulaGreaterLength=Arrays.copyOf(array,array.length+1);
		assertArrayEquals(arrayExpectedSameLength,arrayActulaSameLength);
		assertArrayEquals(arrayExpectedLessLength,arrayActulaLessLength);
		assertArrayEquals(arrayExpectedGreaterLength,arrayActulaGreaterLength);
	}
	
	@Test
	void arraycopyTest()
	{
		int [] array1= {3,10,20,15};
		int [] expected={10,25,10,20,100};
		int [] arrayCopy=Arrays.copyOf(array, array.length);
		System.arraycopy(array1, 1, arrayCopy, 2, 2);
		assertArrayEquals(expected, arrayCopy);
	}
	
	@Test
	void binarySerchIntTest()
	{
	//TODO	
		assertEquals(2,Arrays.binarySearch(array,30));
		assertEquals(-5,Arrays.binarySearch(array,50));
		assertEquals(-1,Arrays.binarySearch(array,3));
		assertEquals(-6,Arrays.binarySearch(array,150));
	}
	
}
