package com.byob.noob.blockchain.block;

import com.byob.noob.blockchain.util.StringUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Block {

    private String hash;
    private String previousHash;
    private String data;
    private long timeStamp;

    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = System.currentTimeMillis();
        this.hash = calculateHash(previousHash, timeStamp, data);
    }

    @JsonProperty("hash")
    public String getHash() {
        return hash;
    }

    @JsonProperty("previous_hash")
    public String getPreviousHash() {
        return previousHash;
    }

    @JsonProperty("data")
    public String getData() {
        return data;
    }

    @JsonProperty("time_stamp")
    public long getTimeStamp() {
        return timeStamp;
    }

    private String calculateHash(String previousHash, long timeStamp, String data) {
        return StringUtil.hashSha256(
                previousHash + Long.toString(timeStamp) + data);
    }
}
