package app.netlify.gledyson;

import app.netlify.gledyson.utils.Constants;

import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        // create blockchain
        BlockChain blockChain = new BlockChain();

        // create a miner
        Miner miner = new Miner();

        // add genesis block
        Block block0 = new Block(UUID.randomUUID(), Constants.GENESIS_PREV_HASH, "transaction1");

        // Miner be minin'
        miner.mine(block0, blockChain);

        // new block
        Block block1 = new Block(
                UUID.randomUUID(),
                blockChain.getBlockChain().get(blockChain.size() - 1).getHash(),
                "transaction2"
        );

        // Miner be minin'
        miner.mine(block1, blockChain);

        // new block
        Block block2 = new Block(
                UUID.randomUUID(),
                blockChain.getBlockChain().get(blockChain.size() - 1).getHash(),
                "transaction3"
        );

        // Miner be minin'
        miner.mine(block2, blockChain);

        System.out.println("Blockchain:\n" + blockChain + "\n");
        System.out.println("Miner reward: " + miner.getReward());
    }
}
