package com.ashish;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BlockChain {

    public List<Block> getChain() {
        return chain;
    }

    private final List<Block> chain;
    private final List<Transaction> currentTransactions;
    private Block lastBlock;

    private String nodeID;

    public BlockChain() {
        chain = new ArrayList();
        currentTransactions = new ArrayList();
        lastBlock = null;
    }

    public Block createNewBlock(int proof, String previousHash) throws JsonProcessingException, NoSuchAlgorithmException {
        //Creates a new Block and adds it to the chain
        if (previousHash == null) {
            previousHash = getHash(chain.get(chain.size() - 1));
        }
        Block block = new Block(chain.size(), new Timestamp(System.currentTimeMillis()),
                currentTransactions, proof, previousHash);
        currentTransactions.clear();
        chain.add(block);
        return block;
    }

    public int createNewTransaction(String sender, String recipient, double amount) {
        //Adds a new transaction to the list of transactions
        Transaction transaction = new Transaction(sender, recipient, amount);
        this.currentTransactions.add(transaction);
        return (currentTransactions.size() - 1);
    }

    private String getHash(Block block) throws JsonProcessingException, NoSuchAlgorithmException {
        ObjectMapper objectMapper = new ObjectMapper();
        String blockText = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(block);
        return getSHA256Hash(blockText);
    }

    private String getSHA256Hash(String blockText) {
//        return DigestUtils.sha256Hex(blockText);
        return Hashing.sha256().hashString(blockText, StandardCharsets.UTF_8).toString();
    }

    public Block getLastBlock() {
//         Returns the last Block in the chain
        return chain.remove(chain.size()-1);
    }

    /**
     * Simple Proof of Work Algorithm:
     * Find a number p' such that hash(pp') contains leading 4 zeroes, where p is the previous p'
     * p is the previous proof, and p' is the new proof
     *
     * @param lastProof
     * @param previousHash
     * @return
     */
    private int createProofOfWork(int lastProof, String previousHash) {
        int proof = 0;
        while (!(isValidProof(lastProof, proof, previousHash))) {
            proof++;
        }
        return proof;
    }

    private boolean isValidProof(int lastProof, int proof, String previousHash) {
        String guess = String.valueOf(lastProof) + String.valueOf(proof) + previousHash;
//        same as above
//        String guess = String.format("%1$s%2$s%3$s", lastProof, proof, previousHash);
        String result = getSHA256Hash(guess);
        return result.startsWith("0000");
    }


}
