package com.ashish;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * <B>10.6</B> ,  <B>Cracking The Coding Interview : Edition : 6</B>
 * <p>
 * <B>Sort Big File: </B>
 * <p>
 * Imagine you have a 20 GB file with one string per line.
 * Explain how you would sort the file.
 *
 * Solution:
 *
 * When an interviewer gives a size limit of 20 gigabytes, it should tell you something.
 * In this case, it suggests that they don't want you to bring all the data into memory.
 * So what do we do? We only bring part of the data into memory.
 *
 * We'll divide the file into chunks, which are x megabytes each, where x is the amount of memory we have available.
 *
 * Each chunk is sorted separately and then saved back to the file system.
 *
 * Once all the chunks are sorted, we merge the chunks, one by one. At the end, we have a fully sorted file.
 * This algorithm is known as external sort.
 *
 * http://faculty.simpson.edu/lydia.sinapova/www/cmsc250/LN250_Weiss/L17-ExternalSort.htm
 *
 * @author Ashish Sharma on 03/29/2019.
 * @since 03/29/2019.
 */
public class SortBigFileTest {

    @BeforeMethod
    public void init() {

    }

    @Test
    public void testSortBigFile() {

    }
}
