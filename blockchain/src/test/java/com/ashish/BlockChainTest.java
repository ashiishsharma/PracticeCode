package com.ashish;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Reference and learning from
 * https://hackernoon.com/learn-blockchains-by-building-one-117428612f46
 */
public class BlockChainTest {

    @BeforeMethod
    public void init(){

    }

    @Test
    public void testBlockChain(){
        BlockChain blockChain = new BlockChain();
    }
}
