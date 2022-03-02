package app.netlify.gledyson;

import app.netlify.gledyson.utils.SHA256Helper;

import java.util.Date;
import java.util.UUID;

public class Block {
    private UUID id;
    private int nonce; // number only used once
    private long timestamp;
    private String hash;
    private String previousHash;
    private String transaction;

    public Block(UUID id, String previousHash, String transaction) {
        this.id = id;
        this.previousHash = previousHash;
        this.transaction = transaction;
        this.timestamp = new Date().getTime();
        generateHash();
    }

    public void generateHash() {
        String dataToHash = id.toString() + previousHash + Long.toString(timestamp) + Integer.toString(nonce) + transaction.toString();

        String hashedData = SHA256Helper.generateHash(dataToHash);

        this.hash = hashedData;
    }

    public void incrementNonce() {
        this.nonce++;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    @Override
    public String toString() {
        return "Block{" +
                "id=" + id +
                ", nonce=" + nonce +
                ", timestamp=" + timestamp +
                ", hash='" + hash + '\'' +
                ", previousHash='" + previousHash + '\'' +
                ", transaction='" + transaction + '\'' +
                '}';
    }
}
