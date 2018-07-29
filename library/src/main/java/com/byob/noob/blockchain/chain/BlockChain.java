package com.byob.noob.blockchain.chain;

import com.byob.noob.blockchain.block.Block;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class BlockChain {

    private static ArrayList<Block> blockChain = new ArrayList<>();

    // No arg constructor
    public BlockChain() {}

    public BlockChain(Block genesis) {
        blockChain.add(genesis);
    }

    public BlockChain(ArrayList<Block> chain) {
        blockChain.addAll(chain);
    }

    public void add(Block block) {
        blockChain.add(block);
    }

    public void addAll(ArrayList<Block> chain) {
        blockChain.addAll(chain);
    }

    @JsonProperty("block_chain")
    public ArrayList<Block> getWholeChain() {
        return blockChain;
    }
}
