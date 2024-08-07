//package DesignPattern.MomentoPattern;
//
///**
// * @author : Kunal Sharma
// * @since : 16/07/24, Tuesday
// **/
//public class AuctionParticipant implements Bidder {
//    private String name;
//    private AuctionMediator mediator;
//
//    public AuctionParticipant(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public void setMediator(AuctionMediator mediator) {
//        this.mediator = mediator;
//    }
//
//    @Override
//    public void setAuctionMediator(AuctionMediator mediator) {
//
//    }
//
//    @Override
//    public void bid(int amount) {
//        System.out.println(name + " bids " + amount);
//    }
//
//    @Override
//    public void cancelBid() {
//        System.out.println(name + " cancels their bid");
//    }
//
//    @Override
//    public String getName() {
//        return name;
//    }
//
//    public void placeBid(int amount) {
//        mediator.bid(new Object(), 0);
//    }
//
//    public void withdrawBid() {
//        mediator.cancelBid(this);
//    }
//}
//
