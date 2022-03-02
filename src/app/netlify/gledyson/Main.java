package app.netlify.gledyson;

import app.netlify.gledyson.utils.Constants;

public class Main {

    public static void main(String[] args) {
        // create blockchain
        BlockChain blockChain = new BlockChain();

        // create a miner
        Miner miner = new Miner();

        // add genesis block
        Block block0 = new Block(Constants.GENESIS_PREV_HASH, "transaction1");

        // Miners be minin'
        miner.mine(block0, blockChain);

        // new block
        Block block1 = new Block(
                blockChain.getBlockChain().get(blockChain.size() - 1).getHash(),
                "transaction2"
        );

        // Miners be minin'
        miner.mine(block1, blockChain);

        // new block
        Block block2 = new Block(
                blockChain.getBlockChain().get(blockChain.size() - 1).getHash(),
                "transaction3"
        );

        // Miners be minin'
        miner.mine(block2, blockChain);

        System.out.println("\n" + blockChain + "\n");
        System.out.println("Miner reward: " + miner.getReward());
    }
}
