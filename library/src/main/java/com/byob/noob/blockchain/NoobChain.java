package com.byob.noob.blockchain;

import com.byob.noob.blockchain.block.Block;
import com.byob.noob.blockchain.chain.BlockChain;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NoobChain {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        Block genesisBlock = new Block("Genesis Block", "0");
        System.out.println("Hash for block 1 : " + genesisBlock.getHash());

        Block secondBlock = new Block("second block", genesisBlock.getHash());
        System.out.println("Hash for block 2 : " + secondBlock.getHash());

        Block thirdBlock = new Block("Third block", secondBlock.getHash());
        System.out.println("Hash for block 3 : " + thirdBlock.getHash());

        BlockChain chain = new BlockChain();
        chain.add(genesisBlock);
        chain.add(secondBlock);
        chain.add(thirdBlock);

        try {
            String prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(chain);
            System.out.println("*******");
            System.out.println(prettyJson);
            System.out.println("*******");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
